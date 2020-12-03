package obstacles;

import ACT.*;
import javafx.scene.image.Image;


/**
 * this class is for the digits used for score and has no runtime functionality
 * @author khaled
 *
 */
public class Digit extends Actor{
	int dim; //dimensions
	Image im1;
	
	//gets p4_group_8_repo for numbers and puts it in place
	public Digit(int n, int dim, int x, int y) {
		
		act=new ActNothing();
		im1 = new Image("file:src/Images/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
