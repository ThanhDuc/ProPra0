package uebung01_musterloesung;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUBruchzahlTest {

	@Test
	public void testContstrorGetterSetter() {
		Bruch a = new Bruch(1,3);
		assertEquals (1, a.getZaehler());
		assertEquals (3, a.getNenner());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNennerZero() {
		Bruch a = new Bruch(1,0);
		a.setNenner(0);
	}
	
	@Test
	public void testEquals() {
		Bruch a = new Bruch(1,3);
		Bruch b = new Bruch(1,3);
		assertEquals (a, b);
	}

	@Test
	public void testAdd() {
		Bruch a = new Bruch(1,3);
		Bruch b = new Bruch(3,4);
		a.add(b);
		assertEquals (new Bruch(13,12), a);
	}
	
	@Test
	public void testSub() {
		Bruch a = new Bruch(1,3);
		Bruch b = new Bruch(3,4);
		a.sub(b);
		assertEquals (new Bruch(-5,12), a);
	}

	@Test
	public void testMul() {
		Bruch a = new Bruch(1,3);
		Bruch b = new Bruch(3,4);
		a.mul(b);
		assertEquals (new Bruch(3,12), a);
	}

	@Test
	public void testDiv() {
		Bruch a = new Bruch(1,3);
		Bruch b = new Bruch(3,4);
		a.div(b);
		assertEquals (new Bruch(4,9), a);
	}
	
	@Test
	public void cancel() {
		Bruch a = new Bruch(12,20);
		a.cancel();
		assertEquals (new Bruch(3,5), a);
	}
}
