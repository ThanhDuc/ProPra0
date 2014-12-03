package uebung05sol.funcs;

public class Poly3 extends Function {
	private double _a, _b, _c, _d;
	
	public Poly3(double a, double b, double c, double d) {
		_a = a;
		_b = b;
		_c = c;
		_d = d;
	}

	@Override
	public double eval(double x) {
		return _a*x*x*x + _b*x*x + _c*x + _d;
	}
}
