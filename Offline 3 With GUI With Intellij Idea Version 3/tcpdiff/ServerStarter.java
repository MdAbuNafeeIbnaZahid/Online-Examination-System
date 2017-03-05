package tcpdiff;/**
 * Created by nafeedgbhs on 11/22/2015.
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
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class ServerStarter extends Application {

    public static ObservableList<Person> personList = FXCollections.observableArrayList();
    public static Hashtable<Button, String> buttonStringHashtable = new Hashtable<>();
    // I need a Button to String/Person Hashtable
    public static Hashtable<Button, Person> buttonPersonHashtable = new Hashtable<>();
    Hashtable<String, NetworkUtil> table = new Hashtable<>();
    String clientName, message;
    NetworkUtil nc;
    Stage stage;
    Server server;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        // fxml will be loaded here
        Parent root = FXMLLoader.load(getClass().getResource("Server.fxml"));
        ServerController.setMain(this);
        primaryStage.setTitle("Server");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
        stage = primaryStage;






        server = new Server(table);
        server.setMain(this);

        /*
        while (true) // Ultimately it will be called when server will press the send button
        {
            Scanner scanner = new Scanner(System.in);
            clientName = scanner.nextLine();

            nc = table.get(clientName);
            if (nc != null)
            {
                //message = scanner.nextLine();
                //nc.write(message);



                table.remove(clientName);
                System.out.println(" Message successfully sent to " + clientName);
            }
        }
        */
    }

    public void sendMessageToClient(Button button)
    {
        /*
        Scanner scanner = new Scanner(System.in);
        clientName = scanner.nextLine();
        */



        clientName = buttonStringHashtable.get(button);
        nc = table.get(clientName);
        if (nc != null) {
            //message = scanner.nextLine();
            // Server Controller is supplying me the message
            nc.write(message);


            // Need to clear personList
            personList.remove( buttonPersonHashtable.get(button) );
            // Need to remove buttonString
            buttonStringHashtable.remove(button);
            // Need to remove buttonPerson
            buttonPersonHashtable.remove(button);

            table.remove(clientName);
            System.out.println(" Message successfully sent to " + clientName);
        }
    }
}
