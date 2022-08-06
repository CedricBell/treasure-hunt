package entity;

import java.util.ArrayList;
import java.util.List;

public class World {
	
	private Integer width;
	
	private Integer height;
	
	private List<Mountain> mountains;

	private List<Treasure> treasures;
	
	private WorldGrid worldGrid;
	
	private Adventurer adventurer;
	
	public World(Adventurer adventurer, List<Mountain> mountains, List<Treasure> treasures) {
		this.mountains = mountains;
		this.treasures = treasures;
		this.adventurer = adventurer;
        this.worldGrid = new WorldGrid(treasures,mountains,width,height);

	}
	
	public World(Adventurer adventurer, int width, int height, ArrayList<Mountain> mountains, ArrayList<Treasure> treasures) {
		this.width = width;
		this.height= height;
		this.mountains = mountains;
		this.treasures = treasures;
		this.adventurer = adventurer;
        this.worldGrid = new WorldGrid(treasures,mountains,width,height);
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public List<Mountain> getMountains() {
		return mountains;
	}

	public void setMountains(List<Mountain> mountains) {
		this.mountains = mountains;
	}

	public List<Treasure> getTreasures() {
		return treasures;
	}

	public void setTreasures(List<Treasure> treasures) {
		this.treasures = treasures;
	}

	public WorldGrid getWorldGrid() {
		return worldGrid;
	}

	public void setWorldGrid(WorldGrid worldGrid) {
		this.worldGrid = worldGrid;
	}

	public Adventurer getAdventurer() {
		return adventurer;
	}

	public void setAdventurer(Adventurer adventurer) {
		this.adventurer = adventurer;
	}
	

}
