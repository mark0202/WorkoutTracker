package com.exercises;

public class Dog extends Mammal {

    private String favouriteFood;
    private String breed;

    public Dog(String n, String favFood, String brd) {
        super(n);
        breed = brd;
        favouriteFood = favFood;
    }

    public String sayHello() {

        return "Hello! My name is " + super.getName() + ". I am a " + breed + " and my favourite food is " + favouriteFood;

    }
}

