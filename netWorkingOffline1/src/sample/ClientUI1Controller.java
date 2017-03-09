package sample;

/**
 * Created by nafee on 3/5/17.
 */

        import java.net.Socket;
        import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Alert;
        import javafx.scene.control.Button;
        import javafx.scene.control.TextField;


public class ClientUI1Controller {

    public static ClientStarter clientStarter;
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
        boolean isEntryGiven = false;
        ipAddress = ipAddressTextField.getText();
        portNumber = portNumberTextField.getText();
        studentId = studentIDTextField.getText();

        System.out.println("ipAddress = " + ipAddress);
        System.out.println("portNumber = " + portNumber);
        System.out.println("studentId = " + studentId);

        //Socket socket = new Socket()
        try {
            Client client = new Client(ipAddress, Integer.parseInt(portNumber), Integer.parseInt(studentId));
            client.setClientStarter( clientStarter );
            client.sendStdIdToServer();
            while ( true )
            {
                Object object = client.networkUtil.read();
                if ( object != null )
                {
                    String entryMessageFromServer = (String)object;
                    if ( entryMessageFromServer.equals( "EntryGreen" ) ) // entry green light
                    {
                        isEntryGiven = true;
                    }
                    break;
                }
            }
            if ( isEntryGiven )
            {
                while (true)
                {
                    Object object = client.networkUtil.read();
                    if ( object != null )
                    {
                        clientStarter.exam = (Exam)object;
                        System.out.println(clientStarter.exam);
                        break;
                    }
                }
            }

        }
        catch ( Exception e )
        {
            System.out.println("Can't create new connection in client");
        }


    }

    @FXML
    void initialize() {
        assert connectButton != null : "fx:id=\"connectButton\" was not injected: check your FXML file 'ClientUI1.fxml'.";
        assert ipAddressTextField != null : "fx:id=\"ipAddressTextField\" was not injected: check your FXML file 'ClientUI1.fxml'.";
        assert portNumberTextField != null : "fx:id=\"portNumberTextField\" was not injected: check your FXML file 'ClientUI1.fxml'.";
        assert studentIDTextField != null : "fx:id=\"studentIDTextField\" was not injected: check your FXML file 'ClientUI1.fxml'.";


    }

    public static void setClientStarter(ClientStarter clientStarter) {
        ClientUI1Controller.clientStarter = clientStarter;
    }
}
