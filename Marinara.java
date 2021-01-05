/**
 * Description: marinara class that extends the base class
 * @author shubhamkamboj
 * Pre: must be in the same package as the base class
 * Post: none 
 */
public class Marinara extends Base{
	
	/**
	 * Description: constructor for the marinara class 
	 * @param description
	 * @param cost
	 * @param calories
	 * Pre: none
	 * Post: none 
	 */
	public Marinara(String description, Money cost, int calories) {
		super(description, cost, calories);
	}
}
