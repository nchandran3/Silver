import java.awt.Point;


public class Player implements Person {
	
	private final String race;
	private String name;
	private final String color;
	private int[] resources;
	private Point location;
	
	Player(String name, String color, String race, int[] resources, Point startLoc){
		this.name = name;
		setColor(color);
		this.race = race;
		this.resources = resources;
		this.location = startLoc;
	}
	
	private void setColor(String color){
		int aColor = (int) color;
	}
	
	/**
	 * Moves the player's location to the point given.  Returns
	 * the point the player ends up at.
	 */
	@Override
	public Point move(Point p) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Get the player's location.
	 */
	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
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
	public String getRace() {
		// TODO Auto-generated method stub
		return race;
	}

}
