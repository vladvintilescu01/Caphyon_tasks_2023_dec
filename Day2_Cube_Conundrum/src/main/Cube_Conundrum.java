package main;

import java.util.Scanner;

public class Cube_Conundrum
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce the characters for each line (for finish type on keyboard 'exit'): ");

        // initialize sum of cubes for each color in a set of game
        int total_red = 0;
        int total_blue = 0;
        int total_green = 0;
        
        //store concatenated numbers in a type of int
        int concatenatedNumber1 = 0;
        int concatenatedNumber2 = 0;
    
        // represents number of each game
        int count_number_of_game = 0;
        
        //sum of IDs
        int sum_of_games = 0;
        //check if all subsets are less than number of cubes specified by the problem
        int OK;
        // help us to concatenate 2 digits and to store the numbers before to be a type of int
        String concatenatedDigits;
        
        String line;
        do
        {
            count_number_of_game++;
            //count each game (IDs game)
            line = scanner.nextLine(); // determine next game
            if (!line.equalsIgnoreCase("exit"))
            {

                total_red = 0;
                total_blue = 0;
                total_green = 0;
                OK = 1;
                // whenever we in a new game we need to reset all sums of cubes
                try
                {
                    for (int i = 0; i < line.length(); i++)
                    {   
                        int verify_two_digits = 0; // verify if we have a number with 2 digits and we suppose we don't have 
                        char currentChar = line.charAt(i); // put each character in this variable
                        //if that current character is a digit means it's possible to be a representation of cubes
                        if (Character.isDigit(currentChar))
                        {
                        	//if we found numbers of red cubes
                            if((line.charAt(i + 2) == 'r' || line.charAt(i + 3) == 'r') && (line.charAt(i + 4) == 'd' || line.charAt(i + 5) == 'd'))
                            {// here we need also to verify if we are in case of red cubes, because when we have for example 
                             // 3 green we have an conflict with case of green cubes. That conflict exists because inside of 
                             // "green" we have "r" and we need to check if last letter is "d" and avoid this conflict 

                            	//if next character is also o digit means we have an number with 2 digits and we need to concatenate that numbers 
                                if(Character.isDigit(line.charAt(i + 1)))
                                {
                                    verify_two_digits = 1;
                                    concatenatedDigits = Character.toString(line.charAt(i)) + Character.toString(line.charAt(i + 1));
                                    concatenatedNumber1 = Integer.parseInt(concatenatedDigits);
                                    // add each number for each color
                                    total_red += concatenatedNumber1;
                                }
                                //if previous character is not a digit (bc we can have an conflict with IDs when first set it is write) and
                                //we have only one digit then we will put in a type of int
                                if(verify_two_digits == 0 && !Character.isDigit(line.charAt(i - 1)))
                                {
                                    concatenatedDigits = Character.toString(currentChar);
                                    concatenatedNumber2 = Integer.parseInt(concatenatedDigits);
                                    // add each number for each color
                                    total_red += concatenatedNumber2;
                                }

                            }
                            else
                            {   //if we found numbers of blue cubes
                                if(line.charAt(i + 2) == 'b' || line.charAt(i + 3) == 'b')
                                {


                                    if(Character.isDigit(line.charAt(i + 1)))
                                    {
                                        verify_two_digits = 1;
                                        concatenatedDigits = Character.toString(line.charAt(i)) + Character.toString(line.charAt(i + 1));
                                        concatenatedNumber1 = Integer.parseInt(concatenatedDigits);
                                        // add each number for each color
                                        total_blue += concatenatedNumber1;
                                    }
                                    if(verify_two_digits == 0 && !Character.isDigit(line.charAt(i - 1)))
                                    {
                                        concatenatedDigits = Character.toString(currentChar);
                                        concatenatedNumber2 = Integer.parseInt(concatenatedDigits);
                                        // add each number for each color
                                        total_blue += concatenatedNumber2;
                                    }

                                }
                                else
                                {   //if we found numbers of green cubes
                                    if(line.charAt(i + 2) == 'g' || line.charAt(i + 3) == 'g')
                                    {


                                        if(Character.isDigit(line.charAt(i + 1)))
                                        {
                                            verify_two_digits = 1;
                                            concatenatedDigits = Character.toString(line.charAt(i)) + Character.toString(line.charAt(i + 1));
                                            concatenatedNumber1 = Integer.parseInt(concatenatedDigits);
                                            // add each number for each color
                                            total_green += concatenatedNumber1;
                                        }
                                        if(verify_two_digits == 0 && !Character.isDigit(line.charAt(i - 1)))
                                        {
                                            concatenatedDigits = Character.toString(currentChar);
                                            concatenatedNumber2 = Integer.parseInt(concatenatedDigits);
                                            // add each number for each color
                                            total_green += concatenatedNumber2;
                                        }

                                    }
                                }
                            }

                        }
                        // if all subsets until ";" are more than sum of cubes for each color means is an invalid game and 
                        // program will go to next game
                        if(currentChar == ';' && (total_red > 12 || total_blue > 14 || total_green > 13))
                        {

                            OK = 0;
                            break;

                        }
                        // need to reset always after an set has finished
                        if(currentChar == ';')
                        {

                            total_red = 0;
                            total_blue = 0;
                            total_green = 0;
                        }

                    }
                }
                catch(StringIndexOutOfBoundsException e) {}
               
                // if all subsets until ";" and last set also respects the problem statements and last set also means
                // that game is a valid game and we need to add his id and to store in sum_of_games
                if(OK == 1 && total_red <= 12 && total_blue <= 14 && total_green <= 13)
                {
                    sum_of_games += count_number_of_game;
                }
            }
    
        }
        while (!line.equalsIgnoreCase("exit"));

        System.out.println("The sum of the valid IDs: "  + sum_of_games);

        scanner.close();
    }
}

