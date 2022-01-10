package world;

import java.util.Timer;
import java.util.TimerTask;

public class RoombaSimulator extends TimerTask {
	
	private Roomba roomba;
	private Room room;
	
	private Timer t;
	private int numSeconds = 180;
	private int framerate = 60;
	
	private int frameCount = 0;
	
	private RoombaGUI gui;
	
	protected static boolean lock = false;
	
	public RoombaSimulator(Roomba roomba, Room room) {
		this.roomba = roomba;
		this.room = room;
		this.room.addRoomba(roomba);
		t = new Timer();
	}
	
	
	public void simulate() {
		t.scheduleAtFixedRate(this, 1000, (int)((1.0/(double)framerate)*1000));
	}
	
	protected Room getRoom() {return room;}
	protected Roomba getRoomba() {return roomba;}


	public RoombaGUI getGui() {return gui;}
	public void setGui(RoombaGUI gui) {this.gui = gui;}


	@Override
	public void run() {
		
		lock = true;
		Move m = roomba.makeMove();
		lock = false;
		
		roomba.reset();
		
		switch(m) {
			case FORWARD:
				//TODO: Don't let roomba go out of bounds
				roomba.moveForward();
				break;
			case TURNCLOCKWISE:
				roomba.turnClockwise();
				break;
			case TURNCOUNTERCLOCKWISE:
				roomba.turnCounterClockwise();
				break;
		}
		
		/* Update the room */
		room.update();
		
		gui.validate();
		gui.repaint();
		
		frameCount++;
		if(frameCount / framerate >= numSeconds) { t.cancel(); t.purge();}
	}
	
	public int framesLeft() { return (framerate*numSeconds) - frameCount;}

}
