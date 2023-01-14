package com.exercises;

public class Convert {

    // Convert decimal int 'from' to base 'base' e.g 2 for binary, 8 for octal, max 16!
    public String convertToBase(int from, int base) {

     //   int fromOrig = from;
        int remainder;
        char remainderChar = 0;

        StringBuffer to = new StringBuffer();

        while(from > 0) {
            remainder = from % base;
            switch (remainder) {
                case 10: remainderChar = 'a'; break;
                case 11: remainderChar = 'b'; break;
                case 12: remainderChar = 'c'; break;
                case 13: remainderChar = 'd'; break;
                case 14: remainderChar = 'e'; break;
                case 15: remainderChar = 'f'; break;
            }

            if (remainderChar == 0)
                to.append(remainder);
            else
                to.append(remainderChar);

            from = from / base;
            from = Math.abs(from);
            remainderChar = 0;

        }

        return  to.reverse().toString();
    }
}
