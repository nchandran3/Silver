import java.awt.Color;
import javax.swing.*;

/**
 * This class is the connection between the front-end and back-end
 * 
 * 
 * @author Michael
 *
 */
public class Controller {
	private Player[] players;
	private int playerCount;
	private int numPlayers;
	
	public Controller(int numPlayers){
		playerCount = 0;
		this.numPlayers = numPlayers;
		players = new Player[numPlayers];
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
	
	
}
