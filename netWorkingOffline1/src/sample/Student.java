package sample;

import util.NetworkUtil;

import java.io.File;
import java.net.InetAddress;

/**
 * Created by nafee on 3/10/17.
 */
public class Student {
    Integer stdId;
    NetworkUtil networkUtil;
    String examName;
    InetAddress inetAddress;
    File studentDestinationFolder;
    File studentAnsStoreFile;

    public Student(Integer stdId, NetworkUtil networkUtil, String examName, InetAddress inetAddress, File studentDestinationFolder, File studentAnsStoreFile) {
        this.stdId = stdId;
        this.networkUtil = networkUtil;
        this.examName = examName;
        this.inetAddress = inetAddress;
        this.studentDestinationFolder = studentDestinationFolder;
        this.studentAnsStoreFile = studentAnsStoreFile;
    }
}
