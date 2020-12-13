package obstacles;

import ACT.*;
import javafx.scene.image.Image;



/**
 * this class is used for wet turtle and it has the turtle functionality 
 * @author khaled
 *
 */
public class WetTurtle extends Actor{
	
	int dim=100;
	/**
	 * the constructor assigns images of the turtle and a type to be used to determine position
	 * @param xpos position of object on the x axis
	 * @param s the speed of teh object
	 */
	public WetTurtle(int xpos, double s) {
		int temp=0;
		int ypos=0;
		
		act=new ActTurtle();
		//assign entity details
		image1 = new Image("file:src/Images/TurtleAnimation1.png", dim, dim, true, true);
		image2 = new Image("file:src/Images/TurtleAnimation2Wet.png", dim, dim, true, true);
		image3 = new Image("file:src/Images/TurtleAnimation3Wet.png", dim, dim, true, true);
		image4 = new Image("file:src/Images/TurtleAnimation4Wet.png", dim, dim, true, true);
		type="Turtle"+String.valueOf(s);
		
		if (s>0) {
			image1 = new Image("file:src/Images/TurtleAnimation1mirror.png", dim, dim, true, true);
			image2 = new Image("file:src/Images/TurtleAnimation2Wetmirror.png", dim, dim, true, true);
			image3 = new Image("file:src/Images/TurtleAnimation3Wetmirror.png", dim, dim, true, true);
		}
			
		if (temp!=0) {ypos=temp;}
			
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(image2);
	}
	
	/**
	 * checks if turtle is sunk or not 
	 * @return boolean of whether the turtle is sunk or not
	 */
	public boolean isSunk() {
		return sunk;
	}
	/**
	 * method to retrieve speed of turtle
	 * @return double which is the speed of the turtle
	 */
	public double getspeed() {
		return speed;
	}
}
