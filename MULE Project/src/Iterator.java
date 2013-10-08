//import java.awt.Color;
import java.awt.*;
import java.util.ArrayList;


public class Iterator {
	private static int turn = 1;
	private int numPlayers;
	private static Iterator iterator;
	private Player[] plarr;
	private final Point CENTER = ("0", "0");
	private ArrayList<Integer> colors = new ArrayList<Integer>(6);
	
	public Iterator(int numPlayers){
		this.numPlayers = numPlayers;
		//choosePlayer(null, null, null, null, null);
		for(int j = 0; j<colors.size(); j++){
			colors.add(j);
		}
		plarr = new Player[numPlayers];
		iterator = this;
		PlayerSelect ps = new PlayerSelect();
		for(int i = turn; i<=numPlayers; i++){
			String[] nP = ps.selectPlayer(colors);
		}
	}
	public void choosePlayer(String name, String color, String race, int[] resources){
		//plarr.add(new Player(name, color, race, null, CENTER));
		if(turn <= numPlayers){
			
		}
	}
	public void simulateTurn(){
		//hep
	}
	
	public static Iterator getIterator()
	{
		return iterator;
	}
}