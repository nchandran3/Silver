/**
 * This class keeps track of turn time.
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
	
	public void startTime(){
		startTime = System.currentTimeMillis();
		running = true;
	}
	
	public long elapsedTime(long time){
		return System.currentTimeMillis() - time;
	}
}
