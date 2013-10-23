import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


public enum Race {
	
	/*
	 * The numbers in the constructors represent the start money of each Race
	 */
	TARGARYEN(600, createImage("./Images/danny_sprite.png")), //represents the Human class
	GREYJOY(1000, createImage("./Images/theon_sprite.png")),
	LANNISTER(1600, createImage("./Images/joff_sprite.png")), //represents the Flapper class
	BARATHEON(1000, createImage("./Images/stannis_sprite.png")),
	STARK(1000, createImage("./Images/robb_sprite.png"));
	
	
	
	private int start_money;
	private BufferedImage image;
	Race(int mon, BufferedImage img) {
		this.start_money = mon;
		this.image = img;
	}
	
	public int getStartMoney()
	{
		return start_money;
	}
	
	private static BufferedImage createImage(String url)
	{
		BufferedImage img = null;
		try 
		{
			img = ImageIO.read(new File(url));
		}
		catch (Exception e){e.printStackTrace();}
		return img;
	}
	
	public BufferedImage getImage()
	{
		return image;
	}
}
