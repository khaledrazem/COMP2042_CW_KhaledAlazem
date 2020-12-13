package obstacles;

import ACT.*;
import javafx.scene.image.Image;

/**
 * This class defines the vehicles of the game and has only movement functionality
 * @author khaled
 *
 */
public class Vehicle extends Actor {
	
	/**
	 * this class instantiates the vehicle, sets the photo and type and the position according to the type of vehicle it is
	 * @param imageLink the sprite of the vehicle
	 * @param s speed of vehicle
	 * @param w width of vehicle sprite
	 * @param h height of vehicle sprite
	 */
	public Vehicle(String imageLink, double s, int w, int h) {
		act=new ActMoveOnly();
		int ypos=0;
		int temp=0;
		if (imageLink.contains("car") ) { type="car"+String.valueOf(s);}
		if (imageLink.contains("truck1")) { type=("trucksmall"+String.valueOf(s));}
		if (imageLink.contains("truck2")) { type=("truckbig"+String.valueOf(s));}



		if (temp!=0) {ypos=temp;}
		setImage(new Image(imageLink, w,h, true, true));
		speed = s;
	}

}
