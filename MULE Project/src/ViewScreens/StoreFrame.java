package ViewScreens;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import control.Store;

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
		add(new GoldPanel(), BorderLayout.NORTH);
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
	
	
	public static StoreFrame frame()
	{
		return Holder.FRAME;
	}
	
	public void show()
	{
		setVisible(true);
	}
	
	public void hide()
	{
		setVisible(false);
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
		public GoldPanel()
		{
			this.setBackground(Color.BLACK);
			this.setPreferredSize(new Dimension(100, 50));
			this.add(new JLabel("GOLD : " + Store.getStore().getGold()));
		}
	}
	
	public static void main(String [] args)
	{
		StoreFrame frame = new StoreFrame();
		frame.show();
	}
}