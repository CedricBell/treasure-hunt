package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class World {
	
	private Integer width;
	
	private Integer height;
	
	private List<Mountain> mountains;

	private List<Treasure> treasures;
	
	private WorldGrid worldGrid;
	
	private HashMap<String, Position> positions;
	
	
	public World(List<Mountain> mountains, List<Treasure> treasures) {
		this.mountains = mountains;
		this.treasures = treasures;
        this.worldGrid = new WorldGrid(treasures,mountains,width,height);
        this.positions =  new HashMap<>();

	}
	
	public World(int width, int height, ArrayList<Mountain> mountains, ArrayList<Treasure> treasures) {
		this.width = width;
		this.height= height;
		this.mountains = mountains;
		this.treasures = treasures;
		this.positions = new HashMap<>();
        this.worldGrid = new WorldGrid(treasures,mountains,width,height);
	}

	public World() {
		this.mountains = new ArrayList<>();
		this.treasures = new ArrayList<>();
        this.positions = new HashMap<>();
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

    public boolean isValid() {
        return width != null && height != null;
    }

	public HashMap<String, Position> getPositions() {
		return positions;
	}

	public void setPositions(HashMap<String, Position> positions) {
		this.positions = positions;
	}
    

}
