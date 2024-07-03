package org.game.model;

import org.game.enums.Symbol;
import org.game.enums.Outcome;
import org.game.constants.Constants;
import org.game.model.player.Player;
import org.game.view.InputProvider;

/**
 * Class containing the game logic for Rock-Paper-Scissors.
 */
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
    
    /**
     * Main game loop. Plays the specified number of rounds.
     */
    public void play() {
        welcome(user.getName());
        int numberOfRounds = getNumberOfRounds();
        for (int roundNum = 0; roundNum < numberOfRounds; roundNum++) {
            printRoundMessage(roundNum + 1, numberOfRounds);
            if(!playRound()) {
                break;
            }
        }
        goodbye();
    }
    
    private void printRoundMessage(int roundNum, int numberOfRounds) {
        System.out.println(Constants.TEXT_LINE_SEPARATOR);
        if (roundNum == numberOfRounds) {
            System.out.println(Constants.FINAL_ROUND_MSG);
        } else {
            System.out.println(Constants.ROUND_NUMBER_MSG + roundNum);
        }
        System.out.println(Constants.TEXT_LINE_SEPARATOR);
    }
    
    /**
     * Plays a single round of the game.
     */
    public boolean playRound() {
        
        Symbol userSymbol = user.chooseSymbol();
        if (userSymbol == null) {
            return false;
        }
        Symbol computerSymbol = computer.chooseSymbol();
        printChoices(userSymbol, computerSymbol);
        
        Outcome outcome = determineOutcome(userSymbol, computerSymbol);
        printResult(outcome, userSymbol, computerSymbol);
        
        scoreManager.updateScore(outcome, computer, user);
        printScore();
        return true;
    }
    
    /**
     * Prints the result of the round based on the outcome.
     *
     * @param outcome The outcome of the round.
     * @param userSymbol The user's chosen symbol.
     * @param computerSymbol The computer's chosen symbol.
     */
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
    
    /**
     * Determines the outcome of a round.
     *
     * @param userSymbol The user's chosen symbol.
     * @param computerSymbol The computer's chosen symbol.
     * @return The outcome of the round.
     */
    private Outcome determineOutcome(Symbol userSymbol, Symbol computerSymbol) {
        return processor.determineWinner(userSymbol, computerSymbol);
    }
    
    /**
     * Prints the choices of both the user and the computer.
     *
     * @param userSymbol The user's chosen symbol.
     * @param computerSymbol The computer's chosen symbol.
     */
    private void printChoices(Symbol userSymbol, Symbol computerSymbol) {
        System.out.println(Constants.USER_CHOICE + userSymbol + '\n' + Constants.COMPUTER_CHOICE + computerSymbol);
    }
    
    /**
     * Prompts the user to enter the number of rounds to play.
     *
     * @return The number of rounds to play.
     */
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
    
    /**
     * Prints the current score of the user and the computer.
     */
    public void printScore() {
        System.out.println(Constants.USER_NUM_WINS + user.getWins() + "\n" + Constants.COMPUTER_NUM_WINS + computer.getWins());
    }
    
    /**
     * Prints a welcome message to the user.
     *
     * @param name The name of the user.
     */
    public void welcome(String name) {
        System.out.println("Hello " + name);
        System.out.println("Let's play Paper-Rock-Scissors!");
    }
    
    /**
     * Prints a goodbye message when the game ends.
     */
    public void goodbye() {
        System.out.println(Constants.GOODBYE_MSG);
    }
}
