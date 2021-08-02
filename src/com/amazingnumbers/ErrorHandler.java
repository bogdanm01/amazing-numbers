package com.amazingnumbers;

import java.util.Arrays;

/**
 ** Methods return true if there are any errors
 */

public final class ErrorHandler {

    static final String VALID_PROPERTIES = "even odd buzz duck spy palindromic gapful square sunny jumping";

    public static boolean checkNumbersErrors(long number1, long number2) { // return true if there are any errors
        boolean flag = false;
        if (number1 < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
            flag = true;
        }
        if(number2 < 1) {
            System.out.println("The second parameter should be a natural number");
            flag = true;
        }
        return flag;
    }

    public static boolean checkProperties(String[] searchProperties) {
        String[] invalidProperties = new String[searchProperties.length];
        int numberOfInvalidProperties = getNumberOfInvalidProperties(searchProperties, invalidProperties);

        if (numberOfInvalidProperties == 1) {
            System.out.println("The property [" + invalidProperties[0] + "] is wrong.");
            printAvailableProperties();
            return true;
        } else if (numberOfInvalidProperties > 1) {
            System.out.println("The properties " + Arrays.toString(invalidProperties) + " are wrong.");
            printAvailableProperties();
            return true;
        }

        if (searchProperties.length > 1) {
            return areMutuallyExclusive(searchProperties);
        }
        return false;
    }

    private static int getNumberOfInvalidProperties(String[] searchProperties, String[] invalidProperties) {
        int numberOfInvalidProperties = 0;
        for (String searchProperty : searchProperties) {
            if (!(isParameterValid(searchProperty))) {
                invalidProperties[numberOfInvalidProperties] = searchProperty.toUpperCase();
                numberOfInvalidProperties++;
            }
        }
        return numberOfInvalidProperties;
    }

    private static void printAvailableProperties() {
        System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, EVEN, ODD]");
    }

    private static boolean areMutuallyExclusive (String[] searchProperties) {
        boolean errorsExist = false;
        String arrayToString = Arrays.toString(searchProperties);

        if ((arrayToString.contains("EVEN") && arrayToString.contains("ODD")) || (arrayToString.contains("even") && arrayToString.contains("odd"))) {
            System.out.println("The request contains mutually exclusive properties: [EVEN, ODD]");
            System.out.println("There are no numbers with these properties.");
            errorsExist = true;
        }
        if ((arrayToString.contains("SQUARE") && arrayToString.contains("SUNNY")) || (arrayToString.contains("square") && arrayToString.contains("sunny"))) {
            System.out.println("The request contains mutually exclusive properties: [SQUARE, SUNNY]");
            System.out.println("There are no numbers with these properties.");
            errorsExist = true;
        }
        if ((arrayToString.contains("DUCK") && arrayToString.contains("SPY")) || (arrayToString.contains("duck") && arrayToString.contains("spy"))) {
            System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]");
            System.out.println("There are no numbers with these properties.");
            errorsExist = true;
        }
        return errorsExist;
    }

    private static boolean isParameterValid(String searchParameter) { // checks if searched property is valid, does it exist
        return VALID_PROPERTIES.contains(searchParameter) || VALID_PROPERTIES.toUpperCase().contains(searchParameter);
    }
}