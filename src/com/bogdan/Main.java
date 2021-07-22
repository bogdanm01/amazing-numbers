package com.bogdan;
import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("\nSupported requests:");
        System.out.println("- enter a natural number to know it's properties;");
        System.out.println("- enter 0 to exit.");
        System.out.print("\nEnter a request: ");

        long number = scan.nextLong();

        while(number != 0) {
            process(number);
            System.out.print("\nEnter a request: ");
            number = scan.nextLong();
        }

        System.out.println("Goodbye!");
    }

    private static void process(long number) {
        if (!(number < 0)) {
            System.out.println("Properties of " + number);
            System.out.println("even: " + checkParity(number));
            System.out.println("odd: " + !checkParity(number));
            System.out.println("buzz: " + checkBuzz(number));
            System.out.println("duck: " + checkDuck(number));
            System.out.println("palindromic: " + checkPalindrome(number));
        } else {
            System.out.println("The first parameter should be a natural number or zero.");
        }
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

    public static boolean checkPalindrome(long number) {
        long reversedNumber = 0;
        long check = number;
        while(check != 0) {
            int remainder = (int)check % 10;
            reversedNumber = reversedNumber * 10 + remainder;
            check = check / 10;
        }
        return reversedNumber == number;
    }
}
