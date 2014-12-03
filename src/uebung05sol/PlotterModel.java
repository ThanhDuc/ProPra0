package uebung05sol;

import java.util.Observable;

import uebung05sol.funcs.Function;

/**
 * Model for FunctionPlotter view (= Panel) and controller (FunctionPlotter window).
 * 
 * @author kif
 *
 */
public class PlotterModel extends Observable {
	private double _min_x = -5;
	private double _max_x =  5;
	private double _min_y = -3;
	private double _max_y =  3;

	private Function _function;
	
	public PlotterModel() {		
	}
	
	/**
	 * Returns the minimum x coordinate of the function space.
	 * @return
	 */
	public double getMinX() {
		return _min_x;
	}

	/**
	 * Sets the minimum x coordinate of the function space.
	 * @return
	 */
	public void setMinX(double min_x) {
		if (_min_x!=min_x) {
			_min_x = min_x;
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * Returns the maximum x coordinate of the function space.
	 * @return
	 */
	public double getMaxX() {
		return _max_x;
	}

	/**
	 * Sets the maximum x coordinate of the function space.
	 * @return
	 */
	public void setMaxX(double max_x) {
		if (_max_x!=max_x) {
			_max_x = max_x;
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * Returns the minimum y coordinate of the function space.
	 * @return
	 */
	public double getMinY() {
		return _min_y;
	}

	/**
	 * Sets the minimum y coordinate of the function space.
	 * @return
	 */
	public void setMinY(double min_y) {
		if (_min_y!=min_y) {
			_min_y = min_y;
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * Returns the maxmimum y coordinate of the function space.
	 * @return
	 */
	public double getMaxY() {
		return _max_y;
	}

	/**
	 * Sets the maximum y coordinate of the function space.
	 * @return
	 */
	public void setMaxY(double max_y) {
		if (_max_y!=max_y) {
			_max_y = max_y;
			setChanged();
			notifyObservers();
		}
	}
	
	/**
	 * Moves the function space bounds by the given delta in x and y direction.
	 * 
	 * @param delta_x
	 * @param delta_y
	 */
	public void moveBounds(double delta_x, double delta_y) {
		_min_x += delta_x;
		_max_x += delta_x;
		_min_y += delta_y;
		_max_y += delta_y;
		setChanged();
		notifyObservers();		
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
