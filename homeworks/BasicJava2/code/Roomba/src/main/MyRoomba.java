package main;

import world.Move;
import world.Roomba;

public class MyRoomba extends Roomba{
	
	/*You can put variables here if it will be helpful*/
	/*Examples: Roomba is currently turning, Roomba is trying to get to some new direction, etc. */

	public MyRoomba(int x, int y, int radius) {
		super(x, y, radius);
	}

	@Override
	public Move makeMove() {
		/*TODO: Make this method better. Here's an example Roomba that always turns a random direction*/
		
		//if we bump into something, turn
		if(this.frontBumper) 
			return Move.TURNCLOCKWISE;
		
		//otherwise just move forward
		return Move.FORWARD;
	}
	
}
