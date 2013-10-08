
/**
 * This class represents a Tile on the Map. It stores the tileType(int), owner(Player), and isOwned(boolean).
 * There are 6 different types of tiles that are given in the constructor. The owner is set with the TileSold
 * method once the player has chosen a new tile in the GUI of the game.
 * @author Michael Carlson
 *
 */
public class Tile {

	private int tileType; //make a char?
	private Player owner;
	private boolean isOwned;
	
	public Tile(int newTileType){
		tileType = newTileType;
	}
	/**
	 * changes the owner of the Tile to the parameter given.
	 * @param player: new owner of the tile.
	 */
	public void TileSold(Player player){
		owner = player;
		isOwned = true;
	}
	public void setOwner(Player newOwner){
		owner = newOwner;
	}
	public int getTileType(){
		
		return tileType;
	}
	public boolean getisOwned(){
		return isOwned;
	}
}
