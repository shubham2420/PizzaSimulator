/**
 * Description: pepperoni meat class that extends the superclass of meat
 * @author shubhamkamboj
 * Pre: must be in the same package as the meat class
 * Post: none
 */
public class Pepperoni extends Meat{
	
	/**
	 * Description: constructor for the pepperoni class
	 * @param description
	 * @param cost
	 * @param calories
	 * Pre: none 
	 * Post: none 
	 */
	public Pepperoni(String description, Money cost, int calories) {
		super(description, cost, calories);
	}
}
