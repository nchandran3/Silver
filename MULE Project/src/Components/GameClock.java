package Components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import Components.*;
import Player.*;
import Tile.*;
import ViewScreens.*;
import control.*;
import Game.*;

/**
 * This class keeps track of the game and turn time.
 * 
 * @author Hamilton Greene and Michael Carlson
 * 
 */
public class GameClock extends JPanel
{
	public static GameClock clock;
	private static int time;
	private int startTime;
	private boolean running;
	private Rectangle rectangle;
	private int timeForTurn;
	private int totalTime;

	double y;
	private double rate;
	private int height = 800;
	private final double FLOW = .1;
	private Timer timer;
	private int time2, currTime, remainingTime;

	public GameClock(int timeForTurn)
	{
		clock = this;
		time = (int) System.currentTimeMillis();
		startTime = (int) System.currentTimeMillis();
		rectangle = new Rectangle(10, 10, 20, timeForTurn * 2);
		this.timeForTurn = timeForTurn * 2;
		totalTime = startTime + (timeForTurn * 1000);
		setPreferredSize(new Dimension(100, 100));
	}

	public GameClock()
	{
		this(10);
	}

	/**
	 * Paints the yellow box representing the time left.
	 * 
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, getWidth(), getHeight() - rectangle.y * totalTime);
	}

	/**
	 * Reduces the yellow rectangle that represents the time left.
	 * 
	 * @throws InterruptedException
	 */
	public void startCountdown() throws InterruptedException
	{
		for (int i = timeForTurn; i > 0; i--)
		{
			rectangle.y++;
			rectangle.height--;
			repaint();
			Thread.sleep(500);
		}
		Controller.getController().endTurn();
		System.out.println("Time up!!!" + "\nIt took "
				+ this.elapsedTime(startTime) + " seconds.");
	}

	/**
	 * Resets the rectangle representing the clock with the time given as the parameter.
	 * 
	 * @param timeForTurn
	 */
	public void resetClock(int timeForTurn)
	{
		rectangle.height = timeForTurn * 2;
		rectangle.y = 10;
		this.timeForTurn = timeForTurn * 2;
		repaint();
		this.startTime();
		totalTime = startTime + (timeForTurn * 1000);
	}

	/**
	 * Resets the clock with the same amount of time as it was originally given when the GameClock was created.
	 */
	public void resetClock()
	{
		rectangle.height = timeForTurn;
		rectangle.y = 10;
		repaint();
		this.startTime();
		totalTime = startTime + (timeForTurn * 1000);
	}

	/**
	 * Starts clock, and sets running to true.
	 */
	public void startTime()
	{
		startTime = (int) System.currentTimeMillis();
		running = true;
	}

	/**
	 * 
	 * @returns elapsed time from beginning of game
	 */
	public int gameTime()
	{
		return elapsedTime(time);
	}

	/**
	 * Returns the amount of time that passed since startTime or resetClock was called initially.
	 * 
	 * @return the time elapsed
	 */
	public int elapsedTime()
	{
		return (((int) System.currentTimeMillis() - startTime) / 1000);
	}

	/**
	 * returns the elapsed time from the time given as a parameter.
	 * 
	 * @param time
	 * @return elapsed time
	 */
	public int elapsedTime(int time)
	{
		return (((int) System.currentTimeMillis() - time) / 1000);
	}

	/**
	 * Returns an int representing the amount of time the player had left in their turn when it was ended.
	 * 
	 * @return time left in turn
	 */
	public int timeLeft()
	{
		return ((totalTime - (int) System.currentTimeMillis()) / 1000);
	}

	public GameClock getClock()
	{
		return clock;
	}

	public static void main(String[] args) throws InterruptedException
	{
		GameClock clock = new GameClock(10);
		clock.startTime();
		Thread.sleep(2000);
		System.out.println(clock.elapsedTime());
		Thread.sleep(5000);
		System.out.println(clock.elapsedTime());
		System.out.println(clock.timeLeft());
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setSize(300, 200);
		frame.getContentPane().add(clock);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(new Point(100, 0));
		frame.pack();
		frame.setVisible(true);
		// clock.startCountdown();
		// clock.resetClock();
		clock.startCountdown();

	}

}
