/**
 * Description: mozzarella class that extends the cheese class 
 * @author shubhamkamboj
 * Pre: must be packaged with cheese class and ingredient
 * Post:none 
 */
public class Mozzarella extends Cheese{
	
	/**
	 * Description: constructor for the mozzarella class
	 * @param description
	 * @param cost
	 * @param calories
	 * Pre: none 
	 * Post: none 
	 */
	public Mozzarella(String description, Money cost, int calories) {
		super(description, cost, calories);
	}
}
