package org.game.enums;

import org.game.constants.MessageConstants;

/**
 * Enum representing the possible outcomes of a game round.
 */
public enum Outcome {
    USER_WIN("You win!"),
    COMPUTER_WIN("Computer wins!"),
    DRAW("It's a draw!");
    
    private final String message;
    
    Outcome(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
