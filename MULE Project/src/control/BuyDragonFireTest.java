package control;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import Player.Player;
import Player.Race;

public class BuyDragonFireTest
{

	// Player has sufficient funds and asked for proper amount of dragonfire
	@Test
	public void testBuyDragonFireTrue()
	{
		Store store = Store.getStore();

		Controller controller = Controller.getController();
		controller.setNumPlayers(1);
		controller.createPlayer("Trey", Color.BLUE, Race.BARATHEON);

		controller.getCurrentPlayer().setGold(1000);
		Player player = controller.getCurrentPlayer();
		System.out.print("Current player: " + player.toString());

		// Amount of dragonfire allocated to store
		int amount = store.getDragonFire();

		boolean result = store.buyDragonFire(player, amount - 3);
		assertTrue("The transaction was succesful", result);
	}

	// Player has insufficient funds but asks for proper amount of dragonfire
	@Test
	public void testBuyDragonFireFalse()
	{
		Store store = Store.getStore();

		Controller controller = Controller.getController();
		controller.setNumPlayers(1);
		controller.createPlayer("Trey", Color.BLUE, Race.BARATHEON);

		controller.getCurrentPlayer().setGold(10);
		Player player = controller.getCurrentPlayer();

		int amount = store.getDragonFire();

		boolean result = store.buyDragonFire(player, amount - 3);
		assertFalse("The transaction failed", result);
	}

	// Player asks for more dragonfire than available
	@Test
	public void testBuyDragonFireFalse2()
	{
		Store store = Store.getStore();

		Controller controller = Controller.getController();
		controller.setNumPlayers(1);
		controller.createPlayer("Trey", Color.BLUE, Race.BARATHEON);

		Player player = controller.getCurrentPlayer();

		int amount = store.getDragonFire();

		boolean result = store.buyDragonFire(player, amount + 1);
		assertFalse("The transaction failed", result);
	}

}
