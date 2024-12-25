package com.ksaboor;

import com.ksaboor.wordgame.WordGuessingGame;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String[] easyWords = {"java", "programming", "class", "computer", "method", "loop"};
        String[] MediumWords = {"java", "programming", "class", "computer", "method", "loop"};
        String[] HardWords = {"java", "programming", "class", "computer", "method", "loop"};

        WordGuessingGame game = new WordGuessingGame(easyWords, 10);
        game.play();
        }
    }
