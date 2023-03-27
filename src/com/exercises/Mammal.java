package com.exercises;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Mammal {

    // every mammal has a name!

    private String name;

    // Constructor supplying name
    public Mammal(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String sayHello() {
        return "Hello! I'm " + name + ". No details have been provided";
    }

}
