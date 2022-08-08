package entity;

public enum Orientation {
	NORTH("N"),
	EAST("E"),
	SOUTH("S"),
	WEST("W");

    public String label;

    private Orientation(String label) {
        this.label = label;
    }
	
}
