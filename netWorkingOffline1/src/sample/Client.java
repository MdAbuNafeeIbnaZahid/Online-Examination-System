package sample;

import util.NetworkUtil;

import java.io.File;

/**
 * Created by nafee on 3/5/17.
 */
public class Client {
    Exam exam;
    public static ClientStarter clientStarter;
    String ipAddress;
    int portNumber;
    Integer studentId;
    NetworkUtil networkUtil;
    String examName;
    File qaFile;



    public static void setClientStarter(ClientStarter clientStarter) {
        Client.clientStarter = clientStarter;
    }

    Client(String ipAddress, int portNumber, Integer studentId, String examName)
    {
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
        this.studentId = studentId;
        this.examName = examName;
        networkUtil = new NetworkUtil(ipAddress, portNumber);
    }

    public File getQaFile() {
        return qaFile;
    }

    public void setQaFile(File qaFile) {
        this.qaFile = qaFile;
    }

    void sendStdIdToServer()
    {
        System.out.println( "from client " );
        networkUtil.write( studentId );
        System.out.println( "written studentId = " + studentId + "to server" );
    }

    void sendExamNameToServer()
    {
        System.out.println( "from client " );
        networkUtil.write( examName );
        System.out.println( "written examName = " + examName + "to server" );
    }
}
