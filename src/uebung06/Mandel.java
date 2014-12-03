package uebung06;

public class Mandel {

	public Mandel() {
	}
	
	public double Function(int n, int x, int c){
		for (int i=0; i<n; i++){
			x= x*x +c;
		}
		return x;
		
	}
}
