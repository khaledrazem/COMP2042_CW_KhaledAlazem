package p4_group_8_repo;

import Worlds.MyStage;
import javafx.animation.AnimationTimer;
import javafx.stage.Stage;

public class sessionHandler {
	
	public MyStage background;
	Stage PS;
	Animal animal;
	InitObjects objects;
	ViewManager VM;
	ScoreHandler ScH;
	
	AnimationTimer timer;
	
	public sessionHandler(ViewManager VM) {
		this.background=VM.background;
		this.animal=VM.animal;
		this.PS=VM.primaryStage;
		this.objects=VM.objects;
		this.VM=VM;
		this.ScH=VM.ScH;
		
		start();
		
	}

	public void start() {
		
		background.playMusic();
    	createTimer();
    	objects.setNumber(ScH.gethiscore(),true);  
    	objects.setNumber(animal.getPoints(),false);  
        timer.start();
    }
	
	private void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {  //if theres been a change in teh score
            		objects.setNumber(animal.getPoints(),false);  
            		}
            	if (animal.getStop()) { //stops everything and alerts player if all 5 ends are filled
            		StopFunctions();
            	}
            }

			
        };
    }
	
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
