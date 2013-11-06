package ViewScreens;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.GTools;
import control.Store;


/**
 * @author Naveen Chandran
 *	Abstract class for representing the layout of all panels in the Store Frame
 */
public abstract class StoreScreen extends JPanel{
	private static final long serialVersionUID = 1L;
	protected JLabel price, storeInventory;
	protected JButton buy, sell;
	protected JComboBox<Integer> selector;
	protected JLabel selectorLabel;
	protected JLabel resource_image;
	protected ButtonListener listener = new ButtonListener();
	protected Store store = Store.getStore();
	protected final int WIDTH = 1080;
	protected int HEIGHT = 720;
	
	public StoreScreen()
	{
		setLayout(null); 				//use GTools to add components
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setBackground(Color.GRAY);
		
		init();
	}
	
	/**
	 * Initialize all components when the class is created. Should only be called upon instantiation.
	 */
	protected void init()
	{
		setUpQuantityBoxLabel();
		setUpQuantityBox();
		setUpPriceLabel();
		setUpInventoryLabel();
		setUpResourceImage();
		
		buy = new JButton("Buy");
		sell = new JButton("Sell");
		
		buy.addMouseListener(listener);
		sell.addMouseListener(listener);
		
		addComponents();
	}
	
	/**
	 * Adds all visual components to the panel
	 */
	protected void addComponents()
	{
		GTools.positionAndAdd(resource_image, .5, .1, this);
		GTools.positionAndAdd(price, .2, .3, this);
		GTools.positionAndAdd(storeInventory, .8, .3, this);
		GTools.positionAndAdd(selectorLabel, .4, .6, this);
		GTools.positionAndAdd(selector, .6, .6, 1.75, 1, this);
		GTools.positionAndAdd(buy, .3, .95, this);
		GTools.positionAndAdd(sell, .7, .95, this);
	}
	
	
	/**
	 * Needs to set up the quantity box to have options 0 - storeInventory of the resource
	 */
	abstract void setUpQuantityBox();
	
	/**
	 * Needs to set up the quantity box label to say "#of resource to buy/sell"
	 */
	abstract void setUpQuantityBoxLabel();
	
	/**
	 * The price label should display "Price " + resource's price
	 */
	abstract void setUpPriceLabel();
	
	/**
	 * The storeInventory label should display the amount of resources remaining in the store of the given resource
	 */
	abstract void setUpInventoryLabel();
	
	/**
	 * Resource Image should be a picture of the current resource. The size should also be set.
	 */
	abstract void setUpResourceImage();
	
	/**
	 * Needs to update the following components (change labels / options):
	 * selector, price, storeInventory
	 */
	abstract void updateComponents();
	
	/**
	 * mouseClicked method that should occur when the buy button is pressed
	 */
	abstract void buyButtonPressed();
	
	/**
	 * mouseClicked method that should occur when the sell button is pressed
	 */
	abstract void sellButtonPressed();
	
	
	public int getWidth()
	{
		return WIDTH;
	}
	
	public int getHeight()
	{
		return HEIGHT;
	}
	
	/**
	 * Private  listener class that is attached to the buttons
	 */
	private class ButtonListener extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{
			JButton src = (JButton) e.getSource();
			
			if(src == buy)
			{
				buyButtonPressed();
			}
			
			else 
			{
				sellButtonPressed();
			}
		}
	}
	
	
//end StoreScreen class	
}
