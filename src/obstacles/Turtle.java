package obstacles;

import ACT.*;
import javafx.scene.image.Image;


/**
 * this class is used for turtle and it has the turtle functionality 
 * @author khaled
 *
 */
public class Turtle extends Actor{
	
	int dim=110;
	
	/**
	 * the constructor assigns images of the trutle and a type to be used to determine position
	 * @param xpos position of object on the x axis
	 * @param s the speed of teh object
	 */
	public Turtle(int xpos,  double s) {
		int temp=0;
		int ypos=0;
		
		act=new ActTurtle();
		
		//import turtle sprites
		
		image1 = new Image("file:src/Images/TurtleAnimation1.png", dim, dim, true, true);
		image2 = new Image("file:src/Images/TurtleAnimation2.png", dim, dim, true, true);
		image3 = new Image("file:src/Images/TurtleAnimation3.png", dim, dim, true, true);
		image4 = null;
		type="TurtleLeft+String.valueOf(s)";
		
		if (s>0) {
			
	
			image1 = new Image("file:src/Images/TurtleAnimation1mirror.png", dim, dim, true, true);
			image2 = new Image("file:src/Images/TurtleAnimation2mirror.png", dim, dim, true, true);
			image3 = new Image("file:src/Images/TurtleAnimation3mirror.png", dim, dim, true, true);
			type="TurtleRight+String.valueOf(s)";
			
		}
		
	
		if (temp!=0) {ypos=temp;}
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(image2);
	}
	
	public double getspeed() {
		return speed;
	}
}
