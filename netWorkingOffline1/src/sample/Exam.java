package sample;

import java.io.File;
import java.io.Serializable;
import java.util.List;

/**
 * Created by nafee on 3/6/17.
 */
public class Exam implements Serializable{

    String name;
    int startHour;
    int startMin;
    double durationMin;
    int warnigMinBefEnding;
    String rules;
    double backupIntervalMin;
    String applicationAllowed;
    List<Integer> listOfStudentsEnrolled;
    File questionFile;
    File ansStoreLocation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getStartMin() {
        return startMin;
    }

    public void setStartMin(int startMin) {
        this.startMin = startMin;
    }

    public double getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(double durationMin) {
        this.durationMin = durationMin;
    }

    public int getWarnigMinBefEnding() {
        return warnigMinBefEnding;
    }

    public void setWarnigMinBefEnding(int warnigMinBefEnding) {
        this.warnigMinBefEnding = warnigMinBefEnding;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public double getBackupIntervalMin() {
        return backupIntervalMin;
    }

    public void setBackupIntervalMin(double backupIntervalMin) {
        this.backupIntervalMin = backupIntervalMin;
    }

    public String getApplicationAllowed() {
        return applicationAllowed;
    }

    public void setApplicationAllowed(String applicationAllowed) {
        this.applicationAllowed = applicationAllowed;
    }

    public List<Integer> getListOfStudentsEnrolled() {
        return listOfStudentsEnrolled;
    }

    public void setListOfStudentsEnrolled(List<Integer> listOfStudentsEnrolled) {
        this.listOfStudentsEnrolled = listOfStudentsEnrolled;
    }

    public File getQuestionFile() {
        return questionFile;
    }

    public void setQuestionFile(File questionFile) {
        this.questionFile = questionFile;
    }

    public File getAnsStoreLocation() {
        return ansStoreLocation;
    }

    public void setAnsStoreLocation(File ansStoreLocation) {
        this.ansStoreLocation = ansStoreLocation;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "name='" + name + '\'' +
                ", startHour=" + startHour +
                ", startMin=" + startMin +
                ", durationMin=" + durationMin +
                ", warnigMinBefEnding=" + warnigMinBefEnding +
                ", rules='" + rules + '\'' +
                ", backupIntervalMin=" + backupIntervalMin +
                ", applicationAllowed='" + applicationAllowed + '\'' +
                ", listOfStudentsEnrolled=" + listOfStudentsEnrolled +
                '}';
    }
}
