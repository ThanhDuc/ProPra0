package uebung03;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class MyController extends JFrame implements ActionListener, Observer{

		private final JTextField redField = new JTextField(4);
		private final JTextField greenField = new JTextField(4);
		private final JTextField blueField = new JTextField(4);
		private final JLabel redLabel = new JLabel("red");
		private final JLabel greenLabel = new JLabel("green");
		private final JLabel blueLabel = new JLabel("blue");
		private final JButton createView = new JButton("Create View");
		private final JButton createController = new JButton("Create Controller");
		
		private JPanel generateColorPanel(JLabel label, JComponent jcomp) {
			JPanel panel = new JPanel();	
			panel.setLayout(new BorderLayout());
			panel.add(label, BorderLayout.NORTH);
			panel.add(jcomp, BorderLayout.SOUTH);			
			return panel;	
		}
		
		public MyController(){
		super("My Controller ");	
		
		JPanel red = generateColorPanel(redLabel, redField);
		JPanel green = generateColorPanel(greenLabel, greenField);
		JPanel blue = generateColorPanel(blueLabel, blueField);
		
		this.setLayout(new FlowLayout());
		this.add(red);
		this.add(green);
		this.add(blue);
		this.add(createView);
		this.add(createController);
		this.pack(); //
		}
		
		
		@Override
		public void update(Observable arg0, Object arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		public static void main(String Args[]){
			MyController win = new MyController();
			win.setVisible(true);
			
		}
		
		
		
		
		
		
}
