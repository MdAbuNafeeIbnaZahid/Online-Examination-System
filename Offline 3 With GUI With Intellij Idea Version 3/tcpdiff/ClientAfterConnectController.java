package tcpdiff;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by nafeedgbhs on 11/22/2015.
 */
public class ClientAfterConnectController implements Initializable {

    public static ClientStarter main;

    public static void setMain(ClientStarter m)
    {
        main = m;
    }

    @FXML
    private TextArea messageFromServerFiled;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ReadThreadClient.setCon(this);
    }

    public void showMessage(String s)
    {
        messageFromServerFiled.setText(s);
    }
}
