package obstacles;

import ACT.*;
import javafx.scene.image.Image;


/**
 * This class is used for the logs and its only functionality is movement
 * @author khaled
 *
 */
public class Log extends Actor {

	int dim=100;
	
	/**
	 * instatiates log and sends it to world to check a free strip to place it on in the game using the checknextfree method
	 * @param imageLink the location of the log image
	 * @param xpos the starting x coordinate
	 * @param s the speed the log moves in
	 * @see World#checknextfree
	 */
	public Log(String imageLink, double s) {
		act=new ActMoveOnly();
		
		int temp=0;
		int ypos=0;
		int xpos=0;
		setImage(new Image(imageLink, dim,dim, true, true));
		type="Log"+String.valueOf(s);
	
		if (temp!=0) {ypos=temp;}
			
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	
	/**
	 * player uses this method o move alongside the log
	 * @return the speed of the log
	 */
	public double getspeed() {
		return speed;
	}
}
