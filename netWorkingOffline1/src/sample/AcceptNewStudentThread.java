
package sample;


import util.NetworkUtil;

import java.net.InetAddress;
import java.net.InetSocketAddress;


public class AcceptNewStudentThread implements Runnable {


    ServerStarter serverStarter;
    Thread thr;
    NetworkUtil networkUtil;

    public AcceptNewStudentThread(ServerStarter serverStarter, NetworkUtil networkUtil) {
        this.serverStarter = serverStarter;
        this.networkUtil = networkUtil;
        thr = new Thread(this);
        thr.start();
    }

    public Thread getThr() {
        return thr;
    }

    public void setThr(Thread thr) {
        this.thr = thr;
    }

    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }

    public void setNetworkUtil(NetworkUtil networkUtil) {
        this.networkUtil = networkUtil;
    }

    AcceptNewStudentThread()
    {
        thr = new Thread(this);
        thr.start();
    }

    @Override
    public void run()
    {
        InetAddress inetAddress = networkUtil.getInetAddress();
        System.out.println( "inetAddress = " + inetAddress );
        Integer stdId = null;
        String examName = null;
        String messageToClient = "";
        while (true)
        {
            Object object = networkUtil.read();
            System.out.println( object );
            if ( object != null )
            {
                stdId = (Integer) object;
                object = networkUtil.read();
                object = (String) object;
                System.out.println( "server received stdId = " + stdId );
                if ( serverStarter.isStdIdOk( examName,  stdId ) )
                {
                    messageToClient = "EntryGreen";
                    //break;
                }
                else
                {
                    messageToClient = "InvalidLoginInfo";
                }
                break;
            }

        }

        networkUtil.write( messageToClient );

        if ( messageToClient.equals( "EntryGreen" ) )
        {
            serverStarter.stdIdIpAddrssList.add( new StdIdIpAddrs(stdId, inetAddress) );
            serverStarter.studentList.add( new Student(stdId, networkUtil) );
            networkUtil.write( serverStarter.examList.get(0) );
        }

    }
}
