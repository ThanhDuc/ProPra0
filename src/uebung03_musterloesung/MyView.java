package uebung03_musterloesung;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

/**
 * Class that implements the GUI for a calculator for ComplexNumbers and Bruchzahlen.
 *  
 * @author kif
 *
 */
public class MyView extends JFrame implements Observer {
	private static int _view_counter = 0;
	
	public MyView(MyModel model) {
		super("MyView "+_view_counter);
		MyModel.getInstance().addObserver(this);
		
		Dimension dim = new Dimension(200,100);
		update_bg_color();
		setSize(dim);
		_view_counter++;
	}

	public void update_bg_color() {
		MyModel model = MyModel.getInstance();
		Color col = new Color(model.get_r(), model.get_g(), model.get_b());
		this.getContentPane().setBackground(col);
	}

	@Override
	public void update(Observable o, Object m) {
		update_bg_color();
	}
}
