import java.awt.Color;

import javax.swing.*;

/**
 * This class is the connection between the front-end and back-end
 * 
 * 
 * @author Michael Carlson
 *
 */
public class Controller {
	public static Controller controller;
	private Player[] players;
	private static int playerCount, numPlayers, difficulty;
	
	/**
	 * This is the constructor for the class which initializes the player count to 0. 
	 */
	public Controller(){
		controller=this;
		playerCount = 0;
	//	players = new Player[numPlayers];
	}
	/**
	 * This creates new players by calling the player class to set up each player's instance variables 
	 * It puts the players into an array which makes it easy for the iterator to iterate through the players for the game.
	 * 
	 * @param name
	 * @param color
	 * @param race
	 */
	public void createPlayer(String name, Color color, Race race){
		if(playerCount < numPlayers){	// checks to make sure you dont add too many players
			Player newPlayer = new Player(name, color, race);
			System.out.println("Created player " + (playerCount + 1) + ":\nname " + name + "\ncolor " + color + 
					"\nand race " + race); 
			players[playerCount] = newPlayer;
			playerCount++;
		}
	/*	else
			System.out.print("Can not create anymore players");*/
	}
	/**
	 * Simple setter that sets the number of players to a desired amount. 
	 * 
	 * @param num
	 */
	public void setNumPlayers(int num){
		numPlayers = num;
		System.out.println("Set number of players to: "  + num);
		players = new Player[numPlayers];

	}
	
	public int getNumPlayers()
	{
		return numPlayers;
	}
	/**
	 * Simple setter that sets the difficulty to a desired hardness. 
	 * @param num
	 */
	public void setDifficulty(int num){
		difficulty = num;
		System.out.println("Difficulty is " + difficulty);
	}
	
	//Don't really know why this is supposed to be static.  In case this causes problems,
	//This method is called from the Tile buttonPressed() method
	public static void buyLand(Tile tile){
		
	}
	/**
	 * This returns an instance of the controller. 
	 * 
	 * @return Controller
	 */
	public static Controller getController()
	{
		return controller;
	}
	
}
