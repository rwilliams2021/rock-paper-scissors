package org.game.model;

import org.game.enums.Symbol;
import org.game.enums.Outcome;
import org.game.constants.Constants;
import org.game.utils.InputUtil;

public class Game {
    private final Player computer = new Computer();
    private final Player user = new User();
    private final Processor processor = Processor.getProcessor();
    private final ScoreManager scoreManager = new ScoreManager();
    
    public void play() {
        welcome(user.getName());
        do {
            Symbol userSymbol = user.chooseSymbol();
            Symbol computerSymbol = computer.chooseSymbol();
            
            System.out.println(Constants.USER_CHOICE + userSymbol + '\n' + Constants.COMPUTER_CHOICE + computerSymbol);
            
            Outcome outcome = processor.determineWinner(userSymbol, computerSymbol);
            scoreManager.updateScore(outcome, computer, user);
            
            System.out.println(outcome.getMessage());
            
            printScore();
        } while (continuePlaying());
        goodbye();
        InputUtil.closeScanner();
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
    }
    
    public boolean continuePlaying() {
        String playOn;
        do {
            playOn = InputUtil.getUserInput(Constants.CONTINUE_PLAYING_MSG);
        } while (!playOn.equals(Constants.YES) && !playOn.equals(Constants.NO));
        return playOn.equals(Constants.YES);
    }
}
