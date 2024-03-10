package com.mowitnow.mower;

import com.mowitnow.mower.ennum.Command;
import com.mowitnow.mower.ennum.Orientation;

public class Mower {
    private Position position;
    private Orientation orientation;
    private final Lawn lawn;

    public Mower(Position position, Orientation orientation, Lawn lawn) {
        this.position = position;
        this.orientation = orientation;
        this.lawn = lawn;
    }

    public void executeCommand(Command command) {
        switch (command) {
            case A -> moveForward();
            case D -> orientation = orientation.rotateRight();
            case G -> orientation = orientation.rotateLeft();
        }
    }

    private void moveForward() {
        Position newPosition = switch (orientation) {
            case N -> position.moveNorth();
            case E -> position.moveEast();
            case S -> position.moveSouth();
            case W -> position.moveWest();
        };
        if (lawn.isWithinBounds(newPosition)) {
            position = newPosition;
        }
    }

    @Override
    public String toString() {
        return position.x() + " " + position.y() + " " + orientation;
    }
}