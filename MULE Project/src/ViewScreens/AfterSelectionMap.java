package ViewScreens;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import control.GTools;
import control.Iterator;
import Components.*;
import Player.*;
import Tile.*;
import ViewScreens.*;
import control.*;
import Game.*;
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
	private GameTimer timer;
	private static boolean first = true;
	public AfterSelectionMap(){
		super();
		Map map = Map.getMap();
		setLayout(new BorderLayout());
		
		disableTiles();
		
		timer = GameTimer.getTimer();
		if(!(Iterator.getIterator().getPreviousScreen() instanceof TownScreen) || !first && !timer.isEnabled())
		{
			timer.reset(35);
			first=false;
		}
		add(timer, BorderLayout.WEST);
		
		add(map, BorderLayout.CENTER);		
		
		
		
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
