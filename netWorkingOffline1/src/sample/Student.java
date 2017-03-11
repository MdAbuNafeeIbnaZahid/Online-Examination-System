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
    Calendar lastBackupCalendar;

    public Integer getStdId() {
        return stdId;
    }

    public void setStdId(Integer stdId) {
        this.stdId = stdId;
    }

    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }

    public void setNetworkUtil(NetworkUtil networkUtil) {
        this.networkUtil = networkUtil;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public InetAddress getInetAddress() {
        return inetAddress;
    }

    public void setInetAddress(InetAddress inetAddress) {
        this.inetAddress = inetAddress;
    }

    public File getStudentDestinationFolder() {
        return studentDestinationFolder;
    }

    public void setStudentDestinationFolder(File studentDestinationFolder) {
        this.studentDestinationFolder = studentDestinationFolder;
    }

    public File getStudentAnsStoreFile() {
        return studentAnsStoreFile;
    }

    public void setStudentAnsStoreFile(File studentAnsStoreFile) {
        this.studentAnsStoreFile = studentAnsStoreFile;
    }

    public Calendar getStartingTimeCalendar() {
        return startingTimeCalendar;
    }

    public void setStartingTimeCalendar(Calendar startingTimeCalendar) {
        this.startingTimeCalendar = startingTimeCalendar;
    }

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
