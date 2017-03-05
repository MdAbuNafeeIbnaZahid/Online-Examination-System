package tcpdiff;


import javafx.beans.property.StringProperty;
import javafx.event.*;
import javafx.scene.control.Button;



/**
 * Created by nafeedgbhs on 11/22/2015.
 */
public class Person {

    public static ServerStarter serverMain;
    public static ServerController serverController;


    private String clientName;
    private Button button;

    public static void setServerMain(ServerStarter serverMain) {
        Person.serverMain = serverMain;
    }

    public static void setServerController(ServerController serCon)
    {
        serverController = serCon;
    }

    Person(String clientName)
    {
        this.clientName = clientName;
        button = new Button("Send");


        button.setOnAction( new EventHandler <ActionEvent> () {
            public void handle(ActionEvent event)
            {
                // Need to write the required code
                serverMain.message = serverController.getMessageFromMessageBox();
                serverMain.sendMessageToClient(button);
            }
        });

    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
