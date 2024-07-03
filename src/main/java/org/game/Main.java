package org.game;

import org.game.model.*;
import org.game.model.player.Computer;
import org.game.model.player.User;
import org.game.utils.ScannerInputProvider;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ScannerInputProvider scannerInputProvider = new ScannerInputProvider(scanner);
            Game game = new Game(scannerInputProvider,
                                 new Computer(),
                                 new User(scannerInputProvider),
                                 new Processor(),
                                 new ScoreManager());
            game.play();
        }
    }
}