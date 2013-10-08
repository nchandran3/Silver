
public class Tile {
	/*Instance variables:
	 * 	-Tile type(stored as a (two character string or numbers?))
	 * 		-mountain(3 types)
	 * 		-river
	 * 		-plain
	 * 		-Town Center
	 */
	private int tileType;
	
	public Tile(int newTileType){
		tileType = newTileType;
	}
	
	public int getTileType(){
		
		return tileType;
	}
}
