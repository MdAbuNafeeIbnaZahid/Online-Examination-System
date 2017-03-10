package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by nafee on 3/9/17.
 */
public class ClientUI2Controller {
    public static ClientStarter clientStarter;
    public static void setClientStarter(ClientStarter clientStarter)
    {
        ClientUI2Controller.clientStarter = clientStarter;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label infoFromServerLabel;

    void setInfoFromServerLabel(String string)
    {
        infoFromServerLabel.setText(string);
    }


    @FXML
    void initialize() {

        System.out.println("Loading client ui 2. control now to clientUI2controller");

        assert infoFromServerLabel != null : "fx:id=\"infoFromServerLabel\" was not injected: check your FXML file 'ClientUI2.fxml'.";


    }

}
