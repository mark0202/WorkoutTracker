package com.exercises.javaproject;

public class Person {

    public Long id;
    public String firstName;
    public String lastName;
    public int age;

    public Person(Long ident, String first, String second, int alter) {
        id = ident;
        firstName = first;
        lastName = second;
        age = alter;

    }
    public String toString() {
        return id + " " + firstName + " " + lastName + " " + age;
    }
}
