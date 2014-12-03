package uebung02;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;


public class Calculator{
	
	
	public static void main(String args[]){
		JFrame window = new JFrame("Calculator");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500, 500);
		
		window.setLayout(new GridBagLayout());
		
		JLabel nenner1 = new JLabel("nenner 1");
		JLabel zaehler1 =new JLabel("zahler1");
		JTextField feldNenner1 = new JTextField();
		JTextField feldZaehler1 = new JTextField();
		JComboBox operationen = new JComboBox();
		JLabel nenner2 = new JLabel("nenner 2");
		JLabel zaehler2 =new JLabel("zahler2");
		JTextField feldNenner2 = new JTextField();
		JTextField feldZaehler2 = new JTextField();
		JButton schalflaecheGleich = new JButton("=");
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(4, 4, 4, 4);
		c.gridx = 0;
		c.gridy = 0;
		window.getContentPane().add(nenner1, c);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		window.getContentPane().add(feldNenner1, c);
		c.gridx = 0;
		c.gridy = 0;
		window.getContentPane().add(zaehler1, c);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		window.getContentPane().add(feldZaehler1, c);
		
		c.gridx = 1;
		c.gridy = 1;
		window.getContentPane().add(nenner2, c);
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		window.getContentPane().add(feldNenner2, c);
		c.gridx = 1;
		c.gridy = 1;
		window.getContentPane().add(zaehler2, c);
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 2;
		window.getContentPane().add(feldZaehler2, c);
		
		
		window.setVisible(true);
		
	}
}
