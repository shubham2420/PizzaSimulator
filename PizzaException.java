/**
 * Description: exception class that throws a pizza exception 
 * @author shubhamkamboj
 * Pre: none
 *Post: none 
 */
public class PizzaException extends Exception{
	private static final long serialVersionUID = 1L;
	/**
	 * Description: constructor for the pizza class 
	 * Pre: none 
	 * Post: none 
	 */
	public PizzaException() {
		super("PizzaException"); //calls the super constructor 
	}
	/**
	 * Description: constructor that takes in a string argument 
	 * @param message
	 * Pre: none 
	 * Post: none 
	 */
	public PizzaException(String message) {
		super(message); // calls the super constructor with a one arg parameter
	}
}