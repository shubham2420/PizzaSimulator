import java.awt.Color;
/**
 * Description: vegetable class that inherits from ingredient
 * @author shubhamkamboj
 * Pre: must be packaged with ingredient class
 * Post: none 
 */
public class Vegetable extends Ingredient {
	private Color myColor;
	/**
	 * Description: constructor for vegetable which calls ingredients constructor
	 * @param description
	 * @param cost
	 * @param calorieCount
	 * Pre: none 
	 * Post: none 
	 */
	public Vegetable(String description, Money cost, int calorieCount) {
		super(description, cost, calorieCount);
		myColor = Color.black;
	}
	
	/**
	 * Description: vegetable constructor that takes the description, cost, calories and the color
	 * @param description
	 * @param cost
	 * @param calorieCount
	 * @param myColor
	 * Pre: none 
	 * Post: none 
	 */
	public Vegetable(String description, Money cost, int calorieCount, Color myColor) {
		super(description, cost, calorieCount);
		this.myColor = myColor;
	}
	
	/**
	 * Description: gets the color of the vegetable
	 * @return color
	 * Pre: none 
	 * Post: none 
	 */
	public Color getColor() {
		return this.myColor;
	}
	
	/**
	 * Description: sets the color of the vegetable
	 * @param toSet
	 * Pre: none 
	 * Post: none 
	 */
	public void setColor(Color toSet) {
		myColor = toSet;
	}
	
	/**
	 * Description: to string method for the vegetable class
	 * Pre: none 
	 * Post: none 
	 */
	public String toString() {
		return super.toString() + ". The color is " + this.myColor;
	}
	
	/**
	 * Description: equals method for the vegetable class
	 * Pre: none 
	 * Post: none 
	 */
	public boolean equals(Object other) {
		if(other == null || !(other instanceof Ingredient)) {
			return false;
		}else {
			Vegetable toCompare = (Vegetable)other;
			if(super.equals(other) == true && toCompare.myColor.equals(this.myColor)) {
				return true;
			}
		}
		return false;
	}
}
