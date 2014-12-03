package uebung03_musterloesung;

import java.util.Observable;

/**
 * MyModel - stores r,g,b values with getters and setters.
 * Implemented as singleton.
 * 
 * @author kif
 *
 */
public class MyModel extends Observable {
	private static MyModel _instance = null;
	private int _r = 0;
	private int _g = 0;
	private int _b = 128;

	public static MyModel getInstance() {
		if (_instance==null) {
			_instance = new MyModel();
		}
		
		return _instance;
	}
	
	private MyModel() {		
	}
	
	public int get_r() {
		return _r;
	}
	public int get_g() {
		return _g;
	}
	public int get_b() {
		return _b;
	}
	
	public void set_r(int r) {
		if (this._r!=r) {
			this._r = r;
			setChanged();
			notifyObservers();
		}
	}
	public void set_g(int g) {
		if (this._g!=g) {
			this._g = g;
			setChanged();
			notifyObservers();
		}
	}
	public void set_b(int b) {
		if (this._b!=b) {
			this._b = b;
			setChanged();
			notifyObservers();
		}
	}
}
