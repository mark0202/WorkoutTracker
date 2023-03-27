package com.exercises.javaproject;

public class BikingWorkout extends Workout {

    BikingType type;

    BikingWorkout() {
    }

    BikingWorkout(Long id, int duration, int distance, Long personId, BikingType type) {

        super.id = id;
        super.duration = duration;
        super.distance = distance;
        super.personId = personId;

        this.type = type;
    }
}
