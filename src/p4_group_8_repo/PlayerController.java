package p4_group_8_repo;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


/**
 * This class is responsible for handling i/o of the player
 * @author khaled
 *
 */
public class PlayerController{
	
	//movement animation images
		Image imgW1;
		Image imgA1;
		Image imgS1;
		Image imgD1;
		Image imgW2;
		Image imgA2;
		Image imgS2;
		Image imgD2;
		
		Image imgw;
		Image imga;
		Image imgs;
		Image imgd;
		
		int imgSize = 40;
		
		private boolean second = false;   //used to swap between moving animtion, can be handelled better
		double movement = 25;
		double movementX = 22;
		
		Animal animal;
		
		/**
		 * This method sets up the player model by defining all sprites required for movement
		 * @param animal This is a passed reference of the player object
		 */
public PlayerController(Animal animal) {
	
	this.animal=animal;
	
	imgW1 = new Image("file:src/Images/froggerUp.png", imgSize, imgSize, true, true);
	imgA1 = new Image("file:src/Images/froggerLeft.png", imgSize, imgSize, true, true);
	imgS1 = new Image("file:src/Images/froggerDown.png", imgSize, imgSize, true, true);
	imgD1 = new Image("file:src/Images/froggerRight.png", imgSize, imgSize, true, true);
	imgW2 = new Image("file:src/Images/froggerUpJump.png", imgSize, imgSize, true, true);
	imgA2 = new Image("file:src/Images/froggerLeftJump.png", imgSize, imgSize, true, true);
	imgS2 = new Image("file:src/Images/froggerDownJump.png", imgSize, imgSize, true, true);
	imgD2 = new Image("file:src/Images/froggerRightJump.png", imgSize, imgSize, true, true);
	
	

	
}

/**
 * This method runs with the game timer and its in charge for checking keyboard input and arranging appropriate actions once input is detected
 * ands it changes animal sprites accordingly
 * since it is a constantly running function it also calls the checkintersections function
 * @see Animal#checkIntersections()
 */
public void checkcontrol() {
	animal.checkIntersections();

	//System.out.println(points);
	animal.setOnKeyPressed(new EventHandler<KeyEvent>() {  //when key is first pressed
		public void handle(KeyEvent event){
			if (animal.noMove) {
				//do nothing
			}
			else {
			    if (second) {
			    	imgw=imgW1;
			    	imga=imgA1;
			    	imgs=imgS1;
			    	imgd=imgD1;
			    	
			    }
			    else {
			    	imgw=imgW2;
			    	imga=imgA2;
			    	imgs=imgS2;
			    	imgd=imgD2;
			    }
			    
				if (event.getCode() == KeyCode.W) {	  
					animal.move(0, -movement*2);
					animal.setImage(imgw);
	                second = !second;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	animal.move(-movementX*2, 0);
	            	animal.setImage(imga);
	            	 second = !second;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	animal.move(0, movement*2);
	            	animal.setImage(imgs);
	            	 second = !second;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	animal.move(movementX*2, 0);
	            	animal.setImage(imgd);
	            	 second = !second;
	            }
			}	
		}
		});	
	animal.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (animal.noMove) {}
				else {
				if (event.getCode() == KeyCode.W) {	  
					if (animal.getY() < animal.w) {
						animal.changeScore = true;
						
						animal.w = animal.getY();
						animal.points+=10;
					}
					animal.setImage(imgW1);
	                second = false;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	animal.setImage(imgA1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	animal.setImage(imgS1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	animal.setImage(imgD1);
	            	 second = false;
	            }
	        }
			}

		
	});
}

	

}

