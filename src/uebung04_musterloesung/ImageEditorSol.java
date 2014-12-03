package uebung04_musterloesung;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageEditorSol extends JFrame implements ActionListener {
	private ImagePanelSol _image_panel;
	
	private JButton _jb_load;
	private JButton _jb_select;
	private JButton _jb_invert;
	private JButton _jb_colorize_r;
	private JButton _jb_colorize_g;
	private JButton _jb_colorize_b;
	private JButton _jb_mirror_x;
	private JButton _jb_mirror_y;
	private JButton _jb_mystery;

	public JButton create_and_add_button(String label, JPanel panel) {
		JButton button = new JButton(label);
		button.addActionListener(this);		
		panel.add(button);
		
		return button;
	}
	
	public ImageEditorSol() {
		super("Image Viewer Solution");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		_image_panel = new ImagePanelSol();
		
		JPanel button_panel = new JPanel();
		button_panel.setLayout(new GridLayout(11, 0));
		
		_jb_load = create_and_add_button("Load", button_panel);		
		button_panel.add(new JPanel());

		_jb_invert = create_and_add_button("Invert", button_panel);
		_jb_colorize_r = create_and_add_button("Colorize Red", button_panel);
		_jb_colorize_g = create_and_add_button("Colorize Green", button_panel);
		_jb_colorize_b = create_and_add_button("Colorize Blue", button_panel);
		_jb_mirror_x = create_and_add_button("Mirror X", button_panel);
		_jb_mirror_y = create_and_add_button("Mirror Y", button_panel);			
		_jb_mystery = create_and_add_button("Mystery", button_panel);
		button_panel.add(new JPanel());
		
		_jb_select = create_and_add_button("Select Region", button_panel);
		
		JPanel west_panel = new JPanel();
		west_panel.add(button_panel, BorderLayout.NORTH);

		this.setLayout(new BorderLayout());
		this.add(_image_panel, BorderLayout.CENTER);
		this.add(west_panel, BorderLayout.WEST);
				
		pack();
	}

	private void load_file(File f) {
		try {
			BufferedImage img = ImageIO.read(f);
			_image_panel.setImg(img);
			this.pack();
			repaint();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object src = ae.getSource();
		
		if (src==_jb_load) {
			File f = null;
			if ((ae.getModifiers() & ActionEvent.SHIFT_MASK) != 0) {
				f = new File( "C:\\Users\\kif\\Pictures\\aerzte.jpg");
			}
			
			if (f==null || !f.exists()) {
				final JFileChooser fc = new JFileChooser();
				int result = fc.showOpenDialog(this);
				if (result==JFileChooser.APPROVE_OPTION) {
					f = fc.getSelectedFile();
				}			
			}
			
			if (f!=null) {
				load_file(f);
			}
		} else if (src==_jb_invert) {
			_image_panel.invert();
		} else if (src==_jb_colorize_r) {
			_image_panel.colorize(0);
		} else if (src==_jb_colorize_g) {
			_image_panel.colorize(1);
		} else if (src==_jb_colorize_b) {
			_image_panel.colorize(2);
		} else if (src==_jb_select) {
			_image_panel.selectRegion();
		} else if (src==_jb_mirror_x) {
			_image_panel.flipX();
		} else if (src==_jb_mirror_y) {
			_image_panel.flipY();
		} else if (src==_jb_mystery) {
			// ...
		} else if (src==_jb_select) {
			_image_panel.selectRegion();
		}
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ImageEditorSol win = new ImageEditorSol();
		win.setVisible(true);
	}
}
