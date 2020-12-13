package p4_group_8_repo;

import java.util.Random;

import ACT.Actor;
import Worlds.MyStage;

import java.util.ArrayList;
import java.util.Collections;

import javafx.stage.Stage;
import obstacles.BackgroundImage;
import obstacles.Digit;
import obstacles.End;
import obstacles.Labels;
import obstacles.Log;
import obstacles.Vehicle;
import obstacles.Turtle;
import obstacles.WetTurtle;


/**
 * This class is in charge of initializing all obstacles attached to the root node
 * @author khaled
 *
 */
public class InitObjects{

	/**
	 * The root node
	 */
	MyStage background;
	
	/**
	 * array to keep track of the digits on the screen
	 */
	public ArrayList<Actor> digits;
	
	/**
	 * Array to keep track of all movable objects
	 */
	ArrayList<Actor> func=new ArrayList<Actor>();
	
	ArrayList<End> ends=new ArrayList<End>();
	
	double bonus=0;
	
	
	/**
	 * The constructor does nothing but instatiate a list that keeps track of all digits on stage
	 */
	public InitObjects() {
		
		digits=new ArrayList<Actor>();

		
		}

	/**
	 * This method returns the bonus speed each obstacle should get according to the level reached
	 * Every level the speed increases by 0.05
	 */
	private void getbonus( ) {
		for(int i=0;i<background.lvl;i++) {
			bonus=bonus+0.0625;
			
		}
	}
	
	
	/**
	 * This method instantiates cars and trucks and adds them to to the func array which stores the game objects
	 */
	private void addobstacles() {
		func.add(new Vehicle("file:src/Images/truck1"+"Right.png",   Double.sum(0.35,bonus), 120, 120));
		func.add(new Vehicle("file:src/Images/truck1"+"Right.png",  Double.sum(0.35,bonus), 120, 120));
		func.add(new Vehicle("file:src/Images/truck1"+"Right.png",  Double.sum(0.35,bonus), 120, 120));
		func.add(new Vehicle("file:src/Images/car1Left.png",  Double.sum(-0.35,-bonus), 50, 50));
		func.add(new Vehicle("file:src/Images/car1Left.png",  Double.sum(-0.35,-bonus), 50, 50));
		func.add(new Vehicle("file:src/Images/car1Left.png",  Double.sum(-0.35,-bonus), 50, 50));
		func.add(new Vehicle("file:src/Images/car1right.png",  Double.sum(0.55,bonus), 50, 50));
		func.add(new Vehicle("file:src/Images/truck2Right.png",  Double.sum(0.35,bonus), 200, 200));
		func.add(new Vehicle("file:src/Images/truck2Right.png",   Double.sum(0.35,bonus), 200, 200));
		func.add(new Vehicle("file:src/Images/car1Left.png",  Double.sum(-0.35,-bonus), 50, 50));
		
	
		
		
	}
	
	/**
	 * This method instantiates the 5 end holes in the game and adds them to the game background
	 */
	private void addends( ) {
		ends.add(new End());
		//ends.add(new End());
		ends.add(new End());
		ends.add(new End());
	//	ends.add(new End());
	}
	
	/**
	 * This method instantiates the logs and adds them to the func array which contains the objects
	 */
	private void addlogs( ) {
		
		
		func.add(new Log("file:src/Images/log3.png",  Double.sum(bonus, 0.25)));
		func.add(new Log("file:src/Images/log3.png",   Double.sum(bonus, 0.25)));
		func.add(new Log("file:src/Images/log3.png",   Double.sum(bonus, 0.25)));
		func.add(new Log("file:src/Images/logs.png",   Double.sum(-bonus, -0.45)));
		func.add(new Log("file:src/Images/logs.png",   Double.sum(-bonus, -0.45)));
		func.add(new Log("file:src/Images/log3.png",   Double.sum(bonus, 0.25)));
		func.add(new Log("file:src/Images/log3.png",  Double.sum(bonus, 0.25)));
		func.add(new Log("file:src/Images/log3.png",  Double.sum(bonus, 0.25)));
		
	}
	
	/**
	 * This method instantiates the turtles and wet turtles and adds them to the func arryay which stores the game objects
	 */
	private void addturtles( ) {


			func.add(new Turtle(100, Double.sum(bonus, 0.35)));
			func.add(new Turtle(500, Double.sum(bonus, 0.35)));
			func.add(new WetTurtle(300, Double.sum(bonus, 0.35)));
			func.add(new WetTurtle(600, Double.sum(-bonus, -0.35)));
			func.add(new WetTurtle(400, Double.sum(-bonus, -0.35)));
			func.add(new WetTurtle(200, Double.sum(-bonus, -0.35)));
			

		
	}
	
	/**
	 * This is the main method of this class and its called to from other classes to instantiate all objects in the scene
	 * @param background This is the root node of the scene, all objects need to be attached to it as a child
	 * 
	 * after it runs the instantiating functions, it shuffles the func array which will contain all moving objects and 
	 * add them to the background afterwards
	 */
	public void addobjects(MyStage background) {
		this.background=background;
		//sets background image |
	  		func.clear();
	  	    
	  		getbonus();
	  		
	  		//adding objects to background makes them children nodes
	  		
	  		

			
	  		addturtles();
	  		addlogs();

	  		addends();
	  		
	  		addobstacles();
	  		
	  		addlabels();
	  		

	  		for(int i=0;i<ends.size();i++) {
	  			background.add(ends.get(i));
	  		}
	  		Collections.shuffle(func);
	  		
			for(int i=0;i<func.size();i++) {
				background.add(func.get(i));
			}
	  		
	  		background.add(new Digit(0, 30, 400, 40));
	  		
	  		BackgroundImage froggerback = new BackgroundImage("file:src/Images/ikogsKW.png");
	  		background.add(froggerback);
	}
	

	/**
	 * This method instatiates the score and hiscore labels on top of the screen
	 */
	private void addlabels( ) {
		background.add(new Labels("file:src/Images/HighScoreimage.png",140, 180, 10));
		background.add(new Labels("file:src/Images/Scoreimage.png",100, 360, 10));
	}
	
	/**
	 * This method manages the digits used for the score and highscore on top of the screen
	 * @param n This is the number to be displayed as digits
	 * @param ishigh This boolean tells the method if it should place the digits under score or under highscore(if true then under highscore)
	 * it also deleted all current score digits from the screen before updating them
	 */
	public void setNumber(int n,boolean ishigh ) { // set n as digits on screen
		
		for(int i=0;i<digits.size();i++) {
			
			background.remove(digits.get(i));
		
		}
		Actor temp;
    	int shift = 0;//shifts positions for bigger digits
    	int x=400;
    	if(ishigh) {x=270;}
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;//calculations to check number digit by digit
    		  n = d;
    		  temp=new Digit(k, 30, x - shift, 40);
    		  if(!ishigh) {digits.add(temp);}
    		  background.addfront(temp);//360 is end of number, works backwards
    		  shift+=30;//move back 30 more pixels
    		}
    }
	
	
}
