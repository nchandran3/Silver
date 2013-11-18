import java.awt.Color;
import java.util.ArrayList;

import junit.framework.TestCase;
import org.junit.Test;

import Player.Player;
import Player.Race;
import control.Controller;


public class TestGetLastPlayer extends TestCase {
	@Test
	public void TestGetLastPlayer() {
		Controller controller = new Controller();
		Player p1 = new Player("Trey", Color.BLUE, Race.TARGARYEN);
		Player p2 = new Player("Naveen", Color.GREEN, Race.BARATHEON);
		Player p3 = new Player("Ford", Color.RED, Race.LANNISTER);
		
		ArrayList<Player> players = new ArrayList<Player>(3);
	
		p1.addResources(0, 5, 10, 15);
		p2.addResources(5, 10, 15, 20);
		p3.addResources(10, 15, 20, 25);
		
		players.add(p1);
		players.add(p2);
		players.add(p3);
		
		Player lowest = controller.getLastPlayer();
		assertEquals(p1, lowest);
	}
}
