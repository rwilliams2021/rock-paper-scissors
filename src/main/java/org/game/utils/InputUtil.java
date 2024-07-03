package org.game.utils;

import java.util.Scanner;

public final class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);
    
    private InputUtil() {
    }
    
    public static String getUserInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
    
    public static void closeScanner() {
        scanner.close();
    }
}

