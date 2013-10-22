import java.awt.*;

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
	private static int Round = 1;
	public Screen cur_screen; //holds the current screen being displayed

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
		contentPane.repaint();
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
	public void simulateRound(){
		Controller controller = new Controller();
		controller = Controller.getController();
		int numTurns = controller.getNumPlayers();
		if(Round)
			for(int i = 1; i <= numTurns; i++){
				
			}
		Round++;
		
	}
}


