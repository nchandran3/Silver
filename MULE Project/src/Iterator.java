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
	public Screen cur_screen; //holds the current screen being displayed
	private boolean firstLandPhase;

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

	public void simulateRound(){
		
		ArrayList<Player> plArray = Player.getPlArray();
		switchScreen(new Map());
		firstLandPhase = true;
		/*int passed = 0;
		ArrayList<Player> plArray = Player.getPlArray();
		boolean gamePhase = false;
		for(Player p: plArray){		//in a priority queue
			setCurrPlayer(p);
			switchScreen(new Map());
			if(gamePhase == false){
				if(Round <= 2){
					//ability to choose from map tile he wants for free
					
				}
				else if(Round > 2 && passPassed() == false){
					//ability to choose from map tile he wants for money or he can pass
					//map.drawMap(p);
					//have to decrement the players money
				}
				else if(Round > 2 && passPassed() == true){
					passed++;
					if(passed == plArray.size()){
						gamePhase = true;
						break;
					}
				}
			}
			else{	//gamePhase
				
			}
		}
		Round++;*/
		round++;
	}
	
	
	
	public int getRound(){
		return round;
	}
	public void incrementRound(){
		round++;
	}
	public void switchPlayers(){
		
	}
	public boolean veryifyPassed(Player p){
		//if()
		return false;
	}
	
	public boolean getFirstLandPhase(){
		return firstLandPhase;
	}
}
