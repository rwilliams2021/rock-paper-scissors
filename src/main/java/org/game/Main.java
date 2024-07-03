package org.game;

import org.game.model.Game;
import org.game.utils.ScannerInputProvider;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScannerInputProvider scannerInputProvider = new ScannerInputProvider(scanner);
        Game game = new Game(scannerInputProvider);
        game.play();
    }
}