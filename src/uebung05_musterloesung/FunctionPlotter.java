package uebung05_musterloesung;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Implements a function plotter. Contains Main Window + main Function.
 * 
 * @author kif
 *
 */
public class FunctionPlotter extends JFrame implements ActionListener, Observer {
	private FunctionPanel _function_panel;
	
	private JButton _jb_sinus;
	private JButton _jb_cosinus;
	private JButton _jb_poly3;
	private JButton _jb_my_func;
	private JTextField _jtf_min_x = new JTextField();
	private JTextField _jtf_max_x = new JTextField();
	private JTextField _jtf_min_y = new JTextField();
	private JTextField _jtf_max_y = new JTextField();
	private PlotterModel _pm = new PlotterModel();

	public JButton create_and_add_button(String label, JPanel panel) {
		JButton button = new JButton(label);
		button.addActionListener(this);		
		panel.add(button);
		
		return button;
	}
	
	public void create_labeled_textfield(String label, JTextField text_field, JPanel panel) {
		JPanel hidden_panel = new JPanel();
		hidden_panel.setLayout(new BorderLayout());
		hidden_panel.add(new JLabel(label), BorderLayout.WEST);		
		hidden_panel.add(text_field, BorderLayout.EAST);
		text_field.setColumns(5);
		text_field.setHorizontalAlignment(JTextField.RIGHT);
		text_field.addActionListener(this);
		panel.add(hidden_panel);
	}

	public FunctionPlotter() {
		super("Function Plotter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		_function_panel = new FunctionPanel(_pm);
		
		JPanel button_panel = new JPanel();
		button_panel.setLayout(new GridLayout(11, 0));
		
		create_labeled_textfield("Min x", _jtf_min_x, button_panel);
		create_labeled_textfield("Max x", _jtf_max_x, button_panel);
		create_labeled_textfield("Min y", _jtf_min_y, button_panel);
		create_labeled_textfield("Max y", _jtf_max_y, button_panel);
		
		button_panel.add(new JPanel());

		_jb_sinus = create_and_add_button("Sinus", button_panel);
		_jb_cosinus = create_and_add_button("Cosinus", button_panel);
		_jb_poly3 = create_and_add_button("Poly 3", button_panel);
		_jb_my_func = create_and_add_button("My Func", button_panel);
				
		JPanel west_panel = new JPanel();
		west_panel.add(button_panel, BorderLayout.NORTH);

		this.setLayout(new BorderLayout());
		this.add(_function_panel, BorderLayout.CENTER);
		this.add(west_panel, BorderLayout.WEST);
		init_fields();
		
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object src = ae.getSource();
		
		if (src==_jb_sinus) {
			// ...
		} else if (src==_jb_cosinus) {
			// ...
		} else if (src==_jb_poly3) {
			// ...
		} else if (src==_jb_my_func) {
			// ...
		} else if (src==_jtf_min_x) {
			_pm.setMinX(Double.parseDouble(_jtf_min_x.getText()));
		} else if (src==_jtf_max_x) {
			_pm.setMaxX(Double.parseDouble(_jtf_max_x.getText()));
		} else if (src==_jtf_min_y) {
			_pm.setMinY(Double.parseDouble(_jtf_min_y.getText()));
		} else if (src==_jtf_max_y) {
			_pm.setMaxY(Double.parseDouble(_jtf_max_y.getText()));
		}
	}

	private void init_fields() {
		_jtf_min_x.setText(""+_pm.getMinX());
		_jtf_max_x.setText(""+_pm.getMaxX());
		_jtf_min_y.setText(""+_pm.getMinY());
		_jtf_max_y.setText(""+_pm.getMaxY());
	}
	
	@Override
	public void update(Observable o, Object arg) {
		init_fields();
	}

	/**
	 * Good old main ...
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FunctionPlotter win = new FunctionPlotter();
		win.setVisible(true);
	}
}
