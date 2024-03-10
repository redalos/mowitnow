package com.mowitnow.mower.ennum;

public enum Command {
    A, // Avancer
    D, // Droite
    G; // Gauche

    public static Command fromChar(char c) {
        return switch (c) {
            case 'A' -> A;
            case 'D' -> D;
            case 'G' -> G;
            default -> throw new IllegalArgumentException("Unknown command: " + c);
        };
    }
}