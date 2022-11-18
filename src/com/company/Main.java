package com.company;

import com.company.models.Course;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Course> cources = FileWorking.getArrayFromFile();

        printCourse(TimeSpanSmallOrEquals3Month(cources));
        printCourse(Top10Popular(cources));
    }

    private static ArrayList<Course> Top10Popular(ArrayList<Course> cources) {
        Collections.s
    }

    private static ArrayList<Course> TimeSpanSmallOrEquals3Month(ArrayList<Course> cources) {
        ArrayList<Course> afterChecking = new ArrayList<Course>();
        for (Course c: cources) if(c.getTimeSpan()<=3) afterChecking.add(c);
        return afterChecking;
    }

    private static void printCourse(ArrayList<Course> cources){
        if(cources == null){
            System.out.println("No cources suitable for the condition");
            return;
        }
        for(Course c : cources) {
            System.out.println("ID: " + c.getID());
            System.out.println("URL: " + c.getURL());
            System.out.println("isHasCost: " + c.isHasCost());
            if (c.isHasCost()) System.out.println("Course cost: " + c.getCourseCost());
            System.out.println("Lesteners: " + c.getListeners());
            System.out.println("Otzivi: " + c.getOtzivi());
            System.out.println("Lections: " + c.getLections());
            System.out.println("Difficulty: " + c.getDifficulty());
            System.out.println("TimeSpan: " + c.getTimeSpan());
            System.out.println("------------------");
        }
    }
}
