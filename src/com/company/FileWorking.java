package com.company;

import com.company.models.Course;

import java.io.*;
import java.util.ArrayList;

public class FileWorking {

    private static String FILE_NAME="data_course.txt";

    public static ArrayList<Course> getArrayFromFile() throws IOException {
        BufferedReader reader = initReader();
        if(reader==null) return null;
        return getArray(reader);
    }

    private static ArrayList<Course> getArray(BufferedReader reader) throws IOException {
        String s;
        ArrayList<Course> cources = new ArrayList<Course>();
        while ((s = reader.readLine()) != null){
            cources.add(new Course(
               Integer.parseInt(s),
               reader.readLine(),
               toBool(reader.readLine()),
               Integer.parseInt(reader.readLine()),
                Integer.parseInt(reader.readLine()),
                Integer.parseInt(reader.readLine()),
                Integer.parseInt(reader.readLine()),
                Integer.parseInt(reader.readLine()),
                Integer.parseInt(reader.readLine())
            ));
        }
        return cources;
    }

    private static boolean toBool(String readLine) {
        return readLine.equals("True");
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
