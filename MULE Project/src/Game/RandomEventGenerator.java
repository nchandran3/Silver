package Game;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import Player.*;
import control.*;



/**
 * This class handles the random events that pop up throughout the game.
 * @author Hamilton Greene
 *
 */
public class RandomEventGenerator {
	private Random rand;
	
	public RandomEventGenerator(){
		rand = new Random();
	}
	
	/**
	 * There is a 27% chance that a random event will happen to any player, but no bad event may 
	 * be inflicted upon the player in last. 
	 * @param the current player
	 */
	public void createRandomEvent(Player player){
//		ArrayList<Player> playerList = Controller.getController().getPlayerOrder();
		if(rand.nextInt(99)<27){
			int round = Iterator.getIterator().getRound();
			int m;
			if(round <4){
				m = 25;
			}else if(round<8){
				m = 50;
			}else if(round<12){
				m = 75;
			}else{
				m = 100;
			}
			
			//This should work.  If problems in which the lowest ranked player receives
			//these effects, try using .equals instead of ==/!= operations
			int event = rand.nextInt(7);
			switch(event) {
			case 0:	player.addResources(2,0,3,0);//2 dragonfire and 3 food 
				break;
			case 1: player.addResources(0,0,0,2);// plus 2 ore
				break;
			case 2: player.addResources(0, 8*m, 0, 0); // 8 * m gold
				break;
			case 3: player.addResources(0, 2*m, 0, 0); // 2m gold
				break;
			case 4: 
				if(player != Controller.getController().getLastPlayer()){
					if(player.getGold()>=4*m){ 			//-(4m) gold
						player.addResources(0,-4*m,0,0);
					}else{
						player.setGold(0);
					}
				}	
				break;
			case 5: 
				if(player != Controller.getController().getLastPlayer())
					player.addResources(0, 0, -player.getFood()/2, 0);
				break;
			case 6: 
				if(player != Controller.getController().getLastPlayer()){
					if(player.getGold()>=6*m){
						player.addResources(0, -6*m, 0, 0);
					}else{
						player.setGold(0);
					}
				}
				break;
			}	
		}
	}
	public static void main(String [] args){
		Controller testController = new Controller();
		Iterator testIterator = new Iterator();
		testController.getDifficulty();
		RandomEventGenerator test = new RandomEventGenerator();
		Player tester = new Player("michael", Color.blue, Race.GREYJOY);
		Player tester2 = new Player("bad bob", Color.red, Race.GREYJOY);
		tester2.addResources(0, -100, 0, 0);
		test.createRandomEvent(tester);
	}
}
