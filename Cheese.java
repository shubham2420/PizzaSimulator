/**
 * Description: cheese class that inherits from ingredient
 * @author shubhamkamboj
 * Pre: must be packaged with ingredient class
 * Post: none 
 */
public class Cheese extends Ingredient{
	
	/**
	 * Description: constructor for cheese which calls ingredients constructor
	 * @param description
	 * @param cost
	 * @param calorieCount
	 * Pre: none 
	 * Post: none 
	 */
	public Cheese(String description, Money cost, int calorieCount) {
		super(description, cost, calorieCount);
	}
}
