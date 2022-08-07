package entity;

public class Treasure extends Position {
	
	private int treasureNumber;

	public Treasure(int treasureNumber, int coordX, int coordY) {
		super(coordX, coordY);
		this.treasureNumber = treasureNumber;
	}

	public int getTreasureNumber() {
		return treasureNumber;
	}

	public void setTreasureNumber(int treasureNumber) {
		this.treasureNumber = treasureNumber;
	}
	
	@Override
	public String toString() {
        return String.format("%s Treasures at %s %s",this.treasureNumber, this.getCoordX(), this.getCoordY());
	}
}
