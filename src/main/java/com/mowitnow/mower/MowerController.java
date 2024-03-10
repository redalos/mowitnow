package com.mowitnow.mower;

import com.mowitnow.mower.ennum.Command;
import com.mowitnow.mower.ennum.Orientation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MowerController {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java MowerController <file_path>");
            System.exit(1);
        }

        String filePath = args[0];
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            // Première ligne pour les dimensions de la pelouse
            String lawnInfo = scanner.nextLine();

            // Lecture des instructions pour chaque tondeuse
            List<String> mowerInstructions = new ArrayList<>();
            while (scanner.hasNextLine()) {
                mowerInstructions.add(scanner.nextLine());
            }

            scanner.close();

            List<String> finalPositions = processInstructions(lawnInfo, mowerInstructions);
            finalPositions.forEach(System.out::println);

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
            System.exit(1);
        }
    }

    public static List<String> processInstructions(String lawnInfo, List<String> mowerInstructions) {
        Scanner lawnScanner = new Scanner(lawnInfo);
        Lawn lawn = parseLawn(lawnScanner.nextLine());
        lawnScanner.close();

        List<String> finalPositions = new ArrayList<>();

        for (int i = 0; i < mowerInstructions.size(); i += 2) {
            String positionLine = mowerInstructions.get(i);
            String commandLine = i + 1 < mowerInstructions.size() ? mowerInstructions.get(i + 1) : "";

            String[] positionParts = positionLine.split(" ");
            Position position = new Position(Integer.parseInt(positionParts[0]), Integer.parseInt(positionParts[1]));
            Orientation orientation = Orientation.valueOf(positionParts[2]);
            Mower mower = new Mower(position, orientation, lawn);

            for (char commandChar : commandLine.toCharArray()) {
                Command command = Command.fromChar(commandChar);
                mower.executeCommand(command);
            }

            finalPositions.add(mower.toString());
        }

        return finalPositions;
    }

    private static Lawn parseLawn(String lawnLine) {
        String[] parts = lawnLine.split(" ");
        return new Lawn(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }
}
