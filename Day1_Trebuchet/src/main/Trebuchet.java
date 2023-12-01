package main;

import java.util.Scanner;

public class Trebuchet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce the characters for each line (for finish type on keyboard 'exit'): ");

        int totalConcatenatedSum = 0; // Variable to determine the sum of concatenated numbers

        String line;
        do {
            line = scanner.nextLine(); // determine next line
            if (!line.equalsIgnoreCase("exit")) {
                char firstDigit = ' ';  // declare first digit and last digit 
                char lastDigit = ' ';

                // go through line to verify if characters are digits
                for (int i = 0; i < line.length(); i++) {
                    char currentChar = line.charAt(i); // put each character in this variable
                    if (Character.isDigit(currentChar)) {
                    	// if that character is a digit then save first digit 
                        if (firstDigit == ' ') {
                        	// that if is only for get first number and works one time 
                            firstDigit = currentChar;
                        }
                        //anytime when we found a new digit we put in this variable until we get the last digit
                        lastDigit = currentChar;
                    }
                }
                //if we found first and last digits then we need to concatenate them and to add with all numbers that we found
                if (firstDigit != ' ' && lastDigit != ' ') {
                    String concatenatedDigits = Character.toString(firstDigit) + Character.toString(lastDigit);
                    int concatenatedNumber = Integer.parseInt(concatenatedDigits);
                    totalConcatenatedSum += concatenatedNumber;
                    System.out.println("Combining the first digit and the last digit is: " + concatenatedDigits);
                } else {
                    System.out.println("For the line: " + line + " we don't have any digits.");
                }
            }
        } while (!line.equalsIgnoreCase("exit"));

        System.out.println("Total sum of concatenated numbers: " + totalConcatenatedSum);

        scanner.close();
    }
}

