package uebung01_musterloesung;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUComplexNumberTest {

	@Test
	public void testContstrorGetterSetter() {
		ComplexNumber a = new ComplexNumber(1,3);
		assertEquals (1.0, a.getReal(), 0.0);
		assertEquals (3.0, a.getImag(), 0.03);
	}
	
	@Test
	public void testEquals() {
		ComplexNumber a = new ComplexNumber(1,3);
		ComplexNumber b = new ComplexNumber(1,3);
		assertEquals (a, b);
	}

	@Test
	public void testAdd() {
		ComplexNumber a = new ComplexNumber(1,3);
		ComplexNumber b = new ComplexNumber(3,4);
		a.add(b);
		assertEquals (new ComplexNumber(4,7), a);
	}
	
	@Test
	public void testSub() {
		ComplexNumber a = new ComplexNumber(1,3);
		ComplexNumber b = new ComplexNumber(3,4);
		a.sub(b);
		assertEquals (new ComplexNumber(-2,-1), a);
	}

	@Test
	public void testMul() {
		ComplexNumber a = new ComplexNumber(1,3);
		ComplexNumber b = new ComplexNumber(3,4);
		a.mul(b);
		assertEquals (new ComplexNumber(-9,13), a);
	}

	@Test
	public void testDiv() {
		ComplexNumber a = new ComplexNumber(1,3);
		ComplexNumber b = new ComplexNumber(3,4);
		a.div(b);
		assertEquals (0.6, a.getReal(), 0.0);
		assertEquals (0.2, a.getImag(), 0.1);
	}
}
