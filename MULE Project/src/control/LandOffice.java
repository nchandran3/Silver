package control;

import java.util.Random;

import Components.*;
import Player.*;
import Tile.*;
import ViewScreens.*;
import control.*;
import Game.*;

/**
 * This represents the land office.
 * 
 * @author Hamilton Greene
 * 
 */
public class LandOffice
{
	private Random rand;
	private int buyPrice;
	private int sellPrice;

	private LandOffice()
	{
		rand = new Random();
		buyPrice = 0;
		sellPrice = 0;
	}

	private static class Holder
	{
		private static LandOffice INSTANCE = new LandOffice();
	}

	/**
	 * This sets the purchase price of land based on the game phase. This should be called following every land
	 * purchase.
	 */
	public void setPrice()
	{
		buyPrice = 300 + Iterator.getIterator().getRound() * rand.nextInt(100);
		sellPrice = 400 + rand.nextInt(200);
	}

	public static LandOffice getLandOffice()
	{
		return Holder.INSTANCE;
	}

	public int getBuyPrice()
	{
		return buyPrice;
	}

	public int getSellPrice()
	{
		return sellPrice;
	}
	
	public static void reset()
	{
		Holder.INSTANCE = new LandOffice();
	}

}
