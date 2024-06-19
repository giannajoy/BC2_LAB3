/*
 * GEE
 * This is free and unencumbered software released into the public domain.
 */
package gee_lab3;

import java.util.Scanner;
/**
 * The program allows a user to guess a number between 1000 and 1500. The user
 * can play as many times as possible.
 *
 * @author gee
 * @version 1.0
 */
public class Lab3 {
    /**
     * This is the main method that runs the guessing game. Prints out a
     * welcome and goodbye message.
     *
     * @param args A string array containing the command line arguments
     */
    public static void main(String[] args) {
        //Welcome message for the guessing game
        System.out.println("Hello, Welcome to the Guessing game." );
        System.out.println("This is a guessing game where you will guess" +
                            " a number");
        System.out.println("and I tell you if it is too low or too high");

        // Create a Scanner object to take user input
        Scanner keyboard = new Scanner(System.in);

        //Create a new instance of the GuessGame class with a range of
        // 1000 and 1500
        GuessGame originalGame = new GuessGame(1000, 1500);

        // Outer do-while loop to allow the user to play the game multiple
        // times
        do {

            //Create a new instance of the GuessGame class using the copy
            // constructor
            GuessGame gameCopy = new GuessGame(originalGame);
            boolean correctGuess = false;

            // Inner do-while loop for handling the guessing process
            do {
                // Prompt the user to input a guess within the specified range
                System.out.println("Guess a number between " +
                                    gameCopy.getRangeMinimum() + " and " +
                                    gameCopy.getRangeMaximum() + ": ");
                int userGuess = keyboard.nextInt();

                // Process the user's guess and update the correctGuess variable
                correctGuess = gameCopy.guess(userGuess);

            } while (!correctGuess); // Continue the loop until the user's
                                    // guess is correct

            // Display game statistics after the inner loop exits
            gameCopy.displayStatistics();

            // Prompt the user if they want to play again
            System.out.println("Ready to play again? (no to quit): ");

            System.out.println("Game details: " + gameCopy.toString());

            if (gameCopy.equals(originalGame)) {
                System.out.println("The copied game is equal to the original game.");
            } else {
                System.out.println("The copied game is not equal to the original game.");
            }

        }while (keyboard.next().equalsIgnoreCase("yes"));
        // Continue the outer loop if the user wants to play again


        // Display a thank you and goodbye message when the user decides to quit
        System.out.println("Thanks for playing.");
        System.out.println("Goodbye and Let's play again soon!");

        //Close the scanner class
        keyboard.close();

    }
}
