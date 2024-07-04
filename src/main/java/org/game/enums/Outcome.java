package org.game.enums;

import org.game.constants.MessageConstants;

/**
 * Enum representing the possible outcomes of a game round.
 */
public enum Outcome {
    USER_WIN(MessageConstants.USER_WIN_MSG),
    COMPUTER_WIN(MessageConstants.COMPUTER_WINS_MSG),
    DRAW(MessageConstants.DRAW_MSG);
    
    private final String message;
    
    Outcome(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
