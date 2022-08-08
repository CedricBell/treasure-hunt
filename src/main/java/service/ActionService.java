package service;

import java.util.ArrayList;
import java.util.List;

import entity.Adventurer;
import entity.Orientation;
import entity.Position;
import entity.Treasure;
import entity.World;

public class ActionService {
	
	private WorldService worldService = new WorldService();
	
    public void movePlayer(Adventurer adventurer,World world, String action) {
        switch (action)
        {
            case "A":
            	moveForward(adventurer,world);
                break;
            case "D":
            	defineNextPositionWhenRotateRight(adventurer);
                break;
            case "G":
            	defineNextPositionWhenRotateLeft(adventurer);
                break;
            default:
            	System.out.println("ILLEGAL MOVE");
            	break;
        }
        ArrayList<Adventurer> advs = new ArrayList<>();
        advs.add(adventurer);
        worldService.showWorld(world, advs);
        
        wait1Second();

    }

	private void moveForward(Adventurer adventurer, World world) {
		System.out.printf("MOVE %s FORWARD %n", adventurer.getName());
		
		Position nextPosition = defineNextPositionWhenMoving(adventurer);
		
		if (checkMove(nextPosition, world)) {
            world.getWorldGrid().getWorldGrid()[adventurer.getPosition().getCoordX()-1][adventurer.getPosition().getCoordY()-1]= 'o';
            world.getPositions().put(adventurer.getName(), nextPosition);
            adventurer.setPosition(nextPosition);
            adventurer.setTreasureNumber(computeTreasure(adventurer.getPosition(), adventurer.getTreasureNumber(), world.getTreasures()));
        } else {
            System.out.println("ILLEGAL MOVE, OTHER ADVENTURER, OUT OF MAP OR MOUNTAIN");
        }
	}


	private boolean checkMove(Position nextPosition, World world) {
				
		return !world.getPositions().containsValue(nextPosition) &&
				nextPosition.getCoordX() > 0 && nextPosition.getCoordX() <= world.getWidth()
                && nextPosition.getCoordY() > 0 && nextPosition.getCoordY() <= world.getHeight()
                && !world.getMountains().contains(nextPosition);
    }
	
    private int computeTreasure(Position position, int currentTreasureNumber, List<Treasure> treasures) {
    	int res = currentTreasureNumber;
    	
    	if(treasures.size()==0) {
    		System.out.println("All Treasures are found !");
    		return res;
    	}

    	System.out.println(position);
        int index = treasures.indexOf(position);

        if (index == -1) {
            return currentTreasureNumber;
        }

        Treasure treasure = treasures.get(index);
        treasures.remove(treasure);
        wait1Second();

        res =  currentTreasureNumber + treasure.getTreasureNumber();
        return res;
    }
	
	public Position defineNextPositionWhenMoving(Adventurer adventurer) {

        Position nextPosition = new Position();
        switch (adventurer.getOrientation()) {
            case NORTH:
                nextPosition.setCoordX(adventurer.getPosition().getCoordX());
                nextPosition.setCoordY(adventurer.getPosition().getCoordY() - 1);
                break;
            case SOUTH:
                nextPosition.setCoordX(adventurer.getPosition().getCoordX());
                nextPosition.setCoordY(adventurer.getPosition().getCoordY() + 1);
                break;
            case EAST:
                nextPosition.setCoordX(adventurer.getPosition().getCoordX() + 1);
                nextPosition.setCoordY(adventurer.getPosition().getCoordY());
                break;
            case WEST:
                nextPosition.setCoordX(adventurer.getPosition().getCoordX() - 1);
                nextPosition.setCoordY(adventurer.getPosition().getCoordY());
                break;
            default:
                break;
        }
        return nextPosition;
    }
	
	public void defineNextPositionWhenRotateRight(Adventurer adventurer) {
		System.out.printf("ROTATE  %s RIGHT %n", adventurer.getName());

		switch (adventurer.getOrientation()) {
    		case NORTH:
    			adventurer.setOrientation(Orientation.EAST);
    			break;
    		case SOUTH:
    			adventurer.setOrientation(Orientation.WEST);
    			break;
    		case EAST:
    			adventurer.setOrientation(Orientation.SOUTH);
    			break;
    		case WEST:
    			adventurer.setOrientation(Orientation.NORTH);
    			break;
		}
    }
	
	public void defineNextPositionWhenRotateLeft(Adventurer adventurer) {
		System.out.printf("ROTATE %s LEFT %n", adventurer.getName());

        switch (adventurer.getOrientation()) {
        	case NORTH:
        		adventurer.setOrientation(Orientation.WEST);
        		break;
        	case SOUTH:
        		adventurer.setOrientation(Orientation.EAST);
        		break;
        	case EAST:
        		adventurer.setOrientation(Orientation.NORTH);
        		break;
        	case WEST:
        		adventurer.setOrientation(Orientation.SOUTH);
        		break;
        }
	}
	
	private void wait1Second() {
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Exception when trying to wait 1 second");
				e.printStackTrace();
			}
    }
	

}
