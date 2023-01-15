package com.exercises;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Mammals {

    public static void main(String[] args) {

        ArrayList<Mammal> mammals= new ArrayList<Mammal>();

        Scanner inputStream = new Scanner(System.in);

        // Create a few instances of Human, Dog and Cat
        Human mark = new Human("Mark", "Irish","Star Trek");
        mammals.add(mark);

        Human michaela = new Human("Michaela", "Austrian", "????");
        mammals.add(michaela);

        Dog rover = new Dog("Rover", "Steak bone", "German Shepherd");
        mammals.add(rover);

        Dog max = new Dog("Max", "Dog food", "Mongrel");
        mammals.add(max);

        Cat pussy = new Cat("Pussy", "chasing mice", "black");
        mammals.add(pussy);

        Cat cuddles = new Cat("Cuddles", "sleeping", "mottled");
        mammals.add(cuddles);

        Rabbit bugs = new Rabbit("Bugs");
        mammals.add(bugs);

        String nameToFind;

        while (true) {
            System.out.print("Enter a name: ");
            nameToFind = inputStream.next();

            if (nameToFind.equals("end")) {
                break;
            }

            // Search the ArrayList for name
            boolean nameNotFound = true;
            for (Mammal mammal : mammals) {

                String name = mammal.getName();
                if (name.equals(nameToFind)) {
                    System.out.println(mammal.sayHello());
                    nameNotFound = false;
                }

                //  if (mammals.get(i).name.equals(nameToFind)) {
                //      System.out.println(mammals.get(i).sayHello() );
                //  }

            }

            if (nameNotFound) {
                System.out.println("Cannot find a mammal called " + nameToFind);
            }
        }

    }
}