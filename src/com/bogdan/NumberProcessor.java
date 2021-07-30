package com.bogdan;

public final class NumberProcessor {

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
        if (ErrorHandler.checkNumbersErrors(startingNumber, consecutiveNumber)) return; // return if there are any errors
        for (long i = startingNumber; i < startingNumber + consecutiveNumber; i++) {
            StringBuilder numberProperties = checkNumberProperties(i);
            System.out.println("\t\t\t" + i + " is " + numberProperties.substring(0, numberProperties.length()-2));
        }
    }

    public static void processQuery(long startingNumber, long numbersCount, String[] searchQuery) { // for parameters and a property
        String validProperties = "even odd buzz duck spy palindromic gapful square sunny";
        String firstSearchParameter = searchQuery[2];
        String secondSearchParameter = searchQuery.length > 3 ? searchQuery[3] : null;

        if (ErrorHandler.checkNumbersErrors(startingNumber, numbersCount)) return; // return if there are any errors

        if (secondSearchParameter == null) { // for one search property
            if (ErrorHandler.checkOnePropertyError(validProperties, firstSearchParameter)) return; // return if there are any errors
            processOneProperty(startingNumber, numbersCount, firstSearchParameter); // process if there aren't any errors
        } else { // if there are two properties
            if (ErrorHandler.checkTwoPropertiesErrors(validProperties, firstSearchParameter, secondSearchParameter)) return; // return if there are any errors
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

    private static boolean checkParameter(String searchParameter, StringBuilder numberProperties) { // checks if searched property is available in numberProperties
        return numberProperties.toString().contains(searchParameter) || numberProperties.toString().toUpperCase().contains(searchParameter);
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
