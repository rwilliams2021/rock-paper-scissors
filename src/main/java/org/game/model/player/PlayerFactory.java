package org.game.model.player;

import org.game.constants.Constants;
import org.game.view.InputProvider;

/**
 * Factory class for creating Player instances.
 */
public class PlayerFactory {
    /**
     * Creates a Player instance based on the specified type.
     * @param type The type of player (user or computer).
     * @param inputProvider The input provider for user input.
     * @return A Player instance.
     */
    public static Player createPlayer(String type, InputProvider inputProvider) {
        return switch (type) {
            case Constants.COMPUTER -> new Computer();
            case Constants.USER -> new User(inputProvider);
            default -> throw new IllegalArgumentException("Invalid player type");
        };
    }
}
