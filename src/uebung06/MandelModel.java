package uebung06;

import java.util.Observable;



public class MandelModel extends Observable {
	
	private Mandel _mandel;
	
	public MandelModel() {		
	}
	
	public Mandel getMenge() {
		return _mandel;
	}
	
	public void setMandel(int a, int b, int c){
		_mandel.Function(a,b,c);
		setChanged();
		notifyObservers();
	}
	
	
}
