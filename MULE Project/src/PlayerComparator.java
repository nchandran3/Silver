import java.util.Comparator;

/**
 * 
 */

/**
 * PlayerComparator for determining which player is ranked higher
 * @author Naveen Chandran
 *
 */
public class PlayerComparator implements Comparator<Player> {

	@Override
	public int compare(Player p1, Player p2) {
		int score1 = p1.getScore();
		int score2 = p2.getScore();
		
		if(score1 > score2)
			return 1;
		else
			return -1;
	}

	
}
