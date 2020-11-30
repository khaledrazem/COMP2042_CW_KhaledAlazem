package p4_group_8_repo;

import java.util.ArrayList;

import ACT.*;
import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import obstacles.End;
import obstacles.Log;
import obstacles.Obstacle;
import obstacles.Turtle;
import obstacles.WetTurtle;

//commented 

public class Animal extends Actor {

	
	
	int spawnposy=710; //spawn position
	int end = 0; //counter for end goals, max 5
	public boolean noMove = false;  //locks player movement
	double movementX = 22;
	boolean stop = false;
	public boolean changeScore = false;   //theres been a chage in the score that should be added
	int carD = 0;  //animation counter
	double w = 800;//stores highest point player reached
	
	
	public Animal() { //init player
		act=new ActPlayer();
		imgSize = 40;
		setImage(new Image("file:src/Images/froggerUp.png", imgSize, imgSize, true, true));
		resetPlayerPos();
		movement = 25;
		

	}
	

	protected void checkIntersections() {
		
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {  //if player hits car
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
			w=800;    //resets highest level to minimum
			resetPlayerPos();
		
			}
		}
		
		else if (getY()<410){   //if you are not on any object after this point u ded :)
			waterDeath = true;
		}
	}

	private void setHoleActive() {
		//add score
		points+=50;
		changeScore = true;
		
		getIntersectingObjects(End.class).get(0).setEnd();    //sets hole o activated
		end++;
		
	}

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

	private void resetPlayerPos() {
		setX(300);
		setY(spawnposy);
	}
	
	//if all 5 holes are filled stop game
	public boolean getStop() {
		return end==1;
	}
	
	public int getPoints() {//sends points to calsses that requested
		return (points);
	}
	
	
	//a trigger to indicate that the score has changed
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	

}
