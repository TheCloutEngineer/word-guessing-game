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
        Scanner scanner = new Scanner(System.in);

        while (attempts > 0) {
            System.out.printf("You have %d attempts left.%n", attempts);
            System.out.print("Guess a letter: ");
            attempts--;
        }
    }
}
