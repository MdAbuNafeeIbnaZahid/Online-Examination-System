
package sample;


import util.NetworkUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.util.Calendar;


public class AcceptNewStudentThread implements Runnable {


    ServerStarter serverStarter;
    Thread thr;
    NetworkUtil networkUtil;
    Student student;

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

    public static void copyFile(File sourceFile, File destFile) throws IOException {
        if(!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination = null;

        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0, source.size());
        }
        finally {
            if(source != null) {
                source.close();
            }
            if(destination != null) {
                destination.close();
            }
        }
    }

    @Override
    public void run()
    {
        InetAddress inetAddress = networkUtil.getInetAddress();
        System.out.println( "inetAddress = " + inetAddress );
        Integer stdId = null;
        String examName = null;
        String loginInstructionToClient = "";
        while (true)
        {
            Object object = networkUtil.read();
            System.out.println( object );
            if ( object != null )
            {
                stdId = (Integer) object;
                System.out.println( "server received stdId = " + stdId );
                object = networkUtil.read();
                examName = (String) object;

                if ( serverStarter.isStdIdOk( examName,  stdId ) )
                {
                    loginInstructionToClient = "EntryGreen";
                    //break;
                }
                else
                {
                    loginInstructionToClient = "InvalidLoginInfo";
                }
                break;
            }

        }

        networkUtil.write( loginInstructionToClient );

        System.out.println("written loginInstructionToClient");


        if ( loginInstructionToClient.equals( "EntryGreen" )  )
        {
            //serverStarter.stdIdIpAddrssList.add( new StdIdIpAddrs(stdId, inetAddress) );

            System.out.println( "added new student to serverStarter's studentList" );
            networkUtil.write( serverStarter.getExamByName( examName ) );
            System.out.println( "sent exam to client" );
            if ( ( !serverStarter.wasStdPreviouslyLoggedIn( stdId ) ) )
            {
                System.out.println( "student was not previously logged in" );

                // I will create a new file for keeping students answer
                Exam exam = serverStarter.getExamByName( examName );
                System.out.println( "Got exam by name" );
                File sourceFile = exam.getQuestionFile();
                File examDestinationFolder = exam.getAnsStoreLocation();
                File studentDestinationFolder = new File( examDestinationFolder.getAbsolutePath() + "/" + stdId );
                if (studentDestinationFolder.mkdir() )
                {
                    System.out.println("Successfully created directory named after student");
                }
                else
                {
                    System.out.println("Failed to created directory named after student");
                }

                File destinationFile = new File( studentDestinationFolder.getAbsolutePath() +  "/ansFile.doc" );
                System.out.println("Created a new destination file");

                try {
                    copyFile(sourceFile, destinationFile);
                    System.out.println("Successfully copied file");
                }
                catch ( Exception e )
                {
                    System.out.println( "Failed to copy file" );
                    System.out.println( e );
                }
                System.out.println("work of copy file ended");

                Calendar calendar = Calendar.getInstance();
                System.out.println( calendar );
                student = new Student(stdId, networkUtil, exam, inetAddress, studentDestinationFolder, destinationFile);
                serverStarter.studentList.add( student );
            }

            try {
                networkUtil.fileSend( student.studentAnsStoreFile.getAbsolutePath() );
            }
            catch (Exception e)
            {
                System.out.println("Failed to send initial question file");
                System.out.println( e );
            }


        }

    }
}
