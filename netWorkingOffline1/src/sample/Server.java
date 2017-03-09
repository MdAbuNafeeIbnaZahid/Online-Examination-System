package sample;

import util.NetworkUtil;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by nafee on 3/5/17.
 */
public class Server implements Runnable {
    ServerStarter serverStarter;
    private ServerSocket servSock;
    Thread thr;

    public void setServerStarter(ServerStarter serverStarter) {
        this.serverStarter = serverStarter;
    }

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
                NetworkUtil networkUtil = new NetworkUtil(clientSock);
                System.out.println("Got a new client request");
                //System.out.println(  clientSock.getInetAddress() );
                InetAddress inetAddress = networkUtil.getInetAddress();
                String stdId;
                AcceptNewStudentThread acceptNewStudentThread = new AcceptNewStudentThread(serverStarter, networkUtil);
                /*
                while (true)
                {
                    Object receivedObject = networkUtil.read();
                    if ( receivedObject != null )
                    {
                        stdId = (String)receivedObject;
                        break;
                    }
                }
                if (  )
                */
            }
        }
        catch (Exception e)
        {
            System.out.println("problem in run method of Server" + e);
        }
    }
}
