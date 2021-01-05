/**
 * Description: goat class that extends the cheese class 
 * @author shubhamkamboj
 * Pre: must be packaged with cheese class and ingredient
 * Post:none 
 */
public class Goat extends Cheese{
	
	/**
	 * Description: constructor for the goat class
	 * @param description
	 * @param cost
	 * @param calories
	 * Pre: none 
	 * Post: none 
	 */
	public Goat(String description, Money cost, int calories) {
		super(description, cost, calories);
	}
}
