package org.game;

import org.game.model.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.welcome();
        do {
            game.play();
            game.printScore();
        }
        while (game.continuePlaying());
        game.goodbye();
    }
}