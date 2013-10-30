import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
/**
 * Puts the game into the land selection phase where players can buy property and see their recent purchases. 
 * @author Andrew Ford
 *
 */
public class LandSelection extends Screen {
	private JButton pass;
	private Iterator iterator;
	private Controller controller;
	private GameTimer clock;
	public LandSelection() {
		super();
		controller = Controller.getController();
		iterator = Iterator.getIterator();
		clock = new GameTimer(10);
		setLayout(new BorderLayout());
		enableTiles();
		add(Map.getMap(), BorderLayout.CENTER);
		
		
		if(iterator.getRound() > 2) {
			LandOffice.getLandOffice().setPrice(); //tiles now cost money to players if the round is greater than 2
		}
		
		add(clock, BorderLayout.WEST);
		//clock.resetClock(10);
	}
	
	
	private class PassListener extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{
			if(controller.incrementCurrentPlayer() == null)
				iterator.switchScreen(new AfterSelectionMap());
			new Announcement("Current player is " + controller.getCurrentPlayer());
		}
	}
	
	private void enableTiles()
	{
		Tile [][] tiles = controller.getTileMap();
		
		for(Tile[] x: tiles)
			for(Tile t: x)
				t.setEnabled(true);
		tiles[2][4].setEnabled(false); // do not let players click on the town - it is not ownable 
	}
	
	public static void main (String [] args)
	{
		Controller controller = new Controller();
		Map map = new Map();
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.getContentPane().setLayout(new java.awt.CardLayout());
		Iterator iterator = new Iterator(frame);
		frame.getContentPane().add(new LandSelection());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(new Point(100,0));
		frame.pack();
		frame.setVisible(true);
	}
	
}
