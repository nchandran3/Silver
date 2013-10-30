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
	public LandSelection() {
		super();
		controller = Controller.getController();
		iterator = Iterator.getIterator();
		setLayout(new BorderLayout());
		enableTiles();
		add(Map.getMap(), BorderLayout.CENTER);
		//if(iterator.getRound() > 2) {
			pass = new JButton("Pass");
			pass.addMouseListener(new PassListener());
		//}
			add(pass, BorderLayout.EAST);
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
