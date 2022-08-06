package service;

import entity.Adventurer;
import entity.World;

public class WorldService {
	
	public void showWorld(World world){
		
		// TODO : weird calling
        char[][] worldGrid = world.getWorldGrid().getWorldGrid();
        
        Adventurer adventurer = world.getAdventurer();
        worldGrid[adventurer.getPosition().getCoordX()][adventurer.getPosition().getCoordY()] = adventurer.getName().charAt(0);
        

        for (int y = 0; y < worldGrid[0].length; y++) {
            for (int x = 0; x < worldGrid.length; x++) {
                System.out.print(worldGrid[x][y] >= '0' ? " " + worldGrid[x][y] + " " : " o ");
                }
            System.out.println();
            }
	}

}
