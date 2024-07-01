package org.game.enums;

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
