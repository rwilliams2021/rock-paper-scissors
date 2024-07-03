package org.game.utils;

public interface InputProvider {
    String getInput(String prompt);
    void close();
}
