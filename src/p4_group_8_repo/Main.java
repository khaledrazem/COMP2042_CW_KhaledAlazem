package p4_group_8_repo;

import java.io.File;
import java.util.List;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

//check player movement with log

/**
 * This class is what starts the game
 * @author khaled
 *
 */
public class Main extends Application { 
	ViewManager vm;


	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * This is where the project starts running from, and it starts by instantiating a viewmanager 
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		vm=new ViewManager(primaryStage);

		
	}

	
	
	


	

	
	
	
	

	
	
	
    
    
}
