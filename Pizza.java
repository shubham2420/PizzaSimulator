import java.awt.Color;

/**
 * Description: pizza class that keeps track of the details of a pizza
 * @author shubhamkamboj
 * Pre: must be packaged with its respective pizza details
 * Post: none 
 */
public class Pizza implements PizzaComparable{
	ArrayList<Ingredient> listOfIngre;
	private int totalCalories;
	private Money totalMoney;
	private Shape myShape;
	private Fraction remaining;
	private int ingredientSize = 0;
	/**
	 * Description: no arg constructor for pizza that generates a random pizza 
	 * Pre: none 
	 * Post: none 
	 */
	public Pizza() {
		listOfIngre = new ArrayList<Ingredient>();
		totalMoney = new Money(0,0);
		this.remaining = new Fraction();
		int baseRand = (int) (Math.random() *2);
		int cheeseRand = (int) (Math.random() *2);
		int meatRand = (int) (Math.random() *3);
		int veggieRand = (int) (Math.random() *3);
		int shapeRand = (int) (Math.random() *2);
		Base base1 = new Alfredo("White sauce base", new Money(2,10), 100);
		Base base2 = new Marinara("Tomato based sauce", new Money(1,70), 80);
		Cheese cheese1 =  new Mozzarella("Cow based cheese",new Money(3, 30), 124);
		Cheese cheese2 = new Goat("Goat based cheese", new Money(2,83), 219);
		Meat meat1 = new Pepperoni("Slices of pepperoni", new Money(1, 76), 257);
		Meat meat2 = new Sausage("Mix of meats", new Money(1, 85), 129);
		Vegetable veggie1 = new Pepper("Green pepper into thin slices", new Money(0,50), 37, Color.green);
		Vegetable veggie2 = new Olive("Sliced Black olives", new Money(1, 10),26, Color.black);
		if(baseRand == 0) {
			this.addIngredient(base1);
		}else if(baseRand == 1) {
			this.addIngredient(base2);
		}
		if(cheeseRand == 0) {
			this.addIngredient(cheese1);
		}else if(cheeseRand == 1) {
			this.addIngredient(cheese2);
		}
		if(meatRand == 0) {
			this.addIngredient(meat1);
		}else if(meatRand == 1) {
			this.addIngredient(meat2);
		}else if(meatRand == 2){
			this.addIngredient(meat1);
			this.addIngredient(meat2);
		}
		if(veggieRand == 0) {
			this.addIngredient(veggie1);
		}else if(veggieRand == 1) {
			this.addIngredient(veggie2);
		}else if(veggieRand == 2){
			this.addIngredient(veggie1);
			this.addIngredient(veggie2);
		}
		if(shapeRand == 0) {
			this.myShape = new Square(1, 1, 4);
		}else if(shapeRand == 1) {
			this.myShape = new Circle(1, 1, 5);
		}
	}
	/**
	 * Description: gets the remaining fraction of pizza left after being eaten 
	 * @return fraction
	 * Pre: none 
	 * Post: none 
	 */
	public Fraction getRemaining() {
		return this.remaining;
	}
	
	/**
	 * Description: sets the remaining fraction of pizza left
	 * @param frac
	 * Pre: none 
	 * Post:none 
	 */
	public void setRemaining(Fraction frac) {
		this.remaining = frac;
	}
	
	/**
	 * Description: gets the total calories on the pizza
	 * @return int
	 * Pre: none 
	 * Post: none 
	 */
	public int getCalories() {
		return this.totalCalories;
	}
	
	/**
	 * Description: gets the total cost of the pizza
	 * @return money 
	 * Pre: none 
	 * Post: none 
	 */
	public Money getCost() {
		double num = this.remaining.getNumerator() * this.totalMoney.getMoney();
		double result = num/ this.remaining.getDenominator();
		result *= 100;
		String result1 =  "" + (double)(Math.round(result))/100;
		String split[] = result1.split("\\.");
		int whole = Integer.parseInt(split[0]);
		int cents = Integer.parseInt(split[1]);
		this.totalMoney = new Money((int)whole, (int)cents);
		return this.totalMoney;
	}
	/**
	 * Description: gets the remaining area of the pizza 
	 * @return double
	 * Pre: none 
	 * Post: none 
	 */
	public double getRemainingArea() {
		//double decimal = Double.parseDouble(this.remaining.getNumerator() + "")/Double.parseDouble(this.remaining.getDenominator() + "");
		//double eaten = decimal * this.myShape.getArea();
		double num = myShape.getArea()* this.remaining.getNumerator();
		double result = num/this.remaining.getDenominator();
		return result;
	}
	
	/**
	 * Description: sets the shape for the pizza
	 * @param s
	 * Pre: none
	 * Post: none 
	 */
	public void setShape(Shape s) {
		this.myShape = (Shape)s.clone();
	}
	
	/**
	 * Description: return the shape of the pizza
	 * @return shape
	 * Pre: none 
	 * Post: none 
	 */
	public Shape getShape() { 
		return (Shape) myShape.clone();
	}
	/**
	 * Description: adds ingredient to the list and updates calorie and money
	 * @param a
	 * Pre: none 
	 * Post: none 
	 */
	public void addIngredient(Ingredient a) {
		listOfIngre.insert(a, this.ingredientSize);
		totalCalories += a.getCalorieCount();
		totalMoney.add(a.getCost());
		this.ingredientSize++;
	}
	/**
	 * Description: subtracts the pizza amount eaten from the remaining pizza
	 * @param amt
	 * Pre: none 
	 * post: none 
	 * @throws PizzaException 
	 */
	public void eatSomePizza(Fraction amt) throws PizzaException {
		Fraction test = this.remaining.subtract(amt);
		if(test.getNumerator() == 0) {
			throw new PizzaException();
		}
		try {
			if(test.getNumerator() < 0) {
				throw new Exception();
			}
		}catch(Exception e) {
			System.out.println("Cannot eat more than whats left");
		}
		if(!(test.getNumerator() < 0)) {
			this.remaining = this.remaining.subtract(amt);
			this.getCost();
		}
	}
	/**
	 *Description: compareTo method that compares two pizzas by their cost and returns an int
	 *@return int
	 *Pre: none 
	 *Post: none  
	 */
	public int compareTo(Object other) {
		if(!(this.getClass().equals(other.getClass())) || other == null) {
			return -5;
		}else {
			Pizza toCompare = (Pizza)other;
			if(toCompare.totalMoney.compareTo(this.totalMoney) == -1) {
				return -1;
			}else if(toCompare.totalMoney.compareTo(this.totalMoney) == 1) {
				return 1;
			}else {
				return 0;
			}
		}
	}
	/**
	 * Description: to String method for pizza 
	 * Pre: none 
	 * Post: none 
	 */
	public String toString() {
		return "Pizza has a price:" + this.totalMoney + " and calories: " + this.totalCalories + 
				", Fraction remaining: " + this.remaining +  " and area left: " + this.getRemainingArea() + " and shape: " + this.myShape;
	}
	
	/**
	 *Description: compareTo method that compares two pizzas by their size and returns an int
	 *@return int
	 *Pre: none 
	 *Post: none  
	 */
	public int compareToBySize(Object other) {
		if(!(this.getClass().equals(other.getClass())) || other == null) {
			return -5;
		}else {
			Pizza toCompare = (Pizza)other;
			if(toCompare.myShape.getArea() > this.myShape.getArea()) {
				return -1;
			}else if(toCompare.myShape.getArea() < this.myShape.getArea()) {
				return 1;
			}else {
				return 0;
			}
		}
	}
	
	/**
	 *Description: compareTo method that compares two pizzas by their calories and returns an int
	 *@return int
	 *Pre: none 
	 *Post: none  
	 */
	public int compareToByCalories(Object other) {
		if(!(this.getClass().equals(other.getClass())) || other == null) {
			return -5;
		}else {
			Pizza toCompare = (Pizza)other;
			if(toCompare.totalCalories > this.totalCalories) {
				return -1;
			}else if(toCompare.totalCalories < this.totalCalories) {
				return 1;
			}else {
				return 0;
			}
		}
	}
}
