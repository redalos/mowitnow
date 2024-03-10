package com.mowitnow.mower;

public record Lawn(int width, int height) {
    public boolean isWithinBounds(Position position) {
        return position.x() >= 0 && position.x() <= width && position.y() >= 0 && position.y() <= height;
    }
}