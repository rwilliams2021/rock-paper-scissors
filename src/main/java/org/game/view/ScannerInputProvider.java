package org.game.view;

import java.util.Scanner;

/**
 * Implementation of InputProvider that uses Scanner for user input.
 */
public class ScannerInputProvider implements InputProvider {
    private final Scanner scanner;
    
    public ScannerInputProvider(Scanner scanner) {
        this.scanner = scanner;
    }
    
    @Override
    public String getInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}
