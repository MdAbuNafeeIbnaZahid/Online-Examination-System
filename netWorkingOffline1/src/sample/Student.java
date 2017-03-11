package sample;

import util.NetworkUtil;

import java.net.InetAddress;

/**
 * Created by nafee on 3/10/17.
 */
public class Student {
    Integer stdId;
    NetworkUtil networkUtil;
    String examName;
    InetAddress inetAddress;

    public Student(Integer stdId, NetworkUtil networkUtil, String examName, InetAddress inetAddress) {
        this.stdId = stdId;
        this.networkUtil = networkUtil;
        this.examName = examName;
        this.inetAddress = inetAddress;
    }
}
