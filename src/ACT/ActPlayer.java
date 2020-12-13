package ACT;

import javafx.scene.image.Image;

/**
 * This functionality is for the player
 * @author khaled
 *
 */
public class ActPlayer implements Act{

	/**
	 * This method calls restrict movement method that keeps the player within the screen, and it also checks for any death triggers and loads the correct images for the death animations
	 */
	@Override
	public void act(Actor actor, long now) {
		
		restrictmovement(actor);
		if(actor.carDeath) {
			actor.image1=new Image("file:src/Images/cardeath1.png", actor.imgSize, actor.imgSize, true, true);
			actor.image2=new Image("file:src/Images/cardeath2.png", actor.imgSize, actor.imgSize, true, true);
			actor.image3=new Image("file:src/Images/cardeath3.png", actor.imgSize, actor.imgSize, true, true);
			actor.image4=null;
			actor.handledeath(now);
		}
		
		if(actor.waterDeath) {
			actor.image1=new Image("file:src/Images/waterdeath1.png", actor.imgSize,actor.imgSize , true, true);
			actor.image2=new Image("file:src/Images/waterdeath2.png", actor.imgSize,actor.imgSize , true, true);
			actor.image3=new Image("file:src/Images/waterdeath3.png", actor.imgSize,actor.imgSize , true, true);
			actor.image4=new Image("file:src/Images/waterdeath4.png", actor.imgSize,actor.imgSize , true, true);
			actor.handledeath(now);
		}
		
		
		
		
	}
	
	/**
	 * Ensures that the player doesnt go offscreen
	 */
	@Override
	public void restrictmovement(Actor actor) {
		if (actor.getY()<0 || actor.getY()>734) {  //stops player from going offscreen down or up
			actor.setX(300);
			actor.setY(679.8+actor.movement);
		}
		if (actor.getX()<0) {//stops player from going offscreen to the left
			actor.move(actor.movement*2, 0);
		}
		
		if (actor.getX()>500-actor.imgSize/2) {//stops player from going offscreen to the right
			actor.move(-actor.movement*2, 0);
		}
		
	}

}
