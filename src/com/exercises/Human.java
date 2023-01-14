package com.exercises;

public class Human extends Mammal {

    private String favouriteMovie;
    private String nationality;

    public Human(String name, String nat, String favMovie) {
        super(name);
        nationality = nat;
        favouriteMovie = favMovie;
    }

    public String sayHello() {

        return "Hello! My name is " + super.getName() + ". I am " + nationality + " and my favourite movie is " + favouriteMovie;

    }
}

