/**
 * Description: fraction class that takes a numerator and denominator
 * @author shubhamkamboj
 * Pre: none
 * Post: none 
 */
public class Fraction implements Comparable{
	private final int numerator;
	private final int denominator;
	
	/**
	 * Description: no arg constructor which sets denominator and numerator to 1
	 * Pre: none 
	 * Post: none 
	 */
	public Fraction() { //default values
		this.numerator = 1;
		this.denominator = 1;
	}
	/**
	 * Description: fraction constructor that takes a numerator and denominator 
	 * @param x
	 * @param y
	 * Pre: none 
	 * Post: none 
	 */
	public Fraction(int num, int denom) {
		int gcd = 1;
        for(int i = 1; i <= num && i <= denom; i++) // finds the greatest common factor 
        {
            if(num%i==0 && denom%i==0)
                gcd = i;
        }
        if (gcd != 1) {
            num /= gcd;
            denom /= gcd;
        }
        this.numerator = num;
        this.denominator = denom;
	}
	/**
	 * Description: equals method for fraction that determines if two fractions are equal
	 * Pre: none 
	 * Post: none 
	 */
	public boolean equals(Object other) { //equals method for two fractions 
		if(!(other.getClass().equals(this.getClass()) || other == null)){
			return false;
		}else {
			Fraction toCompare = (Fraction)other;
			if(this.numerator == toCompare.getNumerator() && 
					this.denominator == toCompare.getDenominator()) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Description: gets the numerator for the fraction
	 * @return int
	 * Pre: none 
	 * Post: none 
	 */
	public int getNumerator() { //returns numerator 
		return this.numerator;
	}
	/**
	 * Description: gets the denominator for the fraction 
	 * @return int
	 * Pre: none 
	 * Post: none 
	 */
	public int getDenominator() { //returns denominator 
		return this.denominator;
	}
	
	/**
	 * Description: to string method for fraction 
	 * Pre: none 
	 * Post: none 
	 */
	public String toString() { // to string method for fraction object 
		return this.numerator + "/" + this.denominator;
	}
	
	/**
	 * Description: compare to method that compares two fraction objects 
	 * @param other
	 * @return int
	 * Pre: none
	 * Post: none 
	 */
	public int compareTo(Object other) {
		if(!(other.getClass().equals(this.getClass())) || other == null) {
			return -5;
		}else {
			Fraction toCompare = (Fraction)other;
			double decimal = Double.parseDouble(this.getNumerator() + "")/Double.parseDouble(this.getDenominator() + "");
			double decimal2 = Double.parseDouble(toCompare.getNumerator() + "")/Double.parseDouble(toCompare.getDenominator() + "");
			if(decimal > decimal2) {
				return 1;
			} else if(decimal < decimal2) {
				return -1;
			}else {
				return 0;
			}
		}
	}
	/**
	 * Description: method that subtracts one fraction from the other
	 * @param other
	 * @return fraction 
	 * Pre: none 
	 * Post: none 
	 */
	public Fraction subtract(Fraction other) {
		int thisNum = this.numerator * other.denominator;
		int denom = this.denominator * other.denominator;
		int objectNum = other.numerator * this.denominator;
		int newNum = thisNum - objectNum;
		int gcd = 1;
        for(int i = 1; i <= newNum && i <= denom; i++) // finds the greatest common factor 
        {
            if(newNum%i==0 && denom%i==0)
                gcd = i;
        }
        if (gcd != 1) {
            newNum /= gcd;
            denom /= gcd;
        }
		return new Fraction(newNum, denom);
	}
}
