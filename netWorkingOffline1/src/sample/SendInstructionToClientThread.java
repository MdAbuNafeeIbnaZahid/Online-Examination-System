package sample;

import java.util.Calendar;

/**
 * Created by nafee on 3/12/17.
 */
public class SendInstructionToClientThread implements Runnable {

    long diffInMilliSec( Calendar calendarOne, Calendar calendarTwo  )
    {
        return calendarOne.getTimeInMillis() - calendarTwo.getTimeInMillis();
    }

    ServerStarter serverStarter;
    Student student;
    Thread thread;

    public SendInstructionToClientThread(ServerStarter serverStarter, Student student) {
        this.serverStarter = serverStarter;
        this.student = student;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run()
    {
        Calendar lastBackupCalendar = Calendar.getInstance();
        Calendar studentStartCalendar = student.getStartingTimeCalendar();
        Exam exam = student.getExam();
        double examDurationMilSec = exam.getDurationMin() * 60 * 1000;
        System.out.println( "examDurationMilSec = " + examDurationMilSec );
        double examBackupIntervalMilSec = exam.getBackupIntervalMin() * 60 * 1000;
        System.out.println( "examBackupIntervalMilSec = " + examBackupIntervalMilSec );



        while (true)
        {
            Calendar currentCalendar = Calendar.getInstance();

            /*
            It is not working
            if ( !student.networkUtil.isConnected()  )
            {
                System.out.println( "Client " + student.getStdId() + "connection dead " );
                break;
            }
            */

            long MilliSecPassedAfterExamStart = diffInMilliSec( currentCalendar, studentStartCalendar );
            System.out.println( "MilliSecPassedAfterExamStart = " + MilliSecPassedAfterExamStart );
            if ( MilliSecPassedAfterExamStart > examDurationMilSec )
            {
                try {
                    student.networkUtil.write( "EXAM_END" );
                }
                catch (Exception e){
                    System.out.println("Failed to write to client........ connection lost");
                    break;
                }

                System.out.println( " instructed client to end exam " );
                //receive a last copy from student
                try {
                    student.networkUtil.fileReceive( student.studentAnsStoreFile.getAbsolutePath() );
                    lastBackupCalendar = Calendar.getInstance();
                }
                catch (Exception e)
                {
                    System.out.println( "In server failed to receive last backup" );
                }
                // send ans to student
                break;
            }

            long MilliSecPassedAfterLastBackup = diffInMilliSec(currentCalendar, lastBackupCalendar);
            System.out.println("MilliSecPassedAfterLastBackup = " + MilliSecPassedAfterLastBackup);
            if ( MilliSecPassedAfterLastBackup > examBackupIntervalMilSec )
            {
                try {
                    student.networkUtil.write( "SEND_ANS" );
                }
                catch (Exception e){
                    System.out.println("Failed to write to client........ connection lost");
                    break;
                }

                System.out.println("instructed server to send ans");
                try {
                    student.networkUtil.fileReceive( student.studentAnsStoreFile.getAbsolutePath() );
                    lastBackupCalendar = Calendar.getInstance();
                }
                catch (Exception e)
                {
                    System.out.println( "In server failed to receive backup" );
                }

            }
        }
    }
}
