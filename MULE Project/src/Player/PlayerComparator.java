package Player;

import java.util.Comparator;

/**
 * 
 */

/**
 * PlayerComparator for determining which player is ranked higher
 * 
 * @author Naveen Chandran
 * 
 */
public class PlayerComparator implements Comparator<Player>
{

	public final static PlayerComparator INSTANCE = new PlayerComparator();

	private PlayerComparator()
	{
	}
	/**
	 * This method compares two players by their current score and compares them to show
	 * you which player is in the lead.
	 * 
	 * @param Player p1, p2
	 * @return integer (1 if p1 is winning, -1 if player 2 is winning)
	 */
	@Override
	public int compare(Player p1, Player p2)
	{
		int score1 = p1.getScore();
		int score2 = p2.getScore();

		if (score1 > score2)
			return 1;
		else
			return -1;
	}

}
