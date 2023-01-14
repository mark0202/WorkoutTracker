package com.exercises;

public class DecimalToBinaryTake2 {
    public static void main(String[] args) {

        int decimal = 42;   // Number to convert
        int base = 16;       // base to convert to
        String result;

        Convert convertor = new Convert();

        result = convertor.convertToBase(decimal, base);

        System.out.println("The  equivalent of " + decimal + " to base " + base + " is " + result);
    }

}
