package org.game.model;

import org.game.enums.Symbol;
import org.game.enums.Outcome;
import org.game.constants.Constants;
import org.game.utils.InputProvider;
import org.game.utils.ScannerInputProvider;

import java.util.Scanner;

public class Game {
    private final InputProvider inputProvider;
    private final Player computer;
    private final Player user;
    private final Processor processor;
    private final ScoreManager scoreManager;
    
    public Game() {
        this.inputProvider = new ScannerInputProvider(new Scanner(System.in));
        this.computer = new Computer();
        this.user = new User(inputProvider);
        this.processor = Processor.getProcessor();
        this.scoreManager = new ScoreManager();
    }
    
    public void play() {
        welcome(user.getName());
        do {
            Symbol userSymbol = user.chooseSymbol();
            while (userSymbol == null) {
                System.out.println(Constants.INVALID_SYMBOL_MSG);
                userSymbol = user.chooseSymbol();
            }
            Symbol computerSymbol = computer.chooseSymbol();
            
            System.out.println(Constants.USER_CHOICE + userSymbol + '\n' + Constants.COMPUTER_CHOICE + computerSymbol);
            
            Outcome outcome = processor.determineWinner(userSymbol, computerSymbol);
            scoreManager.updateScore(outcome, computer, user);
            
            System.out.println(outcome.getMessage());
            
            printScore();
        } while (continuePlaying());
        goodbye();
    }
    
    public void printScore() {
        System.out.println(Constants.USER_WINS + user.getWins() + "\n" + Constants.COMPUTER_WINS + computer.getWins());
    }
    
    public void welcome(String name) {
        System.out.println("Hello " + name);
        System.out.println("Let's play Paper-Rock-Scissors!");
    }
    
    public void goodbye() {
        System.out.println(Constants.GOODBYE_MSG);
        inputProvider.close();
    }
    
    public boolean continuePlaying() {
        String playOn;
        do {
            playOn = inputProvider.getInput(Constants.CONTINUE_PLAYING_MSG);
        } while (!playOn.equals(Constants.YES) && !playOn.equals(Constants.NO));
        return playOn.equals(Constants.YES);
    }
}
