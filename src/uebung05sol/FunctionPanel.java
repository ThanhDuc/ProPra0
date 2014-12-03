package uebung05sol;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * Implements a function panel as a view on the plotter model. Draws a coordinate system and an
 * optional function defined in the PlotterModel.
 * 
 * @author kif
 *
 */
public class FunctionPanel extends JPanel implements Observer, MouseMotionListener, MouseListener {
	private final static int ARROW_LENGTH = 6;
	private PlotterModel _pm;
	
	private double _tick_x = 1;
	private double _tick_y = 1;
	private int _click_x;
	private int _click_y;
	
	public FunctionPanel(PlotterModel pm) {
		_pm = pm;
		_pm.addObserver(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setPreferredSize(new Dimension(800,600));
	}
	
	/**
	 * Converts screen x coordinate to function space defined in the PlotterModel.
	 *  
	 * @param screen_x
	 * @return
	 */
	public double screen_to_space_x(int screen_x) {
		int w = this.getWidth();
		
		double factor = ((double)screen_x) / w ;
		
		return _pm.getMinX() + factor * (_pm.getMaxX() - _pm.getMinX());		
	}
	
	/**
	 * Converts screen y coordinate to function space defined in the PlotterModel.
	 *  
	 * @param screen_x
	 * @return
	 */
	public double screen_to_space_y(int screen_y) {
		int h = this.getHeight();
		
		double factor = ((double)screen_y) / h ;
		
		return _pm.getMaxY() - factor * (_pm.getMaxY() - _pm.getMinY());		
	}
	
	/**
	 * Converts space x coordinate to screen. 
	 *  
	 * @param screen_x
	 * @return
	 */
	public int space_to_screen_x(double space_x) {
		int w = this.getWidth();
		
		double factor = (space_x-_pm.getMinX()) / (_pm.getMaxX() - _pm.getMinX()) ;
		return (int)(Math.round(factor*w));		
	}
	
	/**
	 * Converts space x coordinate to screen. 
	 *  
	 * @param screen_y
	 * @return
	 */
	public int space_to_screen_y(double space_y) {
		int h = this.getHeight();
		
		double factor = (space_y-_pm.getMinY()) / (_pm.getMaxY() - _pm.getMinY()) ;
		return (int)(Math.round(h-factor*h));		
	}

	@Override
    public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		int w = this.getWidth();
		int h = this.getHeight();
		
		super.paintComponent(g);
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, w, h);
		
		g2.setColor(Color.BLACK);
		
		// x axis
		int y0 = space_to_screen_y(0);
		g2.drawLine(0, y0, w, y0);
		g2.drawLine(w-ARROW_LENGTH, y0-ARROW_LENGTH, w, y0);
		g2.drawLine(w-ARROW_LENGTH, y0+ARROW_LENGTH, w, y0);
		
		// y axis
		int x0 = space_to_screen_x(0);
		g2.drawLine(x0, 0, x0, h);
		g2.drawLine(x0, 0, x0-ARROW_LENGTH, ARROW_LENGTH);
		g2.drawLine(x0, 0, x0+ARROW_LENGTH, ARROW_LENGTH);
		
		// axis ticks
		DecimalFormat df = new DecimalFormat("0.00");
		for (double x=_pm.getMinX(); x<_pm.getMaxX(); x+=_tick_x) {
			int screen_x = space_to_screen_x(x);
			int screen_y = space_to_screen_y(0);
			
			String str = ""+df.format(x);
			int str_width = g2.getFontMetrics().stringWidth(str);
			g2.drawLine(screen_x, screen_y, screen_x, screen_y+10);
			g2.drawString(str, screen_x-str_width/2, screen_y+20);
		}
		for (double y=_pm.getMinY(); y<_pm.getMaxY(); y+=_tick_y) {
			int screen_x = space_to_screen_x(0);
			int screen_y = space_to_screen_y(y);
			
			String str = ""+df.format(y);
			int str_width = g.getFontMetrics().stringWidth(str);
			int str_height = g.getFontMetrics().getHeight();
			g.drawLine(screen_x-10, screen_y, screen_x, screen_y);
			g.drawString(str, screen_x-str_width-15, screen_y-str_height/2);
		}
		
		// finally, draw the function itself
		if (_pm.getFunction()!=null) {
			// g2.setStroke(new BasicStroke(3));
			g2.setColor(Color.BLUE);
			double y_old = _pm.getFunction().eval(screen_to_space_x(0));
			for (int x=1; x<w; x++) {
				double y = _pm.getFunction().eval(screen_to_space_x(x));
				g2.drawLine(x-1, (int)(space_to_screen_y(y_old)), x, (int)(space_to_screen_y(y)));
				y_old = y;
			}
		}
	}

	@Override
	public void update(Observable observer, Object o) {
		// if anything in the model changes, update the view
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		double fac_x = (_pm.getMaxX()-_pm.getMinX()) / this.getWidth();
		double fac_y = (_pm.getMaxY()-_pm.getMinY()) / this.getHeight();
		
		double delta_x = (me.getX()-_click_x)*fac_x;
		double delta_y = (me.getY()-_click_y)*fac_y;
		_pm.moveBounds(-delta_x, delta_y);
		_click_x = me.getX();
		_click_y = me.getY();
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent me) {
		_click_x = me.getX();
		_click_y = me.getY();
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub		
	}
}
