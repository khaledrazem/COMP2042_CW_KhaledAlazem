package obstacles;

import ACT.*;
import javafx.scene.image.Image;


//commented
public class BackgroundImage extends Actor{

	
	public BackgroundImage(String imageLink) {  //sets background image to parameter input
		act=new ActNothing();
		setImage(new Image(imageLink, 500, 800, false, true));//change 600 to 500
		
	}

}
