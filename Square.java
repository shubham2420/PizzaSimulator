import java.awt.*;
import java.awt.geom.*;

/**
 * Description: Square class which creates a square object and inherits from shape
 * @author shubhamkamboj
 * Pre: the length must be greater than 0 , if not then they are absolute valued
 *Post: creates a square object 
 */
public class Square extends Shape{
	private double length;
	
	/**
	 * Description: constructor for the square class
	 * @param x
	 * @param y
	 * @param length
	 * Pre: none
	 * Post: none 
	 */
	public Square(int x, int y, double length) {
		super(x, y);
		this.length = Math.abs(length);
	}
	/**
	 * Description: draws the Square shape on Jpanel 
	 * Pre: none 
	 * PostL: none 
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.MAGENTA); // sets the rectangle color to magenta 
		g2d.draw(new Rectangle2D.Double(super.getX(), super.getY(), length , length)); // draws the rectangle 
	}
	/**
	 * Description: returns the area of the square 
	 * Pre: none 
	 * Post: none
	 */
	public double getArea() {
		return length * length; 
	}
	/**
	 * Description: returns the length of the square 
	 * @return length 
	 * Pre: none
	 * Post: none 
	 */
	public double getLength() {
		return this.length;
	}
	/**
	 * Description: sets the length to the desired number
	 * @param l
	 * @return new length 
	 * Pre: length parameter must be greater than 0
	 * Post: none 
	 */
	public double setLength(double l) {
		this.length = l;
		return length;
	}
	/**
	 * Description: clones the square object
	 * Pre: none 
	 * Post: none 
	 */
	public Square clone() {
		return new Square(this.getX(), this.getY(), this.length);
	}
	/**
	 * Description: returns the string format of shape
	 * Pre: none 
	 * Post: none 
	 */
	public String toString() {
		return "Square";
	}
}
