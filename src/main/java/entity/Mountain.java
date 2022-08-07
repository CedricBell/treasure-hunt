package entity;

public class Mountain extends Position {
	
	public Mountain(int coordX, int coordY) {
		super(coordX, coordY);
	}
	
	@Override
	public String toString() {
        return String.format("Mountain at %s %s", this.getCoordX(), this.getCoordY());
	}

}
