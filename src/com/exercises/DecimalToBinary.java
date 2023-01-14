package com.exercises;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {

        int decimal;   // Number to convert
        int decimalOrig;
        int remainder;

        StringBuffer binFormat = new StringBuffer();

        Scanner inputStream = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter decimal number: ");

        decimal= inputStream.nextInt();  // Read integer
        decimalOrig = decimal;

        while(decimal > 0) {
            remainder = decimal % 2;
            binFormat.append(remainder);

            decimal = decimal / 2;
            decimal = Math.abs(decimal);

        }

        System.out.println("The binary equivalent of " + decimalOrig + " is " + binFormat.reverse());

    }
}
