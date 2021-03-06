/**
 * 
 */
package ViewScreens;

import javax.naming.InitialContext;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListDataListener;

import control.Controller;
import control.Store;

/**
 * @author naveen
 * 
 */
public class Food extends StoreScreen
{

	public int getSupply()
	{
		return store.getFood();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ViewScreens.StoreScreen#setUpQuantityBox()
	 */
	@Override
	void setUpQuantityBox()
	{
		// fill options with choices 0 - the supply available
		int supply = getSupply() + 1;
		int owned = Controller.getController().getCurrentPlayer().getFood() + 1;
		Integer[] options = new Integer[supply > owned ? supply : owned];
		for (int i = 0; i < options.length; i++)
			options[i] = i;

		selector = new JComboBox<Integer>(options);
	}

	@Override
	void setUpQuantityBoxLabel()
	{
		selectorLabel = new JLabel("Amount of Food to Buy / Sell");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ViewScreens.StoreScreen#setUpPriceLabel()
	 */
	@Override
	void setUpPriceLabel()
	{
		price = new JLabel("Price: " + store.getFoodPrice());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ViewScreens.StoreScreen#setUpInventoryLabel()
	 */
	@Override
	void setUpInventoryLabel()
	{
		storeInventory = new JLabel("Store Inventory: " + store.getFood());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ViewScreens.StoreScreen#setUpResourceImage()
	 */
	@Override
	void setUpResourceImage()
	{
		resource_image = new JLabel(new ImageIcon("./Images/plain.png"));
		resource_image.setBorder(BorderFactory
				.createBevelBorder(BevelBorder.RAISED));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ViewScreens.StoreScreen#updateComponents()
	 */
	@Override
	void updateComponents()
	{
		removeAll();
		init();
		repaint();
		StoreFrame.frame().updateGold();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ViewScreens.StoreScreen#buyButtonPressed()
	 */
	@Override
	void buyButtonPressed()
	{
		store.buyFood(Controller.getController().getCurrentPlayer(),
				(int) selector.getSelectedItem());
		updateComponents();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ViewScreens.StoreScreen#sellButtonPressed()
	 */
	@Override
	void sellButtonPressed()
	{
		store.sellFood(Controller.getController().getCurrentPlayer(),
				(int) selector.getSelectedItem());
		updateComponents();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.add(new Food());
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
