package tcpdiff;

/**
 * Created by nafeedgbhs on 11/22/2015.
 */
import util.NetworkUtil;

import java.util.Hashtable;

public class ReadThreadServer implements Runnable {

    private Thread thr;
    private NetworkUtil nc;
    public Hashtable<String, NetworkUtil> table;
    public static ServerStarter main;

    public static void setMain(ServerStarter m)
    {
        main = m;
    }

    public ReadThreadServer(NetworkUtil nc, Hashtable<String, NetworkUtil> table) {
        this.nc = nc;
        this.thr = new Thread(this);
        this.table = table;
        thr.start();
    }

    public void run() {
        try {
            //while(true) {
                String s=(String)nc.read();
                System.out.println(s + " is connected ");
                table.put(s, nc);
            Person person = new Person(s);
            person.setServerMain(main);

            ServerStarter.buttonStringHashtable.put(person.getButton(), person.getClientName());
            ServerStarter.buttonPersonHashtable.put(person.getButton(), person);
            ServerStarter.personList.add(person);

            // Now table view will be populated
            //}
        } catch(Exception e) {
            System.out.println (e);
        }
        //nc.closeConnection();
    }
}



