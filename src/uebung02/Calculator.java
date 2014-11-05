package uebung02;
import javax.swing.*;


public class Calculator extends JFrame {

	JTextField zaehler1;
	JTextField nenner1;
	JComboBox operation;
	JTextField zaehler2;
	JTextField nenner2;
	JButton berechnen;
	static int i = 100;
	public Calculator(){
		this.getContentPane().setLayout(null);
		this.initWindow();
	}
	
	protected void initWindow(){
		zaehler1 = new JTextField();
		zaehler2 = new JTextField();
		nenner1 = new JTextField();
		nenner2 = new JTextField();
		berechnen = new JButton("=");
		
		zaehler1.setBounds(i, i, 200, 200);
		nenner1.setBounds(i, i+202 ,200, 200);
		berechnen.setBounds(i+300, i+100, 50, 50);
		
		this.getContentPane().add(zaehler1);
		this.getContentPane().add(nenner1);
		this.getContentPane().add(zaehler2);
		this.getContentPane().add(nenner2);
		this.getContentPane().add(berechnen);
		this.pack();
	}
	
	
	public static void main(String args[]){
		Calculator Cal = new Calculator();
		Cal.setBounds(i, i, 800, 800);
		Cal.show();
		
		
		
	}
}
