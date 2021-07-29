package com.bogdan;

/**
 * The class contains methods for checking different properties of natural numbers. <br> <br>
 * Some of them include basic properties like number parity while others,
 * such as gapful, spy, buzz  are inspired by number theory. <br> <br>
 * Return value of each method is boolean true or false.
 */

public final class AmazingNumbers {

    public static boolean checkSquare (long number) {
        return number == ((long) Math.sqrt(number) * Math.sqrt(number));
    }

    public static boolean checkGapful (long number) {
        if (!(number < 100)) {
            String numberToString = Long.toString(number);
            String firstLastDigit = numberToString.charAt(0) + String.valueOf(numberToString.charAt(numberToString.length()-1));
            long divisor = Long.parseLong(firstLastDigit);
            return number % divisor == 0;
        }
        return false;
    }

    public static boolean checkPalindrome(long number) {
        long reversedNumber = 0;
        long check = number;
        while(check != 0) {
            long remainder = check % 10;
            reversedNumber = reversedNumber * 10 + remainder;
            check /= 10;
        }
        return reversedNumber == number;
    }

    public static boolean checkSpy (long number) { // if the sum of all digits is equal to the product of all digits
        long sum = 0;
        long product = 1;
        while (number != 0) {
            long digit = number % 10;
            sum += digit;
            product *= digit;
            number /= 10;
        }
        return sum == product;
    }

    public static boolean checkParity(long number) {
        return number % 2 == 0;
    }

    public static boolean checkBuzz(long number) {
        return ((number % 10) == 7) || number % 7 == 0;
    }

    public static boolean checkDuck(long number) {
        String strNumber = Long.toString(number);
        return strNumber.substring(1).contains("0");
    }
}
