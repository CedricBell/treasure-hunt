package entity;


public class Position {
	
	private int coordX;
	private int coordY;
	
	public int getCoordX() {
		return coordX ;
	}
	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}
	public int getCoordY() {
		return coordY ;
	}
	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}
	
    public Position(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }
    
    public Position() {
    	super();
	}
    
	public Position add(Position position) {
        return new Position(coordX + position.coordX, coordY + position.coordY);
    }
    
    @Override
    public boolean equals(Object other) {
    	boolean res = false;
    	Position otherPosition = ((Position) other);

    	if(coordX == otherPosition.getCoordX() && coordY == otherPosition.getCoordY()) {
    		res = true;
    	}
        return res;
    }
    
	@Override
	public String toString() {
        return String.format("Position at %s %s", this.getCoordX(), this.getCoordY());
	}
}
