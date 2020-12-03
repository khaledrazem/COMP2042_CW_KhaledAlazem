package obstacles;

import ACT.*;
import javafx.scene.image.Image;


/**
 * This class is used for the background image and has no runtime functionality
 * @author khaled
 *
 */
public class BackgroundImage extends Actor{

	
	public BackgroundImage(String imageLink) {  //sets background image to parameter input
		act=new ActNothing();
		setImage(new Image(imageLink, 500, 800, false, true));//change 600 to 500
		
	}

}
