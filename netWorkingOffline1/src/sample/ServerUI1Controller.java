

package sample;

        import java.io.File;
        import java.net.URL;
        import java.util.List;
        import java.util.ResourceBundle;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.TextArea;
        import javafx.scene.control.TextField;
        import javafx.stage.DirectoryChooser;
        import javafx.stage.FileChooser;


public class ServerUI1Controller {

    public static ServerStarter serverStarter;
    public static void setServerStarter(ServerStarter serverStarter)
    {
        ServerUI1Controller.serverStarter = serverStarter;
    }

    File questionFile;
    File ansStoreLocation;




    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea applicationAllowedList;

    @FXML
    private TextField backupIntervalMin;

    @FXML
    private Button chooseAnsStoreLocation;

    @FXML
    private Button chooseQuestionButton;

    @FXML
    private TextField examDurationMin;

    @FXML
    private TextField examNameField;

    @FXML
    private TextField examStartHour;

    @FXML
    private TextField examStartMin;

    @FXML
    private TextArea ruleText;

    @FXML
    private TextArea studentsEnrolledText;

    @FXML
    private TextField warnigBeforeEndMin;


    @FXML
    void chooseAnsStoreLocationAction(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File chosenDir = directoryChooser.showDialog(serverStarter.stage);
        if (chosenDir == null ) {
            System.out.println("Chosen dir is null");
        }
        else
        {
            ansStoreLocation = chosenDir;
            System.out.println(" Chosen dir absolute path =  " + chosenDir);
        }
    }

    @FXML
    void chooseQuestionAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        System.out.println("New fileChooser created");
        File chosenFile = fileChooser.showOpenDialog( serverStarter.stage );
        if ( chosenFile == null  )
        {
            System.out.println("Chosen file is null");
        }
        else
        {
            questionFile = chosenFile;
            System.out.println("Chosen file absolute path = " + chosenFile.getAbsolutePath());
        }
    }

    @FXML
    void initialize() {
        assert applicationAllowedList != null : "fx:id=\"applicationAllowedMin\" was not injected: check your FXML file 'ServerUI1.fxml'.";
        assert backupIntervalMin != null : "fx:id=\"backupIntervalMin\" was not injected: check your FXML file 'ServerUI1.fxml'.";
        assert chooseAnsStoreLocation != null : "fx:id=\"chooseAnsStoreLocation\" was not injected: check your FXML file 'ServerUI1.fxml'.";
        assert chooseQuestionButton != null : "fx:id=\"chooseQuestionButton\" was not injected: check your FXML file 'ServerUI1.fxml'.";
        assert examDurationMin != null : "fx:id=\"examDurationMin\" was not injected: check your FXML file 'ServerUI1.fxml'.";
        assert examNameField != null : "fx:id=\"examNameField\" was not injected: check your FXML file 'ServerUI1.fxml'.";
        assert examStartHour != null : "fx:id=\"examStartHour\" was not injected: check your FXML file 'ServerUI1.fxml'.";
        assert examStartMin != null : "fx:id=\"examStartMin\" was not injected: check your FXML file 'ServerUI1.fxml'.";
        assert ruleText != null : "fx:id=\"ruleText\" was not injected: check your FXML file 'ServerUI1.fxml'.";
        assert studentsEnrolledText != null : "fx:id=\"studentsEnrolledText\" was not injected: check your FXML file 'ServerUI1.fxml'.";
        assert warnigBeforeEndMin != null : "fx:id=\"warnigBeforeEndMin\" was not injected: check your FXML file 'ServerUI1.fxml'.";


    }

}
