/* 
 * CSS 162, Pizza Manager Project
 * 
 * This interface can do everything the Comparable interface can and more
 * 
 * Author: Rob Nash with minor edits by Johnny Lin
 */
public interface PizzaComparable extends Comparable {  
                                        //Example of interface inheritance
	
	@Override
	/**
	 * Description: compare to method which compares pizzas using their price 
	 * @return int 
	 * Pre: none 
	 * Post: none 
	 */
	public int compareTo(Object o);          //a.k.a compareToByPrice

	//non-overrides
	/**
	 * Description: compare to method which compares pizzas using their size;
	 * @param o
	 * @return int 
	 */
	public int compareToBySize(Object o);    //a.k.a. compareToByAreaLeft
	/**
	 * Description: compare to method which compares pizzas using their calories 
	 * @param o
	 * @return int
	 */
	public int compareToByCalories(Object o);	
	
}
