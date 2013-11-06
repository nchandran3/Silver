
/**
 * The store allows players to purchase certain supplies with their hard-earned gold.
 * @author Hamilton Greene
 *
 */

public class Store {
	private static int dragonFire;
	private static int food;
	private static int gold;
	private static int ore;
	private static int mule;
	
	public Store(){
		setUp();
	}
	
	/**
	 * Stocks the store according to the chosen difficulty.
	 */
	private void setUp(){
		if(Controller.getController().getDifficulty()==1){
			food = 16;
			dragonFire = 16;
			ore = 0;
			mule = 25;
		}else{
			food = 8;
			dragonFire = 8;
			ore = 8;
			mule = 14;
		}
	}
	
	/**
	 * Checks validity of player's food transaction request.
	 * @param foodReq number of food units desired
	 * @return
	 */
	public boolean buyFood(int foodReq){
		Player player =Controller.getController().getCurrentPlayer();
		if(foodReq<=food){
			if(foodReq*30<= player.getGold()){
				player.addResources(0, -30*foodReq, foodReq, 0);
				food-=foodReq;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks validity of player's dragonFire transaction request
	 * @param dragonReq number of dragonFire units desired
	 * @return
	 */
	public boolean buyDragonFire(int dragonReq){
		Player player = Controller.getController().getCurrentPlayer();
		if(dragonReq<=dragonFire){
			if(dragonReq*25<= player.getGold()){
				player.addResources(dragonReq, -25*dragonReq, 0, 0);
				dragonFire-=dragonReq;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks validity of player's ore transaction request
	 * @param oreReq number of ore units required
	 * @return
	 */
	public boolean buyOre(int oreReq){
		Player player = Controller.getController().getCurrentPlayer();
		if(oreReq<=ore){
			if(oreReq*50<= player.getGold()){
				player.addResources(0, -50*oreReq, 0, oreReq);
				ore-=oreReq;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method allows you to buy a mule.  It checks the player's eligibility to perform such
	 * a feat.
	 * @param muleReq -> Type of mule you want to buy
	 * 0 = food, 1 = energy, 2 = ore
	 * @return
	 */
	public boolean buyMule(int muleType){
		Player player = Controller.getController().getCurrentPlayer();
		
		int fee = 0;
		switch(muleType){
		case 0: fee = 25;
			break;
		case 1: fee = 50;
			break;
		case 2: fee = 75;
			break;
		}
		
		if(mule>0 && player.getMule()<0 && fee > 0){
			if(100+fee<= player.getGold()){
				player.addResources(0, -(100+fee), 0, 0);
				mule--;
				player.setMule(muleType);
				return true;
			}
		}
		return false;
	}
}
