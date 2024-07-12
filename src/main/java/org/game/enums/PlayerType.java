package org.game.enums;

public enum PlayerType {
    USER("user"),
    COMPUTER("computer");
    
    private final String type;
    
    PlayerType(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
}
