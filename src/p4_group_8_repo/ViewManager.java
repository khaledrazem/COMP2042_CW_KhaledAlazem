package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import java.util.*;

import Worlds.MyStage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
public class ViewManager {
	
	public Scene menuscene,infoscene;
	
	int xres=500;
	int yres=800;
	
	
	String username;
	
	Scene gamescene;
	
	public Stage primaryStage;
	public MyStage background;
	public InitObjects objects;
	public Animal animal;
	sessionHandler SH;
	public ScoreHandler ScH;
	
	Scene back;
	
	//private TableView table;
	
	AnimationTimer timer;
	
	public ViewManager(Stage PrimaryStage) {
		this.primaryStage=PrimaryStage;
		primaryStage.setResizable(false);
		//this.background=new MyStage();
		
		
		objects = new InitObjects();
		ScH=new ScoreHandler();
		
        menuscene = CreatMenu();
        infoscene=CreateInfo();
		
	}
	
	private Scene CreatMenu() {
		

		Label label1=new Label("Welcome to game");
		label1.setFont(new Font("Arial", 24));
		
		Label label2=new Label("FROGGER");
		label2.setFont(new Font("Arial", 32));
		
		Button button1=new Button("PLAY!");
		button1.setOnAction(e -> primaryStage.setScene(creategamescene()));
		button1.setMinSize(100, 50);
		
		button1.setStyle("-fx-text-fill: #00ff00;-fx-background-color:Green");
		//button1.setStyle("-fx-background-color:Green");
		
		Button button2=new Button("Exit :(");
		button2.setOnAction(e -> primaryStage.close());
		button2.setMinSize(100, 50);
		button2.setStyle("-fx-text-fill: #00ff00;-fx-background-color:Green");
		
		Button button3=new Button("info");
		button3.setOnAction(e -> primaryStage.setScene(infoscene));
		button3.setMinSize(100, 50);
		button3.setStyle("-fx-text-fill: #00ff00;-fx-background-color:Green");
		
		Button button4=new Button("Scoreboard");
		button4.setOnAction(e -> primaryStage.setScene(createtable()));
		button4.setMinSize(100, 50);
		button4.setStyle("-fx-text-fill: #00ff00;-fx-background-color:Green");

		Image logo=new Image("file:src/Images/froggerlogo.png", 350, 350, true, true);
		ImageView iv1 = new ImageView();
        iv1.setImage(logo);
        
		VBox layout1=new VBox();         
		layout1.setSpacing(50);
		layout1.setAlignment(Pos.CENTER);// Changed the alignment to center-left
		layout1.getChildren().addAll(iv1,label1,button1,button3,button4,button2);
		layout1.setBackground(new Background(new BackgroundFill(Color.rgb(0,255,0), CornerRadii.EMPTY, Insets.EMPTY)));
		Scene menuscene=new Scene(layout1,xres,yres);
		back=menuscene;
		return menuscene;
	}
	
	private Scene CreateInfo() {
		Button button4=new Button("Back");
		button4.setOnAction(e -> primaryStage.setScene(menuscene));
		button4.setMinSize(100, 50);
		button4.setStyle("-fx-text-fill: #00ff00;-fx-background-color:Green");
		
		Image wasd=new Image("file:src/Images/wasd.png", 150, 150, true, false);
		ImageView iv1 = new ImageView();
        iv1.setImage(wasd);
       
        
        Image arcade=new Image("file:src/Images/arcade.png", 225, 225, true, false);
		ImageView iv2 = new ImageView();
        iv2.setImage(arcade);
 
        
        Label label1=new Label("Controls");
		label1.setFont(new Font("Arial", 32));
	
		
		Label label2=new Label("Goal: reach the end");
		label2.setFont(new Font("Arial", 18));
	
		
		VBox layout2=new VBox();         
		layout2.getChildren().addAll(label2,iv2,label1,iv1,button4);
		layout2.setSpacing(50);
		layout2.setBackground(new Background(new BackgroundFill(Color.rgb(0,255,0), CornerRadii.EMPTY, Insets.EMPTY)));
		layout2.setAlignment(Pos.CENTER);// Changed the alignment to center-left
	    return(new Scene(layout2,xres,yres));
	}
	
	Scene creategamescene() {
		background = new MyStage();    //stage is aplication window
	    Scene scene  = new Scene(background,xres,yres);//change x to 500, maybe not here
	    //creates new scene with background as root node	    
	    

	    gamescene=scene;
	    
	    animal=background.animal;
	    
	    objects.addobjects(background);
  		
	  	background.start();
	  	SH=new sessionHandler(this); 
	    return(scene);
	}
	
	
	public Scene createtable() {
		TableView table = new TableView();
		table.setMaxSize(300, 400);
		ArrayList scores=new ArrayList(ScH.getscore());

		TableColumn<ScoreType,String> namecol = new TableColumn<>("Name");
		TableColumn<ScoreType,String> scorecol = new TableColumn<>("Score");
		TableColumn<ScoreType,String> lvlcol = new TableColumn<>("Level");
		scorecol.setSortType(TableColumn.SortType.DESCENDING);
		
		
		
		namecol.setMinWidth(100);
		scorecol.setMinWidth(100);
		lvlcol.setMinWidth(100);
		
		namecol.setCellValueFactory(new PropertyValueFactory<>("Username"));
		scorecol.setCellValueFactory(new PropertyValueFactory<>("Score"));
		lvlcol.setCellValueFactory(new PropertyValueFactory<>("Level"));
		
		for(int j=0;j<scores.size();j++) {
			if(j<=10) {
			table.getItems().add(scores.get(j));
			}
		}
		table.getColumns().addAll(namecol,scorecol,lvlcol);
		
		
		//table.setItems(data);
		
		
		Button button4=new Button("Back");
		button4.setOnAction(e -> primaryStage.setScene(back));
		button4.setMinSize(100, 50);
		button4.setStyle("-fx-text-fill: #00ff00;-fx-background-color:Green");
		
		 
		 VBox layout2=new VBox();         
		layout2.getChildren().addAll(table,button4);
		layout2.setSpacing(50);
		layout2.setBackground(new Background(new BackgroundFill(Color.rgb(0,255,0), CornerRadii.EMPTY, Insets.EMPTY)));
		layout2.setAlignment(Pos.CENTER);// Changed the alignment to center-left
	    return(new Scene(layout2,xres,yres));

	}
	
	public void createwin() {
		
		
		
		
		Label label1=new Label("YOU HAVE DID A WIN.");
		label1.setFont(new Font("Arial", 24));
		
		Label label2=new Label("Score: "+animal.getPoints());
		label1.setFont(new Font("Arial", 24));
		
		Button button4=new Button("Scoreboard");
		button4.setOnAction(e -> primaryStage.setScene(createtable()));
		button4.setMinSize(100, 50);
		button4.setStyle("-fx-text-fill: #00ff00;-fx-background-color:Green");
		
		Button button2=new Button("Exit :(");
		button2.setOnAction(e -> primaryStage.close());
		button2.setMinSize(100, 50);
		button2.setStyle("-fx-text-fill: #00ff00;-fx-background-color:Green");
		
		TextField textField = new TextField();
		textField.setMaxSize(150, 50);

	    Button button3 = new Button("Submit username");
	    button3.setMinSize(100, 50);
	    button3.setStyle("-fx-text-fill: #00ff00;-fx-background-color:Green");

	    button3.setOnAction(action -> {
	        ScH.writescores(textField.getText(),animal.getPoints(),background.lvl);
	    });
		
		VBox layout1=new VBox();         
		layout1.setSpacing(50);
		layout1.setAlignment(Pos.CENTER);// Changed the alignment to center-left
		layout1.getChildren().addAll(label1,label2,textField,button3,button4,button2);
		layout1.setBackground(new Background(new BackgroundFill(Color.rgb(0,255,0), CornerRadii.EMPTY, Insets.EMPTY)));
		Scene winscene=new Scene(layout1,xres,yres);
		back=winscene;
		primaryStage.setScene(winscene);
	}
	
public void createnextlvlscrn() {
		
		
	background.lvl=background.lvl+1;
	background.removeall();
	
		Label label1=new Label("YOU HAVE DID LEVEL "+background.lvl+"!");
		label1.setFont(new Font("Arial", 24));
		
		Label label2=new Label("Score: "+animal.getPoints());
		label1.setFont(new Font("Arial", 24));
		
		Button button4=new Button("next level");
		button4.setOnAction(e -> primaryStage.setScene(creategamescene()));
		button4.setMinSize(100, 50);
		button4.setStyle("-fx-text-fill: #00ff00;-fx-background-color:Green");
		
		Button button=new Button("Scoreboard");
		button.setOnAction(e -> primaryStage.setScene(createtable()));
		button.setMinSize(100, 50);
		button.setStyle("-fx-text-fill: #00ff00;-fx-background-color:Green");
		
		Button button2=new Button("Exit :(");
		button2.setOnAction(e -> primaryStage.close());
		button2.setMinSize(100, 50);
		button2.setStyle("-fx-text-fill: #00ff00;-fx-background-color:Green");
		
		TextField textField = new TextField();
		textField.setMaxSize(150, 50);

	    Button button3 = new Button("Submit username");
	    button3.setMinSize(100, 50);
	    button3.setStyle("-fx-text-fill: #00ff00;-fx-background-color:Green");

	    button3.setOnAction(action -> {
	        ScH.writescores(textField.getText(),animal.getPoints(),background.lvl);
	    });
		
		VBox layout1=new VBox();         
		layout1.setSpacing(50);
		layout1.setAlignment(Pos.CENTER);// Changed the alignment to center-left
		layout1.getChildren().addAll(label1,label2,textField,button3,button,button4,button2);
		layout1.setBackground(new Background(new BackgroundFill(Color.rgb(0,255,0), CornerRadii.EMPTY, Insets.EMPTY)));
		Scene nxtlvlscene=new Scene(layout1,xres,yres);
		back=nxtlvlscene;
		primaryStage.setScene(nxtlvlscene);
	}
	public void setMenu() {
		primaryStage.setScene(CreatMenu());
		primaryStage.setTitle("GAME");
		primaryStage.show();
	}
}
	