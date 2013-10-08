



public class Iterator {
	Menu_Screen ms = new Menu_Screen();
	Screen sc;
	//local instance variables
	private static int turn = 1;
	private int numPlayers;
	
	//constructor
	public Iterator(int numPlayers){
		
		this.numPlayers = numPlayers;
		choosePlayer();
	}
	public void choosePlayer(){
		if(turn <= numPlayers){
			for(int i = turn; i<=numPlayers; i++){
				//create selection screen, 
				sc = new Screen();
			}
		}
	}
	public void simulateTurn(){
		//not implemented yet
	}
}
