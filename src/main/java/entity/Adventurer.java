package entity;

import java.util.List;

public class Adventurer {

	private String name;
	
	private Position position;
	
	private int treasureNumber;
	
	private Orientation orientation;
	
	private List<String> actions;
	
	public Adventurer(String name, Position position, Orientation orientation, List<String> actions) {
		this.name =name;
		this.position = position;
		this.treasureNumber = 0;
		this.orientation = orientation;
		this.actions = actions;
	}
	
	public Adventurer(String name, int coordX, int coordY, Orientation orientation, List<String> actions) {
		this.name =name;
		this.position = new Position(coordX, coordY);
		this.treasureNumber = 0;
		this.orientation = orientation;
		this.actions = actions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getTreasureNumber() {
		return treasureNumber;
	}

	public void setTreasureNumber(int treasureNumber) {
		this.treasureNumber = treasureNumber;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public List<String> getActions() {
		return actions;
	}

	public void setActions(List<String> actions) {
		this.actions = actions;
	}
	
    @Override
    public String toString() {
        return String.format("%s %s-%s %s %s", this.name, this.position.getCoordX(), position.getCoordY(), this.orientation, this.treasureNumber);
    }
}
