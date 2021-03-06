package uebung00_musterloesung;

/**
 * Implements a Bruchzahl (Zaehler / Nenner).
 * 
 * @author kif
 *
 */
public class Bruch {
	private int zaehler = 1;
	private int nenner = 1;
	
	/**
	 * Default Constructor with zaehler and nenner. May throw an
	 * exception if set to 0.
	 * 
	 * @param zaehler
	 * @param nenner
	 */
	public Bruch(int zaehler, int nenner) {
		if (nenner==0) {
			throw new IllegalArgumentException(Integer.toString(nenner));			
		}
		
		this.zaehler = zaehler;
		this.nenner = nenner;
	}
	
	/**
	 * Copy Constructor.
	 * 
	 * @param other
	 */
	public Bruch(Bruch other) {
		this.zaehler = other.zaehler;
		this.nenner = other.nenner;
	}

	
	@Override
	/**
	 * Warning, due to performance reasons the Bruchzahlen are not cancled before testing equality.
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Bruch other = (Bruch) obj;
		if (nenner!=other.nenner)
			return false;
		if (zaehler!=other.zaehler)
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "("+this.zaehler+" / "+this.nenner+")";
	}
	
	/**
	 * Adds the BruchZahl given as parameter to this one. Does not automatically cancel() the BruchZahl.
	 * 
	 * @param other
	 */
	public void add(Bruch other) {
		this.zaehler = this.zaehler*other.nenner + other.zaehler*this.nenner;
		this.nenner *= other.nenner;
	}

	/**
	 * Subtracts the BruchZahl given as parameter from this one. Does not automatically cancel() the BruchZahl.
	 * 
	 * @param other
	 */
	public void sub(Bruch other) {
		this.zaehler = this.zaehler*other.nenner - other.zaehler*this.nenner;
		this.nenner *= other.nenner;
	}
	
	/**
	 * Multiplies this BruchZahl by the given one. Does not automatically cancel() the BruchZahl.
	 * 
	 * @param other
	 */
	public void mul(Bruch other) {
		this.zaehler *= other.zaehler;
		this.nenner *= other.nenner;
	}

	/**
	 * Divides this BruchZahl by the given one. Does not automatically cancel() the BruchZahl.
	 * 
	 * @param other
	 */
	public void div(Bruch other) {
		this.zaehler *= other.nenner;
		this.nenner *= other.zaehler;
	}
	
	/**
	 * Classic cancel operations. Also returns the result.
	 * 
	 * @return the canceled BruchZahl
	 */
	public Bruch cancel() {
		boolean once_more;
		do {
			int min = Math.min(this.zaehler, this.nenner);
			once_more = false;
			for (int i=2; i<=min; i++) {
				if (this.zaehler%i==0 && this.nenner%i==0) {
					this.zaehler /= i;
					this.nenner /= i;
					once_more = true;
					break;
				}
			}
		} while (once_more);
		
		return this;
	}

	public int getZaehler() {
		return zaehler;
	}

	public void setZaehler(int zaehler) {
		this.zaehler = zaehler;
	}

	public int getNenner() {
		return nenner;
	}

	/**
	 * Sets the nenner. Throws an exception if set to 0.
	 * 
	 * @param nenner
	 */
	public void setNenner(int nenner) {
		if (nenner==0) {
			throw new IllegalArgumentException(Integer.toString(nenner));			
		}

		this.nenner = nenner;
	}
}
