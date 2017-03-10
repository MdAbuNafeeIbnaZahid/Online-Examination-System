package sample;

import util.NetworkUtil;

/**
 * Created by nafee on 3/10/17.
 */
public class Student {
    Integer stdId;
    NetworkUtil networkUtil;

    public Student(Integer stdId, NetworkUtil networkUtil) {
        this.stdId = stdId;
        this.networkUtil = networkUtil;
    }
}
