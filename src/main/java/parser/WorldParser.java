package parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import entity.Mountain;
import entity.Treasure;
import entity.World;
import entity.WorldGrid;

public class WorldParser {
	
	
	private static final String INCORRECT_FILE = "Incorrect World file";


    public World parseWorldFile(String worldFilePath) throws IOException {

        List<String> linesFromWorldFile = Files.readAllLines(Paths.get(worldFilePath));

        World world = new World();
        ArrayList<Mountain> mountains = new ArrayList<>();
        ArrayList<Treasure> treasures = new ArrayList<>();

        linesFromWorldFile.forEach(line -> {

                    String[] lineSplit = line.split(" ");

                    if (lineSplit.length > 0) {

                        final String lineType = lineSplit[0];

                        switch (lineType) {
                            case "C":
                                createWorld(lineSplit, world);
                                break;
                            case "T":
                                treasures.add(createTreasure(lineSplit));
                                break;
                            case "M":
                                mountains.add(createMountain(lineSplit));
                                break;
                            default:
                                throw new RuntimeException(INCORRECT_FILE);
                        }
                    }
                }
        );

        if (!world.isValid()) {
            throw new RuntimeException(INCORRECT_FILE);
        }

        world.setMountains(mountains);
        world.setTreasures(treasures);
        world.setWorldGrid(new WorldGrid(treasures,mountains, world.getWidth(),world.getHeight()));

        return world;
    }

    private void createWorld(final String[] columns, final World world) {

        if (columns.length != 3 || world.isValid()) {
            throw new RuntimeException(INCORRECT_FILE);
        }

        world.setWidth(Integer.parseInt(columns[1]));
        world.setHeight(Integer.parseInt(columns[2]));

    }

    private Mountain createMountain(final String[] columns) {

        if (columns.length != 2) {
            throw new RuntimeException(INCORRECT_FILE);
        }

        final String[] position = columns[1].split("-");

        if (position.length != 2) {
            throw new RuntimeException(INCORRECT_FILE);
        }

        return new Mountain(Integer.parseInt(position[0]), Integer.parseInt(position[1]));
    }


    private Treasure createTreasure(final String[] columns) {
    	
    	
        if (columns.length != 3) {
            throw new RuntimeException(INCORRECT_FILE);
        }

        final String[] position = columns[1].split("-");

        if (position.length != 2) {
            throw new RuntimeException(INCORRECT_FILE);
        }

        return new Treasure(Integer.parseInt(columns[2]), Integer.parseInt(position[0]), Integer.parseInt(position[1]) );
    }

}
