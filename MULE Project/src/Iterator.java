import java.awt.*;

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
	private static JPanel cards;
	private Container contentPane;
	private JFrame frame;
	public Screen screen;
//	private CardLayout c;
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
		
		//make the cards
		JPanel pSSCard = new PlayerSelectScreen();
		JPanel menuCard = new Menu_Screen();
		
		//create the panel that contains the cards
		cards = new JPanel(new CardLayout());
		cards.add(menuCard, "menu");
		cards.add(pSSCard, "pSS");
		
		
		contentPane.add(cards);
		
		frame.pack();
		frame.setVisible(true);
	}
	/**
	 * changes the screen displayed on the card layout 
	 * 
	 * @param String screen 
	 */
	public void switchScreen(String screen){
		System.out.println("iterator");
		System.out.println("Screen to show is: " + screen);
		CardLayout c = (CardLayout) (cards.getLayout());
		c.show(cards, screen);
	}
	/**
	 * 
	 */
	public void disposing(){
//		c.removeLayoutComponent(frame);
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