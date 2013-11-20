import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.*;
import org.junit.Test;

import control.*;
import Player.Player;
import Player.Race;

public class BuyFoodTest
{

	public static void setUp()
	{
		Iterator iterator = Iterator.getIterator();
		Store store = Store.getStore();
	}

	@Test
	public void testBuyFoodFF()
	{
		// Controller controller = Controller.getController();
		Store store = Store.getStore();

		Player np = new Player("Test", Color.BLACK, Race.TARGARYEN);

		int price = store.getFoodPrice();

		assertTrue("Make Sure there is a price for food", price > 0);
		assertFalse("Owner want to buy too many ",
				store.buyFood(np, store.getFood() + 1));

		System.out.println("Test 1 Done");
	}

	@Test
	public void testBuyFoodTF()
	{
		// Controller controller = Controller.getController();
		Store store = Store.getStore();

		Player np = new Player("Test", Color.BLACK, Race.TARGARYEN);
		np.addResources(0, -300, 0, 0);

		int price = store.getFoodPrice();

		assertTrue("Make Sure there is a price for food", price > 0);
		assertTrue("Owner want to buy all", store.buyFood(np, store.getFood()));
		assertTrue("Owner doesnt have enough money",
				np.getGold() > store.getFood() * store.getFoodPrice());

		System.out.println("Test 2 Done");

	}

	@Test
	public void testBuyFoodTT()
	{
		Store store = Store.getStore();

		Player np = new Player("Test", Color.BLACK, Race.TARGARYEN);
		// np.addResources(0, -300, 0, 0);

		int price = store.getFoodPrice();

		assertTrue("Make Sure there is a price for food", price > 0);
		assertTrue("Owner want to buy all",
				store.buyFood(np, store.getFood() / 2));
		assertTrue("Owner doesnt have enough money",
				np.getGold() > store.getFood() * store.getFoodPrice());

		System.out.println("Test 3 Done");

	}

	/*
	 * This will never come into effect because the first condition is false.
	 * 
	 * @Test public void testBuyFoodFT(){ Store store = Store.getStore();
	 * 
	 * Player np = new Player("Test", Color.BLACK, Race.TARGARYEN); //np.addResources(0, -300, 0, 0);
	 * 
	 * int price = store.getFoodPrice();
	 * 
	 * assertTrue("Make Sure there is a price for food", price > 0); assertFalse("Owner want to buy too many ",
	 * store.buyFood(np, store.getFood() + 1)); assertTrue("Player has ebough Gold", np.getGold()>store.getFood()*0);
	 * 
	 * System.out.println("Test 4 Done"); }
	 */
	@AfterClass
	public static void cleanUp()
	{
		System.out.println("Done");
	}
}
