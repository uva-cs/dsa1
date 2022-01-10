package main;

import world.Move;
import world.Roomba;

public class MyRoomba extends Roomba{
	
	private boolean turning = false;
	private Direction newDir = Direction.NORTH;

	public MyRoomba(int x, int y, int radius) {
		super(x, y, radius);
	}

	@Override
	public Move makeMove() {
		/*TODO: Make this method better. Here's an example Roomba that always turns a random direction*/
		
		if(this.turning && this.getDirection() == newDir) {
			this.turning = false;
		}
		
		if(this.frontBumper && !this.turning) {
			turning = true;
			newDir = Direction.values()[(int)(Math.random()*Direction.values().length)];
			return Move.TURNCLOCKWISE;
		}
		
		if(this.turning) { return Move.TURNCLOCKWISE; }
		return Move.FORWARD;
	}
	
}
