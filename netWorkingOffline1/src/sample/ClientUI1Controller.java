package sample;

/**
 * Created by nafee on 3/5/17.
 */

        import java.io.File;
        import java.net.Socket;
        import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Alert;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;
        import javafx.stage.DirectoryChooser;


public class ClientUI1Controller {

    public static ClientStarter clientStarter;
    String ipAddress;
    String portNumber;
    String studentId;
    String examNameStr;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label loginStatusLabel;

    @FXML
    private Button connectButton;

    @FXML
    private TextField examNameTextField;

    @FXML
    private TextField ipAddressTextField;

    @FXML
    private TextField portNumberTextField;

    @FXML
    private TextField studentIDTextField;

    @FXML
    private Label ansFileLocationLabel;

    @FXML
    private Label questionFileLocationLabel;

    @FXML
    void chooseAnsFileLocationAction(ActionEvent event) {
    }

    @FXML
    void chooseQuestionFileLocationAction(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File chosenDir = directoryChooser.showDialog(clientStarter.stage);
        if (chosenDir == null ) {
            System.out.println("Chosen dir is null");
        }
        else
        {
            //ansStoreLocation = chosenDir;
            questionFileLocationLabel.setText( chosenDir.getAbsolutePath() );
            //System.out.println(" Chosen dir absolute path =  " + chosenDir);
        }
    }


    @FXML
    void connectButtonAction(ActionEvent event) {
        boolean isEntryGiven = false;
        ipAddress = ipAddressTextField.getText();
        portNumber = portNumberTextField.getText();
        studentId = studentIDTextField.getText();
        examNameStr = examNameTextField.getText();
        String questionFolderLocationStr = questionFileLocationLabel.getText();


        System.out.println("ipAddress = " + ipAddress);
        System.out.println("portNumber = " + portNumber);
        System.out.println("studentId = " + studentId);

        //Socket socket = new Socket()
        try {
            Client client = new Client(ipAddress, Integer.parseInt(portNumber), Integer.parseInt(studentId), examNameStr);
            client.setClientStarter( clientStarter );
            client.sendStdIdToServer();
            client.sendExamNameToServer();
            System.out.println("sent examName to server");
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
                }clientStarter.exam = (Exam)object;
                    System.out.println(clientStarter.exam);


            }
            System.out.println("isEntryGiven = " + isEntryGiven);
            if ( isEntryGiven )
            {

                Object object = client.networkUtil.read();

                clientStarter.exam = (Exam)object;
                System.out.println(clientStarter.exam);

                client.networkUtil.fileReceive( questionFolderLocationStr + "/question.doc" );

                clientStarter.showSecondClientUI();

            }

            else
            {
                System.out.println("going to write invalid prompt in client label");
                loginStatusLabel.setText("Invalid ip or student id");
            }

        }
        catch ( Exception e )
        {
            System.out.println("Can't create new connection in client");
            System.out.println("Exception e = " + e);
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
