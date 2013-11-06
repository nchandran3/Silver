package ViewScreens;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

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
	
	private StoreFrame()
	{
		setLayout(new BorderLayout());
		
		tabs = new JTabbedPane();
		tabs.addTab("Food", new Food());
		tabs.addTab("Mule", new Mule());
		
		//add the tabs (mule, food, dragonfire, ore)
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		pack();
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
}
