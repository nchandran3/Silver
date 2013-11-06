/**
 * 
 */
package ViewScreens;

import javax.naming.InitialContext;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.ListDataListener;

import control.Controller;
import control.Store;

/**
 * @author naveen
 *
 */
public class Food extends StoreScreen {
		
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
		Integer[] options = new Integer[getSupply()+1];
		for(int i =0; i <= store.getFood(); i++ )
			options[i]= i;
		
		selector = new JComboBox<Integer>(options);
	}
	
	@Override
	void setUpQuantityBoxLabel() {
		selectorLabel = new JLabel("Amount of Food to Buy / Sell");
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
		resource_image = new JLabel(new ImageIcon("./Images/plain.png"));
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
		store.buyFood((int)selector.getSelectedItem());
		updateComponents();
	}

	/* (non-Javadoc)
	 * @see ViewScreens.StoreScreen#sellButtonPressed()
	 */
	@Override
	void sellButtonPressed() {
		store.sellFood((int)selector.getSelectedItem());
		updateComponents();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		new Controller();
		frame.add(new Food());
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	

}
