package main;

import java.util.Scanner;

public class Gear_Ratios
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int totalSum = 0;
        int digitValue = 0;
        int digitValue1 = 0;
        int digitValue2 = 0;
        int numberValue = 0;

        boolean check = false;
        boolean check1 = false;
        boolean check2 = false;

        System.out.println("Introduce the matrix:");

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        scanner.nextLine();

        // Initialize the matrix without space
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++)
        {
            String line = scanner.nextLine().replaceAll("\\s+", ""); // Eliminate all spaces
            for (int j = 0; j < cols; j++)
            {
                matrix[i][j] = line.charAt(j);
            }
        }


        //We go through to the matrix to find all symbols that have numbers adjancent
        for (int i = 1; i < rows - 1; i++)
        {
            for (int j = 1; j < cols - 1; j++)
            {
                //reset all checks always when we go to a new element
                //thats checks help to identify when we have a number with 1, 2 or 3 digits
                check = false;
                check1 = false;
                check2 = false;
                //if we found any element different than "." and digits means is a symbol
                if (matrix[i][j] != '.' && !Character.isDigit(matrix[i][j]))
                {
                    //if we found a digit in right of same line means we found a neighbor
                    if (j + 1 < cols && Character.isDigit(matrix[i][j + 1]))
                    {
                        //store that neighbor
                        digitValue = Character.getNumericValue(matrix[i][j + 1]);

                        //we can found a neighbor with 3 digits or with 2 digits
                        if (j + 3 < cols && Character.isDigit(matrix[i][j + 2]) && Character.isDigit(matrix[i][j + 3]))
                        {
                            digitValue1 = Character.getNumericValue(matrix[i][j + 2]);
                            digitValue2 = Character.getNumericValue(matrix[i][j + 3]);
                            //calculate that number
                            numberValue = digitValue * 100 + digitValue1 * 10 + digitValue2;
                            //add to total sum
                            totalSum += numberValue;
                            //set to true at check because we found a neighbor with more digits
                            check = true;
                        }
                        else if (j + 2 < cols && Character.isDigit(matrix[i][j + 2]))
                        {
                            digitValue1 = Character.getNumericValue(matrix[i][j + 2]);
                            numberValue = digitValue * 10 + digitValue1;
                            totalSum += numberValue;
                            check = true;
                        }
                        //if we don't find a number with more digits means that number has only 1 digit and we need
                        //to add at total sum
                        if(false == check)
                        {
                            totalSum += digitValue;
                        }

                    }
                    //reset check for more than 1 digit
                    check = false;
                    //works like previous but for neighbor from left at same lime
                    if (j - 1 >= 0 && Character.isDigit(matrix[i][j - 1]))
                    {
                        digitValue = Character.getNumericValue(matrix[i][j - 1]);

                        if (j - 3 >= 0 && Character.isDigit(matrix[i][j - 2]) && Character.isDigit(matrix[i][j - 3]))
                        {
                            digitValue1 = Character.getNumericValue(matrix[i][j - 2]);
                            digitValue2 = Character.getNumericValue(matrix[i][j - 3]);
                            numberValue = digitValue2 * 100 + digitValue1 * 10 + digitValue;
                            totalSum += numberValue;
                            check = true;
                        }
                        else if (j - 2 >= 0 && Character.isDigit(matrix[i][j - 2]))
                        {
                            digitValue1 = Character.getNumericValue(matrix[i][j - 2]);
                            numberValue = digitValue1 * 10 + digitValue;
                            totalSum += numberValue;
                            check = true;
                        }
                        if(false == check)
                        {
                            totalSum += digitValue;
                        }
                    }
                    //reset check for more than 1 digit
                    check = false;
                    //we can find a neighbor from next line at middle
                    if (Character.isDigit(matrix[i + 1][j]))
                    {
                        digitValue = Character.getNumericValue(matrix[i + 1][j]);
                        // we can find with 3 digits with first digit in left of middle and last digit in right of middle
                        if (j - 1 >= 0 && j + 1 < cols && Character.isDigit(matrix[i + 1][j - 1]) && Character.isDigit(matrix[i + 1][j + 1]))
                        {
                            digitValue1 = Character.getNumericValue(matrix[i + 1][j - 1]);
                            digitValue2 = Character.getNumericValue(matrix[i + 1][j + 1]);
                            numberValue = digitValue1 * 100 + digitValue * 10 + digitValue2;
                            totalSum += numberValue;
                            check = true;
                        }  // we can find with 3 digits with second digit and last digit in right of middle
                        else
                        {
                            if (j + 1 < cols && Character.isDigit(matrix[i + 1][j + 1]) && Character.isDigit(matrix[i + 1][j + 2]))
                            {
                                digitValue1 = Character.getNumericValue(matrix[i + 1][j + 1]);
                                digitValue2 = Character.getNumericValue(matrix[i + 1][j + 2]);
                                numberValue = digitValue * 100 + digitValue1 * 10 + digitValue2;
                                totalSum += numberValue;
                                check = true;

                            } // we can find with 2 digits and last digit in right of middle
                            else
                            {
                                if (j + 1 < cols && Character.isDigit(matrix[i + 1][j + 1]))
                                {
                                    digitValue1 = Character.getNumericValue(matrix[i + 1][j + 1]);
                                    numberValue = digitValue * 10 + digitValue1;
                                    totalSum += numberValue;
                                    check = true;
                                }
                            }
                        }
                        // if we not found one of presented previous maybe we can have a number with 3 digits
                        // with first digit and second digit in left of middle
                        if(false == check)
                        {
                            if (j - 1 >= 0 && Character.isDigit(matrix[i + 1][j - 1]) && Character.isDigit(matrix[i + 1][j - 2]))
                            {
                                digitValue1 = Character.getNumericValue(matrix[i + 1][j - 1]);
                                digitValue2 = Character.getNumericValue(matrix[i + 1][j - 2]);
                                numberValue = digitValue2 * 100 + digitValue1 * 10 + digitValue;
                                totalSum += numberValue;
                                check = true;;
                            }
                        }
                        //or a number with 2 digits where first digit are in left of middle
                        if(false == check)
                        {
                            if (j - 1 >= 0 && Character.isDigit(matrix[i + 1][j - 1]))
                            {
                                digitValue1 = Character.getNumericValue(matrix[i + 1][j - 1]);
                                numberValue = digitValue1 * 10 + digitValue;
                                totalSum += numberValue;
                                check = true;
                            }
                        }
                        //if we don't find a number with more digits means that number has only 1 digit and we need
                        //to add at total sum
                        if(false == check)
                        {
                            totalSum += digitValue;
                        }
                        //check that help to identify if we have a neighbor from next line at middle
                        check1 = true;
                    }
                    //reset check for more than 1 digit
                    check = false;
                    //if we don't have a neighbor from next line at middle means we can have one in diagonally
                    if(false == check1)
                    {
                        // we can found in right down a neighbor
                        //logic works like previous but for neighbor from right down
                        if (Character.isDigit(matrix[i + 1][j + 1]))
                        {
                            digitValue = Character.getNumericValue(matrix[i + 1][j + 1]);

                            if (j + 3 < cols && Character.isDigit(matrix[i + 1][j + 2]) && Character.isDigit(matrix[i + 1][j + 3]))
                            {
                                digitValue1 = Character.getNumericValue(matrix[i + 1][j + 2]);
                                digitValue2 = Character.getNumericValue(matrix[i + 1][j + 3]);
                                numberValue = digitValue * 100 + digitValue1 * 10 + digitValue2;
                                totalSum += numberValue;
                                check = true;
                            }
                            else if (j + 2 < cols && Character.isDigit(matrix[i + 1][j + 2]))
                            {
                                digitValue1 = Character.getNumericValue(matrix[i + 1][j + 2]);
                                numberValue = digitValue * 10 + digitValue1;
                                totalSum += numberValue;
                                check = true;
                            }
                            if(false == check)
                            {
                                totalSum += digitValue;
                            }
                        }
                    }
                    //reset check for more than 1 digit
                    check = false;
                    //if we don't have a neighbor from next line at middle means we can have one in diagonally
                    if(false == check1)
                    {
                        // we can found in left down a neighbor
                        //logic works like previous but for neighbor from left down
                        if (Character.isDigit(matrix[i + 1][j - 1]))
                        {
                            digitValue = Character.getNumericValue(matrix[i + 1][j - 1]);

                            if (j - 3 >= 0 && Character.isDigit(matrix[i + 1][j - 2]) && Character.isDigit(matrix[i + 1][j - 3]))
                            {
                                digitValue1 = Character.getNumericValue(matrix[i + 1][j - 2]);
                                digitValue2 = Character.getNumericValue(matrix[i + 1][j - 3]);
                                numberValue = digitValue2 * 100 + digitValue1 * 10 + digitValue;
                                totalSum += numberValue;
                                check = true;
                            }
                            else if (j - 2 >= 0 && Character.isDigit(matrix[i + 1][j - 2]))
                            {
                                digitValue1 = Character.getNumericValue(matrix[i + 1][j - 2]);
                                numberValue = digitValue1 * 10 + digitValue;
                                totalSum += numberValue;
                                check = true;
                            }
                            if(false == check)
                            {
                                totalSum += digitValue;
                            }
                        }
                    }
                    //reset check for more than 1 digit
                    check = false;
                    //we can find a neighbor from previous line at middle
                    // this method works like method from next line but for previous line
                    if (Character.isDigit(matrix[i - 1][j]))
                    {
                        digitValue = Character.getNumericValue(matrix[i - 1][j]);
                        // we can find with 3 digits with first digit in left of middle and last digit in right of middle
                        if (j - 1 >= 0 && j + 1 < cols && Character.isDigit(matrix[i - 1][j - 1]) && Character.isDigit(matrix[i - 1][j + 1]))
                        {
                            digitValue1 = Character.getNumericValue(matrix[i - 1][j - 1]);
                            digitValue2 = Character.getNumericValue(matrix[i - 1][j + 1]);
                            numberValue = digitValue1 * 100 + digitValue * 10 + digitValue2;
                            totalSum += numberValue;
                            check = true;
                        }
                        // we can find with 3 digits with second digit and last digit in right of middle
                        else
                        {
                            if (j + 1 < cols && Character.isDigit(matrix[i - 1][j + 1]) && Character.isDigit(matrix[i - 1][j + 2]))
                            {
                                digitValue1 = Character.getNumericValue(matrix[i - 1][j + 1]);
                                digitValue2 = Character.getNumericValue(matrix[i - 1][j + 2]);
                                numberValue = digitValue * 100 + digitValue1 * 10 + digitValue2;
                                totalSum += numberValue;
                                check = true;

                            }
                            // we can find with 2 digits and last digit in right of middle
                            else
                            {
                                if (j + 1 < cols && Character.isDigit(matrix[i - 1][j + 1]))
                                {
                                    digitValue1 = Character.getNumericValue(matrix[i - 1][j + 1]);
                                    numberValue = digitValue * 10 + digitValue1;
                                    totalSum += numberValue;
                                    check = true;
                                }
                            }
                        }
                        // if we not found one of presented previous maybe we can have a number with 3 digits
                        // with first digit and second digit in left of middle
                        if(false == check)
                        {
                            if (j - 1 >= 0 && Character.isDigit(matrix[i - 1][j - 1]) && Character.isDigit(matrix[i - 1][j - 2]))
                            {
                                digitValue1 = Character.getNumericValue(matrix[i - 1][j - 1]);
                                digitValue2 = Character.getNumericValue(matrix[i - 1][j - 2]);
                                numberValue = digitValue2 * 100 + digitValue1 * 10 + digitValue;
                                totalSum += numberValue;
                                check = true;;
                            }
                        }
                        //or a number with 2 digits where first digit are in left of middle
                        if(false == check)
                        {
                            if (j - 1 >= 0 && Character.isDigit(matrix[i - 1][j - 1]))
                            {
                                digitValue1 = Character.getNumericValue(matrix[i - 1][j - 1]);
                                numberValue = digitValue1 * 10 + digitValue;
                                totalSum += numberValue;
                                check = true;
                            }
                        }
                        //if we don't find a number with more digits means that number has only 1 digit and we need
                        //to add at total sum
                        if(false == check)
                        {
                            totalSum += digitValue;
                        }
                        //check that help to identify if we have a neighbor from previous line at middle
                        check2 = true;
                    }
                    //reset check for more than 1 digit
                    check = false;
                    //if we don't have a neighbor from previous line at middle means we can have one in diagonally
                    if(false == check2)
                    {
                        // we can found in right up a neighbor
                        //logic works like previous but for neighbor from right up
                        if (Character.isDigit(matrix[i - 1][j + 1]))
                        {
                            digitValue = Character.getNumericValue(matrix[i - 1][j + 1]);

                            if (j + 3 < cols && Character.isDigit(matrix[i - 1][j + 2]) && Character.isDigit(matrix[i - 1][j + 3]))
                            {
                                digitValue1 = Character.getNumericValue(matrix[i - 1][j + 2]);
                                digitValue2 = Character.getNumericValue(matrix[i - 1][j + 3]);
                                numberValue = digitValue * 100 + digitValue1 * 10 + digitValue2;
                                totalSum += numberValue;
                                check = true;
                            }
                            else if (j + 2 < cols && Character.isDigit(matrix[i - 1][j + 2]))
                            {
                                digitValue1 = Character.getNumericValue(matrix[i - 1][j + 2]);
                                numberValue = digitValue * 10 + digitValue1;
                                totalSum += numberValue;
                                check = true;
                            }
                            if(false == check)
                            {
                                totalSum += digitValue;
                            }
                        }
                    }
                    //reset check for more than 1 digit
                    check = false;
                    //if we don't have a neighbor from next line at middle means we can have one in diagonally
                    if(false == check2)
                    {
                        // we can found in left up a neighbor
                        //logic works like previous but for neighbor from left up
                        if (Character.isDigit(matrix[i - 1][j - 1]))
                        {
                            digitValue = Character.getNumericValue(matrix[i - 1][j - 1]);


                            if (j - 3 >= 0 && Character.isDigit(matrix[i - 1][j - 2]) && Character.isDigit(matrix[i - 1][j - 3]))
                            {
                                digitValue1 = Character.getNumericValue(matrix[i - 1][j - 2]);
                                digitValue2 = Character.getNumericValue(matrix[i - 1][j - 3]);
                                numberValue = digitValue2 * 100 + digitValue1 * 10 + digitValue;
                                totalSum += numberValue;
                                check = true;
                            }
                            else if (j - 2 >= 0 && Character.isDigit(matrix[i - 1][j - 2]))
                            {
                                digitValue1 = Character.getNumericValue(matrix[i - 1][j - 2]);
                                numberValue = digitValue1 * 10 + digitValue;
                                totalSum += numberValue;
                                check = true;
                            }
                            if(false == check)
                            {
                                totalSum += digitValue;
                            }
                        }
                    }


                }


            }
        }


        //print the total sum
        System.out.println("The sum of all of the part numbers in the engine schematic: " + totalSum);

        scanner.close();
    }

}
