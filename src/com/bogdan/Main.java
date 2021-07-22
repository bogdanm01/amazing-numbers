package com.bogdan;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        welcomeUser();

        boolean exit = false;

        while(!exit) {
            System.out.print("\nEnter a request: ");

            String userInput = scan.nextLine();

            long[] numbers = Arrays.stream(userInput.split(" ")).mapToLong(Long::parseLong).toArray(); // TODO odgonetnuti

            if (numbers[0] == 0) {
                exit = true;
            } else if (numbers.length == 1) {
                // process single number
                processOneNumber(numbers[0]);
            }
            else {
                System.out.println();
                processListOfNumbers(numbers);
            }
        }

        System.out.println("\nGoodbye!");
    }

    private static void welcomeUser() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("\nSupported requests:");
        System.out.println("- enter a natural number to know it's properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be printed;");
        System.out.println("- separate parameters with one space;");
        System.out.println("- enter 0 to exit.");
    }

    private static void processListOfNumbers(long[] input) {
        long startingNumber = input[0];
        long consecutiveNumber = input[1];

        if (startingNumber < 0) { // FIXME: Come up with elegant error system/logic
            System.out.println("The first parameter should be a natural number or zero.");
        }
        if(consecutiveNumber < 1) {
            System.out.println("The second parameter should ne a natural number");
        }

        if(!(startingNumber < 0 || consecutiveNumber < 1)) {
            for (long i = startingNumber; i < startingNumber + consecutiveNumber; i++) {
                String numberProperties = "";

                if (checkParity(i)) { numberProperties += "even, "; }
                else { numberProperties += "odd, "; }

                if (checkBuzz(i)) { numberProperties += "buzz, "; }
                if (checkDuck(i)) { numberProperties += "duck, "; }
                if (checkPalindrome(i)) { numberProperties += "palindromic, "; }

                System.out.println(i + " is " + numberProperties.substring(0, numberProperties.length()-2));
            }

        }
    }

    private static void processOneNumber(long number) {
        if (!(number < 0)) {
            System.out.println("\nProperties of " + number);
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
