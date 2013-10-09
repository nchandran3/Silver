/**
 * This class is responsible for creating the map and storing the tileMap, as a 2-D 
 * array, and the players of game, stored in the array players.
 * @author Michael Carlson
 *
 */
public class Map {
	private Tile[][] tileMap;
	private Player [] players;
	/**
	 * This is the constructor of the class which sets the number of tiles on the map and also 
	 * sets the players array equal to the parameters value. 
	 * 
	 * @param numTiles
	 * @param newPlayers
	 */
	public Map(int numTiles, Player[] newPlayers){
		tileMap = new Tile[numTiles][numTiles];
		players = newPlayers;
	}
	public Tile[][] getTileMap(){
		return tileMap;
	}
	public Player[] getPlayers(){
		return players;
	}
}
