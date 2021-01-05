import java.io.Serializable;

/**
 * Description: Money class used to store dollar and cent value into an object
 * @author shubhamkamboj
 *Pre: Dollar must be >0 and cents must be less than 99
 *Post: none
 *Outcome: Money object created
 */
public class Money implements Comparable<Object>, Cloneable, Serializable{

	private static final long serialVersionUID = 1L;
	public int dollars;
	public int cents;
	/**
	 * Description: constructor assigns dollar value 
	 * @param dol
	 * Pre: Dollar must be greater than 0
	 * Post: makes dollar object 
	 * @throws Exception 
	 */
	public Money(int dol){ // constructor 
		if(dol<0) { // checks for class invarients 
			System.out.println("Enter a valid dollar amount");
		}else {
		this.dollars = dol;
		this.cents = 00;
		}
	}
	/**
	 * Description: Constructor assigns dollar and cent value
	 * Pre: Dollar and cent must be greater than 0. Cent must be less than 99
	 * Post: Makes a money object 
	 * @param dol
	 * @param cent
	 */
	public Money(int dol, int cent){
		this.dollars = dol;
		if(cent > 99) {
			this.cents = Math.round(cent/10);
		}
			this.cents = cent;
	}
	/**
	 * Description: Creates a new money object that is same as one thats given
	 * Pre: Object must be of money class
	 * Post: Creates an identical new money object 
	 * @param other 
	 */
	public Money(Money other){
		this(other.getDollar(), other.getCent());
	}
	/**
	 * Description: gets the dollar amount of the object 
	 * Pre: Must call it with an instance 
	 * Post: returns an int
	 * @return int
	 */
	public int getDollar() {
		return this.dollars;
	}
	/**
	 * Description: gets the cent amount for the object
	 * Pre: Must call the method with an instance of the class
	 * Post: returns an int 
	 * @return int
	 */
	public int getCent() {
		return this.cents;
	}
	/**
	 * Description: sets the dollar amount to the given value
	 * Pre: dollar amount must be greater than 0
	 * Post: sets dollars to desired amount for the object 
	 * @param dol
	 */
	public void setDollar(int dol) {
		this.dollars = dol;
	}
	/**
	 * Description: sets the cents amount to the given value
	 * Pre: Cent amount must be greater than 0 and less than 99
	 * Post: sets cents to desired amount for the object 
	 * @param cents
	 */
	public void setCent(int cents) {
		this.cents = cents;
	}
	/**
	 * Description:gets the money object in a double form 
	 * @return double 
	 * Pre: must call the method with an instance of the same class
	 * Post: returns the money object in a double form
	 */
	public double getMoney() { // displays the money in double format
		String toRet = "";
		if(this.cents < 10) {
			toRet = this.dollars + ".0" + this.cents;
		}else {
			toRet = this.dollars + "." + this.cents;
		}
		return Double.parseDouble(toRet);
	}
	/**
	 * Description: Sets the dollar and sent amount
	 * @param dol
	 * @param cent
	 * Pre: dollar must be greater than 0 and cent must be greater than 0 and less than 99
	 * Post: Sets money object to desired dollar and cent amount 
	 */
	public void setMoney(int dol, int cent) { // sets the money 
		this.setDollar(dol);
		this.setCent(cent);
	}
	/**
	 * Description: adds dollar to the total dollar amount for the object 
	 * Pre: dollar must be greater than 0
	 * Post: dollar is increased by desired amount
	 * @param dol
	 */
	public void add(int dol) {
		this.dollars += dol;
	}
	/**
	 * Description: adds dollar amount to the total dollar and adds the cents to the total cents 
	 * Pre: dollar must be greater than 0 and cents must be greater than 0 and less than 99
	 * Post: Dollars and cents get increased by the desired amount
	 * @param dol
	 * @param cent
	 */
	public void add(int dol, int cent) {
		this.dollars += dol;
		this.cents += cent;
	}
	/**
	 * Description: Takes in money object and add its dollar and cents to the other object 
	 * Pre:dollar must be greater than 0 and cents must be greater than 0 and less than 99
	 * Post: Money objects values added to the instance upon which it is called
	 * @param other
	 */
	public void add(Money other) { // adds one money object to another 
		this.dollars += other.getDollar();
		int cents = this.cents + other.getCent();
		if(cents > 99) {
			this.dollars += 1;
			cents = cents - 100;
		}
		this.cents = cents;
	}
	/**
	 * Description: compares if object is equal to the Money class object 
	 * Pre: none
	 * Post: returns true if object is equal to the money object 
	 */
	public boolean equals(Object other) { 
		if(other == null || !(other instanceof Money)) { //checks if object is an instance of money and if it is null
			return false;
		}
		Money other1 = (Money)other;
		if(other1.getDollar() == this.dollars && other1.getCent() == this.cents) { // checks the dollars and cents of both to see if equal
			return true;
		}
		return false;
	}
	/**
	 * Description: Prints out the object in a string format 
	 * Pre: object must be of class Money 
	 * Post: A string representation of money object
	 */
	public String toString() {
		if(this.cents < 10) {
			return "$" + this.dollars + ".0" + this.cents;
		}
		return "$" + this.dollars + "." + this.cents;
	}
	/**
	 * Description: compareTo method that compares two money objects and returns an integer that indicates
	 * which is bigger 
	 * @param other
	 * @return int 
	 * Pre: none 
	 * Post: none 
	 */
	public int compareTo(Object other) {
		if(!(other.getClass().equals(this.getClass()))) {
			return -5;
		}else {
			Money toCompare = (Money)other;
			if(toCompare.getMoney() < this.getMoney()) {
				return 1;
			}
			if(toCompare.getMoney() > this.getMoney()) {
				return -1;
			}
		}
		return 0;
	}
	/**
	 * Description: clone method for money 
	 * Pre:none 
	 * Post: none 
	 */
	public Money clone() {
		return new Money(this.getDollar(), this.getCent());
	}
}
