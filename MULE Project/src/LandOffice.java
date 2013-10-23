import java.util.Random;

/**
 * This represents the land office.
 * @author Hamilton Greene
 *
 */
public class LandOffice {
	private Random rand;
	public static LandOffice landOffice;
	
	public LandOffice(){
		rand = new Random();
		landOffice = this;
	}
	
	public static LandOffice getLandOffice(){
		return landOffice;
	}
	
	public int getBuyPrice(){
		return 300 + Controller.getController().getRound()*rand.nextInt(100);
	}
	
	public int getSellPrice(){
		return 400 + Controller.getController().getRound()*rand.nextInt(200);
	}
}
