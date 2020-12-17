package ACT;

import Worlds.World;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;

import java.util.ArrayList;



/**
 * This abstract class is used to define all objects in the game
 * @author khaled
 *
 */
public abstract class Actor extends ImageView{

	/**
	 * Type stores the type of object to be added, is used for the slot system in class world, if type is null then its not automated
	 */
	protected String type;
	/**
	 * The functionality of each object
	 */
	protected Act act;
	/**
	 * Defines the speed of moving objects
	 */
	protected double speed;
	
	/**
	 * These images are used to store the movement animations and death animations
	 */
	protected Image image1;
	protected Image image2;
	protected Image image3;
	protected Image image4;
	
	/**
	 * These are player related variables
	 */
	protected boolean sunk=false;
	public static int points;
    protected boolean carDeath,waterDeath;
    protected double movement;
	
	protected int imgSize;
	
	/**
	 * This method is used to move the object a number of pixels in the x direction and a number of pixels in the y direction
	 * @param dx how many pixels to move in the x direction
	 * @param dy how many pixels to move in the y direction
	 */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
    

    
    /**
     * fetches the parent object, which is the stage
     * @return the parent node, the root node
     */
    public World getWorld() {
        return (World) getParent();
    }

    
    /**
     * Method to check intersection between objects
     * @param <A> an empty arraylist
     * @param cls The object to check intersections with
     * @return an array containing all actors that are intersecting
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    /**
     * types of actors such as turtle or log, used for placement functions
     * @return the type of actor 
     * @see World#checknextfree(String)
     */
   public String getType() {
	   return type;
   }



   /**
    * A call to the encapsulated method act
    * @param now game timer
    */
    public void act(long now) {
    	act.act(this,now);
    
    }
    


}
