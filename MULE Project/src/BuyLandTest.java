import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.*;
import org.junit.Test;

import control.Controller;
import control.Iterator;
import control.LandOffice;
import Components.ColorChooseBox;
import Player.Race;
import Tile.River;
import Tile.Tile;

public class BuyLandTest
{

	Controller controller;
	Iterator iterator;

	@Before
	/**
	 * Sets up all the necessary classes pivotal to the game functionality.
	 */
	public void setUp()
	{
		System.out.println("Setting up controller and iterator \n\n");
		controller = Controller.getController();
		iterator = Iterator.getIterator();
	}

	@Test
	public void round1WithEnoughMoney()
	{
		Tile tile = new River(); // by default the tile is not owned

		controller.createPlayer("Test", Color.BLACK, Race.TARGARYEN); // This player should have a default gold value of 600
		controller.startGame();

		new Components.LandSelection();
		int price = LandOffice.getLandOffice().getBuyPrice();
		
		System.out.println("Round: " + iterator.getRound());
		//Round 1, Player buys land 
		assertTrue("Round should be 1", iterator.getRound() == 1);
		assertTrue("Buy Land Price is zero", price == 0);
		assertTrue(
				"Round 1 with Tile unowned and player with sufficient money should return true",
				controller.buyLand(tile) == true);
		assertTrue("Player money should not change", controller.getCurrentPlayer().getGold() == 600);

		iterator.incrementRound();
		new Components.LandSelection();
		price = LandOffice.getLandOffice().getBuyPrice();
		Tile tile2 = new River();
		//Round 2, Player should be able to buy land
		assertTrue("Round should be 2", iterator.getRound() == 2);
		assertTrue("Buy Land Price is still zero", price == 0);
		assertTrue(
				"Round 2 with Tile unowned and player with sufficient money should return true",
				controller.buyLand(tile2) == true);
		assertTrue("Player money should not change", controller.getCurrentPlayer().getGold() == 600);
		
		
		new Components.LandSelection();
		price = LandOffice.getLandOffice().getBuyPrice();
		
		//Round 2, Player should not be able to buy land that is already owned
		
		assertTrue("Round should be 2", iterator.getRound() == 2);
		assertTrue("Buy Land Price is zero", price == 0);
		assertTrue("Round 2 with Tile owned and player with sufficient money should return false",
				controller.buyLand(tile2) == false );
		assertTrue("Player money should not change", controller.getCurrentPlayer().getGold() == 600);
		
		//Round 3, Player should be able to buy land that costs money
		
		iterator.incrementRound();
		new Components.LandSelection();
		price = LandOffice.getLandOffice().getBuyPrice();
		Tile tile3 = new River();
		
		assertTrue("Round should be 3", iterator.getRound() == 3);
		assertFalse("Buy Land Price is not zero", price == 0);
		assertTrue("Round 3 with Tile unowned and player with sufficient money should return true",
				controller.buyLand(tile3) == true );
		assertFalse("Player money should change", controller.getCurrentPlayer().getGold() == 600);
		
		//Round 3, Player doesn't have enough money to buy land
		controller.getCurrentPlayer().addResources(0, -200, 0, 0);
		Tile tile4 = new River();
		new Components.LandSelection();
		price = LandOffice.getLandOffice().getBuyPrice();
		
		assertTrue("Round should be 3", iterator.getRound() == 3);
		assertFalse("Buy Land Price is not zero", price == 0);
		assertFalse("Round 3 with Tile unowned and player with insufficient money should return false",
				controller.buyLand(tile3) == true );

	}

//	@Test
//	public void round2WithEnoughMoney()
//	{
//		Tile tile = new River(); // by default the tile is not owned
//
//		controller.createPlayer("Test", Color.BLACK, Race.TARGARYEN); // Player has default gold value of 600
//		controller.startGame();
//
//		iterator.incrementRound();
//		int price = LandOffice.getLandOffice().getBuyPrice();
//		
//
//		assertTrue("Round should be 2", iterator.getRound() == 2);
//		assertTrue("Buy Land Price is still zero on round 2", price == 0);
//		assertTrue(
//				"Round 2 with Tile unowned and player with sufficient money should return true",
//				controller.buyLand(tile));
//		assertTrue("Player money did not change", controller.getCurrentPlayer()
//				.getGold() == 600);
//
//		System.out.println("Done with Test 2");
//	}
//
//	@Test
//	public void round3WithEnoughMoney()
//	{
//		Tile tile = new River(); // by default the tile is not owned
//
//		controller.createPlayer("Test", Color.BLACK, Race.TARGARYEN); // Player has default gold value of 600
//		controller.startGame();
//
//		iterator.incrementRound();
//		iterator.incrementRound();
//		new Components.LandSelection();
//		int price = LandOffice.getLandOffice().getBuyPrice();
//		
//		
//		assertTrue("Round should be 3", iterator.getRound() == 3);
//		assertFalse("Buy Land Price is not zero on round 3", price == 0);
//		assertTrue(
//				"Round 3 with Tile unowned and player with sufficient money should return true",
//				controller.buyLand(tile));
//		assertFalse("Player money did change", controller.getCurrentPlayer()
//				.getGold() == 600);
//
//		System.out.println("Done with Test 3 \n");
//
//	}

	@After
	/**
	 * Resets the controller and iterator after every method
	 */
	public void reset()
	{
		System.out.println("Resetting for the next test \n");
		Controller.reset();
		Iterator.reset();
		LandOffice.reset();
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
