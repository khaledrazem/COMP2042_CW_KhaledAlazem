package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
//commented

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();   //creates window with segmented children
			Scene scene = new Scene(root,400,400);    //creates new scene with root layout and res 400x400
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());    //imports style sheet
			primaryStage.setScene(scene);    //set defined scene as active scene
			primaryStage.show();   //displays scene and stage to user
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args); //calls javafx application, calls start
	}
}
