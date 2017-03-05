package tcpdiff;

import util.NetworkUtil;

/**
 * Created by nafeedgbhs on 11/22/2015.
 */


import util.NetworkUtil;

public class ReadThreadClient implements Runnable {
    private Thread thr;
    private NetworkUtil nc;
    String s;
    public static ClientAfterConnectController con;

    public static void setCon(ClientAfterConnectController con) {
        ReadThreadClient.con = con;
    }

    public ReadThreadClient(NetworkUtil nc) {
        this.nc = nc;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            //while(true) {
                while ( ( s=(String)nc.read() ) == null );
                //System.out.println(s);   //  It will be printed in the client's incoming message box through After Controller
            con.showMessage(s);
            //}
        } catch(Exception e) {
            System.out.println (e);
        }
        //nc.closeConnection();
    }
}



