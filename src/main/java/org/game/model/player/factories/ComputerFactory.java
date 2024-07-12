package org.game.model.player.factories;

import org.game.model.player.Computer;
import org.game.model.player.Player;

public class ComputerFactory implements PlayerFactory{

    @Override
    public Player createPlayer() {
        return new Computer();
    }
}
