import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.AfterClass;
import org.junit.Test;

import Player.Player;
import Player.Race;
import control.Store;


public class SellFoodTest {

	public void testPlayerWithNoFood(){
		Player tp = new Player("Test", Color.black, Race.STARK);
		Store ts = Store.getStore();
		
		tp.addResources(0, 0, 0 - tp.getFood(), 0);
		assertFalse("Player doesn't have food to sell", ts.sellFood(tp, 1));
		
		System.out.println("Test 1 done.");
	}
	public void testStoreNotEnoughGold(){
		Player tp = new Player("Test", Color.black, Race.STARK);
		Store ts = Store.getStore();
		
		tp.addResources(0, 0, 50, 0);
		
		assertTrue("Player has more 34 food", tp.getFood() > 34);	//34 food because that is more gold than the store has.
		assertTrue("Store has 1000 or less gold", ts.getGold() <= 1000);
		assertFalse("Store does not have enough gold", ts.sellFood(tp, 50));
		
		System.out.println("Test 2 done.");
	}
	
	public void testSellFoodAllTrue(){
		Player tp = new Player("Test", Color.black, Race.STARK);
		Store ts = Store.getStore();
		
		tp.addResources(0, 0, 10, 0);
		int foodReq = 10;
		
		assertTrue("Player has enough food to sell", foodReq <= tp.getFood());
		assertTrue("Store has enough gold", foodReq*30 <= ts.getGold());
		assertTrue("Player sells food to store", ts.sellFood(tp, foodReq));
		
		System.out.println("Test 3 done.");
	}
	
	@AfterClass
	public static void cleanUp()
	{
		System.out.println("Done");
	}
}
