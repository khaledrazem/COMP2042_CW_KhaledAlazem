package p4_group_8_repo;

import Worlds.MyStage;
import javafx.animation.AnimationTimer;
import javafx.stage.Stage;

/**
 * This class is in charge of the game session
 * @author khaled
 *
 */
public class sessionHandler {
	
	public MyStage background;
	Stage PS;
	public Animal animal;
	InitObjects objects;
	ViewManager VM;
	ScoreHandler ScH;
	
	AnimationTimer timer;
	
	PlayerController PC;
	
	/**
	 * the constructor gets reference to all necessary classes
	 * @param VM a reference to the view manager which has all the references needed
	 */
	public sessionHandler(ViewManager VM) {
		this.background=VM.background;
		this.PS=VM.primaryStage;
		this.objects=VM.objects;
		this.VM=VM;
		this.ScH=VM.ScH;
		
		start();
		
	}

	/**
	 * This sets up the game scene it does the following tasks:
	 * creates player object animal
	 * created player controller and attaches the player to it
	 * starts the music timer
	 * adds the initial score and hiscore
	 */
	public void start() {
		animal=new Animal();
    	background.addfront(animal);
		PC=new PlayerController(animal);
		background.playMusic();
    	createTimer();
    	objects.setNumber(ScH.gethiscore(),true);  
    	objects.setNumber(animal.getPoints(),false);  
        timer.start();
    }
	
	/**
	 * this method starts a game timer for player related functions
	 */
	private void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	PC.checkcontrol();
            	if (animal.changeScore()) {  //if theres been a change in teh score
            		objects.setNumber(animal.getPoints(),false);  
            		}
            	if (animal.getStop()) { //stops everything and alerts player if all 5 ends are filled
            		StopFunctions();
            	}
            }

			
        };
    }
	
	/**
	 * This method runs when the game ends and it stops all game functions from living and calls the next action(either to get next level or the win screen)
	 */
	private void StopFunctions() {
		background.stopMusic();
		background.stop();
		timer.stop();
		if (background.lvl<10) {
		VM.createnextlvlscrn();
		}
		else {VM.createwin();}
	}
	
}
