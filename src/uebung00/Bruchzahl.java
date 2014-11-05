package uebung00;

public class Bruchzahl {
	static int zaeler;
	static int nenner;
	double result;
	
	public static int getZaeler() {
		return zaeler;
	}
	public static void setZaeler(int zaeler) {
		this.zaeler = zaeler;
	}
	public static int getNenner() {
		return nenner;
	}
	public static void setNenner(int nenner) {
		this.nenner = nenner;
	}
	
	public static int add(int z1, int n1, int z2, int n2){
		setZaeler(z1*n2+z2*n1);
		setNenner(n1*n2);
		return getZaeler() & getNenner();
		
				
	}
	
	public double sub(int z1, int n1, int z2, int n2){
		return (z1*n2-z2*n1)/(n1*n2);
				
	}
	
	public double mul(int z1, int n1, int z2, int n2){
		return (z1*z2)/(n1*n2);
	}
	
	public double div(int z1, int n1, int z2, int n2){
		return (z1*n2)/(n1*z2);
	}
	
	public boolean equal(int z1, int n1, int z2, int n2){
		return (z1/n1) == (z2/n2);
	}
	
	public String toString(){
		return getZaeler() + "/" + getNenner();
	}
	
}
