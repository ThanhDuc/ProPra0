package uebung02_musterloesung;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Class that implements the GUI for a calculator for ComplexNumbers and Bruchzahlen.
 *  
 * @author kif
 *
 */
public class CalculatorWin extends JFrame implements ActionListener {
	private final JTextField _jtif_number_1a = new JTextField(6);
	private final JTextField _jtif_number_1b = new JTextField(6);
	private final JTextField _jtif_number_2a = new JTextField(6);
	private final JTextField _jtif_number_2b = new JTextField(6);
	private final JTextField _jtif_number_result = new JTextField(20);
	private final JCheckBoxMenuItem _jcbm_complex = new JCheckBoxMenuItem("Complex Mode");
	private final JLabel _jl_z1a = new JLabel("Zähler");
	private final JLabel _jl_z1b = new JLabel("Nenner");
	private final JLabel _jl_z2a = new JLabel("Zähler");
	private final JLabel _jl_z2b = new JLabel("Nenner");

	private final static String[] OPERATIONS = {"+", "-", "*", "/"};
	private final JComboBox<String> _jcb_operation = new JComboBox<String>(OPERATIONS);

	private JPanel generate_number_panel(JLabel label, JComponent jcomp) {
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout());
		panel.add(label, BorderLayout.NORTH);
		panel.add(jcomp, BorderLayout.SOUTH);
		
		return panel;	
	}
	
	/**
	 * This is called when a text field value changes.
	 */
	public void compute_result() {
		String str_result = "";

		if (_jcbm_complex.isSelected()) {
			_jl_z1a.setText("Real");
			_jl_z1b.setText("Imaginär");
			_jl_z2a.setText("Real");
			_jl_z2b.setText("Imaginär");
		} else {
			_jl_z1a.setText("Zähler");
			_jl_z1b.setText("Nenner");
			_jl_z2a.setText("Zähler");
			_jl_z2b.setText("Nenner");
		}
		
		try {
			int n1a = Integer.parseInt(_jtif_number_1a.getText());
			int n1b = Integer.parseInt(_jtif_number_1b.getText());
			int n2a = Integer.parseInt(_jtif_number_2a.getText());
			int n2b = Integer.parseInt(_jtif_number_2b.getText());

			Number n1, n2;
			if (_jcbm_complex.isSelected()) {
				n1 = new ComplexNumber(n1a, n1b);
				n2 = new ComplexNumber(n2a, n2b);
			} else {
				n1 = new Bruchzahl(n1a, n1b);
				n2 = new Bruchzahl(n2a, n2b);
			}
		
			switch (_jcb_operation.getSelectedIndex()) {
			case 0: 
				n1.add(n2);
				break;
			case 1: 
				n1.sub(n2);
				break;
			case 2: 
				n1.mul(n2);
				break;
			case 3: 
				n1.div(n2);
				break;
			default:
				System.err.println("How did you get here???");
				break;
			}
			str_result = n1.toString();
		} catch (NumberFormatException ex) {
			str_result = "fill all fields first";
		} catch (IllegalArgumentException ex) {
			str_result = "error: nenner my not be 0";
		}

		_jtif_number_result.setText(str_result);
	}
	
	public CalculatorWin() {
		super("Bruch/Complex Calculator");
		
		_jtif_number_1a.addActionListener(this);
		_jtif_number_1b.addActionListener(this);
		_jtif_number_2a.addActionListener(this);
		_jtif_number_2b.addActionListener(this);
		_jtif_number_result.setEditable(false);
		_jcb_operation.addActionListener(this);
		_jcbm_complex.addActionListener(this);

		JLabel jl_result = new JLabel("Ergebnis");
		
		JPanel jp_z1a = generate_number_panel(_jl_z1a, _jtif_number_1a);
		JPanel jp_z1b = generate_number_panel(_jl_z1b, _jtif_number_1b);
		JPanel jp_z2a = generate_number_panel(_jl_z2a, _jtif_number_2a);
		JPanel jp_z2b = generate_number_panel(_jl_z2b, _jtif_number_2b);
		JPanel jp_result = generate_number_panel(jl_result, _jtif_number_result);

		JPanel jp_number_1 = new JPanel();
		jp_number_1.add(jp_z1a);
		jp_number_1.add(jp_z1b);
		jp_number_1.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), 
                "Number 1", TitledBorder.CENTER, TitledBorder.TOP));

		JPanel jp_number_2 = new JPanel();
		jp_number_2.add(jp_z2a);
		jp_number_2.add(jp_z2b);
		jp_number_2.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), 
                "Number 2", TitledBorder.CENTER, TitledBorder.TOP));

		JPanel jp_result_outer = new JPanel();
		jp_result_outer.add(jp_result);
		jp_result_outer.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), 
                "Number 3", TitledBorder.CENTER, TitledBorder.TOP));

		JPanel main_panel = new JPanel();
		main_panel.setLayout(new FlowLayout());
		main_panel.add(jp_number_1);
		main_panel.add(_jcb_operation);
		main_panel.add(jp_number_2);
		JLabel jl_equals = new JLabel("=");
		main_panel.add(jl_equals);
		main_panel.add(jp_result_outer);
		
		JMenuBar menu_bar = new JMenuBar();
		
		JMenu jm_options = new JMenu("Options");
		menu_bar.add(jm_options);
		
		jm_options.add(_jcbm_complex);
				
		this.setJMenuBar(menu_bar);
		
		this.setLayout(new BorderLayout());
		this.add(main_panel, BorderLayout.CENTER);		
		this.pack();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		compute_result();
	}
}
