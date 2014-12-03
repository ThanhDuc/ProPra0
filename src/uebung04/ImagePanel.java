package uebung04;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Implements a panel that shows an image and an optional selected rectangular region.
 * 
 * @author kif
 *
 */
public class ImagePanel extends JPanel {
	private BufferedImage _img = null;

	public ImagePanel() {
	}
	
	public BufferedImage getImg() {
		return _img;
	}

	public void setImg(BufferedImage img) throws IOException {
		img = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
		this._img = img;
		// insert you code here
		// e.g. setting preferred size of ImagePanel to the dimensions of img, initialize region etc.
	}

	@Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		// insert you code here ...
		// e.g. drawing of image (if not null) and/or selected region
    }
	
}
