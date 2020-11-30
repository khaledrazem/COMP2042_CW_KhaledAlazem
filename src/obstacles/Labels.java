package obstacles;

import ACT.*;
import javafx.scene.image.Image;

public class Labels extends Actor{

	int dim=100; //dimensions
	Image im1;
	
	//gets p4_group_8_repo for numbers and puts it in place
	public Labels(String imageLink,int dim, int xpos,int ypos) {
		
		act=new ActNothing();
		
		setImage(new Image(imageLink, dim,dim, true, true));
		setX(xpos);
		setY(ypos);
	}
}
