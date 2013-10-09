import java.awt.Color;
import java.awt.Point;

/**
 * This class is responsible for the player's basic information.
 * @author Hamilton Greene
 *
 */
public class Player implements Person {
	
	private final Race race;
	private String name;
	private Color color;
	private int[] resources;
	private final Map map;
	private Point location;
	
	Player(String name, Color color, Race race){
		this.name = name;
		this.color = color;
		this.race = race;
		resources = new int[4];
		playerInit();
		location.x = 0;
		location.y = 0;
	}
	
	/**
	 * Moves the player's location to the point given.  Returns
	 * the point the player ends up at.
	 */
	@Override
	public Point move(Point p) {
		location.move(p.x, p.y);
		return location;
	}

	/**
	 * Get the player's location.
	 */
	@Override
	public Point getLocation() {
		return location;
	}

	/**
	 * Adds resources to the player's inventory.
	 */
	@Override
	public int[] addResources(int[] transaction) {
		for(int i = 0; i<transaction.length;i++){
			resources[i]+=transaction[i];
		}
		return resources;
	}
	
	/**
	 * This method will set the player's attributes and starting 
	 * resources based on map chosen and selected race.
	 */
	public void playerInit(){
		//map = Map.getMapType();
		//resources[x] moneyStart = 1000;
		//(where x is chosen slot for money)
		//if(map==North){
		//	if(race == Lannister){
		//		moneyStart = 600;
		//	}else if(race == Stark){
		//		moneyStart = 1600;
		//	}
		//}else if(map==AcrossSea){
		//	if(race == Baratheon){
		//		moneyStart = 600;
		//	]else if(race == Targaryen){
		//		moneyStart = 1600;
		//}else{
		//	if(race==Targaryen){
		//		moneyStart = 600;
		//	}else if(race == Lannister){
		//		moneyStart == 1600;
		//	}
		//}
	}

	@Override
	public Race getRace() {
		// TODO Auto-generated method stub
		return race;
	}

}
