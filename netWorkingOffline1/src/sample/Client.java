package sample;

import util.NetworkUtil;

/**
 * Created by nafee on 3/5/17.
 */
public class Client {
    public static ClientStarter clientStarter;
    String ipAddress;
    int portNumber;
    Integer studentId;
    NetworkUtil networkUtil;

    public static void setClientStarter(ClientStarter clientStarter) {
        Client.clientStarter = clientStarter;
    }

    Client(String ipAddress, int portNumber, Integer studentId)
    {
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
        this.studentId = studentId;
        networkUtil = new NetworkUtil(ipAddress, portNumber);
    }

    void sendStdIdToServer()
    {
        System.out.println( "from client " );
        networkUtil.write( studentId );
        System.out.println( "written studentId = " + studentId + "to server" );
    }
}
