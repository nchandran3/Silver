import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class keeps track of the game and turn time.
 * @author Hamilton Greene and Michael Carlson
 *
 */
public class GameClock extends JPanel{
	private static long time;
	private long startTime;
	private boolean running;
	private Rectangle rectangle;
	private int timeForTurn;
	
	public GameClock(int timeForTurn){
		time = System.currentTimeMillis();
		rectangle = new Rectangle(10,10,20,timeForTurn * 2);
		this.timeForTurn = timeForTurn * 2;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.yellow);
		g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
	}
	
	/**
	 * Reduces the yellow rectangle that represents the time left.
	 * @throws InterruptedException
	 */
	public void startCountdown() throws InterruptedException{
		for(int i = timeForTurn;i > 0; i--){
			rectangle.y++;
			rectangle.height--;
			repaint();
			Thread.sleep(500);
		}
//		Controller.controller.endTurn();
		System.out.println("time up");
	}
	
	/**
	 * Starts clock, and sets running to true.
	 */
	public void startTime(){
		startTime = System.currentTimeMillis();
		running = true;
	}
	/**
	 * 
	 * @return time returns elapsed time from beginning of game
	 */
	public long gameTime(){
		return elapsedTime(time);
	}
	
	/**
	 * Returns the amount of time that passed since startTime
	 * was called initially.
	 * @param time
	 * @return
	 */
	public long elapsedTime(long time){
		return System.currentTimeMillis() - time;
	}
	public static void main(String [] args) throws InterruptedException{
		GameClock clock = new GameClock(10);
		clock.startTime();
//		Thread.sleep(2000);
//		System.out.println(clock.elapsedTime(clock.startTime));
//		Thread.sleep(5000);
//		System.out.println(clock.gameTime());
		javax.swing.JFrame frame = new javax.swing.JFrame();
//		frame.setLayout(new BorderLayout());
		frame.setSize(300, 200);
//		frame.setResizable(false);
		frame.getContentPane().add(clock);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(new Point(100,0));
		frame.pack();
		frame.setVisible(true);
		clock.startCountdown();

	}
	
	
}

