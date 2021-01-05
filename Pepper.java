import java.awt.Color;

/**
 * Description: pepper class that extends the vegetable class 
 * @author shubhamkamboj
 * Pre: must be in the same class as the vegetable superclass
 * Post: none 
 */
public class Pepper extends Vegetable{
	
	/**
	 * Description: constructor for the pepper class with 3 parameters
	 * @param description
	 * @param cost
	 * @param calories
	 * Pre: none
	 * Post: none 
	 */
	public Pepper(String description, Money cost, int calories) {
		super(description, cost, calories);
	}
	
	/**
	 * Description: second constructor for the pepper class with 4 parameters
	 * @param description
	 * @param cost
	 * @param calories
	 * @param myColor
	 * Pre: none 
	 * Post: none 
	 */
	public Pepper(String description, Money cost, int calories, Color myColor) {
		super(description, cost, calories, myColor);
	}
}
