import java.awt.Color;
import java.awt.event.KeyListener;
import javax.swing.JButton;

/**
 * This class is responsible for creating the map and storing the tileMap, as a 2-D 
 * array, and the players of game, stored in the array players.
 * @author Michael Carlson
 *
 */
public class Map extends Screen implements KeyListener{
	private Tile[][] tileMap;
	//private JButton[][] spotMap;
	private Player player;
	private int rows;
	private int columns;
	/**
	 * This is the constructor of the class which sets the number of tiles on the map and also 
	 * sets the players array equal to the parameters value. 
	 * 
	 * @param numTiles
	 * @param newPlayers
	 */
	public Map(){
		super();
	}
	public Map(Color c){
		super(c);
	}
	
/**
 * this takes in a 2d array filled with tile pieces.
 * @param tileMap
 */
	public Map(Tile[][] tileMap){
		this.tileMap = tileMap;
		this.rows = tileMap.length;
		this.columns = tileMap[0].length;
	}
	
	public void drawMap(Player player){
		for(int i=0; i<rows; i++){
			for(int j = 0; j<columns; j++){
				tileMap[i][j] = new JButton();
			}
			
		}
	}
	
	public Tile[][] getTileMap(){
		return tileMap;
	}
	public Player[] getPlayers(){
		return players;
	}
}
