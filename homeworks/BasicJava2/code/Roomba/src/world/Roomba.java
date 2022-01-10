package world;

public abstract class Roomba {
	
	public enum Direction{
		NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST;
	};
	
	private int x, y;
	private int radius;
	private Direction direction = Direction.NORTH;
	
	protected boolean frontBumper = false;
	protected int infraredSensor = -1;
	protected boolean wallSensor = false;
	
	
	public Roomba(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public abstract Move makeMove();
	
	protected void turnClockwise() {
		if(RoombaSimulator.lock) {
			System.out.println("WARNING: YOU ARE NOT ALLOWED TO INVOKE THE TURNCLOCKWISE() METHOD DIRECTLY. IGNORING REQUEST");
			return; 
		}
		
		switch(this.direction) {
		case NORTH:
			this.direction = Direction.NORTHEAST;
			break;
		case NORTHEAST:
			this.direction = Direction.EAST;
			break;
		case EAST:
			this.direction = Direction.SOUTHEAST;
			break;
		case SOUTHEAST:
			this.direction = Direction.SOUTH;
			break;
		case SOUTH:
			this.direction = Direction.SOUTHWEST;
			break;
		case SOUTHWEST:
			this.direction = Direction.WEST;
			break;
		case WEST:
			this.direction = Direction.NORTHWEST;
			break;
		case NORTHWEST:
			this.direction = Direction.NORTH;
			break;
		}
		
	}
	
	protected void turnCounterClockwise() {
		if(RoombaSimulator.lock) {
			System.out.println("WARNING: YOU ARE NOT ALLOWED TO INVOKE THE TURNCOUNTERCLOCKWISE() METHOD DIRECTLY. IGNORING REQUEST");
			return; 
		}
		
		switch(this.direction) {
		case NORTH:
			this.direction = Direction.NORTHWEST;
			break;
		case NORTHEAST:
			this.direction = Direction.NORTH;
			break;
		case EAST:
			this.direction = Direction.NORTHEAST;
			break;
		case SOUTHEAST:
			this.direction = Direction.EAST;
			break;
		case SOUTH:
			this.direction = Direction.SOUTHEAST;
			break;
		case SOUTHWEST:
			this.direction = Direction.SOUTH;
			break;
		case WEST:
			this.direction = Direction.SOUTHWEST;
			break;
		case NORTHWEST:
			this.direction = Direction.WEST;
			break;
		}
		
	}
	
	/**
	 * Moves the roomba forward one space, does not check boundaries
	 */
	protected void moveForward() {
		if(RoombaSimulator.lock) {
			System.out.println("WARNING: YOU ARE NOT ALLOWED TO INVOKE THE MOVEFORWARD() METHOD DIRECTLY. IGNORING REQUEST");
			return; 
		}
		
		switch(this.direction) {
			case NORTH:
				this.y--;
				break;
			case NORTHEAST:
				this.y--; this.x++;
				break;
			case EAST:
				this.x++;
				break;
			case SOUTHEAST:
				this.x++; this.y++;
				break;
			case SOUTH:
				this.y++;
				break;
			case SOUTHWEST:
				this.x--; this.y++;
				break;
			case WEST:
				this.x--;
				break;
			case NORTHWEST:
				this.x--; this.y--;
				break;
		}
	}
	
	/**
	 * Moves roomba backwards one position, does not check room boundaries
	 */
	protected void moveBackward() {
		if(RoombaSimulator.lock) {
			System.out.println("WARNING: YOU ARE NOT ALLOWED TO INVOKE THE MOVEBACKWARD() METHOD DIRECTLY. IGNORING REQUEST");
			return; 
		}
		
		switch(this.direction) {
			case NORTH:
				this.y++;
				break;
			case NORTHEAST:
				this.y++; this.x--;
				break;
			case EAST:
				this.x--;
				break;
			case SOUTHEAST:
				this.x--; this.y--;
				break;
			case SOUTH:
				this.y--;
				break;
			case SOUTHWEST:
				this.x++; this.y--;
				break;
			case WEST:
				this.x++;
				break;
			case NORTHWEST:
				this.x++; this.y++;
				break;
		}
	}
	
	protected void reset() {
		if(RoombaSimulator.lock) {
			System.out.println("WARNING: YOU ARE NOT ALLOWED TO INVOKE THE RESET() METHOD DIRECTLY. IGNORING REQUEST");
			return; 
		}
		
		this.frontBumper = false;
	}
	
	protected int getX() {
		if(RoombaSimulator.lock) {
			return -1; 
		}
		return x;
	}
	public int getY() {
		if(RoombaSimulator.lock) {
			return -1; 
		}
		return y;
	}
	
	public int getRadius() { return radius; }
	public Direction getDirection() { return this.direction; }

}
