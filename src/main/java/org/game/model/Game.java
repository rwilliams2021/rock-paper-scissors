package org.game.model;

import org.game.enums.Symbol;
import org.game.enums.Outcome;
import org.game.constants.Constants;
import org.game.utils.InputUtil;

public class Game {
    private final Player computer;
    private final Player user;
    
    public Game() {
        computer = new Computer();
        user = new User();
    }
    
    public void play() {
        welcome(user.getName());
        do {

            Symbol userSymbol = user.chooseSymbol();
            Symbol computerSymbol = computer.chooseSymbol();
            
            System.out.println("You chose: " + userSymbol + '\n' + "Computer chose: " + computerSymbol);
            
            Outcome outcome = Processor.getProcessor().getWinner(userSymbol, computerSymbol);
            
            System.out.println(outcome.getMessage());
            
            printScore();
        } while (continuePlaying());
        goodbye();
        InputUtil.closeScanner();
    }
    
    public void printScore() {
        System.out.println(Processor.getProcessor().getScoreUpdate());
    }
    
    public void welcome(String name) {
        System.out.println("Hello " + name);
        System.out.println("Let's play Paper-Rock-Scissors!");
    }
    
    public void goodbye() {
        System.out.println(Constants.GOODBYE_MSG);
    }
    
    public boolean continuePlaying() {
        String playOn;
        do {
            playOn = InputUtil.getUserInput(Constants.CONTINUE_PLAYING_MSG);
        } while (!playOn.equals(Constants.YES) && !playOn.equals(Constants.NO));
        return playOn.equals(Constants.YES);
    }
}
