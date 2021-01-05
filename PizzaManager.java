import java.util.Scanner;

/** PizzaManager Skeleton File
 *  CSS 162, Final Project
 * 
 *  This class is a starting point for your final project and is incomplete.
 *  Note that if there are any inconsistencies between this skeleton and
 *  the assignment description, the assignment description controls.
 * 
 *  Author: Rob Nash with edits by Johnny Lin
 */
public class PizzaManager {
	private ArrayList<Pizza> pizzaCount;
    
    /** 
     * The console interface is defined in the start method 
     * You can exit or extend the code below to accomplish all of 
     * the outcomes defined in the homework document
     */
    public void start() {
        char selection='q';
        pizzaCount = new ArrayList<Pizza>();
        Scanner foo = new Scanner(System.in);
        
        while(true) {
            displayAllPizzas();
            displayInstructions();
            
             selection = foo.next().charAt(0);
             //foo.nextChar() doesn't exist, so now what?
            
            switch(selection) {
                case 'A':    
                case 'a':    System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
                                addRandomPizza();
                                break;
                case 'H':    
                case 'h':    System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
                                for(int i = 0; i <= 99; i ++) {
                                	addRandomPizza();
                                }
                                break;                    
                case 'E':    
                case 'e':    System.out.println("Eating a fraction of a pizza. How much? (a/b)");
                                eatSomePizza(foo);
                                break;            
                case 'P':    
                case 'p':     System.out.println("Sorting pizzas by (P)rice");
                               	  sortByPrice();
                                  break;    
                case 'S':    
                case 's':     System.out.println("Sorting pizzas by (S)ize");
                                 sortBySize();
                                 break;          
                case 'C':    
                case 'c':      System.out.println("Sorting pizzas by (C)alories");
                                  sortByCalories();
                                  break;
                case 'B':
                case 'b':    System.out.println("(B)inary search over pizzas by calories(int).  Sorting first.  What calorie count are you looking for?");
                				int calories = foo.nextInt();
                                if(binarySearchByCalories(calories) == -1) {
                                	System.out.println("Pizza not Found");
                                }else {
                                	System.out.println("Found at Index: " + binarySearchByCalories(calories));
                                }
                                break;
                case 'Q':
                case 'q':    System.out.println("(Q)uitting!" );
                                System.exit(0);
                                break;
                default:    System.out.println("Unrecognized input - try again");
            }
        }

    }
    
    /**
     * Description: subtracts the pizza eaten from whole and adjusts everything accordingly
     * @param keys
     * Pre: none
     * Post: none 
     */
    private void eatSomePizza(Scanner keys) {
    	try {
    	if(pizzaCount.size() == 0) {
    		throw new Exception();
    	}
        String input = keys.next();
        System.out.println("At which index?");
        String index = keys.next();
        String[] frac = input.split("/");
        int num = Integer.parseInt(frac[0]);
        int denom = Integer.parseInt(frac[1]);
        Pizza now = (Pizza)pizzaCount.get(Integer.parseInt(index));
        try {
			now.eatSomePizza(new Fraction(num, denom));
		} catch (PizzaException e) {
			pizzaCount.remove(Integer.parseInt(index));
		}
    	}catch(Exception e) {
    		System.out.println("Index Invalid");
    	}
    }
    
    /**
     * Description: adds random pizza to arraylist of pizza
     * Pre: none 
     * Post: none 
     */
    private void addRandomPizza() {
        pizzaCount.append(new Pizza());    
    }
    /**
     * Description: displays the pizzas on the screen 
     * Pre: none 
     * Post: none 
     */
    private void displayAllPizzas() {
    	if(pizzaCount.size() > 0) {
    		for(int i = 0; i < pizzaCount.size(); i++) {
    			System.out.println(pizzaCount.get(i));
    		}
    	}
    }
    /**
     * Description: sorts the pizzas by price from greatest to least 
     * Pre: none 
     * Post: none 
     */
    private void sortByPrice() {  
        int n = pizzaCount.size();  
        for (int j = 1; j < n; j++) {  
            Pizza key = pizzaCount.get(j);  
            int i = j-1;  
            while ( (i > -1) && ( pizzaCount.get(i).compareTo(key) == 1 ) ) {  
            	pizzaCount.remove(i + 1);
            	pizzaCount.insert(pizzaCount.get(i), i + 1);
                i--;  
            }  
            pizzaCount.remove(i + 1);
            pizzaCount.insert(key, i +1);  
        }  
    }
    
    /**
     * Description: sorts by size from greatest to least
     * Pre: none 
     * Post: none 
     */
    private void sortBySize() {
    	int k = pizzaCount.size();
        for(int i = 0; i < k -1; i ++) {
        	int min = i;
        	for( int j = i + 1; j < k; j ++) {
        		if(pizzaCount.get(j).getRemainingArea() > pizzaCount.get(min).getRemainingArea()){
        			min = j;
        		}
        	}
        	pizzaCount.swap(i, min);
        }
    }
    /**
     * Description: sorts by calories from greatest to least 
     * Pre: none 
     * Post: none 
     */
    private void sortByCalories() {
        int k = pizzaCount.size();
        for(int i = 0; i < k -1; i ++) {
        	int min = i;
        	for( int j = i + 1; j < k; j ++) {
        		if(pizzaCount.get(j).getCalories() > pizzaCount.get(min).getCalories()){
        			min = j;
        		}
        	}
        	pizzaCount.swap(i, min);
        }
    }
    /**
     * Description: searches for the calorie asked for using binary search 
     * @param cals
     * @return index 
     * Pre: none 
     * Post: none 
     */
    private int binarySearchByCalories(int cals) {
    	sortByCalories();
    	int start = 0;
		int end = pizzaCount.size() - 1;

		while (start <= end) {
			
			int middle = (start + end) / 2;
			
			if (cals < pizzaCount.get(middle).getCalories()) {
				start = middle + 1;
			}

			if (cals > pizzaCount.get(middle).getCalories()) {
				end = middle - 1;
			}
			
			if (cals == pizzaCount.get(middle).getCalories()) {
				return middle;
			}
		}
		return -1;
    }
    /**
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */
    private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nSort pizzas by (P)rice\nSort pizzas by (S)ize\nSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(Q)uit\n";

    private void displayInstructions() {
        System.out.println(instructions);    
    }

    /*
     * Notice the one-line main function.
     */
    public static void main(String[] args) {
        new PizzaManager().start();
    }
}

