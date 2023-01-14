package com.exercises;

import java.util.Scanner;

public class DateFormatConverter {

    public static void main(String[] args) {

        int dateInt;
        int day, month, year;
        int remainder;


        Scanner inputStream = new Scanner(System.in);
        System.out.print("Enter date yyyymmdd : ");

        dateInt= inputStream.nextInt();

        int lowerBound = 15821016;
        int upperBound = 21001231;

        if (dateInt < lowerBound || dateInt > upperBound) {
            System.out.println("date out of bounds");
            return;
        }

        day = dateInt % 100;
        dateInt = dateInt/100;

        month = dateInt % 100;
        dateInt = dateInt / 100;

        year = dateInt;

        System.out.printf("%02d",day);
        System.out.print(".");
        System.out.printf("%02d", month);
        System.out.print(".");
        System.out.println(year);

        String newDate = day + "." + month + "." + year;
        System.out.println(newDate);

        }
}
