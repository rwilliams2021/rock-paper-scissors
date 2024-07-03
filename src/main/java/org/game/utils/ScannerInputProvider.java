package org.game.utils;

import java.util.Scanner;

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
    
    @Override
    public void close() {
        scanner.close();
    }
}
