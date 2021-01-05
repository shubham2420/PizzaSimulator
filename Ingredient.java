/**
 * Description: Ingredient class at top of the heirarchy
 * @author shubhamkamboj
 *Pre: none 
 *Post: none 
 */
public class Ingredient implements Comparable{
	
	public final String description;
	public final Money cost;
	public final int calorieCount;
	
	/**
	 * Description: constructor for the ingredient class
	 * @param description
	 * @param cost
	 * @param calorieCount
	 * Pre: none 
	 * Post: none 
	 */
	public Ingredient(String description, Money cost, int calorieCount) {
		this.description = description;
		this.cost = cost;
		this.calorieCount = calorieCount;
	}
	
	/**
	 * Description: returns the description of the ingredient 
	 * @return string
	 * Pre: none
	 * Post: none 
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Description: returns the cost of the ingredient 
	 * @return money 
	 * Pre: none 
	 * Post: none 
	 */
	public Money getCost() {
		return this.cost;
	}
	
	/**
	 * Description: returns the calorie count of the ingredient 
	 * @return int
	 * Pre: none 
	 * Post: none 
	 */
	public int getCalorieCount() {
		return this.calorieCount;
	}
	
	/**
	 * Description: toString method for ingredient
	 * Pre: none 
	 * Post: none 
	 */
	public String toString() {
		return "The ingredient is " + this.description + ". The calories are " + this.calorieCount + 
				" and it costs " + this.cost;
	}
	
	/**
	 * Description: equals method for ingredient 
	 * @return boolean
	 * Pre: none 
	 * Post: none 
	 */
	public boolean equals(Object other) {
		if(other == null || !(other instanceof Ingredient)) {
			return false;
		}else {
		Ingredient compare = (Ingredient)other;
			if(compare.description.equals(this.description) && compare.cost.equals(this.cost) && 
				compare.calorieCount == this.calorieCount) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Description: compares the cost of ingredients and returns a integer
	 * Pre: none 
	 * Post: none 
	 */
	public int compareTo(Object other) {
		if(!(other.getClass().equals(this.getClass()))) {
			return -5;
		}
		Ingredient toCompare = (Ingredient)other;
		return this.cost.compareTo(toCompare.cost);
	}
}
