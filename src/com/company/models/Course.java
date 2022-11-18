package com.company.models;

public class Course {
    int ID = 0;
    String URL = "";
    boolean isHasCost = false;
    int CourseCost = 0;
    int Listeners = 0;
    int Otzivi = 0;
    int Lections = 0;
    int Difficulty = 0;
    int TimeSpan = 0;

    public void setTimeSpan(int timeSpan) {
        TimeSpan = timeSpan;
    }

    public int getTimeSpan() {
        return TimeSpan;
    }

    public Course(int ID, String URL, boolean isHasCost, int courseCost, int listeners, int otzivi, int lections, int difficulty, int timespan) {
        this.ID = ID;
        this.URL = URL;
        this.isHasCost = isHasCost;
        CourseCost = courseCost;
        Listeners = listeners;
        Otzivi = otzivi;
        Lections = lections;
        Difficulty = difficulty;
        this.TimeSpan = timespan;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setHasCost(boolean hasCost) {
        isHasCost = hasCost;
    }

    public void setCourseCost(int courseCost) {
        CourseCost = courseCost;
    }

    public void setListeners(int listeners) {
        Listeners = listeners;
    }

    public void setOtzivi(int otzivi) {
        Otzivi = otzivi;
    }

    public void setLections(int lections) {
        Lections = lections;
    }

    public void setDifficulty(int difficulty) {
        Difficulty = difficulty;
    }

    public int getID() {
        return ID;
    }

    public String getURL() {
        return URL;
    }

    public boolean isHasCost() {
        return isHasCost;
    }

    public int getCourseCost() {
        return CourseCost;
    }

    public int getListeners() {
        return Listeners;
    }

    public int getOtzivi() {
        return Otzivi;
    }

    public int getLections() {
        return Lections;
    }

    public int getDifficulty() {
        return Difficulty;
    }
}
