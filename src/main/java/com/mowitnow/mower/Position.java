package com.mowitnow.mower;

public record Position(int x, int y) {
    public Position moveNorth() {
        return new Position(x, y + 1);
    }

    public Position moveEast() {
        return new Position(x + 1, y);
    }

    public Position moveSouth() {
        return new Position(x, y - 1);
    }

    public Position moveWest() {
        return new Position(x - 1, y);
    }
}
