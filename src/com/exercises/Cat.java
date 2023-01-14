
package com.exercises;

public class Cat extends Mammal {

    private String favouritePastime;
    private String colour;

    public Cat(String n, String pastime, String col) {
        super(n);
        favouritePastime = pastime;
        colour = col;
    }


    public String sayHello() {

        return "Hello! My name is " + super.getName() + ". I am a " + colour + " cat and my favourite pastime is " + favouritePastime;

    }
}

