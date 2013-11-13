package ViewScreens;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Player.Player;
import Player.Race;
import control.Store;
import control.Controller;

/**
 * 
 */

/**
 * @author Naveen Chandran
 *
 */
public final class StoreFrame extends JFrame {
	private JTabbedPane tabs;
	private StoreScreen mule, food, dragfire, ore;
	private GoldPanel goldPanel;
	Store store = Store.getStore();
	
	private StoreFrame()
	{
		super("Store");
		setLayout(new BorderLayout());
		
		init();
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		pack();
	}
	
	private void init()
	{
		initStores();
		goldPanel = new GoldPanel();
		add(goldPanel, BorderLayout.NORTH);
		initTabs();
	}
	
	private void initStores()
	{
		mule = new Mule();
		food = new Food();
		dragfire = new DragonFire();
		ore = new Ore();
	}

	private void initTabs()
	{
		tabs = new JTabbedPane();
	
		//add the tabs (mule, food, dragonfire, ore)
		tabs.addTab("Mule", mule);
		tabs.addTab("Food", food);
		tabs.addTab("DragonFire", dragfire);
		tabs.addTab("Ore", ore);
		
		add(tabs,BorderLayout.CENTER);
	}
	
	public void updateGold()
	{
		goldPanel.updateGold();
	}
	
	public void showStore()
	{
		setVisible(true);
	}
	
	public void hideStore()
	{
		setVisible(false);
	}
	
	public static StoreFrame frame()
	{
		return Holder.FRAME;
	}
	
	
	
	/**
	 * Singleton Holder class using Bill Pugh implementation
	 *
	 */
	private static class Holder
	{
		public static final StoreFrame FRAME = new StoreFrame(); 
	}

	 
	private class GoldPanel extends JPanel
	{
		private int money = store.getGold();
		JLabel gold = new JLabel("STORE GOLD: " + money);
		
		public GoldPanel()
		{
			this.setBackground(Color.BLACK);
			this.setPreferredSize(new Dimension(100, 50));
			gold.setForeground(Color.YELLOW);
			add(gold);
		}
		
		public void updateGold()
		{
			money = Store.getStore().getGold();
			gold.setText("STORE GOLD: " + money);
			revalidate();
		}
	}
	
	public static void main(String [] args)
	{
		Controller controller =new Controller();
		
		controller.setNumPlayers(2);
		controller.createPlayer("Who Cares", Color.RED, Race.BARATHEON);
		controller.createPlayer("Wzzz", Color.BLACK, Race.BARATHEON);
		controller.setCurrentPlayer(controller.getCurrentPlayer());
		StoreFrame frame = StoreFrame.frame();
		frame.showStore();
	}
}
