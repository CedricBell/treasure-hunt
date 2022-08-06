package service;

import entity.Adventurer;
import entity.Position;
import entity.World;

public class ActionService {
	
    public void movePlayer(Adventurer adventurer,World world, String action) {
        switch (action)
        {
            case "A":
            	moveForward(adventurer,world);
                break;
            case "D":
            	rotateRight(adventurer);
                break;
            case "G":
            	rotateLeft(adventurer);
                break;
            default:
            	System.out.println("ILLEGAL MOVE");
            	break;
        }
    }
    
    private void rotateLeft(Adventurer adventurer) {
		// TODO Auto-generated method stub
    	System.out.println("ROTATE LEFT");
		
	}

	private void rotateRight(Adventurer adventurer) {
		// TODO Auto-generated method stub
		System.out.println("ROTATE RIGHT");
	}

	private void moveForward(Adventurer adventurer, World world) {
		// TODO Auto-generated method stub
		System.out.println("MOVE FORWARD");
	}

	@SuppressWarnings("unused")
	private boolean checkMove(Position nextPosition, World world) {
    	// TODO : check if the move is legal 
		// When to call that function ?
		System.out.println("CHECK IF MOVE IS LEGAL");
        return true;
    }

}
