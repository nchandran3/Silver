import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Iterator {
	private static Iterator iterator;
	private JFrame frame;
	private CardLayout c;
	public Iterator(){iterator = this;}
	public Iterator(JFrame gameframe){
		iterator = this;
		frame = gameframe;
		c = (CardLayout)frame.getLayout();
	}
	public void switchScreen(){
		c.next(frame);
	}
	public void disposing(){
		c.removeLayoutComponent(frame);
	}
	public static Iterator getIterator()
	{
		return iterator;
	}
}



/*
private static int turn = 1;
private int numPlayers;
private static Iterator iterator;
private Player[] plarr;
//private final Point center = (0, 0);
private ArrayList<Integer> colors = new ArrayList<Integer>(6);

public Iterator(){iterator = this;}

public Iterator(int numPlayers){
	this.numPlayers = numPlayers;
	plarr = new Player[numPlayers];
	buildPlayers();
	for(int j = 0; j<colors.size(); j++){
		colors.add(j);
	}
	
	iterator = this;
	PlayerSelection ps = new PlayerSelection();
	for(int i = turn; i<=numPlayers; i++){
		String[] nP = ps.selectPlayer(colors);
	}
}
private void buildPlayers() {
	for(int i = 0; i < plarr.length; i++){
		
	}
	// TODO Auto-generated method stub
	
}
public void choosePlayer(String name, String color, String race, int[] resources){
	//plarr.add(new Player(name, color, race, null, CENTER));
	if(turn <= numPlayers){
		
	}
}
public void simulateTurn(){
	//hep
}
*/