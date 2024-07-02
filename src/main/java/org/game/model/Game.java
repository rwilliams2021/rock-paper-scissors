package org.game.model;

import org.game.enums.HandSymbol;
import org.game.enums.Outcome;
import org.game.constants.Constants;

import java.util.Scanner;

public class Game {
    private final Scanner input;
    private final Computer computer;
    
    public Game() {
        input = new Scanner(System.in);
        computer = new Computer();
        welcome();
    }
    
    public void play() {
        do {
            System.out.println(Constants.CHOOSE_SYMBOL);
            HandSymbol userSymbol;
            do {
                String userChoice = input.nextLine().toLowerCase();
                userSymbol = HandSymbol.fromStringSymbol(userChoice);
                if (userSymbol == null) {
                    System.out.println(Constants.INVALID_SYMBOL);
                }
            }
            while (userSymbol == null);
            
            HandSymbol computerSymbol = computer.generateRandomSymbol();
            
            System.out.println("You chose: " + userSymbol + '\n' + "Computer chose: " + computerSymbol);
            
            Outcome outcome = Processor.getProcessor().getWinner(userSymbol, computerSymbol);
            
            System.out.println(outcome.getMessage());
            
            printScore();
        } while (continuePlaying());
        goodbye();
    }
    
    public void printScore() {
        System.out.println(Processor.getProcessor().getScoreUpdate());
    }
    
    public void welcome() {
        System.out.println("Enter your name: ");
        String name = input.nextLine();
        System.out.println("Hello " + name);
        System.out.println("Let's play Paper-Rock-Scissors!");
    }
    
    public void goodbye() {
        System.out.println("Thanks for playing!");
    }
    
    public boolean continuePlaying() {
        String playOn;
        do {
            System.out.println(Constants.PLAY_YES_OR_NO);
            playOn = input.nextLine();
        } while (!playOn.equals(Constants.YES) && !playOn.equals(Constants.NO));
        return playOn.equals(Constants.YES);
    }
}
