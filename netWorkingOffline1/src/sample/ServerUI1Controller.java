

package sample;

        import java.io.File;
        import java.net.URL;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.ResourceBundle;
        import java.util.StringTokenizer;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
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

    public ArrayList<Integer> rangeInsert(ArrayList<Integer> arrayList, int s, int e)
    {
        int a, b, c, d;
        for (a = s; a <= e; a++)
        {
            arrayList.add( a );
        }
        return  arrayList;
    }

    public ArrayList<Integer> getStdListFromStr( String str )
    {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        String strWithoutSpace = "";
        str = str.replaceAll(" ", "");
        //System.out.println( str );
        StringTokenizer st = new StringTokenizer(str, ",");
        while (st.hasMoreTokens())
        {
            String part = st.nextToken();
            int firStd, secStd;
            if ( part.contains( "-" ) )
            {
                StringTokenizer stringTokenizer = new StringTokenizer(part, "-");
                firStd = Integer.parseInt( stringTokenizer.nextToken() );
                secStd = Integer.parseInt( stringTokenizer.nextToken() );
            }
            else
            {
                firStd = Integer.parseInt( part );
                secStd = Integer.parseInt(part );
            }
            ret = rangeInsert(ret, firStd, secStd);
        }

        return ret;
    }

    String examNameStr;
    int examStartHourInt;
    int examStartMinInt;
    File questionFile;
    File ansStoreLocation;
    String applicationAllowed;
    double backupIntervalMinDob;
    double examDurationMinDob;
    double warningBefEndMinuteDob;
    String ruleStr;
    String studentsEnrolledStr;
    List<Integer> studentsEnrolledList = new ArrayList<Integer>();






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
    private TextField examStartHourField;

    @FXML
    private TextField examStartMinField;

    @FXML
    private TextArea ruleText;

    @FXML
    private TextArea studentsEnrolledText;

    @FXML
    private TextField warnigBeforeEndMin;


    @FXML
    private Label questionLocationLabel;

    @FXML
    private Label ansStoreLocationLabel;

    @FXML
    private Button correctionSendButton;

    @FXML
    private TextArea correctionTextArea;



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
            ansStoreLocationLabel.setText( ansStoreLocation.getAbsolutePath() );
            //System.out.println(" Chosen dir absolute path =  " + chosenDir);
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
            questionLocationLabel.setText( questionFile.getAbsolutePath() );
            //System.out.println("Chosen file absolute path = " + chosenFile.getAbsolutePath());
        }
    }

    @FXML
    private Button submitButton;

    @FXML
    void submitAction(ActionEvent event) {
        examNameStr = examNameField.getText();
        examStartHourInt = Integer.parseInt( examStartHourField.getText() );
        examStartMinInt = Integer.parseInt( examStartMinField.getText() );
        examDurationMinDob = Double.parseDouble( examDurationMin.getText() );
        warningBefEndMinuteDob = Double.parseDouble( warnigBeforeEndMin.getText() );
        ruleStr = ruleText.getText();
        backupIntervalMinDob = Double.parseDouble(backupIntervalMin.getText() );
        applicationAllowed = applicationAllowedList.getText();
        studentsEnrolledStr = studentsEnrolledText.getText().replaceAll(" ", "");
        studentsEnrolledList = getStdListFromStr( studentsEnrolledStr );

        Exam exam = new Exam();
        exam.setName( examNameStr );
        exam.setStartHour( examStartHourInt );
        exam.setStartMin( examStartMinInt );
        exam.setDurationMin((int) examDurationMinDob);
        exam.setWarnigMinBefEnding( (int)warningBefEndMinuteDob );
        exam.setRules( ruleStr );
        exam.setBackupIntervalMin( (int)backupIntervalMinDob );
        exam.setApplicationAllowed( applicationAllowed );
        exam.setAnsStoreLocation( ansStoreLocation );
        exam.setQuestionFile( questionFile );
        exam.setListOfStudentsEnrolled( studentsEnrolledList );

        serverStarter.examList.add( exam );
        serverStarter.server = new Server();
        serverStarter.server.setServerStarter( serverStarter );

        /*
        try {
            serverStarter.showNextScene();
        }
        catch (Exception e)
        {
            System.out.println("caught exception. server UI2 can't be displayed");
        }
        */

    }

    @FXML
    void correctionSendAction(ActionEvent event) {
    }


    @FXML
    void initialize() {

        assert applicationAllowedList != null : "fx:id=\"applicationAllowedList\" was not injected: check your FXML file 'ServerUI1.fxml'.";
        assert backupIntervalMin != null : "fx:id=\"backupIntervalMin\" was not injected: check your FXML file 'ServerUI1.fxml'.";
        assert chooseAnsStoreLocation != null : "fx:id=\"chooseAnsStoreLocation\" was not injected: check your FXML file 'ServerUI1.fxml'.";
        assert chooseQuestionButton != null : "fx:id=\"chooseQuestionButton\" was not injected: check your FXML file 'ServerUI1.fxml'.";
        assert examDurationMin != null : "fx:id=\"examDurationMin\" was not injected: check your FXML file 'ServerUI1.fxml'.";
        assert examNameField != null : "fx:id=\"examNameField\" was not injected: check your FXML file 'ServerUI1.fxml'.";
        assert examStartHourField != null : "fx:id=\"examStartHour\" was not injected: check your FXML file 'ServerUI1.fxml'.";
        assert examStartMinField != null : "fx:id=\"examStartMin\" was not injected: check your FXML file 'ServerUI1.fxml'.";
        assert ruleText != null : "fx:id=\"ruleText\" was not injected: check your FXML file 'ServerUI1.fxml'.";
        assert studentsEnrolledText != null : "fx:id=\"studentsEnrolledText\" was not injected: check your FXML file 'ServerUI1.fxml'.";
        assert submitButton != null : "fx:id=\"submitButton\" was not injected: check your FXML file 'ServerUI1.fxml'.";
        assert warnigBeforeEndMin != null : "fx:id=\"warnigBeforeEndMin\" was not injected: check your FXML file 'ServerUI1.fxml'.";


    }

}
