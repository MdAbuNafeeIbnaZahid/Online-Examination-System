package sample;

import util.NetworkUtil;

import java.io.File;
import java.net.InetAddress;
import java.util.Calendar;

/**
 * Created by nafee on 3/10/17.
 */
public class Student {
    Integer stdId;
    NetworkUtil networkUtil;
    Exam exam;
    InetAddress inetAddress;
    File studentDestinationFolder;
    File studentAnsStoreFile;
    Calendar startingTimeCalendar;


    public Student(Integer stdId, NetworkUtil networkUtil, Exam exam, InetAddress inetAddress, File studentDestinationFolder, File studentAnsStoreFile, Calendar startingTimeCalendar) {
        this.stdId = stdId;
        this.networkUtil = networkUtil;
        this.exam = exam;
        this.inetAddress = inetAddress;
        this.studentDestinationFolder = studentDestinationFolder;
        this.studentAnsStoreFile = studentAnsStoreFile;
        this.startingTimeCalendar = startingTimeCalendar;
    }


}
