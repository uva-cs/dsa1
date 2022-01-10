package world;

/**
 * A single room that needs to be cleaned
 * @author Mark Floryan
 *
 */
public class Room {
	
	/* The room data itself */
	private RoomTile[][] data;
	private int width, height; //in pixels
	
	private Roomba roomba; //reference to the roomba in this room
	
	
	public Room(int width, int height, int numObstacles) {
		data = new RoomTile[width][height];
		this.width = width;
		this.height = height;
		
		/* By default, every tile starts as DIRTY */
		for(int i=0; i< width; i++)
			for(int j=0; j<height; j++)
				data[i][j] = RoomTile.DIRTY;
		
		/* Scatter some obstacles and such around the room */
		initializeObstacles(numObstacles);
	}
	
	/**
	 * This method scatters the number of obstacles specified around the room.
	 * For now, they are all rectangles of arbitrary size
	 */
	protected void initializeObstacles(int numObs) {
		
		for(int n=0; n<numObs; n++) {
			
			/* Randomly choose a large or small obstacle */
			boolean large = (int)(Math.random()*2) == 1;
			
			/* Choose a random location for the obstacle */
			int x = (int)(width*Math.random());
			int y = (int)(height*Math.random());
			
			int sizeBase=5; int sizeRange=5; //small obstacle is 5-10% of whole room size
			if(large) { sizeBase = 15; sizeRange = 10; }
			
			/* By default, choose a random small width and height, make it larger if necessary */
			int obsWidth = (int)(((Math.random()*(double)sizeRange + sizeBase) / 100) * width);
			int obsHeight = (int)(((Math.random()*(double)sizeRange + sizeBase) / 100) * height);
			
			/* Make the actual obstacle */
			for(int i = 0; i<obsWidth; i++)
				for(int j = 0; j<obsHeight; j++)
					if(this.inBounds(x+i, y+j)) data[x+i][y+j] = RoomTile.BLOCKED;
			
		}
	}
	
	/**
	 * Returns the percent of the room that is clean
	 */
	protected double percentClean() {
		int total = 0;
		int clean = 0;
		for(int i=0; i<width; i++)
			for(int j=0; j<height; j++) {
				if(data[i][j] != RoomTile.BLOCKED) total++;
				if(data[i][j] == RoomTile.CLEAN) clean++;
			}
		
		return (double)clean / (double)total;
	}
	
	/**
	 * Cleans the given tile
	 */
	protected void cleanTile(int x, int y) {
		if(inBounds(x,y) && data[x][y] == RoomTile.DIRTY) data[x][y] = RoomTile.CLEAN;
	}
	
	/**
	 * Return the data at position x,y or null if out of bounds
	 */
	protected RoomTile getData(int x, int y){
		if(inBounds(x,y)) return data[x][y];
		return null;
	}
	
	/**
	 * Updates this room based on roomba position
	 */
	protected void update() {
		if(this.roomba == null) {System.out.println("ERROR: No roomba in this room being updated"); return; }
		
		/* Get roomba position */
		int r = roomba.getRadius();
		
		/* Clean the tiles under Roomba */
		for(int i=roomba.getX()-(r); i<=roomba.getX()+(r); i++) {
			for(int j = roomba.getY() - (r); j <= roomba.getY() + (r); j++) {
				this.cleanTile(i, j);
			}
		}
		
		/* If the roomba runs into something, set the bumper value and move roomba back */
		for(int i=roomba.getX()-r; i<=roomba.getX()+r; i++) {
			for(int j = roomba.getY() - r; j <= roomba.getY() + r; j++) {
				if(!roomba.frontBumper && (!inBounds(i,j) || this.getData(i, j) == RoomTile.BLOCKED)) {
					roomba.frontBumper = true;
					roomba.moveBackward();
				}
			}
		}
		
		
		/* Figure out if there is an object just to the right of the roomba */
		/* To do this, turn twice, then check for collisions again */
		roomba.turnClockwise();
		roomba.turnClockwise();
		roomba.moveForward();
		roomba.wallSensor = false;
		/* If the roomba runs into something, set the sensor value */
		for(int i=roomba.getX()-r; i<=roomba.getX()+r; i++) {
			for(int j = roomba.getY() - r; j <= roomba.getY() + r; j++) {
				if((!inBounds(i,j) || this.getData(i, j) == RoomTile.BLOCKED)) {
					roomba.wallSensor = true;
				}
			}
		}
		/* Reset roomba position */
		roomba.moveBackward();
		roomba.turnCounterClockwise();
		roomba.turnCounterClockwise();
		
		
		/* Figure out the infrared distance */
		int d=1;
		boolean done = false;
		for(d=1; d<Math.max(this.width, this.height) && !done; d++) {
			int x = roomba.getX(); int y = roomba.getY();
			for(int xOff=-1; xOff<=1 && !done; xOff++) {
				for(int yOff=-1; yOff<=1 && !done; yOff++) {
					if(!inBounds(x+(xOff*d),y+(yOff*d)) || this.getData(x-xOff*d, y-yOff*d) == RoomTile.BLOCKED) {
						done=true;
					}
				}
			}
		}
		roomba.infraredSensor = d;
	}
	
	
	
	/**
	 * Returns true iff x,y is within the dimensions of this room
	 */
	protected boolean inBounds(int x, int y) {
		return (x >= 0 && x < width) && (y >= 0 && y < height);
	}
	
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	
	public void addRoomba(Roomba r) { this.roomba = r; }

}
