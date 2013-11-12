package ViewScreens;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Player.Player;
import control.Controller;
import control.Iterator;

public class StatusScreen extends Screen{
	private JPanel status = new JPanel();
	private PlayerStats ps;
	private JPanel[] panArr = new JPanel[Controller.getController().getNumPlayers()];
	
	public StatusScreen(){
		super(Color.BLACK);
		status.setLayout(new BoxLayout(status, BoxLayout.X_AXIS));
		setUpPlayers();
		setUpGeneral();
		add(status);
		
	}
	private void setUpPlayers(){
		int i = 0;
		Player[] plArr = (Player[]) Player.getPlArray().toArray();
		for(Player p: plArr){
			ps = new PlayerStats(p);
			panArr[i] = ps;
			status.add(ps);
			i++;
		}
	}
	private void setUpGeneral() {
		
		JPanel general = new JPanel();
		
		//general.setLayout(new GridLayout(0, 2));
		
		//String currPlayer = Controller.controller.getCurrentPlayer().toString();
		//JLabel current = new JLabel(currPlayer);
		//general.add(current);
		
		status.add(general);
	}
	public void setBorder(Player currPlayer){
		int i = 0;
		while(!panArr[i].equals(currPlayer))
			i++;
		panArr[i].setBorder(BorderFactory.createLineBorder(Color.yellow, 5));
	
	}
	public static void main (String [] args)
	{
		
		Controller controller = new Controller();
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.getContentPane().setLayout(new java.awt.CardLayout());
		Iterator iterator = new Iterator(frame);
		frame.getContentPane().add(new StatusScreen());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(new Point(100,0));
		frame.pack();
		frame.setVisible(true);
	}
}
