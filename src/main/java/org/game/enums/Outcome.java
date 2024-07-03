package org.game.enums;

import org.game.constants.Constants;

public enum Outcome {
    USER_WIN(Constants.USER_WIN_MSG),
    COMPUTER_WIN(Constants.COMPUTER_WINS_MSG),
    DRAW(Constants.DRAW_MSG);
    
    private final String message;
    
    Outcome(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
