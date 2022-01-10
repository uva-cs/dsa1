package world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RoombaGUI extends JFrame{
	
	class RoombaPanel extends JPanel{
		
		/* Obligatory */
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {		
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D)g;
			
			g2d.setColor(Color.RED);
			
			//Draw the room pixel by pixel
			Room r = sim.getRoom();
			Roomba robo = sim.getRoomba();
			
			/* Draw the tiles on the floor */
			for(int i=0; i<r.getWidth(); i++)
				for(int j=0; j<r.getHeight(); j++) {
					if(r.getData(i, j) == RoomTile.BLOCKED) g2d.setColor(Color.BLACK);
					if(r.getData(i, j) == RoomTile.CLEAN) g2d.setColor(Color.WHITE);
					if(r.getData(i, j) == RoomTile.DIRTY) g2d.setColor(Color.YELLOW);
					
					g.fillRect(i, j, 1, 1);
				}
			
			/* Draw the roomba itself */
			g2d.translate(robo.getX(), robo.getY());
			g2d.setColor(Color.RED);
			g2d.fillOval(-robo.getRadius(), -robo.getRadius(), robo.getRadius()*2, robo.getRadius()*2);
			g2d.setColor(Color.GRAY);
			g2d.rotate(Math.toRadians(robo.getDirection().ordinal()*45));
			g2d.fillOval(-3, -robo.getRadius(), 6, 6);
			g2d.rotate(-Math.toRadians(robo.getDirection().ordinal()*45));
			g2d.translate(-robo.getX(), -robo.getY());
			
			/* Draw the text to the right */
			int xPos = r.getWidth() + 50; //text appears 50 pixels to the right of the room
			int yPos = 50;
			
			g.drawString("Time Steps Left: " + sim.framesLeft(), xPos, yPos);
			yPos+=50;
			g.drawString("Percent Clean: " + (String.format( "%.2f", r.percentClean()*100)) + "%", xPos, yPos);
			yPos+= 50;
			g.drawString("Roomba Dir: " + robo.getDirection(), xPos, yPos);
			yPos+= 50;
			g.drawString("Roomba Infrared Sensor: " + robo.infraredSensor, xPos, yPos);
			yPos+= 50;
			g.drawString("Roomba Wall Sensor: " + robo.wallSensor, xPos, yPos);
		}
	};

	/* Obligatory */
	private static final long serialVersionUID = 1L;
	
	private RoombaSimulator sim;
	
	/*  */
	public RoombaGUI(RoombaSimulator sim) {
		RoombaPanel panel = new RoombaPanel();
		this.add(panel);
		this.sim = sim;
	}

	
	
}
