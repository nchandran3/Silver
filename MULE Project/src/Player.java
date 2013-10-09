import java.awt.Color;
import java.awt.Point;


public class Player implements Person {
	
	private final Race race;
	private String name;
	private Color color;
	private int[] resources;
	private Point location;
	
	Player(String name, Color color, Race race){
		this.name = name;
		setColor(color);
		this.race = race;
		resources = new int[4];
		location.x = 0;
		location.y = 0;
//		this.location = startLoc;
	}
	
	/**
	 * Takes in the string color and converts it back to an int
	 * where it gives the player the respective color
	 * @param color
	 */
	private void setColor(Color color){
		this.color = color;
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

	@Override
	public int[] addResources(int[] transaction) {
		for(int i = 0; i<transaction.length;i++){
			resources[i]+=transaction[i];
		}
		return resources;
	}

	@Override
	public Race getRace() {
		// TODO Auto-generated method stub
		return race;
	}

}
