import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Test;

import Player.Player;
import Player.Race;
import Tile.Mountain;
import Tile.River;
import Tile.Tile;
import control.Controller;
import control.Iterator;

/**
 * This class tests whether the getPlayerOrder
 * 
 * @author Hamilton Greene
 * 
 */
public class GetPlayerOrderTest
{
	/*
	 * Player score is calculated by: food + dragonFire + ore +
	 * gold*propertiesOwned The different Races start out with different amounts
	 * of gold: TARGARYEN = 600 GREYJOY = 1000 BARATHEON = 1000 STARK = 1000
	 * LANNISTER = 1600
	 */

	@Test
	public void testPlayerCreation1()
	{
		Controller controller = Controller.getController();
		controller.setNumPlayers(4);
		// This should set the player's resources to: 8 food, 4 dragonFire, 0
		// ore
		controller.setDifficulty(1);
		controller.createPlayer("Last", Color.BLACK, Race.BARATHEON); // This
																		// player
																		// should
																		// have
																		// a
																		// default
																		// gold
																		// value
																		// of
																		// 600
		ArrayList<Player> orderedPlayers = controller.setPlayerOrder();

		assertTrue("Number of players == 1:", controller.getNumPlayers() == 4);
		assertTrue("The created TARGARYEN has 1000 gold: ",
				orderedPlayers.get(0).getGold() == 1000);
		assertTrue("The player's food supply is 8: ", orderedPlayers.get(0)
				.getFood() == 8);
		assertTrue("The player's dragonFire supply is 4: ",
				orderedPlayers.get(0).getDragonFire() == 4);
		assertTrue("The player's ore supply is 0: ", orderedPlayers.get(0)
				.getOre() == 0);
	}

	@Test
	public void testGetPlayerOrder1()
	{
		Controller controller = Controller.getController();
		controller.setDifficulty(1);
		/*
		 * Because no player has any properties, they should all be viewed
		 * equally by the priority queue they're entered in in getPlayerOrder().
		 * 0 properties cancels out any gold advantages.
		 */
		controller.createPlayer("Third", Color.RED, Race.TARGARYEN);
		controller.createPlayer("Second", Color.YELLOW, Race.GREYJOY);
		controller.createPlayer("First", Color.GREEN, Race.LANNISTER);

		// Checks if players are added in order of creation if they all have the
		// same score
		ArrayList<Player> equalPlayers = controller.setPlayerOrder();

		// Ensures all players have a score of 0 due to property.
		assertTrue("Last player has score = 0: ", equalPlayers.get(0)
				.getScore() == 0);
		assertTrue("Third player has score = 0: ", equalPlayers.get(1)
				.getScore() == 0);
		assertTrue("Second player has score = 0: ", equalPlayers.get(2)
				.getScore() == 0);
		assertTrue("First player has score = 0: ", equalPlayers.get(3)
				.getScore() == 0);

		// Ensures all players were added to the PQ based on creation time
		// (stable)
		assertTrue("First player is named Last: ",
				"Last".equals(equalPlayers.get(0).toString()));
		assertTrue("Second player is named Third: ",
				"Third".equals(equalPlayers.get(1).toString()));
		assertTrue("Third player is named Second: ",
				"Second".equals(equalPlayers.get(2).toString()));
		assertTrue("Fourth player is named First: ",
				"First".equals(equalPlayers.get(3).toString()));

		// Make player scores unequal with respect to their names.
		equalPlayers.get(0).addProperty(new Mountain());
		equalPlayers.get(0).setGold(100);
		equalPlayers.get(1).addProperty(new Mountain());
		equalPlayers.get(1).setGold(200);
		equalPlayers.get(2).addProperty(new Mountain());
		equalPlayers.get(2).setGold(300);
		equalPlayers.get(3).addProperty(new Mountain());
		equalPlayers.get(3).setGold(400);

		// Ensures players have proper scores
		assertTrue("Last Player's score = 112: ", equalPlayers.get(0)
				.getScore() == 112);
		assertTrue("Third Player's score = 212: ", equalPlayers.get(1)
				.getScore() == 212);
		assertTrue("Second Player's score = 312: ", equalPlayers.get(2)
				.getScore() == 312);
		assertTrue("First Player's score = 412: ", equalPlayers.get(3)
				.getScore() == 412);

		// Ensures all players were ordered based on score
		ArrayList<Player> unequalPlayers = controller.setPlayerOrder();
		assertTrue("First player is named First: ",
				"First".equals(unequalPlayers.get(0).toString()));
		assertTrue("Second player is named Second: ",
				"Second".equals(unequalPlayers.get(1).toString()));
		assertTrue("Third player is named Third: ",
				"Third".equals(unequalPlayers.get(2).toString()));
		assertTrue("Last player is named Last: ",
				"Last".equals(unequalPlayers.get(3).toString()));
	}
}
