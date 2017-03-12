package sample;

/**
 * Created by nafee on 3/12/17.
 */
public class ListenToServerThread implements Runnable {

    ClientStarter clientStarter;
    Client client;
    Thread thread;

    String instructionFromServer;

    public ListenToServerThread(ClientStarter clientStarter, Client client) {
        this.clientStarter = clientStarter;
        this.client = client;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true)
        {
            instructionFromServer = (String) client.networkUtil.read();

            System.out.println( "In client received instructionFromServer = " + instructionFromServer );

            if ( instructionFromServer.equals( "EXAM_END" ) )
            {
                try {
                    client.networkUtil.fileSend( client.getQaFile().getAbsolutePath() );
                    System.out.println( "Successfully sent last backup file from client" );
                }
                catch (Exception e)
                {
                    System.out.println("Failed to send last backup file from client");
                }
            }

            if ( instructionFromServer.equals( "SEND_ANS" ) )
            {
                try {
                    client.networkUtil.fileSend( client.getQaFile().getAbsolutePath() );
                    System.out.println( "Successfully sent backup file from client" );
                }
                catch (Exception e)
                {
                    System.out.println("Failed to send backup file from client");
                }

            }


        }
    }
}
