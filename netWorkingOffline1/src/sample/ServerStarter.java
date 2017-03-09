package sample;

/**
 * Created by nafee on 3/5/17.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import util.NetworkUtil;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.*;

public class ServerStarter extends Application {
    Stage stage;
    List<Exam> examList = new ArrayList<Exam>() ;


    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;
        ServerUI1Controller.setServerStarter( this );

        Parent root = FXMLLoader.load(getClass().getResource("ServerUI1.fxml"));

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
}
