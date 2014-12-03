package uebung04;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ImageEditor extends JFrame implements ActionListener {
	private ImagePanel _image_panel;
	
	private JButton _jb_load;
	private JButton _jb_select;
	private JButton _jb_invert;
	private JButton _jb_colorize_r;
	private JButton _jb_colorize_g;
	private JButton _jb_colorize_b;
	private JButton _jb_mirror_x;
	private JButton _jb_mirror_y;
	private JButton _jb_mystery;

	public JButton create_button(String label) {
		JButton button = new JButton(label);
		button.addActionListener(this);
		
		return button;
	}
	
	public ImageEditor() {
		super("Image Viewer");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		_image_panel = new ImagePanel();
		
		JPanel button_panel = new JPanel();
		button_panel.setLayout(new GridLayout(11, 0));
		
		_jb_load = create_button("Load");
		_jb_invert = create_button("Invert");
		_jb_colorize_r = create_button("Colorize Red");
		_jb_colorize_g = create_button("Colorize Green");
		_jb_colorize_b = create_button("Colorize Blue");
		_jb_mirror_x = create_button("Mirror X");
		_jb_mirror_y = create_button("Mirror Y");			
		_jb_mystery = create_button("Mystery");
		_jb_select = create_button("Select Region");

		button_panel.add(_jb_load);
		button_panel.add(new JPanel());
		button_panel.add(_jb_invert);
		button_panel.add(_jb_colorize_r);
		button_panel.add(_jb_colorize_g);
		button_panel.add(_jb_colorize_b);
		button_panel.add(_jb_mirror_x);
		button_panel.add(_jb_mirror_y);
		button_panel.add(_jb_mystery);
		button_panel.add(new JPanel());
		button_panel.add(_jb_select);
		
		JPanel west_panel = new JPanel();
		west_panel.add(button_panel, BorderLayout.NORTH);

		this.setLayout(new BorderLayout());
		this.add(_image_panel, BorderLayout.CENTER);
		this.add(west_panel, BorderLayout.WEST);
				
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		//System.out.println("Someone pressed some button");
		if (ae.getSource()==_jb_load){		
			_image_panel.getImg();
			_image_panel.setVisible(true);
		}
		// insert your code here ...
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ImageEditor win = new ImageEditor();
		win.setVisible(true);
	}
}
