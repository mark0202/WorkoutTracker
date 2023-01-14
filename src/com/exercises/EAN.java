package com.exercises;

import java.util.Scanner;

public class EAN {

    public static void main(String[] args) {

        Scanner inputStream = new Scanner(System.in);
        System.out.print("Enter an amount: ");
        Long ean = inputStream.nextLong();       // e.g. 9783890111049,  0024901000709

        EANChecker eanChecker = new EANChecker();

        if (eanChecker.checkEAN2(ean) == true) {
            System.out.println("The EAN is VALID");}
        else {
            System.out.println("The EAN is NOT VALID");

        };

    }
}


