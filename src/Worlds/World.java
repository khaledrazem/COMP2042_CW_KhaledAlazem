package Worlds;



//commented
import java.util.ArrayList;
import java.util.List;

import java.util.Random;

import p4_group_8_repo.Animal;
import p4_group_8_repo.PlayerController;
import ACT.Actor;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import p4_group_8_repo.Animal;
import p4_group_8_repo.PlayerController;
public abstract class World extends Pane {
    private AnimationTimer timer;
    
    static String[] positionslots=new String[] {"","","","","","","","","","",""};
	static int[] positionfull=new int[] {3,3,3,3,3,3,3,3,3,3,3};
    
	public Animal animal;
    
    
    public World() {
    	animal=new Animal();
    	add(animal);
        System.out.print(getChildren());
    	sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					
					//run setonkeyreleased function for player
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {  
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					});
					
					
					//run setonkeypressed function for player
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
						
					});
				}
				
			}
    		
		});
    }

    //initializes game timer which starts all game objects
    public void createTimer() {
        timer = new AnimationTimer() {
        	
            @Override
            public void handle(long now) {
                List<Actor> actors = getObjects(Actor.class);
                
                PlayerController PC=new PlayerController(animal);
                
                for (Actor anActor: actors) {
                	anActor.act(now);
                }
                PC.checkcontrol(now);
      
            }
        };
    }

    //starts game functionality
    public void start() {
    	createTimer();
        timer.start();
    }

    //stops game
    public void stop() {
        timer.stop();
    }
    
    public void addfront(Actor actor) {
    	
    	getChildren().add(getChildren().size(),actor);
    }
    
    //adds object to world
    public void add(Actor actor) {
        getChildren().add(0,actor);
        if (actor.getType()!=null) {
        	position temp=checknextfree(actor.getType());
        	actor.setY(temp.y);
        	actor.setX(temp.x);
        }
        
    }
    
    //removes object from world
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    public void removeall() {
        getChildren().removeAll();
        positionslots=new String[] {"","","","","","","","","","",""};
    	positionfull=new int[] {3,3,3,3,3,3,3,3,3,3,3};
    }
    
    //looks though list of existing objects for requested object
    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }
    
  
public position checknextfree(String type) {
	 Random rand = new Random(); 
	position pos=new position(rand.nextInt(150),710);
	int j=0;
	if (type=="TurtleLeft" || type=="TurtleRight" || type=="Logright" || type=="Logleft") {
		j=6;
	}
	else {j=0;}
	for ( int i=j; i < positionfull.length; i++) {
		
		
		pos.y=710-50*(i+1);
		
		if (positionfull[i]>0) {
			if (positionslots[i]=="") {
				positionslots[i]=type;
				positionfull[i]--;
				return(pos);
			}
			else {
				if (positionslots[i].contentEquals(type)) {
					pos.x=pos.x+300*(3-positionfull[i]);
					positionfull[i]--;
    				return(pos);
				}
				else {
					System.out.println("notsame");
				}
			}
		}
	}
	return(null);
}


}
