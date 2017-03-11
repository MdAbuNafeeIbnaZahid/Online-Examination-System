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

import static java.lang.System.in;
import static java.lang.System.setOut;

public class ServerStarter extends Application {

    Stage stage;
    List<Exam> examList = new ArrayList<Exam>() ;
    Server server;
    List<StdIdIpAddrs> stdIdIpAddrssList = new ArrayList<StdIdIpAddrs>();
    List<Student> studentList = new ArrayList<Student>();

    Exam getExamByName(String examName)
    {
        Exam ret = null;
        for ( Exam exam : examList )
        {
            if ( exam.name.equals( examName ) )
            {
                ret = exam;
            }
        }
        return ret;
    }

    public boolean wasStdPreviouslyLoggedIn(int stdId)
    {
        boolean ret = false;
        for ( Student student : studentList )
        {
            if ( student.stdId == stdId )
            {
                ret = true;
            }
        }
        return ret;
    }

    public boolean isStdIdOk( String examName,  int stdId )
    {
        boolean ret = false;
        for ( Exam exam : examList )
        {
            for ( Integer i : exam.getListOfStudentsEnrolled() )
            {
                if ( exam.getName().equals( examName ) &&  stdId == i )
                {
                    ret = true;
                }
            }
        }
        return ret;
    }



    public static void main(String[] args) {

        /*
        Calendar calendar1 = Calendar.getInstance();
        for ( int i = 1; i < 10000; i++ )
        {

        }
        Calendar calendar2 = Calendar.getInstance();

        System.out.println( calendar1.compareTo( calendar2 ) );
        */

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


    public void showNextScene() throws Exception
    {
        // fxml will be loaded here
        Parent root = FXMLLoader.load( getClass().getResource("ServerUI2.fxml") );
        ServerUI2Controller.setServerStarter(this);
        //stage.setTitle("Client : " + clientName);
        stage.setScene(new Scene(root, 400, 300));
        stage.show();

    }
}
