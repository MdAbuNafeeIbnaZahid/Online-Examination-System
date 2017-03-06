package sample;

import java.io.File;
import java.util.List;

/**
 * Created by nafee on 3/6/17.
 */
public class Exam {
    String name;
    int startHour;
    int startMin;
    int durationMin;
    int warnigMinBefEnding;
    String rules;
    int backupIntervalMin;
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

    public int getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(int durationMin) {
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

    public int getBackupIntervalMin() {
        return backupIntervalMin;
    }

    public void setBackupIntervalMin(int backupIntervalMin) {
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


}
