package uebung00;

public class Test extends Bruchzahl {
	
	int zaeler1;
	int nenner1;
	int zaeler2;
	int nenner2;
	
	public static void main(String[] args) {
		
		Bruchzahl test1 = new Bruchzahl();
		Bruchzahl test2 = new Bruchzahl();
		test1.setZaeler(1);
		test1.setNenner(2);
		test2.setZaeler(2);
		test2.setNenner(6);
		
		add(test1.getZaeler(),test1.getNenner(),test2.getZaeler(),test2.getNenner());
		
		

	}

}
