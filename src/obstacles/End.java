package obstacles;

import ACT.*;
import javafx.scene.image.Image;


//commented
public class End extends Actor{
	boolean activated = false;
	int dim=60;
	int ypos=92;
	int xpos[]= {8,115,220,325,430};
	static int i=0;
	
	public End() {  //initialize end hole 
		
		act=new ActNothing();
		
		setX(xpos[i]);
		setY(ypos);
		i++;
		if(i==5) {i=0;}
		setImage(new Image("file:src/Images/End.png", dim, dim, true, true));
	}
	
	public void setEnd() { //add frog image to indicate it triggered
		setImage(new Image("file:src/Images/FrogEnd.png", dim, dim, true, true));
		activated = true;
	}
	
	public boolean isActivated() { //tells other classes if hole is activated or not
		return activated;
	}
	

}
