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
	 * Sets up all the necessary classes pivotal to the game functionality.
	 */
	public static void setUp()
	{
	}
	
	@Test
	public void testBuyLand(){
		Tile tile = new River();		//by default the tile is not owned
		Controller controller = Controller.getController();
		Iterator iterator = Iterator.getIterator();
		
		controller.createPlayer("Test", Color.BLACK, Race.TARGARYEN);		//This player should have a default gold value of 600
		controller.startGame();
		
		int price = LandOffice.getLandOffice().getBuyPrice();
		
		assertTrue("Buy Land Price is zero", price == 0);
		assertTrue("Round 3 with Tile unowned and player with full money should return true", controller.buyLand(tile) == true);
		
	}
	
	@AfterClass
	/**
	 * Exits
	 */
	public static void cleanUp()
	{
		System.out.println("END OF TESTS!");
		System.exit(0);
	}
}
