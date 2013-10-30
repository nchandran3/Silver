import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import control.GTools;

/**
 * 
 */


/**
 * This class moves the game into the after selection of land phase where players dont have the ability
 * to choose land but can walk around and enter the pub.
 * 
 * @author Andrew Ford
 *
 */
public class AfterSelectionMap extends Screen{
	public AfterSelectionMap(){
		super();
		Map map = Map.getMap();
		setLayout(new BorderLayout());
		
		disableTiles();
		
		add(map, BorderLayout.CENTER);
		JButton pub = new JButton("Pub");
		//GTools.positionAndAdd(pub, .5, 1.01, this);
		pub.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{		
				Controller controller = Controller.getController();
				if(controller.incrementCurrentPlayer() == null){
					Iterator iterator = Iterator.getIterator();
					iterator.switchScreen(new LandSelection());
				}
			}
		});
		
		add(pub, BorderLayout.SOUTH);
		
		GameTimer timer = GameTimer.getTimer();
		timer.reset(15);
		add(timer, BorderLayout.WEST);
		timer.start();
		new Announcement("Player Turns start now");
	}
	
	/**
	 * Disable all tiles from being clicked, except the Town tile
	 */
	public void disableTiles()
	{
		//set all buttons of the map disabled, except for the town
				Tile[][] tiles = Controller.getController().getTileMap();
				for(Tile [] x : tiles)
					for(Tile t: x)
						t.setEnabled(false);
				
				tiles[2][4].setEnabled(true); //set town tile to enabled
	}
	public static void main (String [] args)
	{
		Controller controller = new Controller();
		javax.swing.JFrame frame = new javax.swing.JFrame();
		//Iterator iterator = new Iterator(frame);
		new Map();
		frame.getContentPane().add(new AfterSelectionMap());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(new Point(100,0));
		frame.pack();
		frame.setVisible(true);
	}
}
