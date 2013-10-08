
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
		//hep
	}
	
	public static Iterator getIterator()
	{
		return iterator;
	}
}
