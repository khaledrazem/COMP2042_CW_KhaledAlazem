package obstacles;

import ACT.*;
import javafx.scene.image.Image;

//commented

//maybe use this for all moving objects
public class Obstacle extends Actor {
	
	//initialize object
	public Obstacle(String imageLink, double s, int w, int h) {
		act=new ActMoveOnly();
		int ypos=0;
		int temp=0;
		if (imageLink=="file:src/Images/car1Left.png" ) { type="car1left"+String.valueOf(s);}
		if (imageLink=="file:src/Images/car1right.png") { type="car1Right"+String.valueOf(s);}
		if (imageLink=="file:src/Images/truck2Right.png") { type=("truckRight"+String.valueOf(s));}
		if (imageLink=="file:src/Images/truck1Right.png") { type=("truckRight"+String.valueOf(s));}

		
	
		if (temp!=0) {ypos=temp;}
		setImage(new Image(imageLink, w,h, true, true));
		speed = s;
	}

}
