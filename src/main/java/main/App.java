package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entity.Adventurer;
import entity.Mountain;
import entity.Orientation;
import entity.Treasure;
import entity.World;
import parser.AdventurerParser;
import parser.WorldParser;
import runner.AdventurerRunner;
import service.ActionService;
import service.WorldService;

/**
 * Hello world!
 *
 */
public class App 
{
	
    private static final ActionService actionService = new ActionService();
    private static final WorldService worldService = new WorldService();
    private static final WorldParser worldParser = new WorldParser();
    private static final AdventurerParser adventurerParser = new AdventurerParser();
    
    private static final Scanner scanner = new Scanner(System.in);


    public static void demoMode() {
    	ArrayList<Mountain> mountains = new ArrayList<>();
        
        mountains.add(new Mountain(5, 3));

        ArrayList<Treasure> treasures = new ArrayList<>();
        treasures.add(new Treasure(1, 4, 2));
        treasures.add(new Treasure(3, 1, 4));

        
        ArrayList<Adventurer> adventurers = new ArrayList<>();


        Adventurer john = new Adventurer("John", 1, 1, Orientation.EAST, null);
        adventurers.add(john);
        World world = new World(6, 5, mountains, treasures);
        for (final Adventurer adventurer : adventurers) {
            world.getPositions().put(adventurer.getName(), adventurer.getPosition());
        }
        System.out.println(String.format("World dimensions %s lines x %s columns",world.getWidth(), world.getHeight()));

        

        while (true) {
        	
        	for(Adventurer adv : adventurers) {
        		System.out.println(String.format("Number of treasures collected : %s",adv.getTreasureNumber()));            
                System.out.println(String.format("Adventurer position (Column, Line, orientation) : %s - %s - %s",adv.getPosition().getCoordX(), adv.getPosition().getCoordY(), adv.getOrientation()));
        	}
            

            System.out.println("");
            System.out.println("Choose an action from the following (Avancer, Droite, Gauche, Exit)  : ");
            System.out.println(" A - D - G - E");

            String action = scanner.nextLine();

            if ("E".equals(action)) {
                System.out.println("EXIT");
                return;
            }

            actionService.movePlayer(adventurers.get(0), world, action);
        }
    }
    
    public static void uploadFilesMode() {
    	System.out.println("Enter path of the file to generate the world");
    	
    	String worldPath = scanner.nextLine();
        World world;
		try {
			world = worldParser.parseWorldFile(worldPath);
			
			worldService.showWorld(world, new ArrayList<>());
			
			System.out.println("Enter path of the file for adventurers");

	        String adventurerPath = scanner.nextLine();
	        List<Adventurer> adventurers = adventurerParser.parseAdventurerFile(adventurerPath);
	        
	        for (final Adventurer adventurer : adventurers) {
	            world.getPositions().put(adventurer.getName(), adventurer.getPosition());
	        }
	        
	        adventurers.forEach(adventurer ->{
	        	Thread thread = new Thread(new AdventurerRunner(adventurer,actionService, world));
	            thread.start();
	        }); 
	        
//	        TODO : Need to execute the following after the threads are done
	        
	        String adventurerToString = adventurers.stream().map(Adventurer::toString).collect(Collectors.joining("\n"));

	        File output = new File("output.txt");

	        Files.write(output.toPath(), adventurerToString.getBytes());

	        System.out.println(String.format("Output file is available here : %s", output.getAbsoluteFile()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
    }
    
    
    public static void main( String[] args )
    {
    	while (true) {

            System.out.println("Choose from the following options");
            System.out.println("1 : Demo mode");
            System.out.println("2 : Upload world and adventurers from file");

            String action = scanner.nextLine();

            switch (action) {
        		case "1":
        			demoMode();
        			break;
        		case "2":
        			uploadFilesMode();
        			break;
        	default:
        		System.out.println("Please select 1 or 2");
            }
        } 
    }
}
