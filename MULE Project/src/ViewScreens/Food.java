/**
 * 
 */
package ViewScreens;

import javax.naming.InitialContext;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.event.ListDataListener;

import control.Store;

/**
 * @author naveen
 *
 */
public class Food extends StoreScreen {
		private int supply = getSupply();	//the amount of food present in the store
		
	public int getSupply()
	{
		return store.getFood();
	}
	
	/* (non-Javadoc)
	 * @see ViewScreens.StoreScreen#setUpQuantityBox()
	 */
	@Override
	void setUpQuantityBox() {
		//fill options with choices 0 - the supply available
		Integer[] options = new Integer[getSupply()];
		for(int i =0; i < supply; i++ )
			options[i]= i;
		
		selector = new JComboBox<Integer>(options);
	}

	/* (non-Javadoc)
	 * @see ViewScreens.StoreScreen#setUpPriceLabel()
	 */
	@Override
	void setUpPriceLabel() {
		price = new JLabel("Price: " + store.getFoodPrice());
	}

	/* (non-Javadoc)
	 * @see ViewScreens.StoreScreen#setUpInventoryLabel()
	 */
	@Override
	void setUpInventoryLabel() {
		storeInventory = new JLabel("Store Inventory: " + store.getFood());
	}

	/* (non-Javadoc)
	 * @see ViewScreens.StoreScreen#setUpResourceImage()
	 */
	@Override
	void setUpResourceImage() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see ViewScreens.StoreScreen#updateComponents()
	 */
	@Override
	void updateComponents() {
		removeAll();
		init();
	}

	/* (non-Javadoc)
	 * @see ViewScreens.StoreScreen#buyButtonPressed()
	 */
	@Override
	void buyButtonPressed() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see ViewScreens.StoreScreen#sellButtonPressed()
	 */
	@Override
	void sellButtonPressed() {
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
