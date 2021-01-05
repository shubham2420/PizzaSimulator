import java.awt.Graphics;
/**
 * Description: shape class that extends the object class
 * @author shubhamkamboj
 * Pre: none 
 * Post: none 
 */
abstract class Shape extends Object {
	private int x = 0;
	private int y = 0;
	
	/**
	 * Description: constructor for the shape class
	 * @param a
	 * @param b
	 * Pre: none 
	 * Post: none 
	 */
	public Shape( int a, int b ) {
		this.x = a;
		this.y = b;
	}
	
	/**
	 * Description: returns the area of the shape 
	 * @return area of the shape 
	 * Pre: none
	 * Post: none 
	 */
	public double getArea(){ return -1; }
	
	/**
	 * Description: draws the shape
	 * @param g
	 * Pre: none 
	 * Post: none 
	 */
	public void draw( Graphics g ){}
	
	/**
	 * Description: gets the x coordinate of the shape 
	 * @return x coordinate
	 * Pre: none 
	 * Post: none 
	 */
	public int getX() {
		return this.x; 
	}
	/**
	 * Description: gets the y coordinate of the shape 
	 * @return y coordinate 
	 * Pre: none 
	 * Post: none 
	 */
	public int getY() { 
		return this.y; 
	}
	/**
	 * Description: sets the x coordinate to a new value
	 * @param newX
	 * @return new x coordinate 
	 * Pre: none 
	 * Post: none 
	 */
	protected int setX(int newX) {
		this.x = newX; 
		return this.x;
	}
	/**
	 * Description: sets the y coordinate to a new value 
	 * @param newY
	 * @return the new y coordinate 
	 * Pre: none 
	 * Post: none 
	 */
	protected int setY(int newY) { 
		this.y = newY;
		return this.y;
	}
	/**
	 * Description: clone interface for subclasses
	 * Pre: none 
	 * Post: must be implemented in sub classes
	 */
	public abstract Shape clone();
}