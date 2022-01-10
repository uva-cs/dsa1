package main;

import java.awt.Dimension;

import javax.swing.JFrame;

import world.Room;
import world.RoombaGUI;
import world.RoombaSimulator;

public class Main {
	
	public static void main(String[] args) {
		
		Room r = new Room(800, 600, 20);
		MyRoomba robo = new MyRoomba(450, 450, 10);
		
		RoombaSimulator sim = new RoombaSimulator(robo, r);
		
		RoombaGUI gui = new RoombaGUI(sim);
		gui.setSize(new Dimension(1200,800));
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		sim.setGui(gui);
		sim.simulate();
	}
}