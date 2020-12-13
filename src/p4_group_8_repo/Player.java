package p4_group_8_repo;

import java.util.ArrayList;

import ACT.*;
import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import obstacles.End;
import obstacles.Log;
import obstacles.Vehicle;
import obstacles.Turtle;
import obstacles.WetTurtle;

/**
 * Objects of this class represent the player 
 * 
 * @author khaled
 *
 */

public class Player extends Actor {

	/**
	 * This is the spawn coordinates for the player
	 */
	int spawnposy=710; //spawn position
	/**
	 * Trigger that locks player movement
	 */
	public boolean noMove = false;  //locks player movement
	/**
	 * Trigger that alrts for a need to update the score
	 */
	public boolean changeScore = false;   //theres been a chage in the score that should be added
	/**
	 * Animation timer
	 */
	int carD = 0;  //animation counter
	/**
	 * used to check highest lane player reached
	 */
	double highestlane = 800;//stores highest point player reached
	
	
	/**
	 * This is the constructor of the animal class
	 * it sets the player sprite and the spawn position
	 */
	public Player() { //init player
		act=new ActPlayer();
		imgSize = 40;
		setImage(new Image("file:src/Images/froggerUp.png", imgSize, imgSize, true, true));
		resetPlayerPos();
		movement = 25;
	}
	

	/**
	 * This method is called to by the PlayerController script constantly to check for any collisions between the player and other objects
	 * @see PlayerController
	 */
	protected void checkIntersections() {
		
		if (getIntersectingObjects(Vehicle.class).size() >= 1) {  //if player hits car
			carDeath = true;
		}
		
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) { //move player with log
				move(getIntersectingObjects(Log.class).get(0).getspeed(),0);

		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) { //move player with turtle
			move(getIntersectingObjects(Turtle.class).get(0).getspeed(),0);
		}
		
		
		//if player on turtle and turtle is sunk then kill player
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(getIntersectingObjects(WetTurtle.class).get(0).getspeed(),0);
			}
		}
		
		//if intersecting with the end hole
		else if (getIntersectingObjects(End.class).size() >= 1) {
			
			//if end hole is already activated, undo score additoin || can be more effecient
			if (!getIntersectingObjects(End.class).get(0).isActivated()) {
			
			setHoleActive();
			highestlane=800;    //resets highest level to minimum
			resetPlayerPos();
		
			}
		}
		
		else if (getY()<410){   //if you are not on any object after this point u ded :)
			waterDeath = true;
		}
	}

	
	/**
	 * This method handles the event where the player reaches an end point, it will add points and set the appropriate end hole to active
	 */
	private void setHoleActive() {
		//add score
		points+=50;
		changeScore = true;
		getIntersectingObjects(End.class).get(0).setEnd();    //sets hole to activated
		
	}

	
	/**
	 * This is a death handler method, it plays the animation according to the type of death, which is checked in the ActPlayer class
	 * it uses the game timer to go through death sprites
	 * @param now this is the game timer
	 * it also handles anything required for player death, such as point deduction and position reset
	 */
	public void handledeath(long now) {
		noMove = true;//lock movement
		
		//play death animation
		if ((now)% 11 ==0) {
			carD++;
		}
		if (carD==1) {
			setImage(image1);
		}
		if (carD==2) {
			setImage(image2);
		}
		if (carD==3) {
			setImage(image3);
		}
		if (carD == 4) {
			if (image4!=null) {setImage(image4);}
		}
		if (carD == 5) {
			//reset position player
			resetPlayerPos();
			
			//reset death triggers
			waterDeath = false;   
			carDeath=false;
					
			//reset animation
			carD = 0;   
			setImage(new Image("file:src/Images/froggerUp.png", imgSize, imgSize, true, true));  //reset player sprite
			noMove = false;  //unlock movement
			if (points>50) { //deduct points if possible
				points-=50;
				changeScore = true;
			}  
		}
	}

	/**
	 * This method resets the player position to spawn point
	 */
	private void resetPlayerPos() {
		setX(300);
		setY(spawnposy);
	}
	
	/**
	 * This is a public method that returns the number of points the player have gathered
	 * @return points, an integer representing the player's points
	 */
	public int getPoints() {//sends points to calsses that requested
		return (points);
	}
	
	
	/**
	 * This is a public method that can be called to check whether theres been a change in the score
	 * @return a boolean that indiciates if the score has changed
	 */
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	

}
