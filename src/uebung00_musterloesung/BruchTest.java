package uebung00_musterloesung;

public class BruchTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("BruchZahl Test");
		
		System.out.println();
		System.out.println("Konstruktoren");

		Bruch a = new Bruch(1,4);
		Bruch b = new Bruch(1,3);
		
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		
		Bruch c = new Bruch(b);
		System.out.println("c = new BruchZahl(b) = "+c);
		
		System.out.println();
		System.out.println("Getter/Setter");
		
		System.out.println("Zaehler von c = "+c.getZaehler());
		System.out.println("Nenner von c = "+c.getNenner());
		System.out.println("c.setZahler(3)");
		System.out.println("c.setNenner(5)");
		c.setZaehler(3);
		c.setNenner(5);
		System.out.println("Zaehler von c = "+c.getZaehler());
		System.out.println("Nenner von c = "+c.getNenner());

		System.out.println();
		System.out.println("Methoden");
		
		c.add(a);
		System.out.println("c = c + a = "+c+" = "+c.cancel()+" (gekürzt)");

		c.sub(a);
		System.out.println("c = c - a = "+c+" = "+c.cancel()+" (gekürzt)");
		
		c.mul(b);
		System.out.println("c = c * b = "+c+" = "+c.cancel()+" (gekürzt)");

		c.div(b);
		System.out.println("c = c / b = "+c+" = "+c.cancel()+" (gekürzt)");
	}

}
