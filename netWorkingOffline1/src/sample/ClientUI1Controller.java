package sample;

/**
 * Created by nafee on 3/5/17.
 */

        import java.net.Socket;
        import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.TextField;


public class ClientUI1Controller {
    String ipAddress;
    String portNumber;
    String studentId;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button connectButton;

    @FXML
    private TextField ipAddressTextField;

    @FXML
    private TextField portNumberTextField;

    @FXML
    private TextField studentIDTextField;


    @FXML
    void connectButtonAction(ActionEvent event) {
        ipAddress = ipAddressTextField.getText();
        portNumber = portNumberTextField.getText();
        studentId = studentIDTextField.getText();

        System.out.println("ipAddress = " + ipAddress);
        System.out.println("portNumber = " + portNumber);
        System.out.println("studentId = " + studentId);

        //Socket socket = new Socket()
        Client client = new Client(ipAddress, Integer.parseInt(portNumber), studentId);

    }

    @FXML
    void initialize() {
        assert connectButton != null : "fx:id=\"connectButton\" was not injected: check your FXML file 'ClientUI1.fxml'.";
        assert ipAddressTextField != null : "fx:id=\"ipAddressTextField\" was not injected: check your FXML file 'ClientUI1.fxml'.";
        assert portNumberTextField != null : "fx:id=\"portNumberTextField\" was not injected: check your FXML file 'ClientUI1.fxml'.";
        assert studentIDTextField != null : "fx:id=\"studentIDTextField\" was not injected: check your FXML file 'ClientUI1.fxml'.";


    }

}
