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
	private static int time;
	private int startTime;
	private boolean running;
	private Rectangle rectangle;
	private int timeForTurn;
	
	public GameClock(int timeForTurn){
		time = (int) System.currentTimeMillis();
		rectangle = new Rectangle(10,10,20,timeForTurn * 2);
		this.timeForTurn = timeForTurn * 2;
	}
	/**
	 * Paints the yellow box representing the time left.
	 * 
	 */
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
		System.out.println("time up" +"\nIt took " + this.elapsedTime(startTime) + " seconds.");
	}
	
	/**
	 * Resets the rectangle representing the clock with the time given as the parameter.
	 * @param timeForTurn
	 */
	public void resetClock(int timeForTurn){
		rectangle.height = timeForTurn * 2;
		rectangle.y = 10;
		this.timeForTurn = timeForTurn * 2;
		repaint();
		startTime = (int) System.currentTimeMillis();
	}
	
	/**
	 * Resets the clock with the same amount of time as it was 
	 * originally given when the GameClock was created.
	 */
	public void resetClock(){
		rectangle.height = timeForTurn;
		rectangle.y = 10;
		repaint();
		startTime = (int) System.currentTimeMillis();
	}
	/**
	 * Starts clock, and sets running to true.
	 */
	public void startTime(){
		startTime = (int) System.currentTimeMillis();
		running = true;
	}
	/**
	 * 
	 * @return time returns elapsed time from beginning of game
	 */
	public int gameTime(){
		return elapsedTime(time);
	}
	
	/**
	 * Returns the amount of time that passed since startTime
	 * was called initially.
	 * @param time
	 * @return
	 */
	public int elapsedTime(int time){
		return (((int) System.currentTimeMillis() - time)/1000);
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
//		clock.resetClock(30);
//		clock.startCountdown();
		clock.resetClock();
		clock.startCountdown();

	}
	
	
}

