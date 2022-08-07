package entity;

import java.util.List;

public class WorldGrid {
	
    public char[][] worldGrid;

    public WorldGrid(List<Treasure> treasures, List<Mountain> mountains, int width, int height) {
        worldGrid = new char[width][height];
        
        for (Position mountain : mountains) {
        	worldGrid[mountain.getCoordX()-1][mountain.getCoordY()-1] = 'M';
        }
        for(Treasure treasure: treasures) {
        	String s = new StringBuilder().append(treasure.getTreasureNumber()).toString();
            worldGrid[treasure.getCoordX()-1][treasure.getCoordY()-1] = s.charAt(0);
        }
    }
    
    public char[][] getWorldGrid() {
        return worldGrid;
    }

}
