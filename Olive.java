import java.awt.Color;

/**
 * Description: olive class that extends the vegetable class 
 * @author shubhamkamboj
 * Pre: must be in the same class as the vegetable superclass
 * Post: none 
 */
public class Olive extends Vegetable{
	
	/**
	 * Description: constructor for the Olive class with 3 parameters
	 * @param description
	 * @param cost
	 * @param calories
	 * Pre: none
	 * Post: none 
	 */
	public Olive(String description, Money cost, int calories) {
		super(description, cost, calories);
	}
	
	/**
	 * Description: second constructor for the Olive class with 4 parameters
	 * @param description
	 * @param cost
	 * @param calories
	 * @param myColor
	 * Pre: none 
	 * Post: none 
	 */
	public Olive(String description, Money cost, int calories, Color myColor) {
		super(description, cost, calories, myColor);
	}
}
