package org.game.model;

import org.game.constants.MessageConstants;
import org.game.enums.Symbol;
import org.game.enums.Outcome;
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
            if (!playRound()) {
                break;
            }
        }
        goodbye();
    }
    
    private void printRoundMessage(int roundNum, int numberOfRounds) {
        System.out.println(MessageConstants.TEXT_LINE_SEPARATOR);
        if (roundNum == numberOfRounds) {
            System.out.println(MessageConstants.FINAL_ROUND_MSG);
        } else {
            System.out.println(MessageConstants.ROUND_NUMBER_MSG + roundNum);
        }
        System.out.println(MessageConstants.TEXT_LINE_SEPARATOR);
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
        printOutcome(outcome, userSymbol, computerSymbol);
        
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
    public void printOutcome(Outcome outcome, Symbol userSymbol, Symbol computerSymbol) {
        String result = switch (outcome) {
            case USER_WIN -> userSymbol.getSymbol() + " " + Symbol.getWinAction(userSymbol) + " " + computerSymbol.getSymbol();
            case COMPUTER_WIN -> computerSymbol.getSymbol() + " " + Symbol.getWinAction(computerSymbol) + " " + userSymbol.getSymbol();
            default -> null;
        };
        if (result != null) {
            System.out.println(result);
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
        System.out.println(MessageConstants.USER_CHOICE +
                           userSymbol +
                           System.lineSeparator() +
                           MessageConstants.COMPUTER_CHOICE +
                           computerSymbol);
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
                String input = inputProvider.getInput(MessageConstants.NUMBER_OF_GAMES_MSG).trim();
                numberOfGames = Integer.parseInt(input);
                if (numberOfGames > 0) {
                    break;
                }
                System.out.println(MessageConstants.NEGATIVE_NUMBER_MSG);
            } catch (NumberFormatException e) {
                System.out.println(MessageConstants.INVALID_NUMBER_MSG);
            }
        }
        return numberOfGames;
    }
    
    /**
     * Prints the current score of the user and the computer.
     */
    public void printScore() {
        System.out.println(MessageConstants.USER_NUM_WINS +
                           user.getWins() +
                           System.lineSeparator() +
                           MessageConstants.COMPUTER_NUM_WINS +
                           computer.getWins());
    }
    
    /**
     * Prints a welcome message to the user.
     *
     * @param name The name of the user.
     */
    public void welcome(String name) {
        System.out.println(MessageConstants.GREETING + name);
        System.out.println(MessageConstants.BEGIN_GAME_MSG);
    }
    
    /**
     * Prints a goodbye message when the game ends.
     */
    public void goodbye() {
        System.out.println(MessageConstants.GOODBYE_MSG);
    }
}
