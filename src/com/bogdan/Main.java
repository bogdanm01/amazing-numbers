package com.bogdan;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        welcomeUser(); // displays instructions
        while (true) {
            System.out.print("\nEnter a request: ");
            String[] searchQueryArray = scan.nextLine().split(" ");

            if (Long.parseLong(searchQueryArray[0]) == 0) break;

            switch (searchQueryArray.length) {
                case 1 -> processOneNumber(Long.parseLong(searchQueryArray[0]));
                case 2 -> processQuery(Long.parseLong(searchQueryArray[0]), Long.parseLong(searchQueryArray[1]));
                default -> processQuery(Long.parseLong(searchQueryArray[0]), Long.parseLong(searchQueryArray[1]), searchQueryArray); // method overloading
            }
        }
        System.out.println("\nGoodbye!");
    }

    public static void welcomeUser() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("\nSupported requests:");
        System.out.println("- enter a natural number to know it's properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be printed;");
        System.out.println("- two natural numbers and a property to search for;");
        System.out.println("- separate parameters with one space;");
        System.out.println("- enter 0 to exit.");
    }

    public static void processOneNumber(long number) {
        if (!(number < 0)) {
            System.out.println("\nProperties of " + number);
            System.out.println("        buzz: " + AmazingNumbers.checkBuzz(number));
            System.out.println("        duck: " + AmazingNumbers.checkDuck(number));
            System.out.println(" palindromic: " + AmazingNumbers.checkPalindrome(number));
            System.out.println("      gapful: " + AmazingNumbers.checkGapful(number));
            System.out.println("         spy: " + AmazingNumbers.checkSpy(number));
            System.out.println("        even: " + AmazingNumbers.checkParity(number));
            System.out.println("         odd: " + !AmazingNumbers.checkParity(number));
        } else {
            System.out.println("The first parameter should be a natural number or zero.");
        }
    }

    public static void processQuery(long startingNumber, long consecutiveNumber) { // for two parameters
        if (startingNumber < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
        }
        if(consecutiveNumber < 1) {
            System.out.println("The second parameter should be a natural number");
        }
        else if(!(startingNumber < 0)) {
            for (long i = startingNumber; i < startingNumber + consecutiveNumber; i++) {
                StringBuilder numberProperties = checkNumberProperties(i);
                System.out.println("\t\t\t" + i + " is " + numberProperties.substring(0, numberProperties.length()-2));
            }
        }
        System.out.println();
    }

    public static void processQuery(long startingNumber, long numbersCount, String[] searchQuery) { // for parameters and a property
        String validProperties = "even, odd, buzz, duck, spy, palindromic, gapful";

        if (startingNumber < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
        } if(numbersCount < 1) {
            System.out.println("The second parameter should be a natural number");
        } else if (validProperties.contains(searchQuery[2]) || validProperties.toUpperCase().contains(searchQuery[2])) {
            int x = 0;
            while (x < numbersCount) {

                StringBuilder numberProperties = checkNumberProperties(startingNumber);

                if (numberProperties.toString().contains(searchQuery[2]) || numberProperties.toString().toUpperCase().contains(searchQuery[2])) {
                    System.out.println("\t\t\t" + startingNumber + " is " + numberProperties.substring(0, numberProperties.length() - 2));
                    x++;
                }
                startingNumber++;
            }
        } else {
            System.out.println("The property [" + searchQuery[2].toUpperCase() + "] is wrong.");
            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD]");
        }
    }

    private static StringBuilder checkNumberProperties(long i) {
        StringBuilder numberProperties = new StringBuilder();

        if (AmazingNumbers.checkParity(i)) numberProperties.append("even, ");
        else numberProperties.append("odd, ");
        if (AmazingNumbers.checkBuzz(i)) numberProperties.append("buzz, ");
        if (AmazingNumbers.checkDuck(i)) numberProperties.append("duck, ");
        if (AmazingNumbers.checkPalindrome(i)) numberProperties.append("palindromic, ");
        if (AmazingNumbers.checkGapful(i)) numberProperties.append("gapful, ");
        if (AmazingNumbers.checkSpy(i)) numberProperties.append("spy, ");

        return numberProperties;
    }
}