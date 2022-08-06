package main;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Adventurer;
import entity.Mountain;
import entity.Orientation;
import entity.Treasure;
import entity.World;
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
    
    public static void main( String[] args )
    {

    	@SuppressWarnings("resource")
		final Scanner scanner = new Scanner(System.in);

        ArrayList<Mountain> mountains = new ArrayList<>();
        
        mountains.add(new Mountain(5, 3));

        ArrayList<Treasure> treasures = new ArrayList<>();
        treasures.add(new Treasure(1, 4, 2));
        treasures.add(new Treasure(3, 1, 4));


        Adventurer adventurer = new Adventurer("John", 0, 0, Orientation.EAST, null);
        World world = new World(adventurer, 6, 5, mountains, treasures);
        System.out.println(String.format("World dimensions %s lines x %s columns",world.getWidth(), world.getHeight()));


        while (true) {
            System.out.println(String.format("Number of treasures collected : %s",adventurer.getTreasureNumber()));            
            System.out.println(String.format("Adventurer position (line, column, orientation) : %s - %s - %s",adventurer.getPosition().getCoordX(), adventurer.getPosition().getCoordY(), adventurer.getOrientation()));

            worldService.showWorld(world);
            System.out.println("");
            System.out.println("Choose an action from the following (Avancer, Droite, Gauche, Exit)  : ");
            System.out.println(" A - D - G - E");

            String action = scanner.nextLine();

            if ("E".equals(action)) {
                System.out.println("EXIT");
                return;
            }

            actionService.movePlayer(adventurer, world, action);
        }
    }
}
