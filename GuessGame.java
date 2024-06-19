/*
 * GEE
 * This is free and unencumbered software released into the public domain.
 */
package gee_lab3;



import java.util.Random;
/**
 * The program allows a user to guess a number between 1000 and 1500. The user
 * can play as many times as possible.
 *
 * @author gee
 * @version 1.0
 */
public class GuessGame {

    //Instance variables for the guess game
    private int targetNumber;       // The randomly selected target number
    private int rangeMin;           // The minimum value of the guessing range
    private int rangeMax;           // The maximum value of the guessing range
    private int numberOfGuesses;    // The number of guesses made by the player

    /**
     * Constructor initializes the game with a specified range
     * @param rangeMin The minimum value of the guessing game
     * @param rangeMax The maximum value of the guessing game
     */
    public GuessGame(int rangeMin, int rangeMax) {
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMax;
        newTarget();
    }

    /**
     * This is a copy constructor to create a new instance by copying the state
     * of an existing one
     * @param otherGame Is a new object that initializes the new Guess game
     */
    public GuessGame(GuessGame otherGame) {
        this.targetNumber = otherGame.targetNumber;
        this.rangeMin = otherGame.rangeMin;
        this.rangeMax = otherGame.rangeMax;
        this.numberOfGuesses = otherGame.numberOfGuesses;
    }

    /**
     * This method displays the game statistics. That is the number of guesses
     *
     */
    public void displayStatistics(){
        System.out.println("You guessed" + numberOfGuesses + "times.");
    }

    /**
     * Generates a new target which is within the specified range
     */
    public void newTarget(){

        //Generate a random number within the specified range
        Random random = new Random();
        targetNumber = random.nextInt(rangeMax - rangeMin + 1)
                                      + rangeMin;
        numberOfGuesses = 0;    //Reset the number of guesses for the new
                                // target
    }

    /**
     *  This method is responsible for processing the user's guess and updating
     *  the number of guesses while providing user with feedback
     *
     * @param num Represents the users guess
     * @return True if the guess is correct and False if it is not
     */
    public boolean guess(int num){

        numberOfGuesses++;      //Increment the number of guesses
        if (num == targetNumber){
            System.out.println("That's correct");
            return true;
        }else {
            //Display whether the guess is too high or too low
            displayHint(num);
            return false;
        }
    }

    /**
     *  Get the minimum value range
     *
     * @return The minimum value range
     */
    public int getRangeMinimum(){
        return rangeMin;
    }

    /**
     * Get the maximum value of the range
     *
     * @return The maximum range
     */
    public int getRangeMaximum(){
        return rangeMax;
    }

    /**
     * Display a hint based on whether the guess is too high or too low
     *
     * @param num Represents the user's guess
     */
    private void displayHint(int num) {
        if (num < targetNumber) {
            System.out.println(num + "is too low.");
        }else {
            System.out.println(num + "is too high.");
        }
    }

    /**
     * Equals method compares two GuessGame instances based on their state
     * @param otherGame Initializes the new guess game instance
     * @return The comparison for the instance variables
     */
    private boolean equals(GuessGame otherGame) {
        //check if all the instance variables are equal
        return this.targetNumber == otherGame.targetNumber &&
                this.rangeMax == otherGame.rangeMax &&
                this.rangeMin == otherGame.rangeMin &&
                this.numberOfGuesses == otherGame.numberOfGuesses;
    }

    /**
     * The ToString method provides a string representation of the GuessGame
     * instance
     *
     * @return The string representation for all instance variables
     */
    public String toString() {
        return "GuessGame{ " + targetNumber + ", rangeMin=" + rangeMin +
                ", rangeMax=" + rangeMax + ", numberofGuesses= "
                +numberOfGuesses + '}';
    }

}
