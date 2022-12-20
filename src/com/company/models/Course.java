package com.company.models;

public class Course {
    private int ID = 0;
    private String Title = "";
    private String URL = "";
    private boolean isHasCost = false;
    private int CourseCost = 0;
    private int Listeners = 0;
    private int Otzivi = 0;
    private int Lections = 0;
    private String Difficulty = "";
    private float TimeSpan = 0;
    private float AverageLectionsPerWeek = 0;

    public void setTimeSpan(int timeSpan) {
        TimeSpan = timeSpan;
    }

    public float getTimeSpan() {
        return TimeSpan;
    }

    public String getTitle() {
        return Title;
    }

    public float getAverageLectionsPerWeek() {
        return AverageLectionsPerWeek;
    }

    public Course(int ID, String Title, String URL, boolean isHasCost, int courseCost, int listeners, int otzivi, int lections, String difficulty, float timespan) {
        this.ID = ID;
        this.Title = Title;
        this.URL = URL;
        this.isHasCost = isHasCost;
        CourseCost = courseCost;
        Listeners = listeners;
        Otzivi = otzivi;
        Lections = lections;
        Difficulty = difficulty;
        TimeSpan = timespan;

        AverageLectionsPerWeek = Lections/(TimeSpan*4);
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

    public void setDifficulty(String difficulty) {
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

    public String getDifficulty() {
        return Difficulty;
    }
}
