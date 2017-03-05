package tcpdiff;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by nafeedgbhs on 11/22/2015.
 */
public class ClientBeforeConnectController {

    public static ClientStarter main;
    String clientName;

    public static void setMain(ClientStarter m)
    {
        main = m;
    }

    @FXML
    private TextField clientNameField;

    @FXML
    private Button connectButton;

    @FXML
    void connectButtonAction(ActionEvent event) {
        clientName = clientNameField.getText();
        new Client(clientName);

        // show scene two
        try {
            main.showNextScene(clientName);
        }
        catch (Exception e)
        {
            System.out.println("Client's second scene can't be displayed " + e);
        }
    }



}
