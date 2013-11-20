package ViewScreens;

import Components.*;
import Player.*;
import Tile.*;
import ViewScreens.*;
import control.*;
import Game.*;

/**
 * The Gamble class just calculates the amount of money each player gets after their turn based on how much time remains
 * in the game clock for their turn.
 * 
 * @author Andrew Ford
 * 
 */
public class Pub
{
	public Pub()
	{
		// set up picture
	}

	/**
	 * Gets the time left on the game clock and adds the corresponding amount to the players total amount of gold based
	 * on the time left.
	 * 
	 * @param time
	 */
	public void gamble(int time)
	{
		Player currPlayer = Controller.getController().getCurrentPlayer();
		// int random = (int )(Math.random() * 50 + 1);

		int moneyBonus = 0;
		moneyBonus = (int) (roundBonus() * (Math.random() * timeBonus(time)));
		if (moneyBonus > 250)
		{
			moneyBonus = 250;
		}
		currPlayer.addResources(0, moneyBonus, 0, 0);
		System.out.println("Player "
				+ Controller.getController().getCurrentPlayer()
				+ " gambled and won " + moneyBonus + "!");
	}

	/**
	 * The Time bonus is computed by: 37-50 seconds left : 200 25 - 37 seconds left : 150 12 - 25 seconds left : 100 0 -
	 * 12 seconds left : 50
	 * 
	 * @param time
	 * @return time bonus
	 */
	private int timeBonus(int time)
	{
		if (time > 37)
		{
			return 200;
		}
		else if (time > 25)
		{
			return 150;
		}
		else if (time > 12)
		{
			return 100;
		}
		return 50;
	}

	/**
	 * Calculates the round bonus based on the current round because based on your round it is important to get more
	 * money later on in the game based on how the game changes and the players need more money.
	 * 
	 * @return int round bonus
	 */
	public int roundBonus()
	{
		int round = Iterator.getIterator().getRound();
		if (round < 4)
		{
			return 50;
		}
		else if (round < 8)
		{
			return 100;
		}
		else if (round < 12)
		{
			return 150;
		}
		return 200;
	}
}
