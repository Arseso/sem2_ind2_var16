package com.company;

import com.company.models.Course;

import java.io.PrintStream;
import java.util.*;

public class Main {

    public static void main(String[] args){
        PrintStream console = new PrintStream(System.out);

        ArrayList<Course> cources = FileWorking.getArrayFromFile();
        printCourse(TimeSpanSmallOrEquals3Month(cources));
        printCourse(Top10Popular(cources));
        printCourse(SortFreeByLectionsPerWeek(cources));

        //additional
        System.setOut(console);

        //patterns: "All Levels", "Beginner Level", "Intermediate Level", "Expert Level"
        String Difficulty = "Beginner Level";

        //patterns: "free", "paid"
        String Payment = "free";

        //patterns: "TimeSpan", "Lections", "Listeners"
        String SortBy = "Lections";

        printCourse(adaptiveSort(cources, Difficulty, Payment, SortBy));

    }

    private static List<Course> adaptiveSort(ArrayList<Course> cources, String difficulty, String payment, String sortBy) {
        ArrayList<Course> cources_sorted = new ArrayList<>();
        System.out.println("[AdaptiveSort]");

        switch(difficulty){
            case "All Levels":
                for(Course c : cources)if(Objects.equals(c.getDifficulty(), "All Levels")) cources_sorted.add(c);
                break;
            case "Beginner Level":
                for(Course c : cources)if(Objects.equals(c.getDifficulty(), "Beginner Level")) cources_sorted.add(c);
                break;
            case "Intermediate Level":
                for(Course c : cources)if(Objects.equals(c.getDifficulty(), "Intermediate Level")) cources_sorted.add(c);
                break;
            case "Expert Level":
                for(Course c : cources)if(Objects.equals(c.getDifficulty(), "Expert Level")) cources_sorted.add(c);
                break;
        }

        switch(payment){
            case "free":
                for(Course c : cources)if(c.isHasCost()) cources_sorted.remove(c);
                break;
            case "paid":
                for(Course c : cources)if(!c.isHasCost()) cources_sorted.remove(c);
                break;
        }

        switch (sortBy) {
            case "TimeSpan" -> cources_sorted.sort(Comparator.comparing(Course::getTimeSpan));
            case "Lections" -> cources_sorted.sort(Comparator.comparing(Course::getLections));
            case "Listeners" -> cources_sorted.sort(Comparator.comparing(Course::getListeners));
        }
        return cources_sorted;
    }

    private static List<Course> Top10Popular(ArrayList<Course> cources) {

        System.out.println("[Top10Popular]");

        List<Course> cost_cources = new ArrayList<>();
        for(Course c : cources) if(c.isHasCost()) cost_cources.add(c);

        cost_cources.sort(Comparator.comparing(Course::getListeners));
        Collections.reverse(cost_cources);
        cost_cources = cost_cources.subList(0,9);
        cost_cources.sort(Comparator.comparing(Course::getCourseCost));
        return cost_cources;
    }

    private static ArrayList<Course> SortFreeByLectionsPerWeek(ArrayList<Course> cources) {

        System.out.println("[SortFreeByLectionsPerWeek]");

        ArrayList<Course> free_cources = new ArrayList<>();
        for(Course c : cources) if(!c.isHasCost()) free_cources.add(c);
        free_cources.sort(Comparator.comparing(Course::getAverageLectionsPerWeek));
        return free_cources;
    }

    private static ArrayList<Course> TimeSpanSmallOrEquals3Month(ArrayList<Course> cources) {

        System.out.println("[TimeSpanSmallOrEquals3Month]");

        ArrayList<Course> afterChecking = new ArrayList<>();
        for (Course c: cources) if(c.getTimeSpan()<=3) afterChecking.add(c);
        return afterChecking;
    }

    private static void printCourse(List<Course> cources){
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
            System.out.println("Average L/W: " + c.getAverageLectionsPerWeek());
            System.out.println("------------------");
        }
    }
}
