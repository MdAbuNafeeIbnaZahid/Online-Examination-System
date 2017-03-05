package tcpdiff;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.*;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by nafeedgbhs on 11/22/2015.
 */
public class ServerController implements Initializable{

    public static ServerStarter main;

    public static void setMain(ServerStarter m)
    {
        main = m;
    }

    @FXML
    private TableView<Person> tableView;

    @FXML
    private TableColumn<Person, String> nameColumn;

    @FXML
    private TableColumn<Person, Button> buttonColumn;


    @FXML
    private TextArea messageBox;


    @FXML
    private Button sendButton;

    public String getMessageFromMessageBox()
    {
        return messageBox.getText();
    }


    //  It will be discarded
    @FXML
    // This method is now unnecessary
    void sendAction(ActionEvent event) {
        //String message = messageBox.getText();
        //main.sendMessageToClient(message);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Person.setServerController(this);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("clientName"));
        buttonColumn.setCellValueFactory(new PropertyValueFactory<Person, Button>("button"));
        tableView.setItems(main.personList);


    }
}
