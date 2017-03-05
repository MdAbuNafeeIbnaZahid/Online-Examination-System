package sample;

import util.NetworkUtil;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by nafee on 3/5/17.
 */
public class Server implements Runnable {
    private ServerSocket servSock;
    Thread thr;
    Server()
    {
        thr = new Thread(this);
        thr.start();
    }
    public void run()
    {
        try
        {
            servSock = new ServerSocket(5555);
            System.out.println("Created new serSock");
            while (true)
            {
                Socket clientSock = servSock.accept();
                NetworkUtil nc = new NetworkUtil(clientSock);
                System.out.println("Accepted a new client");
            }
        }
        catch (Exception e)
        {
            System.out.println("problem in run method of Server" + e);
        }
    }
}
