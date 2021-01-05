/**
 * Description: base class that inherits from ingredient
 * @author shubhamkamboj
 * Pre: must be packaged with ingredient class
 * Post: none 
 */
public class Base extends Ingredient {
	
	/**
	 * Description: constructor for base which calls ingredients constructor
	 * @param description
	 * @param cost
	 * @param calorieCount
	 * Pre: none 
	 * Post: none 
	 */
	public Base(String description, Money cost, int calorieCount) {
		super(description, cost, calorieCount);
	}
}
