package com.exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeGenerator {

    public boolean isPrime(int num) {

        // return true is num is a prime (exclude 1 and num in divisor check)
        boolean numIsPrime = true;
        for (int i=2; i<=num-1; i++) {
            if (num % i == 0) {
                numIsPrime = false;
                break;
            }
        }

        return numIsPrime;
    }

    // return an ArrayList of all the primes between 2 and toNum
    public ArrayList<Integer> getPrimes(int toNum) {

        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int num=2; num<=toNum; num++) {

            // check each number
            if (isPrime(num)) {
                result.add((Integer) num);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        Scanner inputStream = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = inputStream.nextInt();

        PrimeGenerator primeGenerator = new PrimeGenerator();

        ArrayList<Integer> result = new ArrayList<Integer>();

        result = primeGenerator.getPrimes(num);

        System.out.println("Prime numbers = " + result);

        for (int i : result) {
            System.out.println(i);
        }

    }

}


