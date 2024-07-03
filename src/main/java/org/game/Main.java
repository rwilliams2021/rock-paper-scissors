package org.game;

import org.game.constants.Constants;
import org.game.controller.GameManager;
import org.game.model.Game;
import org.game.model.Processor;
import org.game.model.ScoreManager;
import org.game.model.player.Player;
import org.game.model.player.PlayerFactory;
import org.game.view.ScannerInputProvider;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ScannerInputProvider scannerInputProvider = new ScannerInputProvider(scanner);
            Player user = PlayerFactory.createPlayer(Constants.USER, scannerInputProvider);
            Player computer = PlayerFactory.createPlayer(Constants.COMPUTER, null);
            Game game = new Game(scannerInputProvider, computer, user, new Processor(), new ScoreManager());
            
            GameManager.getInstance().startGame(game);
        }
    }
}
