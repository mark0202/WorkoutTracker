package com.exercises;

import java.util.Arrays;

public class EANChecker {

    // Approach 1 - leave ean as Long
    public boolean checkEAN(Long ean) {

        long intVal = 0;
        long evenSum = 0;
        long oddSum = 0;

        // Step 1 Compute sum of digits in even positions
        for (int i=2; i<13; i=i+2) {

            intVal = ean % (long) Math.pow(10, 14-i);
            intVal = intVal / (long) Math.pow(10, 13-i);

            evenSum = evenSum + intVal;
        }

        //Step 2 Compute sum of digits in odd positions
        for (int i=1; i<13; i=i+2) {

            intVal = ean % (long) Math.pow(10, 14-i);
            intVal = intVal / (long) Math.pow(10, 13-i);

            oddSum = oddSum + intVal;
        }

        //Step 3 Multiply first sum by 3 and add second sub
        long sum = evenSum*3 + oddSum;

        //Step 4 Subtract 1
        sum = sum - 1;

        //Step 5 Compute remainder after dividing by 10
        long sumRem = sum % 10;

        //Step 6 Calculate checksum
        long checkSum = 9 - sumRem;

        //Step 7 Return true if checksum matches last digit, otherwise false

        if (checkSum == ean % 10) {
            return true;
        } else {
            return false;
        }
        // return checkSum == ean % 10;

    }

    // Approach 2 - convert ean to char[]

    public Boolean checkEAN2(Long ean) {

        char[] arrVal= convertLongToCharArray(ean);
        System.out.println("EAN as Array: " + Arrays.toString(arrVal));
        long evenSum = 0;
        long oddSum = 0;

        // Step 1 Compute sum of digits in even positions
        for (int i=1; i<12; i=i+2) {
            evenSum = evenSum + Character.getNumericValue(arrVal[i]);
        }

        //Step 2 Compute sum of digits in odd positions
        for (int i=0; i<12; i=i+2) {
            oddSum = oddSum + Character.getNumericValue(arrVal[i]);
        }

        //Step 3 Multiply first sum by 3 and add second sub
        long sum = evenSum*3 + oddSum;

        //Step 4 Subtract 1
        sum = sum - 1;

        //Step 5 Compute remainder after dividing by 10
        long sumRem = sum % 10;

        //Step 6 Calculate checksum
        long checkSum = 9 - sumRem;

        //Step 7 Return true if checksum matches last digit, otherwise false
        return checkSum == ean % 10;


    }

    char[] convertLongToCharArray(long longVal) {

        // Convert the given long value to an array of char of length 13 with leading zeroes

        String strVal = Long.toString(longVal);
        int len = strVal.length();
        int zerosToAdd = 13-len;
        String zeros = "";
        for (int i = 0; i<zerosToAdd; i++) {
            zeros = zeros + "0";
        }
        strVal = zeros + strVal;

        return strVal.toCharArray();
    }
}
