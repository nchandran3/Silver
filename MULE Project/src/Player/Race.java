package Player;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public enum Race {
	
	/*
	 * The numbers in the constructors represent the start money of each Race
	 */
	TARGARYEN(600, 0), //represents the Human class
	GREYJOY(1000, 1),
	LANNISTER(1600, 2), //represents the Flapper class
	BARATHEON(1000, 3),
	STARK(1000, 4);
	
	
	
	private int start_money;
	private int imageIndex;
	Race(int mon, int key) {
		this.start_money = mon;
		this.imageIndex = key;
		
	}
	
	public int getStartMoney()
	{
		return start_money;
	}
	
	private static ImageIcon createImage(String url)
	{
		ImageIcon img = new ImageIcon(url);
		return img;
	}
	
	/**
	 * Returns the index of the array in Player that represents the image to use for the race's sprite
	 * @return
	 */
	public int getImageIndex()
	{
		return imageIndex;
	}
}
