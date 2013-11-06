
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

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
	private ArrayList<Player> players;
	private static Player currPlayer;
	private static int playerInd;
	private static int playerCount, numPlayers, difficulty;
	private Tile[][] tileMap;
	private String[][] makeMap;
	//private LinkedList<RoundPhase> phaseList;
	
	/**
	 * This is the constructor for the class which initializes the player count to 0. 
	 */
	public Controller(){
		controller=this;
		playerCount = 0;
	 	players = new ArrayList<Player>(numPlayers);
//	 	phaseList.add(LandSelectionPhase);
//	 	phaseList.add(AfterSelectionPhase);
//	 	phaseList.add(AuctionPhase);
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
			players.add(newPlayer);
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
		players = new ArrayList<Player>(numPlayers);

	}
	
	/**
	 * Called after the player selection screen to instatiate all the next screens.
	 */
	public void startGame(){
		Iterator iterator = Iterator.getIterator();
		currPlayer = players.get(0);
		playerInd = 0;
		LandOffice landOffice = new LandOffice();
		new Map(); //initialize the map
		new GameTimer(10); //initialize the game clock 
		GameTimer.getTimer().pause(); // allow the next screen to initialize it
		iterator.setCurrentPhase(1);
		iterator.switchScreen(new LandSelection());
	}
	public void setCurrentPlayer(Player player){
		currPlayer = player;
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
	
	/**
	 * Returns the current player's index
	 * @return the current player's index (0 - # players)
	 */
	public int getCurrentPlayerIndex()
	{
		return playerInd;
	}
	//Don't really know why this is supposed to be static.  In case this causes problems,
	//This method is called from the Tile buttonPressed() method
	/**
	 * Determines the price of the piece of land the current player is trying to buy then
	 * checks the viability of the transaction against the player's available resources.
	 * Round<2 -> landPrice = free
	 * Round>2 && first land selection phase -> landPrice = 300
	 * Round>2 && !first land selection phase -> landPrice = found in LandOffice
	 * @param tile
	 * @return true if land acquisition was successful
	 */
	public static boolean buyLand(Tile tile){
		Player player = currPlayer;
		int landPrice = LandOffice.getLandOffice().getBuyPrice();
		if(!tile.isOwned()){
			if(player.getGold()>=landPrice){
				tile.tileSold(player);
				player.addResources(0, -landPrice, 0,0);
				System.out.println(player.toString() + "'s new Balance is:" + player.getGold());
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
	 * This calculates player order based on each player's respective score.  Lowest score first.
	 * Really not sure if this code works.  Should probably be checked.
	 * @return
	 */
	public ArrayList<Player> getPlayerOrder(){
		PriorityQueue<Player> playOrder = new PriorityQueue<Player>(players.size(), PlayerComparator.INSTANCE);
		playOrder.addAll(players);
		players.clear();
		players.addAll(playOrder);
		return players;
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
	
	//This method may be out of date please check (*)&)&^&^&%&$%&^(*)*%*()_*()&*()&
	/**
	 * This method goes through each of the players in the players[] and finds the player
	 * with the smallest score.
	 * Really not sure if we want this right now
	 * @return Player in last place
	 */
	public Player getLastPlayer(){
		int lowestScore = calculateScore(players.get(0));
		int playerNum = 0;
		for(int i = 0; i<players.size();i++){
			if(calculateScore(players.get(i))<lowestScore){
				lowestScore = calculateScore(players.get(i));
				playerNum = i;
			}
		}
		return players.get(playerNum);
	}
	
	/**
	 * Creates a tile array representing the tiles on the map, by using the default configuration
	 */
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
					//System.out.println("Hep");
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
	
	/**
	 * Sets the player index to point at a certain index of the player array
	 * @param num the index to point at
	 */
	public void setPlayerIndex(int num) {
		playerInd = num;
	}
	
	public int getPlayerIndex() {
		return playerInd;
	}
	
	/**
	 * Returns the tile corresponding to the location of the player. For use with glass pane
	 * @param point the player's location
	 * @return the tile that the player is on
	 */
	public Tile getTileFromCoord(Point point){
		//Tile tile;
		int row = (int) Math.round(point.x/142.22);
		int column = (int)Math.round(point.y/144);
		if(getTileName(row, column).equalsIgnoreCase("Town")){
			//tileMap[row][column];//.setOwner(iterator.getCurrPlayer());
			Iterator iterator = Iterator.getIterator();
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
	
	/**
	 * Calculates the net worth of each player and orders them accordingly
	 * @return the ordered arraylist of players
	 */
	public ArrayList<Player> setPlayerOrder() {
		ArrayList<Player> temp = players;
		ArrayList<Player> order = new ArrayList<Player>(numPlayers);
		int lowestScore = calculateScore(players.get(0));
		int j = 0;
		while(temp != null) {
			for(int i = 0; i<temp.size();i++) {
				if(temp.get(i) != null) {
					if(calculateScore(temp.get(i))<lowestScore) {
						lowestScore = calculateScore(temp.get(i));
						order.set(j, temp.get(i));
						temp.set(i, null);
						j++;
					}
				}
			}
		}	
		return order;
	}
	
	/**
	 * Increments the player index pointer to get the next player. If it is the last player, it will return null and reset the pointer
	 * @return the player at the incremented index. Null if it is the last player
	 */
	public Player incrementCurrentPlayer()
	{
		ArrayList <Player> array = Player.getPlArray();
		playerInd++;
		if(playerInd >= numPlayers)
		{
			playerInd =0;
			setCurrentPlayer(array.get(playerInd));
			return null;
		}
		setCurrentPlayer(array.get(playerInd));
		return currPlayer;
	}
	
	public void endTurn()
	{
		GameTimer timer = GameTimer.getTimer(); //any time a player ends their turn, stop the timer
		timer.pause();
		
		if(incrementCurrentPlayer() == null) //if the last player has gone, then switch to the next phase.
		{
			Iterator.getIterator().switchToNextPhase(); 
		}
		else
			resetClock();
		new Announcement("Current player is now " + currPlayer);
	}
	
	private void resetClock()
	{
		int phase = Iterator.getIterator().getCurrentPhase();
		GameTimer timer = GameTimer.getTimer();
		
		if(phase == 1) //Land Selection Phase
		{
			timer.reset(10);
		}
		else if (phase == 2)
		{
			timer.reset(currPlayer.calculateTime());
		}
		//else auction timer
	}
}
