package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

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
    private TextArea examInfo;



    public void setInitialInfo()
    {
        examInfo.setText( clientStarter.exam.toString() );
    }


    @FXML
    void initialize() {

        System.out.println("Loading client ui 2. control now to clientUI2controller");
        //setInfoFromServerLabel( clientStarter.exam.toString() );

        //assert infoFromServerLabel != null : "fx:id=\"infoFromServerLabel\" was not injected: check your FXML file 'ClientUI2.fxml'.";


    }

}
