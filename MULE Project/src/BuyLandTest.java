import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.*;
import org.junit.Test;

import control.Controller;
import control.Iterator;
import control.LandOffice;
import Player.Race;
import Tile.River;
import Tile.Tile;


public class BuyLandTest {

	@BeforeClass
	/**
	 * Sets up all the necessary singletons pivotal to the game functionality. Without these instantiations,
	 * the game would not run. Defines the Controller, Iterator, and LandOffice
	 */
	public static void setUp()
	{
		Iterator iterator = new Iterator();
		LandOffice landOffice = new LandOffice();
	}
	
	@Test
	public void testBuyLand(){
		Tile tile = new River();		//by default the tile is not owned
		Controller controller = Controller.getController();
		Iterator iterator = Iterator.getIterator();
		
		controller.createPlayer("Test", Color.BLACK, Race.TARGARYEN);		//This player should have a default gold value of 600
		
		int price = landOffice.getBuyPrice();
		
		assertTrue("Buy Land Price is not zero", price > 0);
		assertTrue("Round 3 with Tile unowned and player with full money should return true", controller.buyLand(tile) == true);
		
		
	}
	
	@AfterClass
	/**
	 * Exits
	 */
	public static void cleanUp()
	{
		System.exit(0);
	}
}
