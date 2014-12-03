package uebung05_musterloesung;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class FunctionPanel extends JPanel implements Observer, MouseMotionListener, MouseListener {
	private PlotterModel _pm;
	
	public FunctionPanel(PlotterModel pm) {
		_pm = pm;
		_pm.addObserver(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setPreferredSize(new Dimension(800,600));
	}
	
	@Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		int w = this.getWidth();
		int h = this.getHeight();
		
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, w, h);
	}

	@Override
	public void update(Observable observer, Object o) {
		System.out.println("Function Panel received Model Change");
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		System.out.println("dragged mouse to "+me.getX()+", "+me.getY());
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
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}
}
