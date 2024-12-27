package com.ksaboor.wordgame;

import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {

    private String wordToGuess;
    private char[] guessedLetters;
    private int attempts;

    public WordGuessingGame(String[] wordList, int maxAttempts) {
        Random random = new Random();
        this.wordToGuess = wordList[random.nextInt(wordList.length)];
        this.guessedLetters = new char[wordToGuess.length()];
        this.attempts = 0;
        for (int i = 0; i < this.guessedLetters.length; i++) {
            this.guessedLetters[i] = '_';
        }
        this.attempts = maxAttempts;
    }

    public void play() {
        System.out.println("This word is: " + wordToGuess);
        Scanner scanner = new Scanner(System.in);

        while (attempts > 0) {
            System.out.printf("You have %d attempts left.%n", attempts);
            System.out.print("Guess a letter: ");

            char guess = scanner.nextLine().toLowerCase().charAt(0);

            if (processGuess(guess)) {
                System.out.printf("Correct!");
            } else {
                System.out.printf("That guess was incorrect!");
                attempts--;
            }
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
}
