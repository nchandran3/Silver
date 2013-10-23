import java.util.Random;



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
	 * Rolls for a random event for the current player and dishes out the consequences 
	 */
	public void createRandomEvent(){
		Player player = Iterator.getIterator().getCurrPlayer();
		if(player!=Controller.getController().getLastPlayer()){
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
				
				int event = rand.nextInt(7);
				switch(event) {
				case 0:	player.addResources(2,0,3,0);
					break;
				case 1: player.addResources(0,0,0,2);
					break;
				case 2: player.addResources(0, 8*m, 0, 0);
					break;
				case 3: player.addResources(0, 2*m, 0, 0);
					break;
				case 4: player.addResources(0,-4*m,0,0);
					break;
				case 5: player.addResources(0, 0, -player.getFood()/2, 0);
					break;
				case 6: player.addResources(0, -6*m, 0, 0);
					break;
				}
			}
		}
	}
}
