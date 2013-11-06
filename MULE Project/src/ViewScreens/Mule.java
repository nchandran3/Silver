package ViewScreens;

import javax.naming.InitialContext;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.ListDataListener;

import control.Controller;
import control.GTools;
import control.Store;

/**
 * @author Hamilton Greene
 *
 */
public class Mule extends StoreScreen {
		
	public int getSupply()
	{
		return store.getMules();
	}
	
	/* (non-Javadoc)
	 * @see ViewScreens.StoreScreen#setUpQuantityBox()
	 */
	@Override
	void setUpQuantityBox() {
		//fill options with choices 0 - the supply available
		Integer[] options = new Integer[3];
		for(int i =0; i < 3; i++ )
			options[i]= i;
		
		selector = new JComboBox<Integer>(options);
	}
	
	@Override
	void setUpQuantityBoxLabel() {
		selectorLabel = new JLabel("<html>Type of mule you would like to purchase: <br/> 0 = Food, 1 = DragonFire, 2 = Ore</html>");
	}

	/* (non-Javadoc)
	 * @see ViewScreens.StoreScreen#setUpPriceLabel()
	 */
	@Override
	void setUpPriceLabel() {
		price = new JLabel("<html>Prices: Food Mule - 125<br/>	Energy Mule - 150<br/>	Ore Mule - 175</html>");
	}

	/* (non-Javadoc)
	 * @see ViewScreens.StoreScreen#setUpInventoryLabel()
	 */
	@Override
	void setUpInventoryLabel() {
		storeInventory = new JLabel("Store Inventory: " + store.getMules());
	}

	/* (non-Javadoc)
	 * @see ViewScreens.StoreScreen#setUpResourceImage()
	 */
	@Override
	void setUpResourceImage() {
		ImageIcon anImage = new ImageIcon("./Images/danny_sprite.png");
		anImage = GTools.compress(anImage, 50, 100);
		resource_image = new JLabel(anImage);
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
		store.buyMule((int)selector.getSelectedItem());
	}

	/* (non-Javadoc)
	 * @see ViewScreens.StoreScreen#sellButtonPressed()
	 */
	@Override
	void sellButtonPressed() {
		System.out.println("Sucks to suck bitch.");
		//store.sellDragonFire((int)selector.getSelectedItem());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		new Controller();
		frame.add(new Mule());
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	

}
