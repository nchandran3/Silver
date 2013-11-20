package ViewScreens;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

import control.*;
public class Ore extends StoreScreen {
	public int getSupply()
	{
		return store.getOre();
	}
	/**
	 * Needs to set up the quantity box to have options 0 - storeInventory of the resource
	 */
	void setUpQuantityBox() {
		int supply = getSupply()+1;
		int owned = Controller.getController().getCurrentPlayer().getOre();
		Integer[] options = new Integer[supply > owned ? supply : owned];
		for(int i =0; i < options.length; i++ )
			options[i]= i;
		
		selector = new JComboBox<Integer>(options);
	}

	/**
	 * The price label should display "Price " + resource's price
	 */
	void setUpPriceLabel() {
		price = new JLabel("Price: " + store.getOrePrice());
		
		// TODO Auto-generated method stub
		
	}

	/**
	 * The storeInventory label should display the amount of resources remaining in the store of the given resource
	 */
	void setUpInventoryLabel() {
		storeInventory = new JLabel("Store Inventory: " + store.getOre());
		// TODO Auto-generated method stub
		
	}

	/**
	 * Resource Image should be a picture of the current resource. The size should also be set.
	 */
	void setUpResourceImage() {
		resource_image = new JLabel(new ImageIcon("./Images/mountain.png"));
		resource_image.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	}

	/**
	 * Needs to update the following components (change labels / options):
	 * selector, price, storeInventory
	 */
	void updateComponents() {
		removeAll();
		init();
		repaint();
		StoreFrame.frame().updateGold();

		// TODO Auto-generated method stub
		
	}

	/**
	 * mouseClicked method that should occur when the buy button is pressed
	 */
	void buyButtonPressed() {
		store.buyOre(Controller.getController().getCurrentPlayer(), (int)selector.getSelectedItem());
		updateComponents();
	}

	/**
	 * mouseClicked method that should occur when the sell button is pressed
	 */
	void sellButtonPressed() {
		store.sellOre(Controller.getController().getCurrentPlayer(), (int)selector.getSelectedItem());
		updateComponents();
	}

	@Override
	void setUpQuantityBoxLabel() {
		selectorLabel = new JLabel("Amount of Ore to Buy / Sell");
		
	}

}
