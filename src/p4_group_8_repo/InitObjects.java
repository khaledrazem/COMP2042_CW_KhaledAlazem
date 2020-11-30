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
import obstacles.Obstacle;
import obstacles.Turtle;
import obstacles.WetTurtle;

public class InitObjects{

	MyStage background;
	
	public ArrayList<Actor> digits;
	
	ArrayList<Actor> func=new ArrayList<Actor>();
	
	double bonus=0;
	
	public InitObjects() {
		
		digits=new ArrayList<Actor>();

		
		}

	private void getbonus( ) {
		for(int i=0;i<background.lvl;i++) {
			bonus=bonus+0.05;
			
		}
	}
	
	private void addobstacles() {
		
		func.add(new Obstacle("file:src/Images/truck1"+"Right.png",   Double.sum(0.35,bonus), 120, 120));
		func.add(new Obstacle("file:src/Images/truck1"+"Right.png",  Double.sum(0.35,bonus), 120, 120));
		func.add(new Obstacle("file:src/Images/truck1"+"Right.png",  Double.sum(0.35,bonus), 120, 120));
		func.add(new Obstacle("file:src/Images/car1Left.png",  Double.sum(-0.35,-bonus), 50, 50));
		func.add(new Obstacle("file:src/Images/car1Left.png",  Double.sum(-0.35,-bonus), 50, 50));
		func.add(new Obstacle("file:src/Images/car1Left.png",  Double.sum(-0.35,-bonus), 50, 50));
		func.add(new Obstacle("file:src/Images/car1right.png",  Double.sum(0.55,bonus), 50, 50));
		func.add(new Obstacle("file:src/Images/truck2Right.png",  Double.sum(0.35,bonus), 200, 200));
		func.add(new Obstacle("file:src/Images/truck2Right.png",   Double.sum(0.35,bonus), 200, 200));
		func.add(new Obstacle("file:src/Images/car1Left.png",  Double.sum(-0.35,-bonus), 50, 50));
		
	
		
		
	}
	
	private void addends( ) {
		background.add(new End());
		background.add(new End());
		background.add(new End());
		background.add(new End());
		background.add(new End());
	}
	
	private void addlogs( ) {
		
		
		func.add(new Log("file:src/Images/log3.png", 0, Double.sum(bonus, 0.25)));
		func.add(new Log("file:src/Images/log3.png", 220,  Double.sum(bonus, 0.25)));
		func.add(new Log("file:src/Images/log3.png", 440,  Double.sum(bonus, 0.25)));
		func.add(new Log("file:src/Images/logs.png",  0,  Double.sum(-bonus, -0.45)));
		func.add(new Log("file:src/Images/logs.png",  400,  Double.sum(-bonus, -0.45)));
		func.add(new Log("file:src/Images/log3.png",  50, Double.sum(bonus, 0.25)));
		func.add(new Log("file:src/Images/log3.png", 270, Double.sum(bonus, 0.25)));
		func.add(new Log("file:src/Images/log3.png",  490, Double.sum(bonus, 0.25)));
		
	}
	
	private void addturtles( ) {


			func.add(new Turtle(100, Double.sum(bonus, 0.35)));
			func.add(new Turtle(500, Double.sum(bonus, 0.35)));
			func.add(new WetTurtle(300, Double.sum(bonus, 0.35)));
			func.add(new WetTurtle(600, Double.sum(-bonus, -0.35)));
			func.add(new WetTurtle(400, Double.sum(-bonus, -0.35)));
			func.add(new WetTurtle(200, Double.sum(-bonus, -0.35)));
			

		
	}
	
	public void addobjects(MyStage background) {
		this.background=background;
		//sets background image |
	  		
	  	    
	  		getbonus();
	  		
	  		//adding objects to background makes them children nodes
	  		
	  		

			
	  		addturtles();
	  		addlogs();

	  		addends();
	  		
	  		addobstacles();
	  		
	  		addlabels();
	  		

	  		Collections.shuffle(func);
	  		
			for(int i=0;i<func.size();i++) {
				background.add(func.get(i));
			}
	  		
	  		background.add(new Digit(0, 30, 400, 40));
	  		
	  		BackgroundImage froggerback = new BackgroundImage("file:src/Images/ikogsKW.png");
	  		background.add(froggerback);
	}
	

	private void addlabels( ) {
		background.add(new Labels("file:src/Images/HighScoreimage.png",140, 180, 10));
		background.add(new Labels("file:src/Images/Scoreimage.png",100, 360, 10));
	}
	
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
