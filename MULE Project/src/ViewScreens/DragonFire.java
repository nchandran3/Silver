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
 * @author Hamilton Greene
 *
 */
public class DragonFire extends StoreScreen {
		
	public int getSupply()
	{
		return store.getDragonFire();
	}
	
	/* (non-Javadoc)
	 * @see ViewScreens.StoreScreen#setUpQuantityBox()
	 */
	@Override
	void setUpQuantityBox() {
		//fill options with choices 0 - the supply available
		int supply = getSupply()+1;
		int owned = Controller.getController().getCurrentPlayer().getDragonFire();
		Integer[] options = new Integer[supply > owned ? supply : owned];
		for(int i =0; i < options.length; i++ )
			options[i]= i;
		
		selector = new JComboBox<Integer>(options);
	}
	
	@Override
	void setUpQuantityBoxLabel() {
		selectorLabel = new JLabel("Amount of DragonFire to Buy / Sell");
	}

	/* (non-Javadoc)
	 * @see ViewScreens.StoreScreen#setUpPriceLabel()
	 */
	@Override
	void setUpPriceLabel() {
		price = new JLabel("Price: " + store.getDragonFirePrice());
	}

	/* (non-Javadoc)
	 * @see ViewScreens.StoreScreen#setUpInventoryLabel()
	 */
	@Override
	void setUpInventoryLabel() {
		storeInventory = new JLabel("Store Inventory: " + store.getDragonFire());
	}

	/* (non-Javadoc)
	 * @see ViewScreens.StoreScreen#setUpResourceImage()
	 */
	@Override
	void setUpResourceImage() {
		resource_image = new JLabel(new ImageIcon("./Images/mountain.png"));
	}

	/* (non-Javadoc)
	 * @see ViewScreens.StoreScreen#updateComponents()
	 */
	@Override
	void updateComponents() {
		removeAll();
		init();
		repaint();
		StoreFrame.frame().updateGold();
	}

	/* (non-Javadoc)
	 * @see ViewScreens.StoreScreen#buyButtonPressed()
	 */
	@Override
	void buyButtonPressed() {
		store.buyDragonFire((int)selector.getSelectedItem());
		updateComponents();
	}

	/* (non-Javadoc)
	 * @see ViewScreens.StoreScreen#sellButtonPressed()
	 */
	@Override
	void sellButtonPressed() {
		store.sellDragonFire((int)selector.getSelectedItem());
		updateComponents();
		

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		new Controller();
		frame.add(new DragonFire());
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	

}