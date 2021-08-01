package com.amazingnumbers;

/**
** Methods return true if there are any errors
 */

public final class ErrorHandler {

    static final String VALID_PROPERTIES = "even odd buzz duck spy palindromic gapful square sunny";

    public static boolean checkOnePropertyError(String firstSearchParameter) { // return true if there any errors
        if (!isParameterValid(firstSearchParameter)) {
            System.out.println("The property [" + firstSearchParameter.toUpperCase() + "] is wrong.");
            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
            return true;
        }
        return false;
    }

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

    public static boolean checkTwoPropertiesErrors(String firstSearchParameter, String secondSearchParameter) {
        if (!(isParameterValid(firstSearchParameter)) && (isParameterValid(secondSearchParameter))) {
            System.out.println("The property [" + firstSearchParameter.toUpperCase() + "] is wrong.");
            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
            return true;
        }
        if (isParameterValid(firstSearchParameter) && !(isParameterValid(secondSearchParameter))) {
            System.out.println("The property [" + secondSearchParameter.toUpperCase() + "] is wrong.");
            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
            return true;

        }
        if (!(isParameterValid(secondSearchParameter)) && !(isParameterValid(firstSearchParameter))) {
            System.out.println("The properties [" + firstSearchParameter.toUpperCase()+", "+ secondSearchParameter.toUpperCase() + "] are wrong.");
            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
            return true;
        }
        if (areMutuallyExclusive(firstSearchParameter, secondSearchParameter)) { // if parameters cancel each out
            System.out.println("The request contains mutually exclusive properties: [" + firstSearchParameter.toUpperCase() + ", " + secondSearchParameter.toUpperCase() + "]");
            System.out.println("There are no numbers with these properties.");
            return true;
        }
        return false;
    }

    private static boolean areMutuallyExclusive (String firstParameter, String SecondParameter) {
        if ((firstParameter.equalsIgnoreCase("EVEN") && SecondParameter.equalsIgnoreCase("ODD")) || (firstParameter.equalsIgnoreCase("ODD") && SecondParameter.equalsIgnoreCase("EVEN")))
            return true;
        if ((firstParameter.equalsIgnoreCase("DUCK") && SecondParameter.equalsIgnoreCase("SPY")) || (firstParameter.equalsIgnoreCase("SPY") && SecondParameter.equalsIgnoreCase("DUCK")))
            return true;
        return (firstParameter.equalsIgnoreCase("SUNNY") && SecondParameter.equalsIgnoreCase("SQUARE")) || (firstParameter.equalsIgnoreCase("SQUARE") && SecondParameter.equalsIgnoreCase("SUNNY"));
    }

    private static boolean isParameterValid(String searchParameter) { // checks if searched property is valid, does it exist
        return VALID_PROPERTIES.contains(searchParameter) || VALID_PROPERTIES.toUpperCase().contains(searchParameter);
    }
}
