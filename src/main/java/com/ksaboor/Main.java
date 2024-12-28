package com.ksaboor;

import com.ksaboor.wordgame.WordGuessingGame;

import java.util.Scanner;

public class Main {

    private  static final String[] COMMON_WORDS = {"java", "while", "class", "computer", "method", "loop", "array", "string", "object", "inheritance", "polymorphism", "encapsulation", "abstraction"};
    public static void main(String[] args) {

        String[] easyWords = getWordListForDifficulty("E");
        String[] MediumWords = getWordListForDifficulty("M");
        String[] HardWords = getWordListForDifficulty("H");

        boolean gameOver = false;
        int wins = 0, lost = 0;

        while (!gameOver) {
            System.out.println("Hello welcoming to the word guessing game!" +
                    "What level of word would you like to play with?" +
                    "(E) --> Easy, (M) --> Medium, (H) --> Hard");
            Scanner scanner = new Scanner(System.in);
            String level = scanner.nextLine().toUpperCase();

            WordGuessingGame game;
            switch (level) {
                case "E":
                    game = new WordGuessingGame(easyWords, 10);
                    break;
                case "M":
                    game = new WordGuessingGame(MediumWords, 7);
                    break;
                case "H":
                    game = new WordGuessingGame(HardWords, 5);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose (E), (M), or (H).");
                    continue;
            }
            game.play();
            if (game.userHasWon) {
                wins++;
            } else {
                lost++;
            }
            System.out.println("Would you like to play again? (Y) --> Yes, (N) --> No");
            System.out.println("Wins: " + wins + ", Lost: " + lost);
            String playAgain = scanner.nextLine().toUpperCase();
            if (playAgain.equals("N")) {
                System.out.println("Thanks for playing!");
                System.out.printf("Wins: %d, Lost: %d%n", wins, lost);
                gameOver = true;
            }
        }
    }

    private static String[] getWordListForDifficulty(String difficultyLevel) {
        // Currently, the word list is the same for all levels. Use `COMMON_WORDS` for simplicity.
        return COMMON_WORDS;
    }
}
