
public class Tile {
	/*Instance variables:
	 * 	-Tile type(stored as a (two character string or numbers?))
	 * 		-mountain(3 types)
	 * 		-river
	 * 		-plain
	 * 		-Town Center
	 * 	-isOwned(Boolean: saying if the tile is owned by a player/computer)
	 *  -Owner(Player: player that owns the tile)
	 */	
	private int tileType;
	private Player owner;
	private boolean isOwned;
	
	public Tile(int newTileType){
		tileType = newTileType;
	}
	
	public void TileSold(Player player){
		owner = player;
	}
	public int getTileType(){
		
		return tileType;
	}
	public boolean getisOwned(){
		return isOwned;
	}
}
