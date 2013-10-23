
import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * This class is responsible for the player's basic information.
 * @author Hamilton Greene
 *
 */

public class Player {
	private BufferedImage image;
	private int score;
	private final Race race;
	private String name;
	private Color color;
	private int dragonFire;
	private int gold;
	private int food;
	private int ore;
	private int muleType;
	private Point location;
	private static ArrayList<Player> plArray = new ArrayList<Player>();
	
	/**
	 * This is the constructor for the player class which initializes the player's data. 
	 * 
	 * @param name
	 * @param color
	 * @param race
	 */
	public Player(String name, Color color, Race race){
		this.name = name;
		this.color = color;
		this.race = race;
		playerInit();
		location = new Point(0,0);
		plArray.add(this);
	}
	
	/**
	 * Moves the player's location to the point given.  Returns
	 * the point the player ends up at.
	 */
	public Point move(Point p) {
		location.move(p.x, p.y);
		return location;
	}

	/**
	 * Get the player's location.
	 */
	public Point getLocation() {
		return location;
	}
	public static ArrayList<Player> getPlArray(){
		return plArray;
	}




	/**
	 * updates the player's resources amount based on transactions that happen in-game.  Negative
	 * integers will deplete the player's resources.
	 * 
	 */
	public void addResources(int dragonFire, int gold, int food, int ore) {
		this.dragonFire+=dragonFire;
		this.gold+=gold;
		this.food+=food;
		this.ore+=ore;
		
	}
	
	/**
	 * This method will set the player's attributes and starting 
	 * resources based on map chosen, difficulty, and selected race.
	 */
	public void playerInit(){
		//This code is to be implemented if/when additional map types are introduced
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
		
		if(Controller.getController().getDifficulty() == 1){
			food = 8;
			dragonFire = 4;
		}else{
			food = 4;
			dragonFire = 2;
		}
		gold = race.getStartMoney();
		ore = 0;
		image = race.getImage();
		tintImage(image);
	}
	
	
/**
 * Tints the sprite image to the player's designated color.
 * @param image the sprite of the player
 */
	public void tintImage(BufferedImage image)
	{
		for (int x = 0; x < image.getWidth(); x++) {
	        for (int y = 0; y < image.getHeight(); y++) {
	        	image.setRGB(x, y, color.getRGB());
	        }
		}
	}
	/**
	 * Getter for race
	 * 
	 * @return Race
	 */
	public Race getRace() {
		// TODO Auto-generated method stub
		return race;
	}
	
	public int getGold(){
		return gold;
	}
	
	public int getDragonFire(){
		return dragonFire;
	}
	
	public int getFood(){
		return food;
	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public Color getColor(){
		return color;
	}
	
	public BufferedImage getImage()
	{
		return image;
	}
	/**
	 * Returns -1 if the player has no mule, 0, 1, or 2 for food, energy, and ore respectively
	 * @return
	 */
	public int getMule(){
		return muleType;
	}
	
	public void setMule(int muleType){
		this.muleType = muleType;
	}

}
