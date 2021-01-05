/**
 * Description: sausage meat class that extends the superclass of meat
 * @author shubhamkamboj
 * Pre: must be in the same package as the meat class
 * Post: none
 */
public class Sausage extends Meat{
	
	/**
	 * Description: constructor for the sausage class
	 * @param description
	 * @param cost
	 * @param calories
	 * Pre: none 
	 * Post: none 
	 */
	public Sausage(String description, Money cost, int calories) {
		super(description, cost, calories);
	}
}
