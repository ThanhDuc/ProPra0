package uebung03_musterloesung;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * MyControler allows to change the r,g,b values of the model. It observes the model for changes.
 * Also allows to create new controllers and views.
 * 
 * @author kif
 *
 */
public class MyControler extends JFrame implements ActionListener, Observer {
	private static int _ctrl_counter = 0;
	private static int _win_pos_x = 0;
	private static int _win_pos_y = 0;
	
	private final JTextField _jtif_r = new JTextField(6);
	private final JTextField _jtif_g = new JTextField(6);
	private final JTextField _jtif_b = new JTextField(6);
	private final JButton _jb_create_view = new JButton("Create View");
	private final JButton _jb_create_ctrl = new JButton("Create Controler");
	
	private JPanel generate_number_panel(JLabel label, JComponent jcomp) {
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout());
		panel.add(label, BorderLayout.NORTH);
		panel.add(jcomp, BorderLayout.SOUTH);
		
		return panel;	
	}

	public MyControler() {
		super("MyControler "+_ctrl_counter); //set label of JFrame
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		_jtif_r.addActionListener(this);
		_jtif_g.addActionListener(this);
		_jtif_b.addActionListener(this);
		
		update_fields();

		JPanel jp_r = generate_number_panel(new JLabel("r"), _jtif_r);
		JPanel jp_g = generate_number_panel(new JLabel("g"), _jtif_g);
		JPanel jp_b = generate_number_panel(new JLabel("b"), _jtif_b);

		_jb_create_view.addActionListener(this);	 
		_jb_create_ctrl.addActionListener(this);	 
		
		this.setLayout(new FlowLayout());
		this.add(jp_r);
		this.add(jp_g);
		this.add(jp_b);
		this.add(_jb_create_view);
		this.add(_jb_create_ctrl);
		this.pack();
		
		MyModel.getInstance().addObserver(this);
		_ctrl_counter++;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		MyModel model = MyModel.getInstance();
    	if (_win_pos_x==0) {
    		_win_pos_x = this.getX()+5;
    		_win_pos_y = this.getY()+this.getHeight()+5;
    	}

		if (ae.getSource()==_jb_create_view) {			
	    	MyView view = new MyView(model);
	    	view.setLocation(_win_pos_x, _win_pos_y);
	    	_win_pos_x += 30;
	    	_win_pos_y += 40;	    	
	    	view.setVisible(true);
		} else 	if (ae.getSource()==_jb_create_ctrl) {				    		    	
	    	MyControler ctrl = new MyControler();
	    	ctrl.setLocation(_win_pos_x, _win_pos_y);	    	
	    	_win_pos_x += 30;
	    	_win_pos_y += 40;	    	
	    	ctrl.setVisible(true);
		} else if (ae.getSource()==_jtif_r){
			int r = Integer.parseInt(_jtif_r.getText());
			model.set_r(r);
		} else if (ae.getSource()==_jtif_g){
			int g = Integer.parseInt(_jtif_g.getText());
			model.set_g(g);
		} else if (ae.getSource()==_jtif_b){
			int b = Integer.parseInt(_jtif_b.getText());
			model.set_b(b);
		}
	}

	public void update_fields() {
		MyModel model = MyModel.getInstance();

		_jtif_r.setText(""+model.get_r());
		_jtif_g.setText(""+model.get_g());
		_jtif_b.setText(""+model.get_b());
	}

	@Override
	public void update(Observable o, Object m) {
		update_fields();
	}
}
