package obstacles;

import ACT.*;
import javafx.scene.image.Image;


//commented
public class WetTurtle extends Actor{
	
	int dim=100;
	
	public WetTurtle(int xpos, double s) {
		int temp=0;
		int ypos=0;
		
		act=new ActTurtle();
		//assign entity details
		image1 = new Image("file:src/Images/TurtleAnimation1.png", dim, dim, true, true);
		image2 = new Image("file:src/Images/TurtleAnimation2Wet.png", dim, dim, true, true);
		image3 = new Image("file:src/Images/TurtleAnimation3Wet.png", dim, dim, true, true);
		image4 = new Image("file:src/Images/TurtleAnimation4Wet.png", dim, dim, true, true);
		type="TurtleLeft+String.valueOf(s)";
		
		if (s>0) {
			image1 = new Image("file:src/Images/TurtleAnimation1mirror.png", dim, dim, true, true);
			image2 = new Image("file:src/Images/TurtleAnimation2Wetmirror.png", dim, dim, true, true);
			image3 = new Image("file:src/Images/TurtleAnimation3Wetmirror.png", dim, dim, true, true);
			type="TurtleRight+String.valueOf(s)";
		}
			
		if (temp!=0) {ypos=temp;}
			
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(image2);
	}
	
	//tells other classes if turtle is sunk
	public boolean isSunk() {
		return sunk;
	}
	public double getspeed() {
		return speed;
	}
}
