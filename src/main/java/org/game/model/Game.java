package org.game.model;

import org.game.enums.Symbol;
import org.game.enums.Outcome;
import org.game.constants.Constants;
import org.game.exceptions.QuitGameException;
import org.game.model.player.Player;
import org.game.utils.InputProvider;

public class Game {
    private final InputProvider inputProvider;
    private final Player computer;
    private final Player user;
    private final Processor processor;
    private final ScoreManager scoreManager;
    
    public Game(InputProvider inputProvider, Player computer, Player user, Processor processor, ScoreManager scoreManager) {
        this.inputProvider = inputProvider;
        this.computer = computer;
        this.user = user;
        this.processor = processor;
        this.scoreManager = scoreManager;
    }
    
    public void play() {
        welcome(user.getName());
        int numberOfRounds = getNumberOfRounds();
        for (int i = 0; i < numberOfRounds; i++) {
            try {
                playRound();
            } catch (QuitGameException e) {
                break;
            }
        }
        goodbye();
    }
    
    public void playRound() throws QuitGameException {
        Symbol userSymbol = getUserSymbol();
        Symbol computerSymbol = computer.chooseSymbol();
        printChoices(userSymbol, computerSymbol);
        
        Outcome outcome = determineOutcome(userSymbol, computerSymbol);
        printResult(outcome, userSymbol, computerSymbol);
        
        scoreManager.updateScore(outcome, computer, user);
        printScore();
    }
    
    private void printResult(Outcome outcome, Symbol userSymbol, Symbol computerSymbol) {
        switch (outcome) {
            case USER_WIN:
                System.out.println(userSymbol.getSymbol() +
                                   " " +
                                   Symbol.getWinAction(userSymbol) +
                                   " " +
                                   computerSymbol.getSymbol());
                break;
            case COMPUTER_WIN:
                System.out.println(computerSymbol.getSymbol() +
                                   " " +
                                   Symbol.getWinAction(computerSymbol) +
                                   " " +
                                   userSymbol.getSymbol());
                break;
            default:
                break;
        }
        System.out.println(outcome.getMessage());
    }
    
    private Outcome determineOutcome(Symbol userSymbol, Symbol computerSymbol) {
        return processor.determineWinner(userSymbol, computerSymbol);
    }
    
    private void printChoices(Symbol userSymbol, Symbol computerSymbol) {
        System.out.println(Constants.USER_CHOICE + userSymbol + '\n' + Constants.COMPUTER_CHOICE + computerSymbol);
    }
    
    public int getNumberOfRounds() {
        int numberOfGames;
        while (true) {
            try {
                String input = inputProvider.getInput(Constants.NUMBER_OF_GAMES_MSG);
                numberOfGames = Integer.parseInt(input);
                if (numberOfGames > 0) {
                    break;
                }
                System.out.println(Constants.POSITIVE_NUMBER_MSG);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return numberOfGames;
    }
    
    public Symbol getUserSymbol() throws QuitGameException {
        Symbol userSymbol = user.chooseSymbol();
        while (userSymbol == null) {
            System.out.println(Constants.INVALID_SYMBOL_MSG);
            userSymbol = user.chooseSymbol();
        }
        return userSymbol;
    }
    
    public void printScore() {
        System.out.println(Constants.USER_NUM_WINS + user.getWins() + "\n" + Constants.COMPUTER_NUM_WINS + computer.getWins());
    }
    
    public void welcome(String name) {
        System.out.println("Hello " + name);
        System.out.println("Let's play Paper-Rock-Scissors!");
    }
    
    public void goodbye() {
        System.out.println(Constants.GOODBYE_MSG);
    }
}
