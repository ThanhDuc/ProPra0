package uebung00;

public class PrintStr {

	public static void main(String[] args) {
		System.out.println("Hello World");
		//3.1
		System.out.println(args[0]);
		System.out.println(args[args.length - 1]);
		//3.2
		int i = 0;
		while (i<args.length) {
			System.out.print(args[i] + " ");
			i++;			
		}
		
		
		
		

	}

}
