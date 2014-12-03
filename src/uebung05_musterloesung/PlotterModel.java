package uebung05_musterloesung;

import java.util.Observable;

import uebung05_musterloesung.funcs.Function;



public class PlotterModel extends Observable {
	private double _min_x = -5;
	private double _max_x =  5;
	private double _min_y = -3;
	private double _max_y =  3;

	private Function _function;
	
	public PlotterModel() {		
	}
	
	public double getMinX() {
		return _min_x;
	}

	public void setMinX(double min_x) {
		if (_min_x!=min_x) {
			_min_x = min_x;
			setChanged();
			notifyObservers();
		}
	}

	public double getMaxX() {
		return _max_x;
	}

	public void setMaxX(double max_x) {
		if (_max_x!=max_x) {
			_max_x = max_x;
			setChanged();
			notifyObservers();
		}
	}

	public double getMinY() {
		return _min_y;
	}

	public void setMinY(double min_y) {
		if (_min_y!=min_y) {
			_min_y = min_y;
			setChanged();
			notifyObservers();
		}
	}

	public double getMaxY() {
		return _max_y;
	}

	public void setMaxY(double max_y) {
		if (_max_y!=max_y) {
			_max_y = max_y;
			setChanged();
			notifyObservers();
		}
	}
	
	public Function getFunction() {
		return _function;
	}

	public void setFunction(Function function) {
		_function = function;
		setChanged();
		notifyObservers();
	}
}
