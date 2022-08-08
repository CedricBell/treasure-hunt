package runner;

import entity.Adventurer;
import entity.World;
import service.ActionService;

public class AdventurerRunner implements Runnable {
	
	private Adventurer adventurer;
	
	private ActionService actionService;
	
	private World world;
	
	public AdventurerRunner(Adventurer adventurer, ActionService actionService, World world) {
		this.actionService = actionService;
		this.adventurer = adventurer;
		this.world = world;
	}
	
	
	public void run()
    {
			try {
	            // Displaying the thread that is running
	            System.out.printf("Begining  %s turn %n", this.adventurer.getName());
	            adventurer.getActions().forEach(action -> actionService.movePlayer(this.adventurer,this.world,action));
	            System.out.printf("Ending  %s turn %n", this.adventurer.getName());
	        }
	        catch (Exception e) {
	            // Throwing an exception
	            System.out.println("Exception is caught");
	            throw new Error(e);
	        }
		
    }

}
