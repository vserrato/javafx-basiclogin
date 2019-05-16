import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{
	
	
	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		
		Scene scene = new Scene(pane, 250, 400, Color.rgb(100, 100, 101));
		
		Button singlePlayer = new Button("Single Player");
		singlePlayer.relocate(70, 200);
		pane.getChildren().add(singlePlayer);
		
		
		singlePlayer.setOnAction(e -> {
			changeWindow();
			primaryStage.close();
		});
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Main Menu");
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
	public void changeWindow() {
		
		Pane pane = new Pane();
	
		Scene scene = new Scene(pane, 250,400);
		
		ActualMenu menu = new ActualMenu();
		pane.getChildren().add(menu);
		
		Stage newWindow = new Stage();
		newWindow.setScene(scene);
		newWindow.setResizable(false);
		newWindow.setTitle("Home Screen");
		newWindow.show();
	}
	
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	

}
