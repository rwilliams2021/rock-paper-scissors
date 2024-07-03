package org.game.model;

import org.game.enums.Outcome;
import org.game.model.player.Player;

/**
 * Class responsible for managing the scores of the players.
 */
public class ScoreManager {
    
    /**
     * Updates the score based on the outcome of the round.
     * @param outcome The outcome of the round.
     * @param computer The computer player.
     * @param user The user player.
     */
    public void updateScore(Outcome outcome, Player computer, Player user) {
        switch (outcome) {
            case USER_WIN:
                user.incrementWins();
                break;
            case COMPUTER_WIN:
                computer.incrementWins();
                break;
        }
    }
}
