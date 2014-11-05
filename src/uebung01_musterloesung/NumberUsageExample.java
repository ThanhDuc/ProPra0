package uebung01_musterloesung;

import uebung02.Number;

public class NumberUsageExample {
	
	/*
	 * Example of method that caluclates a formula with the
	 * numbers a and by, independent of their concrete type (Bruch, ComplexNumber, BigInteger, ...).
	 */
	public static void compute(Number a, Number b, Number result) {
		result.set(a);
		result.add(b);
		result.mul(a);
		result.sub(b);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test 1 - calling compute() with Bruchzahlen
		Bruch b1 = new Bruch(1,3);
		Bruch b2 = new Bruch(3,4);
		Bruch bresult = new Bruch(1,1);
		compute(b1, b2, bresult);
		System.out.println("compute with Bruchzahlen: "+bresult);

		// test 2 - calling compute() with ComplexNumbers
		ComplexNumber c1 = new ComplexNumber(1,3);
		ComplexNumber c2 = new ComplexNumber(3,4);
		ComplexNumber cresult = new ComplexNumber(1,1);
		compute(c1, c2, cresult);
		System.out.println("compute with ComplexNumbers: "+cresult);
	}

}
