package parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entity.Adventurer;
import entity.Orientation;

public class AdventurerParser {
	
	private static final String INCORRECT_FILE = "Incorrect Adventurers file";

    public List<Adventurer> parseAdventurerFile(final String adventurerFilePath) throws IOException {

        List<String> adventurerLines = Files.readAllLines(Paths.get(adventurerFilePath));
        List<Adventurer> adventurers = new ArrayList<>();

        adventurerLines.stream().map(adventurer -> adventurer.split(" ")).forEach(infoAdventurer -> {

            if (infoAdventurer.length != 4) {
                throw new RuntimeException(INCORRECT_FILE);
            }

            String[] position = infoAdventurer[1].split("-");

            if (position.length != 2) {
                throw new RuntimeException(INCORRECT_FILE);
            }

            String name = infoAdventurer[0];
            int initialColumn = Integer.parseInt(position[0]);
            int initialLine = Integer.parseInt(position[1]);
            Orientation initialOrientation = Orientation.valueOf(infoAdventurer[2]);
            List<String> actions = Arrays.asList(infoAdventurer[3].split(""));

            adventurers.add(new Adventurer(name, initialColumn, initialLine, initialOrientation, actions));
        });

        return adventurers;

    }
}