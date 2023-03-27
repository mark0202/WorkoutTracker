package com.exercises.javaproject;

public class SwimmingWorkout extends Workout {

    SwimmingType type;

    SwimmingWorkout(Long id, int duration, int distance, Long personId, SwimmingType type) {

        super.id = id;
        super.duration = duration;
        super.distance = distance;
        super.personId = personId;

        this.type = type;
    }


}
