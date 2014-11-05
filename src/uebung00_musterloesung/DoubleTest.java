package uebung00_musterloesung;

public class DoubleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double d = 0.1;	
		System.out.println("--------------------------");
		System.out.println("adding doubles");
		for (int i=0; i<10; i++) {
			System.out.println(d);
			d += 0.1;
		}

		System.out.println("--------------------------");
		System.out.println("adding Brüche");
		Bruch b = new Bruch (1,10);
		for (int i=0; i<10; i++) {
			System.out.println(b);
			b.add (new Bruch(1,10));
			b.cancel();
		}
		System.out.println("--------------------------");
	}
}
