package control;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.*;

import Components.*;
import Player.*;
import Tile.*;
import ViewScreens.*;
import control.*;
import Game.*;

/**
 * This class controls the switching between the screens in the game. It keeps track of the current screen and updates
 * the game according to the controller.
 * 
 * @author Andrew Ford
 * 
 */
public class Iterator implements Serializable
{
	private Container contentPane;
	private JFrame frame;
	private int round = 1;
	private Player p;
	private Map map;
	private int currPhase;
	private Screen cur_screen; // holds the current screen being displayed
	private Screen prev_screen;

	/**
	 * Constructor that initializes the iterator
	 */
	private Iterator()
	{
		frame = GameFrame.getFrame();
		contentPane = frame.getContentPane(); // crucial for layout. This is what will be used to add components, remove
												// them, and position timers and stat boxes
		cur_screen = new Menu_Screen();
	}

	private static class Holder
	{
		private static Iterator INSTANCE = new Iterator();
	}

	/**
	 * 
	 * @return Instance of Iterator
	 */
	public static Iterator getIterator()
	{
		return Holder.INSTANCE;
	}

	static void setIterator(Iterator i)
	{
		Holder.INSTANCE = i;
	}

	public static void reset()
	{
		Holder.INSTANCE = new Iterator();
	}

	/**
	 * Overloaded constructor that instantiates the gameframe into the cardLayout and adds the two components menu
	 * screen and player select screen
	 * 
	 * @param JFrame
	 *            gameframe
	 */

	/**********************************************************************************************************************
	 * METHODS *
	 **********************************************************************************************************************/

	/**
	 * Sets up the GameFrame with the preliminary screens
	 */
	public void setUpFrame()
	{
		contentPane.add(cur_screen);
		frame.pack();
		Toolkit tk = Toolkit.getDefaultToolkit();
		frame.setLocation(tk.getScreenSize().width / 2 - frame.getWidth() / 2,
				10);
		frame.setVisible(true);
	}

	/**
	 * Changes the screen displayed on the frame
	 * 
	 * @param Screen
	 *            screen the screen to display next
	 */
	public void switchScreen(Screen screen)
	{
		contentPane.remove(cur_screen); // remove current screen
		setPreviousScreen(cur_screen); // only really used with town screen
		cur_screen = screen; // add next screen to display
		contentPane.add(screen, BorderLayout.CENTER);
		// frame.setContentPane(contentPane);
		frame.pack();
	}

	public void setPreviousScreen(Screen screen)
	{
		prev_screen = screen;
	}

	public Screen getPreviousScreen()
	{
		return prev_screen;
	}

	/**
	 * @return Screen that the Card Layout is currently on
	 */
	public Screen getScreen()
	{
		return cur_screen;
	}

	public JFrame getFrame()
	{
		return frame;
	}

	public int getRound()
	{
		return round;
	}

	public void incrementRound()
	{
		round++;
		System.out.println("Round is now " + round);
	}

	public void setUpStatsPanel()
	{
		contentPane.add(PlayerStatsPanel.getPanel(), BorderLayout.SOUTH);
	}

	/**********************************************
	 * PHASE Methods
	 **********************************************/

	public void setCurrentPhase(int i)
	{
		currPhase = i;
	}

	/**
	 * Gets the current phase
	 * 
	 * @return The current phase (1 for LandSelection, 2 for AfterSelectionMap())
	 */
	public int getCurrentPhase()
	{
		return currPhase;
	}

	/**
	 * Increments the phase index. It can only vary from 1-2. If it reaches 2, it goes back to 1.
	 */
	public void incrementPhase()
	{
		 //ensures that currPhase cycles between 1 or 2
		currPhase = (currPhase % 2) + 1; 
	}

	/**
	 * Switches the screen to the next phase. [Ensure that the last player has gone]
	 */
	public void switchToNextPhase()
	{
		incrementPhase();
		switch (currPhase)
		{
			case 1:
				incrementRound();
				switchScreen(new LandSelection());
				break;
			case 2:
				switchScreen(new AfterSelectionMap());
				break;
		// case 3:
		// switchScreen(new Auction()); //switch this to Auction after it is implemented
		// incrementRound(); //move this to the beginning of phase 1.
		// break;
			default:
				break;
		}
	}
}
