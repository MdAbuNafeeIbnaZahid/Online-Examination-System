package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Created by nafee on 3/5/17.
 */
public class ClientStarter extends Application {

    Stage stage;

    Exam exam;

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("ClientUI1.fxml"));
        ClientUI1Controller.setClientStarter(this);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

    }

    public void showSecondClientUI() throws Exception
    {
        // fxml will be loaded here
        //Parent root = FXMLLoader.load( getClass().getResource("ClientUI2.fxml") );
        FXMLLoader fxmlLoader = new FXMLLoader( getClass().getResource("ClientUI2.fxml") );
        Parent root = fxmlLoader.load();
        ClientUI2Controller clientUI2Controller = fxmlLoader.getController();
        System.out.println("got ClientUI2Controller instance");
        clientUI2Controller.setClientStarter(this);
        clientUI2Controller.setInitialInfo();
        //Label examInfo = (Label) root.lookup("#infoFromServerLabel");
        //examInfo.setText( exam.toString() );
        //stage.setTitle("Client : " + clientName);
        stage.setScene(new Scene(root, 400, 300));
        stage.show();

    }
}
