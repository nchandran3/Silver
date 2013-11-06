package ViewScreens;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import control.*;
public class Ore extends StoreScreen {

	/**
	 * Needs to set up the quantity box to have options 0 - storeInventory of the resource
	 */
	void setUpQuantityBox() {
		Integer[] options = new Integer[Store.getStore().getOre()];
		for(int i =0; i <Store.getStore().getOre(); i++ )
			options[i]= i;
		
		selector = new JComboBox<Integer>(options);
		// TODO Auto-generated method stub
		
	}

	/**
	 * The price label should display "Price " + resource's price
	 */
	void setUpPriceLabel() {
		price = new JLabel("Price of Ore" + Store.getStore().getOrePrice());
		
		// TODO Auto-generated method stub
		
	}

	/**
	 * The storeInventory label should display the amount of resources remaining in the store of the given resource
	 */
	void setUpInventoryLabel() {
		storeInventory = new JLabel("There are: " + Store.getStore().getOre() + " remaining in the store.");
		// TODO Auto-generated method stub
		
	}

	/**
	 * Resource Image should be a picture of the current resource. The size should also be set.
	 */
	void setUpResourceImage() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Needs to update the following components (change labels / options):
	 * selector, price, storeInventory
	 */
	void updateComponents() {
		removeAll();
		init();
		// TODO Auto-generated method stub
		
	}

	/**
	 * mouseClicked method that should occur when the buy button is pressed
	 */
	void buyButtonPressed() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * mouseClicked method that should occur when the sell button is pressed
	 */
	void sellButtonPressed() {
		// TODO Auto-generated method stub
		
	}

}
