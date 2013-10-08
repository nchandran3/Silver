/**
 * 
 * @author Andrew Ford
 *
 */
public class Iterator {
	Menu_Screen ms = new Menu_Screen();
	Screen sc = new Screen();
	//local instance variables
	private static int turn = 1;
	private int numPlayers;
	
	//constructors
	public Iterator(){}
	public Iterator(int numPlayers){
		
		this.numPlayers = numPlayers;
		playerCreation();
	}
	public void playerCreation(){
		if(turn <= numPlayers){
			for(int i = turn; i<=numPlayers; i++){
				//create selection screen, 
			}
		}
	}
	
	public void simulateTurn(){
		//not implemented yet
	}
}
