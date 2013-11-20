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

	static Controller controller;
	
	@BeforeClass
	/**
	 * Sets up all the necessary classes pivotal to the game functionality.
	 */
	public static void setUp()
	{
		controller = Controller.getController();
	}
	
	@Test
	public void Round1WithEnoughMoney(){
		Tile tile = new River();		//by default the tile is not owned
		
		controller.createPlayer("Test", Color.BLACK, Race.TARGARYEN);		//This player should have a default gold value of 600
		controller.startGame();
		
		int price = LandOffice.getLandOffice().getBuyPrice();
		
		assertTrue("Round should be 1", Iterator.getIterator().getRound() == 1);
		assertTrue("Buy Land Price is zero", price == 0);
		assertTrue("Round 1 with Tile unowned and player with sufficient money should return true",
				controller.buyLand(tile) == true);
		assertTrue("Player money should not change", 
				controller.getCurrentPlayer().getGold() == 600);

		System.out.println("Done with Test 1");
	}
	
	@Test
	public void Round2WithEnoughMoney()
	{
		Tile tile = new River(); //by default the tile is not owned
		
		controller.createPlayer("Test",  Color.BLACK, Race.TARGARYEN);		//Player has default gold value of 600
		controller.startGame();
		
		int price = LandOffice.getLandOffice().getBuyPrice();
		Iterator.getIterator().incrementRound();
		
		assertTrue("Round should be 2", Iterator.getIterator().getRound() == 2);
		assertTrue("Buy Land Price is still zero on round 2", price == 0);
		assertTrue("Round 1 with Tile unowned and player with sufficient money should return true",
				controller.buyLand(tile));
		assertTrue("Player money did not change", controller.getCurrentPlayer().getGold() == 600);

		System.out.println("Done with Test 2");
	}
	
	
	@Test
	public void Round3WithEnoughMoney()
	{
		
	}
	@After
	/**
	 * Resets the controller
	 */
	public void reset()
	{
		Controller.reset();
	}
	
	@AfterClass
	/**
	 * Exits the test.
	 */
	public static void cleanUp()
	{
		System.out.println("END OF TESTS!");
	}
}
