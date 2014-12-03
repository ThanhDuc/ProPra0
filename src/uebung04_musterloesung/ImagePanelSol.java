package uebung04_musterloesung;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePanelSol extends JPanel implements MouseListener {
	private enum SelectMode {
		NONE, STEP1, STEP2, MADE
	}
	
	private BufferedImage _img;
	private int _x1, _y1, _x2, _y2;
	private SelectMode _selecting;

	public ImagePanelSol() {
		this.addMouseListener(this);
	}
	
	public BufferedImage getmg() {
		return _img;
	}

	public void setImg(BufferedImage _img) {
		this._img = _img;
		Dimension dim = new Dimension(_img.getWidth(), _img.getHeight());
		setPreferredSize(dim);

		this._selecting = SelectMode.NONE;
		this._x1 = this._y1 = 0;
		this._x2 = _img.getWidth()-1;
		this._y2 = _img.getHeight()-1;
	}

	public void selectRegion() {
		this._selecting = SelectMode.STEP1;
	}
	
	@Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
    	g.drawImage(_img, 0,0, null);
    	
    	if (_selecting==SelectMode.MADE) {
    		int min_x = Math.min(_x1, _x2);
    		int min_y = Math.min(_y1, _y2);
    		int w = Math.abs(_x2-_x1);
    		int h = Math.abs(_y2-_y1);
    		g.setColor(Color.WHITE);    		
    		g.drawRect(min_x, min_y, w, h);
    	}
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
		int x = me.getX(), y = me.getY();

		switch (_selecting) {
		case STEP1:
			_x1 = x;
			_y1 = y;
			this._selecting = SelectMode.STEP2;
			break;
		case STEP2:
			_x2 = x;
			_y2 = y;
			this._selecting = SelectMode.MADE;
			repaint();
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub		
	}

	public void invert() {
		for (int y=_y1; y<_y2; y++) {
			for (int x=_x1; x<_x2; x++) {
				int rgb = _img.getRGB(x, y);
				rgb = ~rgb;
				_img.setRGB(x, y, rgb);
			}
		}
		
		repaint();
	}

	public void colorize(int mode) {
		for (int y=_y1; y<_y2; y++) {
			for (int x=_x1; x<_x2; x++) {
				int rgb = _img.getRGB(x, y);
				Color old_col = new Color(rgb);
				int sum = old_col.getRed() + old_col.getBlue() + old_col.getGreen();
				
				Color new_col;
				if (mode==0) {
					new_col = new Color(sum/3, 0, 0);
				} else if (mode==1) {
					new_col = new Color(0, sum/3, 0);
				} else {
					new_col = new Color(0, 0, sum/3);
				}
				
				_img.setRGB(x, y, new_col.getRGB());
			}
		}

		repaint();
	}

	public void flipX() {
		int half = (_x1 + _x2) / 2;
		int min = Math.min(_x1, _x2);
		int max = Math.max(_x1, _x2);

		for (int y=_y1; y<_y2; y++) {
			for (int x=0; x<half-min; x++) {
				int rgb_left = _img.getRGB(min+x, y);				
				_img.setRGB(min+x, y, _img.getRGB(max-x, y));
				_img.setRGB(max-x, y, rgb_left);
			}
		}

		repaint();
	}

	public void flipY() {
		int half = (_y1 + _y2) / 2;
		int min = Math.min(_y1, _y2);
		int max = Math.max(_y1, _y2);
		
		for (int x=_x1; x<_x2; x++) {
			for (int y=0; y<half-min; y++) {
				int rgb_up = _img.getRGB(x, min+y);				
				_img.setRGB(x, min+y, _img.getRGB(x, max-y));
				_img.setRGB(x, max-y, rgb_up);
			}
		}

		repaint();
	}

}
