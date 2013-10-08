<<<<<<< HEAD

public class Iterator {
	private static int turn = 1;
	private int numPlayers;
	private static Iterator iterator;
	
	public Iterator(int numPlayers){
		this.numPlayers = numPlayers;
		choosePlayer();
		iterator = this;
	}
	public void choosePlayer(){
		if(turn <= numPlayers){
			for(int i = turn; i<=numPlayers; i++){
				
			}
		}
	}
	public void simulateTurn(){
		
	}
	
	public static Iterator getIterator()
	{
		return iterator;
	}
}
=======




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
>>>>>>> 0e8c9bf0032048cb8e83733fc575e79b9d7ca7d8
