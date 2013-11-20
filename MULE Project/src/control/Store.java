package control;

import Player.*;

/**
 * The store allows players to purchase certain supplies with their hard-earned
 * gold.
 * 
 * @author Hamilton Greene
 * 
 */

public class Store
{
	private int dragonFire;
	private int food;
	private int gold;
	private int ore;
	private int dragonFirePrice;
	private int foodPrice;
	private int orePrice;
	private int mule;

	private Store()
	{
		setUp();
	}

	/**
	 * Stocks the store according to the chosen difficulty.
	 */
	private void setUp()
	{
		if (Controller.getController().getDifficulty() == 1)
		{
			food = 16;
			dragonFire = 16;
			ore = 0;
			mule = 25;
		}
		else
		{
			food = 8;
			dragonFire = 8;
			ore = 8;
			mule = 14;
		}
		gold = 1000;
		setFoodPrice(30);
		setDragonFirePrice(25);
		setOrePrice(50);
	}

	private static class Holder
	{
		public static final Store STORE = new Store();
	}

	public static Store getStore()
	{
		return Holder.STORE;
	}

	// *************************************************************************
	// SETTERS
	// *************************************************************************

	public void setDragonFirePrice(int price)
	{
		dragonFirePrice = price;
	}

	public void setFoodPrice(int price)
	{
		foodPrice = price;
	}

	public void setOrePrice(int price)
	{
		orePrice = price;
	}

	// *************************************************************************
	// GETTERS
	// *************************************************************************

	public int getDragonFire()
	{
		return dragonFire;
	}

	public int getDragonFirePrice()
	{
		return dragonFirePrice;
	}

	public int getFood()
	{
		return food;
	}

	public int getFoodPrice()
	{
		return foodPrice;
	}

	public int getGold()
	{
		return gold;
	}

	public int getOre()
	{
		return ore;
	}

	public int getOrePrice()
	{
		return orePrice;
	}

	public int getMules()
	{
		return mule;
	}

	// **********************************************************************************
	// TRANSACTIONS
	// **********************************************************************************

	/**
	 * Checks validity of player's food transaction request.
	 * 
	 * @param foodReq
	 *            number of food units desired
	 * @return
	 */
	public boolean buyFood(Player curr_player, int foodReq)
	{
		if (foodReq <= food)
		{
			if (foodReq * 30 <= curr_player.getGold())
			{
				curr_player.addResources(0, -30 * foodReq, foodReq, 0);
				food -= foodReq;
				gold += foodReq * 30;
				return true;
			}
		}
		return false;
	}

	public boolean sellFood(Player curr_player, int foodReq)
	{
		if (foodReq <= curr_player.getFood())
		{
			if (foodReq * 30 <= gold)
			{
				curr_player.addResources(0, 30 * foodReq, -foodReq, 0);
				food += foodReq;
				gold -= foodReq * 30;
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks validity of player's dragonFire transaction request
	 * 
	 * @param dragonReq
	 *            number of dragonFire units desired
	 * @return
	 */
	public boolean buyDragonFire(Player curr_player, int dragonReq)
	{
		Player player = Controller.getController().getCurrentPlayer();
		if (dragonReq <= dragonFire)
		{
			if (dragonReq * 25 <= player.getGold())
			{
				player.addResources(dragonReq, -25 * dragonReq, 0, 0);
				dragonFire -= dragonReq;
				gold += dragonReq * 25;
				return true;
			}
		}
		return false;
	}

	public boolean sellDragonFire(Player curr_player, int dragonReq)
	{
		Player player = Controller.getController().getCurrentPlayer();
		if (dragonReq <= player.getDragonFire())
		{
			if (dragonReq * 25 <= gold)
			{
				player.addResources(-dragonReq, 25 * dragonReq, 0, 0);
				dragonFire += dragonReq;
				gold -= dragonReq * 25;
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks validity of player's ore transaction request
	 * 
	 * @param oreReq
	 *            number of ore units required
	 * @return
	 */
	public boolean buyOre(Player curr_player, int oreReq)
	{
		Player player = Controller.getController().getCurrentPlayer();
		if (oreReq <= ore)
		{
			if (oreReq * 50 <= player.getGold())
			{
				player.addResources(0, -50 * oreReq, 0, oreReq);
				ore -= oreReq;
				gold += oreReq * 50;
				return true;
			}
		}
		return false;
	}

	public boolean sellOre(Player curr_player, int oreReq)
	{
		Player player = Controller.getController().getCurrentPlayer();
		if (oreReq <= player.getOre())
		{
			if (oreReq * 50 <= gold)
			{
				player.addResources(0, 50 * oreReq, 0, -oreReq);
				ore += oreReq;
				gold -= oreReq * 50;
				return true;
			}
		}
		return false;
	}

	/**
	 * This method allows you to buy a mule. It checks the player's eligibility
	 * to perform such a feat.
	 * 
	 * @param muleReq
	 *            -> Type of mule you want to buy 0 = food, 1 = energy, 2 = ore
	 * @return
	 */
	public boolean buyMule(Player curr_player, int muleType)
	{
		Player player = Controller.getController().getCurrentPlayer();

		int fee = 125 + 25 * muleType; // food costs 125, energy costs 150, and
										// ore costs 175
		switch (muleType)
		{
			case 0:
				fee = 125;
				break;
			case 1:
				fee = 150;
				break;
			case 2:
				fee = 175;
				break;
		}
		System.out.println("The fee is " + fee);
		System.out.println("Mules " + mule + "\t Player has mule: "
				+ player.getMule());
		// If Store has a mule to sell, player doesn't currently have a mule,
		// and
		// the player can afford the selected mule, a mule shall be granted unto
		// him.
		if (mule > 0 && player.getMule() < 0 && fee > 0)
		{
			// If the player can afford the fee
			if (fee <= player.getGold())
			{
				player.addResources(0, -(fee), 0, 0);
				mule--;
				System.out.println("This many mules: " + mule);
				gold += fee;
				System.out.println("New Store balance: " + gold);
				player.setMule(muleType);
				return true;
			}
		}
		return false;
	}
}
