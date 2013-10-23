import java.util.Random;

/**
 * This represents the land office.
 * @author Hamilton Greene
 *
 */
public class LandOffice {
	Random rand;
	
	public LandOffice(){
		rand = new Random();
	}
	
	public int getBuyPrice(){
		return 300 + Controller.getController().getRound()*rand.nextInt(100);
	}
	
	public int getSellPrice(){
		return 400 + Controller.getController().getRound()*rand.nextInt(200);
	}
}
