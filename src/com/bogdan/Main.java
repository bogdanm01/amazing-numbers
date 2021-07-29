package com.bogdan;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        welcomeUser(); // displays instructions and welcomes user
        while (true) {
            System.out.print("\nEnter a request: ");
            String[] searchQueryArray = scan.nextLine().split(" ");
            System.out.println();

            if (Long.parseLong(searchQueryArray[0]) == 0) break;

            switch (searchQueryArray.length) {
                case 1 -> processOneNumber(Long.parseLong(searchQueryArray[0]));
                case 2 -> processQuery(Long.parseLong(searchQueryArray[0]), Long.parseLong(searchQueryArray[1]));
                default -> processQuery(Long.parseLong(searchQueryArray[0]), Long.parseLong(searchQueryArray[1]), searchQueryArray);
            }
        }
        System.out.println("Goodbye!");
    }

    public static void welcomeUser() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("\nSupported requests:");
        System.out.println("- enter a natural number to know it's properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be printed;");
        System.out.println("- two natural numbers and a property to search for;");
        System.out.println("- two natural numbers and two properties to search for;");
        System.out.println("- separate parameters with one space;");
        System.out.println("- enter 0 to exit.");
    }

    public static void processOneNumber(long number) {
        if (!(number < 0)) {
            System.out.println("Properties of " + number);
            System.out.println("        buzz: " + AmazingNumbers.checkBuzz(number));
            System.out.println("        duck: " + AmazingNumbers.checkDuck(number));
            System.out.println(" palindromic: " + AmazingNumbers.checkPalindrome(number));
            System.out.println("      gapful: " + AmazingNumbers.checkGapful(number));
            System.out.println("         spy: " + AmazingNumbers.checkSpy(number));
            System.out.println("      square: " + AmazingNumbers.checkSquare(number));
            System.out.println("       sunny: " + AmazingNumbers.checkSquare(number+1));
            System.out.println("        even: " + AmazingNumbers.checkParity(number));
            System.out.println("         odd: " + !AmazingNumbers.checkParity(number));
        } else {
            System.out.println("The first parameter should be a natural number or zero.");
        }
    }

    public static void processQuery(long startingNumber, long consecutiveNumber) { // for two parameters
        if (checkNumbersErrors(startingNumber, consecutiveNumber)) return; // return if there are any errors
        for (long i = startingNumber; i < startingNumber + consecutiveNumber; i++) {
            StringBuilder numberProperties = checkNumberProperties(i);
            System.out.println("\t\t\t" + i + " is " + numberProperties.substring(0, numberProperties.length()-2));
        }
    }

    public static void processQuery(long startingNumber, long numbersCount, String[] searchQuery) { // for parameters and a property
        String validProperties = "even odd buzz duck spy palindromic gapful square sunny";
        String firstSearchParameter = searchQuery[2];
        String secondSearchParameter = searchQuery.length > 3 ? searchQuery[3] : null;

        if (checkNumbersErrors(startingNumber, numbersCount)) return; // return if there are any errors

        if (secondSearchParameter == null) { // for one search property
            if (checkOnePropertyError(validProperties, firstSearchParameter)) return; // return if there are any errors
            processOneProperty(startingNumber, numbersCount, firstSearchParameter); // process if there aren't any errors
        } else { // if there are two properties
            if (checkTwoPropertiesErrors(validProperties, firstSearchParameter, secondSearchParameter)) return; // return if there are any errors
            processTwoProperties(startingNumber, numbersCount, firstSearchParameter, secondSearchParameter); // process if there aren't any errors
        }
    }

    private static void processTwoProperties(long startingNumber, long numbersCount, String firstSearchParameter, String secondSearchParameter) {
        int x = 0;
        while (x < numbersCount) {
            StringBuilder numberProperties = checkNumberProperties(startingNumber);

            if (checkParameter(firstSearchParameter, numberProperties) && checkParameter(secondSearchParameter, numberProperties)) {
                System.out.println("\t\t\t" + startingNumber + " is " + numberProperties.substring(0, numberProperties.length() - 2));
                x++;
            }
            startingNumber++;
        }
    }

    private static void processOneProperty(long startingNumber, long numbersCount, String firstSearchParameter) {
        int x = 0;
        while (x < numbersCount) {
            StringBuilder numberProperties = checkNumberProperties(startingNumber);

            if (checkParameter(firstSearchParameter, numberProperties)) {
                System.out.println("\t\t\t" + startingNumber + " is " + numberProperties.substring(0, numberProperties.length() - 2));
                x++;
            }
            startingNumber++;
        }
    }

    private static boolean checkTwoPropertiesErrors(String validProperties, String firstSearchParameter, String secondSearchParameter) {
        if (!(isParameterValid(validProperties, firstSearchParameter)) && (isParameterValid(validProperties, secondSearchParameter))) {
            System.out.println("The property [" + firstSearchParameter.toUpperCase() + "] is wrong.");
            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
            return true;
        }
        if (isParameterValid(validProperties, firstSearchParameter) && !(isParameterValid(validProperties, secondSearchParameter))) {
            System.out.println("The property [" + secondSearchParameter.toUpperCase() + "] is wrong.");
            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
            return true;

        }
        if (!(isParameterValid(validProperties, secondSearchParameter)) && !(isParameterValid(validProperties, firstSearchParameter))) {
            System.out.println("The properties [" + firstSearchParameter.toUpperCase()+", "+ secondSearchParameter.toUpperCase() + "] are wrong.");
            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
            return true;
        }
        if (areMutuallyExclusive(firstSearchParameter, secondSearchParameter)) { // ako uneti parametri ponistavaju jedan drugog, npr even i odd
            System.out.println("The request contains mutually exclusive properties: [" + firstSearchParameter.toUpperCase() + ", " + secondSearchParameter.toUpperCase() + "]");
            System.out.println("There are no numbers with these properties.");
            return true;
        }
        return false;
    }

    private static boolean checkOnePropertyError(String validProperties, String firstSearchParameter) { // true if there any errors
        if (!isParameterValid(validProperties, firstSearchParameter)) {
            System.out.println("The property [" + firstSearchParameter.toUpperCase() + "] is wrong.");
            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
            return true;
        }
        return false;
    }

    private static boolean checkNumbersErrors(long number1, long number2) { // true if there are any errors
        if (number1 < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
            return true;
        }
        if(number2 < 1) {
            System.out.println("The second parameter should be a natural number");
            return true;
        }
        return false;
    }

    private static boolean isParameterValid(String validProperties, String searchParameter) { // checks if searched property is valid, does it exist
        return validProperties.contains(searchParameter) || validProperties.toUpperCase().contains(searchParameter);
    }

    private static boolean checkParameter(String searchParameter, StringBuilder numberProperties) { // checks if searched property is available in numberProperties
        return numberProperties.toString().contains(searchParameter) || numberProperties.toString().toUpperCase().contains(searchParameter);
    }

    public static boolean areMutuallyExclusive (String firstParameter, String SecondParameter) {
        if ((firstParameter.equalsIgnoreCase("EVEN") && SecondParameter.equalsIgnoreCase("ODD")) || (firstParameter.equalsIgnoreCase("ODD") && SecondParameter.equalsIgnoreCase("EVEN")))
            return true;
        if ((firstParameter.equalsIgnoreCase("DUCK") && SecondParameter.equalsIgnoreCase("SPY")) || (firstParameter.equalsIgnoreCase("SPY") && SecondParameter.equalsIgnoreCase("DUCK")))
            return true;
        return (firstParameter.equalsIgnoreCase("SUNNY") && SecondParameter.equalsIgnoreCase("SQUARE")) || (firstParameter.equalsIgnoreCase("SQUARE") && SecondParameter.equalsIgnoreCase("SUNNY"));
    }

    private static StringBuilder checkNumberProperties(long i) {
        StringBuilder numberProperties = new StringBuilder();

        if (AmazingNumbers.checkBuzz(i)) numberProperties.append("buzz, ");
        if (AmazingNumbers.checkDuck(i)) numberProperties.append("duck, ");
        if (AmazingNumbers.checkPalindrome(i)) numberProperties.append("palindromic, ");
        if (AmazingNumbers.checkGapful(i)) numberProperties.append("gapful, ");
        if (AmazingNumbers.checkSpy(i)) numberProperties.append("spy, ");
        if (AmazingNumbers.checkSquare(i)) numberProperties.append("square, ");
        if (AmazingNumbers.checkSquare(i+1)) numberProperties.append("sunny, ");
        if (AmazingNumbers.checkParity(i)) numberProperties.append("even, ");
        else numberProperties.append("odd, ");

        return numberProperties;
    }
}