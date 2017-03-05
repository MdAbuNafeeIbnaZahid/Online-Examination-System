package tcpdiff;/**
 * Created by nafeedgbhs on 11/22/2015.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class ClientStarter extends Application {

    Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        // fxml will be loaded here
        Parent root = FXMLLoader.load( getClass().getResource("ClientBeforeConnect.fxml") );
        ClientBeforeConnectController.setMain(this);
        primaryStage.setTitle("Client");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
        stage = primaryStage;



        // Now it is happening inside ClientBeforeConnectController
        /*
        while (true) // actually it will not happen always, It will be called by a button press in the scene
        {
            Scanner scn = new Scanner(System.in);
            String clientName = scn.nextLine();

            new Client(clientName);
        }
        */

    }


    public void showNextScene(String clientName) throws Exception
    {
        // fxml will be loaded here
        Parent root = FXMLLoader.load( getClass().getResource("ClientAfterConnect.fxml") );
        ClientAfterConnectController.setMain(this);
        stage.setTitle("Client : " + clientName);
        stage.setScene(new Scene(root, 400, 300));
        stage.show();

    }
}
