package service;

import java.util.List;

import entity.Adventurer;
import entity.World;

public class WorldService {
	
	public void showWorld(World world, List<Adventurer> adventurers){
		
		// TODO : weird calling
        char[][] worldGrid = world.getWorldGrid().getWorldGrid();
                
        for(Adventurer adventurer : adventurers) {
        	worldGrid[adventurer.getPosition().getCoordX()-1][adventurer.getPosition().getCoordY()-1] = adventurer.getName().charAt(0);
        }
       
        

        for (int y = 0; y < worldGrid[0].length; y++) {
            for (int x = 0; x < worldGrid.length; x++) {
                System.out.print(worldGrid[x][y] >= '0' ? " " + worldGrid[x][y] + " " : " o ");
                }
            System.out.println();
            }
	}
	
	

}
