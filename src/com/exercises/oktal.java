package com.exercises;

import java.util.Scanner;
import java.lang.Math;

public class oktal {
    public static void main(String[] args) {

        int octal;
        int remainder;


        Scanner inputStream = new Scanner(System.in);
        System.out.print("Enter octal number: ");
        octal= inputStream.nextInt();

        int power = 0;
        int intValue = 0;

        while(octal > 0) {
            remainder = octal % 10;
            intValue = (int) (intValue + remainder * Math.pow(8,power));

            octal = octal / 10;
            octal = Math.abs(octal);
            power++;

        }

        System.out.println("Dezimal: " + intValue);

        int digitSum = 0;
        while(intValue > 0) {

            remainder = intValue % 10;
            digitSum = digitSum + remainder;

            intValue = intValue / 10;
            intValue = Math.abs(intValue);

        }

        System.out.println("Ziffersumme: " + digitSum);
    }

    }
