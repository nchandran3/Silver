import java.awt.Color;
import java.awt.Point;

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
	private Iterator iterator = Iterator.getIterator();
	private Player[] players;
	private static Player currPlayer;
	private int playerInd;
	private static int playerCount, numPlayers, difficulty;
	private Tile[][] tileMap;
	private String[][] makeMap;
	
	/**
	 * This is the constructor for the class which initializes the player count to 0. 
	 */
	public Controller(){
		controller=this;
		playerCount = 0;
	 	players = new Player[numPlayers];
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
		if(playerCount < numPlayers){	// checks to make sure you don't add too many players
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
	public void startGame(){
		Iterator iterator = Iterator.getIterator();
		currPlayer = players[0];
		playerInd = 0;
		LandOffice landOffice = new LandOffice();
		iterator.switchScreen(new Map());
		
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
	/**
	 * Determines the price of the piece of land the current player is trying to buy then
	 * checks the viability of the transaction against the player's available resources.
	 * @param tile
	 * @return true if land acquisition was successful
	 */
	public static boolean buyLand(Tile tile){
		Player player = currPlayer;
		int landPrice = LandOffice.getLandOffice().getBuyPrice();
		if(!tile.isOwned()){
			if(Iterator.getIterator().getRound()<=2){
				tile.tileSold(player);
				return true;
			}else if(player.getGold()>=landPrice){
				tile.tileSold(player);
				player.addResources(0, -landPrice, 0,0);
				return true;
			}
		}
		return false;
	}
	
	public int getDifficulty(){
		return difficulty;
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
	
	/**
	 * Calculate the given player's score.  Not quite sure how this is supposed to be calculated
	 * at the moment, but will be changed to reflect intended values once clarified.
	 * @param player
	 * @return player's score
	 */
	public int calculateScore(Player player){
		return player.getDragonFire() + player.getFood() + player.getGold();
	}
	
	/**
	 * This method goes through each of the players in the players[] and finds the player
	 * with the smallest score.
	 * @return Player in last place
	 */
	public Player getLastPlayer(){
		int lowestScore = calculateScore(players[0]);
		int playerNum = 0;
		for(int i = 0; i<players.length;i++){
			if(calculateScore(players[i])<lowestScore){
				lowestScore = calculateScore(players[i]);
				playerNum = i;
			}
		}
		return players[playerNum];
	}
	
	public void createMap(){
		Tile[][] tileMap = new Tile[5][9];
		makeMap = new String[][]{
			{"P","P","M","P","R","P","M","P","P"}, 
			{"P","M","P","P","R","P","P","P","M"}, 
			{"M","P","P","P","Town","P","P","P","M"}, 
			{"P","M","P","P","R","P","M","P","P"}, 
			{"P","P","M","P","R","P","P","P","M"}
		};	
		setMap(makeMap);
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 9; j++){
				if(makeMap[i][j].equalsIgnoreCase("P")){
					System.out.println("Hep");
					tileMap[i][j] = new Plain();
				}
				else if(makeMap[i][j].equalsIgnoreCase("R")){
					tileMap[i][j] = new River();
				}
				else if(makeMap[i][j].equalsIgnoreCase("m")){
					tileMap[i][j] = new Mountain();
				}
				else{
					tileMap[i][j] = new Town();
				}
			}
		}
		this.tileMap = tileMap;
	}
	
	private void setMap(String[][] makeMap) {
		this.makeMap = makeMap;
		
	}
	public String getTileName(int x, int y){
		return makeMap[x][y];
	}
	public Tile[][] getTileMap(){
		return tileMap;
	}
	
	public Player getCurrentPlayer() {
		return currPlayer;
	}
	
	public void setPlayerIndex(int num) {
		playerInd = num;
	}
	
	public int getPlayerIndex() {
		return playerInd;
	}
	
	public Tile getTileFromCoord(Point point){
		//Tile tile;
		int row = (int) Math.round(point.x/142.22);
		int column = (int)Math.round(point.y/144);
		if(getTileName(row, column).equalsIgnoreCase("Town")){
			//tileMap[row][column];//.setOwner(iterator.getCurrPlayer());
			iterator.switchScreen(new TownScreen());
			return tileMap[row][column];
		}
		else if(getTileName(row, column).equalsIgnoreCase("R")){
			//tileMap[row][column];//.setOwner(iterator.getCurrPlayer());
			return tileMap[row][column];
		}
		else if(getTileName(row, column).equalsIgnoreCase("P")){
			//tileMap[row][column];//.setOwner(iterator.getCurrPlayer());
			return tileMap[row][column];
		}
		else if(getTileName(row, column).equalsIgnoreCase("M")){
			//tileMap[row][column];//.setOwner(iterator.getCurrPlayer());
			return tileMap[row][column];
		}
		else{
			System.out.println("Invalid Coordinate");
			return null;
			//throw exception
		}
	}
	
	public Player[] setPlayerOrder() {
		Player[] temp = players;
		Player[] order = new Player[numPlayers];
		int lowestScore = calculateScore(players[0]);
		int j = 0;
		while(temp != null) {
			for(int i = 0; i<temp.length;i++) {
				if(temp[i] != null) {
					if(calculateScore(temp[i])<lowestScore) {
						lowestScore = calculateScore(temp[i]);
						order[j] = temp[i];
						temp[i] = null;
						j++;
					}
				}
			}
		}	
		order = temp;
		return order;
	}
}
