import java.util.Random;

/**
 * This represents the land office.
 * @author Hamilton Greene
 *
 */
public class LandOffice {
	private Random rand;
	public static LandOffice landOffice;
	private int buyPrice;
	private int sellPrice;
	
	public LandOffice(){
		rand = new Random();
		landOffice = this;
		buyPrice = 0;
		sellPrice = 0;
	}
	
	/**
	 * This sets the purchase price of land based on the game phase.  This should be called 
	 * following every land purchase.
	 */
	public void setPrice(){
		buyPrice = 300 + Iterator.getIterator().getRound()*rand.nextInt(100);
		sellPrice = 400 + rand.nextInt(200);
	}
	
	public static LandOffice getLandOffice(){
		return landOffice;
	}
	
	public int getBuyPrice(){
		return buyPrice;
	}
	
	public int getSellPrice(){
		return sellPrice;
	}
	
}
