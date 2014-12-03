package uebung06;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MandelPlotter extends JFrame implements ActionListener, Observer  {
	private MandelPanel _mandel_panel;

	private JButton _jb_paint;
	
	private MandelModel _mm = new MandelModel();
	
	public MandelPlotter() {
		super("Mandelbrot Menge");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		_mandel_panel = new MandelPanel(_mm);
		
		JPanel button_panel = new JPanel();
		button_panel.setLayout(new GridLayout(1, 0));
		
		_jb_paint = new JButton("paint");
		_jb_paint.addActionListener(this);
		
		button_panel.add(_jb_paint);
		
		this.setLayout(new BorderLayout());
		this.add(button_panel, BorderLayout.WEST);
		//this.add(_mandel_panel, BorderLayout.CENTER);
		
		pack();		
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		MandelPlotter win = new MandelPlotter();
		win.setVisible(true);
		
	}

}
