package Uebung1;

public class Bruchzahl {
	int zaeler;
	int nenner;
	
	public int getZaeler() {
		return zaeler;
	}
	public void setZaeler(int zaeler) {
		this.zaeler = zaeler;
	}
	public int getNenner() {
		return nenner;
	}
	public void setNenner(int nenner) {
		this.nenner = nenner;
	}
	
	public double add(int z1, int n1, int z2, int n2){
		return (z1*n2+z2*n1)/(n1*n2);
				
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
		return null ;
	}
	
}
