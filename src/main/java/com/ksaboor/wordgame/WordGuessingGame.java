package com.ksaboor.wordgame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {

    private final String wordToGuess;
    private final char[] guessedLetters;
    private int attempts;
    public boolean userHasWon = false;


    public WordGuessingGame(String[] wordList, int maxAttempts) {
        Random random = new Random();
        this.wordToGuess = wordList[random.nextInt(wordList.length)];
        this.guessedLetters = new char[wordToGuess.length()];
        Arrays.fill(this.guessedLetters, '_');
        this.attempts = maxAttempts;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (attempts > 0 && !userHasWon) {
            displayState();
            System.out.printf("You have %d attempts left.%n", attempts);
            System.out.print("Guess a letter: ");

            char guess = scanner.nextLine().toLowerCase().charAt(0);

            if (processGuess(guess)) {
                System.out.println("Correct!");
                if (new String(guessedLetters).equals(wordToGuess)) {
                    System.out.println("You have guess the word! You Win");
                    System.out.println("The word was: " + wordToGuess);
                    userHasWon = true;
                }
            } else {
                System.out.println("That guess was incorrect!");
                attempts--;
            }
        }
        if (!userHasWon) {
            System.out.println("You are out of guesses. You lose!");
            System.out.println("The word was: " + wordToGuess);
        }
    }

    private boolean processGuess(char letter) {
        boolean letterFound = false;

        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter) {
                guessedLetters[i] = letter;
                letterFound = true;
            }
        }
        return letterFound;
    }

    private void displayState() {
        System.out.println("Guessed letter: " + new String(guessedLetters));
    }
}
