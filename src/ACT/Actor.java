package ACT;

import Worlds.World;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;

import java.util.ArrayList;



//commented
public abstract class Actor extends ImageView{

	protected String type;
	protected Act act;
	protected double speed;
	
	protected Image image1;
	protected Image image2;
	protected Image image3;
	protected Image image4;
	
	protected boolean sunk=false;
	public static int points;
    protected boolean carDeath,waterDeath;
    protected double movement;
	
	protected int imgSize;
	
	//moves player image dx pixels in the x direction and dy pixels in the y direction
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
    

    
    //fetches parent object to put objects in
    public World getWorld() {
        return (World) getParent();
    }

    
    //checks intersections between objects
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
   public String getType() {
	   return type;
   }



    public void act(long now) {
    	act.act(this,now);
    
    }
    
    public void handledeath(long now) {
    	
    }

}
