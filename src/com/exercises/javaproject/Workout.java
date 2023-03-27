package com.exercises.javaproject;

public abstract class Workout {

    Long id;
    int duration;
    int distance;
    long personId;

    Workout() {

    }

    Workout(Long id, int duration, int distance, Long personId ) {
        this.id = id;
        this.duration = duration;
        this.distance = distance;
        this.personId = personId;
    }
}
