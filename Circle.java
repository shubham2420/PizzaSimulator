import java.awt.*;
import java.awt.geom.Ellipse2D;
/**
 * Description: Circle class which creates a circle object and inherits from shape
 * @author shubhamkamboj
 *Pre: radius should be of positive value  but if not then it is absolute valued
 *Post: Circle object created with instance methods available to it 
 */
public class Circle extends Shape{
	private double radius;
	
	/**
	 * Description: constructor for circle
	 * @param x
	 * @param y
	 * @param radius
	 * Pre: radius can be any number but if negative then it is absolute valued
	 * Post: circle object made
	 */
	public Circle(int x, int y, double radius) {
		super(x, y); // calls the shape constructor for the x and y value 
		this.radius = Math.abs(radius);
	}
	/**
	 * Description: gets the area of the circle object 
	 * @return area 
	 * Pre: none
	 * Post: none 
	 */
	public double getArea() {
		int retVal = (int)(Math.PI* radius *radius* 100);
		return retVal/100.0;
	}
	/**
	 * Description: draws the object
	 * Pre: none
	 * Post: object is drawn on Jpanel
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor( Color.BLUE ); // sets the color of circle to blue 
		g2d.draw( new Ellipse2D.Double(super.getX(), super.getY(), radius, radius)); // draws the circle 
	}
	/**
	 * Description: returns the radius of the circle object 
	 * @return radius 
	 * Pre: none
	 * Post: none
	 */
	public double getRadius() {
		return this.radius; 
	}
	/**
	 * Description: sets the radius of the object to desired number
	 * @param r
	 * Pre: none
	 * Post: none 
	 */
	public void setRadius(double r) {
		this.radius = r;
	}
	/**
	 * Description: clones the circle object
	 * Pre: none 
	 * Post: none 
	 */
	public Circle clone() {
		return new Circle(this.getX(), this.getY(), this.radius);
	}
	/**
	 * Description: returns string format for circle object
	 * Pre: none 
	 * Post: none 
	 */
	public String toString() {
		return "Circle";
	}
}

