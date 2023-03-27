package com.exercises.javaproject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

//import com.exercises.javaproject.SwimmingType;
//import com.exercises.javaproject.BikingType;


public class FileUtils {

    private final String PATH_TO_PERSON_IMPORT = "/Users/mark/Library/Mobile Documents/com~apple~CloudDocs/Developer/IdeaProjects/DecToBin/resources/csvFile";
    private final String PATH_TO_STATISTICS = "/Users/mark/Library/Mobile Documents/com~apple~CloudDocs/Developer/IdeaProjects/DecToBin/resources/statisticsFile";

    // Retrieve the list of persons frpm csv file
    public List<Person> readPersonsFromCsv() {

        List<Person> personList = new ArrayList<Person>() ;

        try {
            File csvFile = new File(PATH_TO_PERSON_IMPORT);
            Scanner csvFileReader = new Scanner(csvFile);

            while (csvFileReader.hasNextLine()) {
                String line = csvFileReader.nextLine();
                String[] attr = line.split(",");

                Person person = new Person(Long.parseLong(attr[0]), attr[1], attr[2], Integer.parseInt(attr[3]));
                personList.add(person);

                //System.out.println(data);
            }
            csvFileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return personList;

    }

    public void writeStatisticsToFile(List<Person> persons, List<Workout> workouts) {

        try {
            File statsFile = new File(PATH_TO_STATISTICS);
            if (statsFile.createNewFile()) {
                System.out.println("File created: " + statsFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        FileWriter statsWriter = null;
        try {
            statsWriter = new FileWriter(PATH_TO_STATISTICS);

            // Person statistics
            int personNum = 1;
            for (Person p : persons) {
                statsWriter.write("- - - Person " + personNum++ + " - - -" + String.format("%n"));
                statsWriter.write("Name: " + p.firstName + " " + p.lastName + " " + "(" + p.age + ")" + String.format("%n"));

                statsWriter.write("Number of biking Exercises: " + getNumberOfBikingWorkoutsByPerson(p.id, workouts) + String.format("%n"));
                statsWriter.write("Number of swimming Exercises: " + getNumberOfSwimmingWorkoutsByPerson(p.id, workouts) + String.format("%n"));
                statsWriter.write("Average duration: " + Math.round(getAverageDurationOfWorkoutByPerson(p.id, workouts)) + "min" + String.format("%n"));

            }

            // Biking and Swimming statistics
            List<BikingWorkout> bWorkouts = new ArrayList<BikingWorkout>();
            for (Workout p: workouts ) {
                if (p instanceof BikingWorkout) {
                    bWorkouts.add((BikingWorkout) p);
                }
            }

            statsWriter.write(String.format("%n") + "- - - Biking - - -" + String.format("%n"));
            statsWriter.write("Average distance: " + Math.round(getAverageDistance(bWorkouts)) + "m" + String.format("%n"));
            statsWriter.write("Average duration: " + Math.round(getAverageDuration(bWorkouts)) + "min" + String.format("%n"));
            statsWriter.write("# mountain: " + getNumberOfBikingWorkoutsByType(bWorkouts, BikingType.MOUNTAIN) + String.format("%n"));
            statsWriter.write("# road: " + getNumberOfBikingWorkoutsByType(bWorkouts, BikingType.ROAD) + String.format("%n"));


            List<SwimmingWorkout> sWorkouts = new ArrayList<SwimmingWorkout>();
            for (Workout p: workouts ) {
                if (p instanceof SwimmingWorkout) {
                    sWorkouts.add((SwimmingWorkout) p);
                }
            }
            statsWriter.write("- - - Swimming - - -" + String.format("%n"));
            statsWriter.write("Average distance: " + Math.round(getAverageDistance(sWorkouts)) + "m" + String.format("%n"));
            statsWriter.write("Average duration: " + Math.round(getAverageDuration(sWorkouts)) + "min" + String.format("%n"));
            statsWriter.write("# backstroke: " + getNumberOfSwimmingWorkoutsByType(sWorkouts, SwimmingType.BACKSTROKE) + String.format("%n"));
            statsWriter.write("# butterfly: " + getNumberOfSwimmingWorkoutsByType(sWorkouts, SwimmingType.BUTTERFLY) + String.format("%n"));


        } catch (IOException e) {
            System.out.println("File error occurred.");
            e.printStackTrace();
        }

        try {
            statsWriter.close();

        } catch (IOException e) {
            System.out.println("Error closing file.");
            e.printStackTrace();
        }

        System.out.println("Successfully wrote to the file.");

    }




    // By Person Statistics

    public int getNumberOfBikingWorkoutsByPerson(Long personId, List<Workout> workoutList) {
        int bCount = 0;

        for (Workout w:workoutList ) {
            if (w instanceof BikingWorkout && w.personId == personId) {
                bCount++;
            }
        }
        return bCount;
    }

    public int getNumberOfSwimmingWorkoutsByPerson(Long personId, List<Workout> workoutList) {

        int sCount = 0;

        for (Workout w:workoutList ) {
            if (w instanceof SwimmingWorkout && w.personId == personId) {
                sCount++;
            }
        }
        return sCount;
    }

    public double getAverageDurationOfWorkoutByPerson(Long personId, List<Workout> workoutList) {

        int wCount = 0;
        int durationSum = 0;
        double average;

        for (Workout w:workoutList ) {
            if (w.personId == personId) {
                durationSum = durationSum + w.duration;
                wCount++;
            }
        }
        average = durationSum/wCount;
        return average;
    }



    // Workout Statistics
    // series of getters to access and return relevant statistics data
    //

    public int getNumberOfBikingWorkoutsByType(List<BikingWorkout> workouts, BikingType type) {

        // two ways to count number of biking workouts of given type
        boolean usingStreamFilter = false;

        if (usingStreamFilter) {
            return (int) workouts.stream().filter(w -> w.type == type).count();
        } else {
            int wCount = 0;
            for (BikingWorkout w : workouts) {
                if (w.type == type) {
                    wCount++;
                }
            }
            return wCount;
        }

    }

    public int getNumberOfSwimmingWorkoutsByType(List<SwimmingWorkout> workouts, SwimmingType type) {

        int sCount = 0;

        for (SwimmingWorkout w: workouts ) {
            if  (w.type == type) {
                sCount++;
            }
        };

        return sCount;
    }



    public double getAverageDistance(List<? extends Workout> workouts) {

        double distanceTotal = 0;
        int wTotal = 0;
        for (Workout p: workouts){
            distanceTotal = distanceTotal + p.distance;
            wTotal++;
        }

        return distanceTotal/wTotal;
    }

    public double getAverageDuration(List<? extends Workout> workouts) {

        double durationTotal = 0;
        int wTotal = 0;
        for (Workout p: workouts){
            durationTotal = durationTotal + p.duration;
            wTotal++;
        }
        return durationTotal/wTotal;
    }


}
