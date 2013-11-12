package ViewScreens;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.Controller;
import control.Iterator;
import Player.Player;

public class PlayerStats extends JPanel{
	private JPanel playerPanel = new JPanel();

	public PlayerStats(){
		
	}
	public PlayerStats(Player p){
		
		GridLayout gLay = new GridLayout(0,2);
		playerPanel.setLayout(gLay);
		
		playerPanel.add(new JLabel("Player:"));
		playerPanel.add(new JLabel(p.toString()));
		playerPanel.add(new JLabel("Gold"));
		playerPanel.add(new JLabel(Integer.toString(p.getGold())));
		playerPanel.add(new JLabel("Ore:"));
		playerPanel.add(new JLabel(Integer.toString(p.getOre())));
		playerPanel.add(new JLabel("DragonFire:"));
		playerPanel.add(new JLabel(Integer.toString(p.getDragonFire())));
		playerPanel.add(new JLabel("Food:"));
		playerPanel.add(new JLabel(Integer.toString(p.getFood())));
		playerPanel.add(new JLabel("Score:"));
		playerPanel.add(new JLabel(Integer.toString(p.getScore())));
		playerPanel.setBorder(BorderFactory.createLineBorder(Color.black, 5));

	}
	public JPanel getPlayerBox(){
		return playerPanel;
	}
	public static void main (String [] args)
	{
		
		Controller controller = new Controller();
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.getContentPane().setLayout(new java.awt.CardLayout());
		Iterator iterator = new Iterator(frame);
		frame.getContentPane().add(new PlayerStats());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(new Point(100,0));
		frame.pack();
		frame.setVisible(true);
	}
}
