/**
 * Description: Arraylist class that has same functionality as in built arraylist class
 * @author shubhamkamboj
 * Pre: none
 * Post: none 
 * @param <TBA>
 */
public class ArrayList <T>{ //arraylist class declared
	private Object[] theArray;  // an array of object
	
	/**
	 * Description: constructor for arraylist
	 * Pre: none 
	 * Post: none
	 */
	public ArrayList() { // initializes the object and gives it length of zero 
		theArray = new Object[0];
	}
	/** 
	 * Description: inserts the object at the desired index
	 * Pre: index must be less than arrays length 
	 * Post: Moves every object over and inserts the object at desired index 
	 */
	public void insert(Object other, int index){  
		Object[] tempArray = createAndCopyNewArray(this.theArray); // creates a new array with theArray value with a added length of 1
		//
		for(int i = tempArray.length-1; i > index ; i--) { // moves all the elements over to make space for object at index
			Object temp = tempArray[i-1];
			tempArray[i] = temp;
		}
		
		tempArray[index] = other; //adds object at the desired index
		this.theArray = tempArray;
	}
	/**
	 * Description: adds the object to the end of the array
	 * @param other
	 * Pre: none 
	 * Post: none 
	 */
	public void append(Object other) {
		this.insert(other, theArray.length);
	}
	/**
	 * Description: replaces the object at the specified index with the one given
	 * @param other
	 * @param index
	 */
	public void replace(Object other, int index) {
		theArray[index] = other;
	}
	/**
	 * Description: checks for an empty array
	 * Pre: none
	 * Post: none 
	 */
	public boolean isEmpty() { 
		if(this.theArray.length == 0) { //checks if array length is 0
			return true;
		}
		return false;
		
	}
	/**
	 * Description: removes the object at the given index
	 * Pre: index must be less than arrays length 
	 * Post: removes the object at the index and shortens the arraylength by 1  
	 */
	public Object remove(int index) {   
		Object toReturn = this.theArray[index]; // the object which is being removed
		Object[] tempArray = new Object[theArray.length-1]; //creates same array with one less length 
		int t=0; // index for tempArray
		for(int i = 0; i < theArray.length; i++) {
			if (i!=index) { // copy array element
				tempArray[t] = this.theArray[i];
				t++;
			}//~if
		}
		this.theArray = tempArray; 
		return toReturn;
	}
	/**
	 * Description: returns the index of the desired object
	 * Pre: none 
	 * Post: none 
	 */
	public int indexOf(Object other) {  
		int index = -1;  // returns -1 if object not found 
		for(int i = 0; i < this.theArray.length;i++) {
			if(this.theArray[i].equals(other)) {
				index = i;
			}
		}
		return index;
	}
	/**
	 * Description: checks if two arraylists are equals to eachother
	 * Pre: Arraylist must be populated 
	 * Post:none 
	 */
	public boolean equals(ArrayList other) {  
		for(int i = 0; i < this.theArray.length ; i++) {
			if(!(other.get(i).equals(this.theArray[i]))){ //if it doesnt equal, then break and return false
				break;
			}else {
				return true;
			}
		}
		return false;
	}
	/**
	 * Description: returns size of the arraylist
	 * Pre: none
	 * Post: none 
	 */
	public int size() {  
		return this.theArray.length; 
	}
	/**
	 * Description: returns the object at desired index
	 * Pre: index must be less than arrays length  
	 * Post: none 
	 */
	public T get(int index) { 
		return (T)this.theArray[index];  //returns object 
	}
	/**
	 * Description: creates array with length 1 more than theArray
	 * Pre: Object array must be populated with at least 1 element  
	 * Post: none 
	 */
	public Object[] createAndCopyNewArray(Object[] other) { 
		Object[] tempArray = new Object[this.theArray.length+1];
		for(int i = 0; i < this.theArray.length ; i++) { // populates tempArray with values from theArray
			tempArray[i] = this.theArray[i]; // copys theArray values to tempArray at exact index
		}
		return tempArray;	
	}
	/**
	 * Description: creates an array for the remove method
	 * Pre: Object array must be populated with at least 1 object  
	 * Post: none 
	 */
	public Object[] createRemoveArray(Object[] other) {  
		Object[] tempArray = new Object[this.theArray.length -1]; // creates an array with a length of 1 minus theArray length 
		return tempArray;	
	}
	/**
	 * Description: creates a String version of the ArrayList
	 * Pre: none 
	 * Post: none 
	 */
	public String toString() {   
		String toReturn = "";
		for(int i = 0; i < this.theArray.length; i++) { // returns the arraylist in a string form 
			toReturn += this.theArray[i]+",";
		}
		return toReturn;
	}
	/**
	 * Description: swaps the two indexs provided
	 * @param idx1
	 * @param idx2
	 * Pre: none 
	 * Post: none 
	 */
	public void swap(int idx1, int idx2) {
		T temp = this.get(idx1);
		this.replace(this.get(idx2), idx1);
		this.replace(temp, idx2);
	}
}
