/**
 * This class keeps track of the game and turn time.
 * @author Hamilton Greene
 *
 */
public class GameClock {
	private static long time;
	private long startTime;
	private boolean running;
	
	public GameClock(){
		time = System.currentTimeMillis();
	}
	
	/**
	 * Starts tracking for a player's turn, starting the time
	 * then returning false once the player's turn is over.
	 * @return
	 * @throws InterruptedException
	 */
	public boolean startTurn() throws InterruptedException{
		if(!running){
			startTime();
		}
		while(elapsedTime(startTime)<30000){
			wait(10,1000);
		}
		running=false;
		return false;
	}
	
	/**
	 * Starts clock.
	 */
	public void startTime(){
		startTime = System.currentTimeMillis();
		running = true;
	}
	
	public long gameEnd(){
		return elapsedTime(time);
	}
	
	/**
	 * Returns the amount of time that passed since startTime
	 * was called
	 * @param time
	 * @return
	 */
	public long elapsedTime(long time){
		return System.currentTimeMillis() - time;
	}
}
