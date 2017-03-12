package sample;

import util.NetworkUtil;

import javax.jws.soap.SOAPBinding;
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
        try
        {
            networkUtil.write( studentId );
        }
        catch (Exception e)
        {
            System.out.println("Failed to send stdid to server");
            System.out.println(e);
        }

        System.out.println( "written studentId = " + studentId + "to server" );
    }

    void sendExamNameToServer()
    {
        System.out.println( "from client " );
        try {
            networkUtil.write( examName );
        }
        catch (Exception e)
        {
            System.out.println("Failed to send exam name to server");
            System.out.println(e);
        }

        System.out.println( "written examName = " + examName + "to server" );
    }
}
