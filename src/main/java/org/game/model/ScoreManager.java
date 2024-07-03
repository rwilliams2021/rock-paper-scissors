package org.game.model;

import org.game.enums.Outcome;
import org.game.model.player.Player;

public class ScoreManager {
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
