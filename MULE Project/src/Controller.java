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
	private int playerCount;
	private int numPlayers;
	private int difficulty;
	
	public Controller(){
		controller=this;
		playerCount = 0;
//		players = new Player[numPlayers];
	}
	
	public void createPlayer(String name, Color color, Race race){
		if(playerCount < numPlayers){	// checks to make sure you dont add too many players
			Player newPlayer = new Player(name, color, race);
			players[playerCount] = newPlayer;
			playerCount++;
		}
	/*	else
			System.out.print("Can not create anymore players");*/
	}
	public void setNumPlayers(int num){
		numPlayers = num;
	}
	public void setDifficulty(int num){
		difficulty = num;
		System.out.println("Difficulty is " + difficulty);
	}
	
	public static Controller getController()
	{
		return controller;
	}
	
}
