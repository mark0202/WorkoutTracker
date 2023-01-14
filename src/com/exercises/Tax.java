package com.exercises;

import java.util.Scanner;

public class Tax {

    public static void main(String[] args) {

        float amount = 0;
        float amountTaxed = 0;
        float amountRounded;


        Scanner inputStream = new Scanner(System.in);
        System.out.print("Enter an amount: ");
        amount= inputStream.nextFloat();

        amountTaxed = amount + amount/5;

        System.out.print("With tax added : ");
        System.out.println(String.format("%.2f",amountTaxed));


    }
}
