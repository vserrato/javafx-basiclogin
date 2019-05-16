import java.io.File;
import java.io.PrintWriter;

import java.util.Scanner;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ActualMenu extends Pane {

	TextField name;
	PasswordField pass;


	public ActualMenu() {
		Pane gPane = new Pane();

		Scene scene = new Scene(gPane,250,400);

		gameSetup();


	}

	public void gameSetup() {

		name = new TextField();
		name.setPromptText("Enter a username:");
		name.relocate(30, 30);
		getChildren().add(name);

		pass = new PasswordField();
		pass.setPromptText("Enter a password:");
		pass.relocate(30, 80);
		getChildren().add(pass);

		Button register = new Button("Register");
		register.relocate(30, 120);
		getChildren().add(register);

		Button login = new Button("Login");
		login.relocate(30,170);
		getChildren().add(login);

		register.setOnAction(e ->{

			String user = name.getText();
			String password = pass.getText();

			registerText(user, password);

		});

		login.setOnAction(e ->{
			createFile();
		});


	}
	

	public String getUser() {
		return this.name.getText();
	}

	public String getPassword() {
		return this.pass.getText();
	}


	public void createFile() {

		String user = "userinfo.txt";
		String read;

		File file = new File(user);

		Scanner in;

		try {

			in = new Scanner(file);

			while(in.hasNext()) {

				read = in.nextLine();
				System.out.println(read);

				String[] splitter = read.split(",");

				String castName = splitter[0];
				String castPass = splitter[1];

				if(!(castName.equals(getUser())) || !(castPass.equals(getPassword()))) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Incorrect User/Password");
					alert.setHeaderText("Please type in the correct Username or Password");
					alert.show();
				} else {
					System.out.println("Logged in!");

					changeToHome();
				}

			}



		}catch(Exception ex) {

			System.out.println("Cannot find file text");

		}

	}

	public void registerText(String name, String pass) {

		PrintWriter writer = null;
		String user = "userinfo.txt";

		try {

			writer = new PrintWriter(new File(user));

			writer.print(name + ","+ pass);


		}catch(Exception e) {

		}
		writer.flush();
		writer.close();

	}

	public void changeToHome() {
		Pane pane = new Pane();

		Scene scene = new Scene(pane, 250,400);

		Home home = new Home();
		pane.getChildren().add(home);

		Stage game = new Stage();
		game.setTitle("Game Screen");
		game.setResizable(false);
		game.setScene(scene);
		game.show();

	}



}
