package com.bogdan;

public final class ErrorHandler {
    public static boolean checkOnePropertyError(String validProperties, String firstSearchParameter) { // true if there any errors
        if (!isParameterValid(validProperties, firstSearchParameter)) {
            System.out.println("The property [" + firstSearchParameter.toUpperCase() + "] is wrong.");
            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
            return true;
        }
        return false;
    }

    public static boolean checkNumbersErrors(long number1, long number2) { // true if there are any errors
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

    public static boolean checkTwoPropertiesErrors(String validProperties, String firstSearchParameter, String secondSearchParameter) {
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
        if (areMutuallyExclusive(firstSearchParameter, secondSearchParameter)) { // if parameters cancel each out
            System.out.println("The request contains mutually exclusive properties: [" + firstSearchParameter.toUpperCase() + ", " + secondSearchParameter.toUpperCase() + "]");
            System.out.println("There are no numbers with these properties.");
            return true;
        }
        return false;
    }

    public static boolean areMutuallyExclusive (String firstParameter, String SecondParameter) {
        if ((firstParameter.equalsIgnoreCase("EVEN") && SecondParameter.equalsIgnoreCase("ODD")) || (firstParameter.equalsIgnoreCase("ODD") && SecondParameter.equalsIgnoreCase("EVEN")))
            return true;
        if ((firstParameter.equalsIgnoreCase("DUCK") && SecondParameter.equalsIgnoreCase("SPY")) || (firstParameter.equalsIgnoreCase("SPY") && SecondParameter.equalsIgnoreCase("DUCK")))
            return true;
        return (firstParameter.equalsIgnoreCase("SUNNY") && SecondParameter.equalsIgnoreCase("SQUARE")) || (firstParameter.equalsIgnoreCase("SQUARE") && SecondParameter.equalsIgnoreCase("SUNNY"));
    }

    public static boolean isParameterValid(String validProperties, String searchParameter) { // checks if searched property is valid, does it exist
        return validProperties.contains(searchParameter) || validProperties.toUpperCase().contains(searchParameter);
    }
}
