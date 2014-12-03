package uebung02_musterloesung;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class SwingComponentsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame win = new JFrame("Swing Components");
		win.setLayout(new FlowLayout());
		
		win.add(new JButton("Start"));
		win.add(new JCheckBox("on"));
		win.add(new JTextField(10));
		win.add(new JLabel("Color:"));
		String[] values = {"red", "green", "blue"};
		win.add(new JComboBox<String>(values));
		String[] names = {"Peter", "Paul", "Mary", "John"};
		win.add(new JList<String>(names));
		win.add(new JSlider(0, 100, 20));

		JMenuBar menu_bar = new JMenuBar();
		
		JMenu jm_options = new JMenu("Options");
		menu_bar.add(jm_options);
		
		JCheckBoxMenuItem jcbm_complex = new JCheckBoxMenuItem("Complex Mode");
		jm_options.add(jcbm_complex);
				
		win.setJMenuBar(menu_bar);

		win.pack();
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);
	}

}
