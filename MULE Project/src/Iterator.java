import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
/**
 * This class controls the switching between the screens in the game.
 * It keeps track of the current screen and updates the game according to the controller.
 * 
 * @author Andrew Ford
 *
 */
public class Iterator {
	private static Iterator iterator;
	private Container contentPane;
	private JFrame frame;
	private static int round = 1;
	private Player p;
	private Map map;
	private int currPhase;
	private Screen cur_screen; //holds the current screen being displayed

	/**
	 * Constructor that initializes the iterator
	 */
	public Iterator(){iterator = this;}
	
	
	/**
	 * Overloaded constructor that instantiates the gameframe into the cardLayout and adds the two components 
	 * menu screen and player select screen
	 * 
	 * @param JFrame gameframe
	 */
	public Iterator(JFrame frm){ //add the cards to the pane
		this();
		frame = frm;
		contentPane = frame.getContentPane();
		Screen menu = new Menu_Screen();
		cur_screen = menu;
		contentPane.add(menu);
		frame.pack();
		frame.setVisible(true);
	}
	
/**********************************************************************************************************************
 * 														METHODS	                                                      *
 **********************************************************************************************************************/
	
	/**
	 * Changes the screen displayed on the frame 
	 * @param Screen screen the screen to display next
	 */
	public void switchScreen(Screen screen)
	{
		contentPane.removeAll(); //remove current screen
		cur_screen = screen;			//add next screen to display
		contentPane.add(screen);
		frame.setContentPane(contentPane);
		frame.pack();
	}
	
	
	/**
	 * @return Screen that the Card Layout is currently on 
	 */
	public Screen getScreen(){
		return cur_screen;
	}
	/**
	 * 
	 * @return Instance of Iterator
	 */
	public static Iterator getIterator()
	{
		return iterator;
	}


	public int getRound(){
		return round;
	}
	public void incrementRound(){
		round++;
		System.out.println("Round is now " + round);
	}
	
	
	/**********************************************
	 *            PHASE Methods
	 **********************************************/
	 
	public void setCurrentPhase(int i)
	{
		currPhase = i;
	}
	public int getCurrentPhase()
	{
		return currPhase;
	}
/**
 * Increments the phase index. It can only vary from 1-3. If it reaches 3, it goes back to 1.
 */
	public void incrementPhase()
	{
		currPhase =  (currPhase % 3) + 1; // ensures that currPhase cycles between 1, 2, or 3.
	}
	
	/**
	 * Switches the screen to the next phase.
	 * [Ensure that the last player has gone]
	 */
	public void switchToNextPhase()
	{
		incrementPhase();
		switch (currPhase) {
		case 1:
			switchScreen(new LandSelection());
			break;
		case 2:
			switchScreen(new AfterSelectionMap());
			break;
		case 3:
			switchScreen(new LandSelection()); //switch this to Auction after it is implemented
			incrementRound();
			break;
		}
	}
}
