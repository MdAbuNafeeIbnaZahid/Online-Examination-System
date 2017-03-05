package sample;

import util.NetworkUtil;

/**
 * Created by nafee on 3/5/17.
 */
public class Client {
    String ipAddress;
    int portNumber;
    String studentId;
    NetworkUtil networkUtil;
    Client(String ipAddress, int portNumber, String studentId)
    {
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
        this.studentId = studentId;
        networkUtil = new NetworkUtil(ipAddress, portNumber);
    }
}
