/**
 * Description: meat class that inherits from ingredient
 * @author shubhamkamboj
 * Pre: must be packaged with ingredient class
 * Post: none 
 */
public class Meat extends Ingredient{
	/**
	 * Description: constructor for meat which calls ingredients constructor
	 * @param description
	 * @param cost
	 * @param calorieCount
	 * Pre: none 
	 * Post: none 
	 */
	public Meat(String description, Money cost, int calorieCount) {
		super(description, cost, calorieCount);
	}
}
