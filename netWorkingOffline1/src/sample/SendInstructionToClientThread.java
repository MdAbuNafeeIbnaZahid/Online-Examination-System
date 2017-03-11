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
        thread = new Thread();
        thread.start();
    }

    @Override
    public void run()
    {
        Calendar lastBackupCalendar = Calendar.getInstance();
        Calendar studentStartCalendar = student.getStartingTimeCalendar();
        Exam exam = student.getExam();
        double examDurationMilSec = exam.getDurationMin() * 60 * 1000;
        double examBackupIntervalMilSec = exam.getBackupIntervalMin() * 60 * 1000;


        while (true)
        {
            Calendar currentCalendar = Calendar.getInstance();
            if ( diffInMilliSec( currentCalendar, studentStartCalendar ) > examDurationMilSec )
            {
                student.networkUtil.write( "EXAM_END" );
                //receive a last copy from student
                // send ans to student
                break;
            }

            if ( diffInMilliSec(currentCalendar, lastBackupCalendar) > examBackupIntervalMilSec )
            {
                student.networkUtil.write( "SEND_ANS" );
            }

        }
    }
}
