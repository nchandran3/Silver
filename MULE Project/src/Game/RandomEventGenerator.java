package Game;

import java.awt.Color;
import ViewScreens.Announcement;
import java.util.ArrayList;
import java.util.Random;

import Player.*;
import control.*;

/**
 * This class handles the random events that pop up throughout the game.
 * 
 * @author Hamilton Greene
 * 
 */
public class RandomEventGenerator
{

	public RandomEventGenerator()
	{
	}

	/**
	 * There is a 27% chance that a random event will happen to any player, but no bad event may be inflicted upon the
	 * player in last.
	 * 
	 * @param the
	 *            current player
	 */
	public static void createRandomEvent(Player player)
	{
		// ArrayList<Player> playerList = Controller.getController().getPlayerOrder();
		Random rand = new Random();
		if (rand.nextInt(99) < 27)
		{
			int round = Iterator.getIterator().getRound();
			int m;
			if (round < 4)
			{
				m = 25;
			}
			else if (round < 8)
			{
				m = 50;
			}
			else if (round < 12)
			{
				m = 75;
			}
			else
			{
				m = 100;
			}

			// This should work. If problems in which the lowest ranked player receives
			// these effects, try using .equals instead of ==/!= operations
			int event = rand.nextInt(7);
			switch (event)
			{
				case 0:
					player.addResources(2, 0, 3, 0);// 2 dragonfire and 3 food
					new Announcement(
							"You have been rewarded 2 Dragonfire and 3 Food for winning a joust tournament!");
					System.out
							.println("You have been rewarded 2 Dragonfire and 3 Food for winning a joust tournament!");
					System.out.println(player.toString() + " now has "
							+ player.getDragonFire() + " dragonfire and "
							+ player.getFood() + " food");
					break;
				case 1:
					player.addResources(0, 0, 0, 2);// plus 2 ore
					new Announcement(
							"For giving a stranger shelter he gives you 2 Ore!");
					System.out
							.println("For giving a stranger shelter he gives you 2 Ore!");
					System.out.println(player.toString() + " now has "
							+ player.getOre() + " ore");
					break;
				case 2:
					player.addResources(0, 8 * m, 0, 0); // 8 * m gold
					new Announcement("You inhereted " + 8 * m
							+ " gold pieces from a recent battle!");
					System.out.println("You inhereted " + 8 * m
							+ " gold pieces from a recent battle!");
					System.out.println(player.toString() + " now has "
							+ player.getGold() + " gold");
					break;
				case 3:
					player.addResources(0, 2 * m, 0, 0); // 2m gold
					new Announcement(
							"You found a lost purse, with "
									+ 2
									* m
									+ " gold pieces, along the road and decide to keep it!");
					System.out
							.println("You found a lost purse, with "
									+ 2
									* m
									+ " gold pieces, along the road and decide to keep it!");
					System.out.println(player.toString() + " now has "
							+ player.getGold() + " gold");
					break;
				case 4:
					if (player != Controller.getController().getLastPlayer())
					{
						if (player.getGold() >= 4 * m)
						{ // -(4m) gold
							player.addResources(0, -4 * m, 0, 0);
							new Announcement("TAXES!\n" + "You owe " + 4 * m
									+ "gold pieces.");
						}
						else
						{
							player.setGold(0);
							new Announcement("TAXES!\n"
									+ "All your gold should cover it.");
						}
						System.out.println("TAXES!\n" + "You owe " + 4 * m
								+ "gold pieces.");
						System.out.println(player.toString() + " now has "
								+ player.getGold() + " gold");
					}
					break;
				case 5:
					if (player != Controller.getController().getLastPlayer())
					{
						player.addResources(0, 0, -player.getFood() / 2, 0);
						new Announcement(
								"A fire swept through your food storages. You were only able to save half the food");
						System.out
								.println("A fire swept through your food storages. You were only able to save half the food");
						System.out.println(player.toString() + " now has "
								+ player.getFood() + " food.");
					}
					break;
				case 6:
					if (player != Controller.getController().getLastPlayer())
					{
						if (player.getGold() >= 6 * m)
						{
							player.addResources(0, -6 * m, 0, 0);
							new Announcement(
									"Someone has broken into your vault and stolen "
											+ 6 * m + "gold pieces");
						}
						else
						{
							player.setGold(0);
							new Announcement(
									"Someone has broken into your vault and stolen all your gold.");
						}
						System.out
								.println("Someone has broken into your vault and stolen "
										+ 6 * m + "gold pieces");
						System.out.println(player.toString() + " now has "
								+ player.getGold() + " gold");
					}
					break;
					
				default:
					break;
			}
		}
	}
}
