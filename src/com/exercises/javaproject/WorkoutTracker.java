package com.exercises.javaproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

enum SwimmingType {
    BACKSTROKE,
    BUTTERFLY
}

enum BikingType {
    MOUNTAIN,
    ROAD
}

public class WorkoutTracker

{
    List<Workout> workoutList = new ArrayList<Workout>();
    List<Person> personList = new ArrayList<Person>();


    Long workoutId = Long.valueOf(2000); // will be increased by 1 for each workout
    int backstrokeDuration, backstrokeDistance, butterflyDuration, butterflyDistance;
    int mountainDuration, mountainDistance, roadDuration, roadDistance;

    public static void main(String[] args) {

        WorkoutTracker workoutTracker = new WorkoutTracker();

        workoutTracker.trackWorkouts();

    }

    public void trackWorkouts() {
        // Method which manages the overall process of tracking Workouts

        //Step 1
        FileUtils fileUtils = new FileUtils();
        personList = fileUtils.readPersonsFromCsv();

        //Step 2
        for (Person p : personList) {
            System.out.println("\n" + p);
            addWorkoutsToPerson(p.id);
        }

        //Step 3
        fileUtils.writeStatisticsToFile(personList, workoutList);
    }
    public  void addWorkoutsToPerson(Long personId) {
        // Create at least 5 Workouts for the specified Person
        int min = 5;
        int max = 10;

        Random rand = new Random();
        int numWorkouts = rand.nextInt(min, max);
        System.out.println("Number of workouts: " + numWorkouts);

        // set Duration and Distance initial values
        backstrokeDuration = 40;    // minutes
        backstrokeDistance = 1000;   // 1k
        butterflyDuration = 30;     // minutes
        butterflyDistance = 1000;   // 1k
        mountainDuration = 120;     // 2 hours
        mountainDistance = 30000;    // 30k
        roadDuration = 180;         // 3 hours
        roadDistance = 60000;       // 60k

        for (int i=1;  i<=numWorkouts; i++) {
            System.out.println("Creating workout #" + i);
            createWorkout(personId);
        }
    }

    public  void createWorkout(Long personId) {
        // There are 4 workout types
        // 1 Swimming Backstroke
        // 2 Swimming Butterfly
        // 3 Biking Mountain
        // 4 Biking Road

        // Randomly select one of these
        Random rand = new Random();
        int workoutType = rand.nextInt(1, 5);
        System.out.println("workoutType = " + workoutType);

        workoutId = workoutId + 1;

        Workout workout;
        switch(workoutType) {
            case 1:
                workout = new SwimmingWorkout(workoutId,backstrokeDuration,backstrokeDistance,personId,SwimmingType.BACKSTROKE);
                workoutList.add(workout);
                System.out.println("Backstroke, Dur:" + backstrokeDuration + " Dist:" + backstrokeDistance);

                backstrokeDuration = backstrokeDuration + 2;     // 2 mins longer for next backstroke workout
                backstrokeDistance = backstrokeDistance + 20;   // 20m further for next backstroke workout

                break;
            case 2:
                workout = new SwimmingWorkout(workoutId,butterflyDuration,butterflyDistance,personId,SwimmingType.BUTTERFLY);
                workoutList.add(workout);
                System.out.println("Butterfly, Dur:" + butterflyDuration + " Dist:" + butterflyDistance);

                butterflyDuration = butterflyDuration + 1;     // 1 min longer
                butterflyDistance = butterflyDistance + 15;     // 15m further
                break;
            case 3:
                workout = new BikingWorkout(workoutId,mountainDuration,mountainDistance,personId,BikingType.MOUNTAIN);
                workoutList.add(workout);
                System.out.println("Mountain, Dur:" + mountainDuration + " Dist:" + mountainDistance);

                mountainDuration = mountainDuration + 10;    // 10 mins
                mountainDistance = mountainDistance + 1500; // 1.5k

                break;
            case 4:
                workout = new BikingWorkout(workoutId,roadDuration,roadDistance,personId,BikingType.ROAD);
                workoutList.add(workout);
                System.out.println("Road, Dur:" + roadDuration + " Dist:" + roadDistance);

                roadDuration = roadDuration + 10;     // 10 mins
                roadDistance = roadDistance + 3000;     // 3k
                break;
            default:
                System.out.println("shouldn't be here!");
        }


    }
}
