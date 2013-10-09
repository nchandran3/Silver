import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 * This class controls the switching between the screens in the game.
 * It keeps track of the current screen and updates the game according to the game.
 * 
 * @author Andrew Ford
 *
 */
public class Iterator {
	private static Iterator iterator;
	private JFrame frame;
	public Screen screen;
	private CardLayout c;
	/**
	 * Constructor that initializes the iterator
	 */
	public Iterator(){iterator = this;}
	/**
	 * Overloaded constructor that instantiates the gameframe into the cardLayout and adds the two components 
	 * men screen and player select screen
	 * 
	 * @param JFrame gameframe
	 */
	public Iterator(JFrame gameframe){
		this();
		frame = gameframe;
		c = (CardLayout)frame.getContentPane().getLayout();
		Menu_Screen menuScreen = new Menu_Screen();
		PlayerSelectScreen pSS = new PlayerSelectScreen();
		c.addLayoutComponent(menuScreen, "menu");
		c.addLayoutComponent(pSS, "pSS");
		
	}
	/**
	 * changes the screen displayed on the card layout 
	 * 
	 * @param String screen 
	 */
	public void switchScreen(String screen){
		c.show(frame, screen);
	}
	/**
	 * 
	 */
	public void disposing(){
		c.removeLayoutComponent(frame);
	}
//	public void setNextScreen(Screen screen){
//		
//		this.screen = screen;
//	}
	/**
	 * @return Screen that the Card Layout is currently on 
	 */
	public Screen getScreen(){
		return screen;
	}
	/**
	 * 
	 * @return Instance of Iterator
	 */
	public static Iterator getIterator()
	{
		return iterator;
	}
}



/*
private static int turn = 1;
private int numPlayers;
private static Iterator iterator;
private Player[] plarr;
//private final Point center = (0, 0);
private ArrayList<Integer> colors = new ArrayList<Integer>(6);

public Iterator(){iterator = this;}

public Iterator(int numPlayers){
	this.numPlayers = numPlayers;
	plarr = new Player[numPlayers];
	buildPlayers();
	for(int j = 0; j<colors.size(); j++){
		colors.add(j);
	}
	
	iterator = this;
	PlayerSelection ps = new PlayerSelection();
	for(int i = turn; i<=numPlayers; i++){
		String[] nP = ps.selectPlayer(colors);
	}
}
private void buildPlayers() {
	for(int i = 0; i < plarr.length; i++){
		
	}
	// TODO Auto-generated method stub
	
}
public void choosePlayer(String name, String color, String race, int[] resources){
	//plarr.add(new Player(name, color, race, null, CENTER));
	if(turn <= numPlayers){
		
	}
}
public void simulateTurn(){
	//hep
}
*/