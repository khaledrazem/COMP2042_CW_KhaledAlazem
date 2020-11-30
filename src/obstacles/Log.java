package obstacles;

import ACT.*;
import javafx.scene.image.Image;


//commented
public class Log extends Actor {

	int dim=100;
	
	//intitialize log
	public Log(String imageLink, int xpos, double s) {
		act=new ActMoveOnly();
		int temp=0;
		int ypos=0;
		setImage(new Image(imageLink, dim,dim, true, true));
		if (s>0) { type="Logright"+String.valueOf(s);}
		else { type="Logleft"+String.valueOf(s);}
			
			
		if (temp!=0) {ypos=temp;}
			
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	
	//check if log is going to the left
	public boolean getLeft() {
		return speed < 0;
	}
	
	public double getspeed() {
		return speed;
	}
}
