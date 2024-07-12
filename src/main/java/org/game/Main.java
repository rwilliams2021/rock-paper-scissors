package org.game;

import org.game.model.Game;
import org.game.model.Processor;
import org.game.model.ScoreManager;
import org.game.model.player.Player;
import org.game.model.player.factories.ComputerFactory;
import org.game.model.player.factories.PlayerFactory;
import org.game.model.player.factories.UserFactory;
import org.game.view.InputProvider;
import org.game.view.ScannerInputProvider;

import java.util.Scanner;


/**
 * Main class to start the Rock-Paper-Scissors game.
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            InputProvider scannerInputProvider = new ScannerInputProvider(scanner);
            PlayerFactory computerFactory = new ComputerFactory();
            PlayerFactory userFactory = new UserFactory();
            Player computer = computerFactory.createPlayer();
            Player user = userFactory.createPlayer();
            Game game = new Game(scannerInputProvider, computer, user, new Processor(), new ScoreManager());
            game.play();
        }
    }
}
