package com.company;

import com.company.models.Course;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class FileWorking {

    private static String FILE_NAME="src/data_course.txt";
    private static String LOG_NAME="src/out.log";

    public static ArrayList<Course> getArrayFromFile() {
        redirectLogToFile();
        BufferedReader reader = initReader();
        if(reader==null) return null;
        return getArray(reader);
    }

    private static void redirectLogToFile() {
        try{
            PrintStream out = new PrintStream(new FileOutputStream(LOG_NAME));
            System.setOut(out);
        } catch (FileNotFoundException ex){}
    }

    private static boolean isDataCorrect(ArrayList<Course> cources){
        for (Course c : cources){
            if(!c.getURL().contains("https://")) return false;
        }
        return true;
    }


    private static ArrayList<Course> getArray(BufferedReader reader) {
        String s;
        ArrayList<Course> cources = new ArrayList<Course>();
        try {
            while ((s = reader.readLine()) != null) {
                cources.add(new Course(
                        Integer.parseInt(s),
                        reader.readLine(),
                        reader.readLine(),
                        reader.readLine().equals("True"),
                        Integer.parseInt(reader.readLine()),
                        Integer.parseInt(reader.readLine()),
                        Integer.parseInt(reader.readLine()),
                        Integer.parseInt(reader.readLine()),
                        reader.readLine(),
                        Float.parseFloat(reader.readLine())
                ));
            }
            if(isDataCorrect(cources)) return cources;
            else return null;
        } catch (IOException e){ return null;}
    }

    private static BufferedReader initReader() {
        try {
            return new BufferedReader(new FileReader(FILE_NAME));
        } catch (FileNotFoundException ex){
            System.out.println("file no found");
            return null;
        }
    }
}
