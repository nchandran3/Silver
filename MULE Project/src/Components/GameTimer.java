package Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import control.GTools;
import Components.*;
import Player.*;
import Tile.*;
import ViewScreens.*;
import control.*;
import Game.*;

/**
 * This class draws the Yellow bar that represents time left in a turn.
 * 
 * 
 */
public class GameTimer extends Screen implements ActionListener
{
	private int time;
	double y;
	private double rate;
	private int height = super.height;
	private int width = super.width / 64;
	private final double FLOW = .01;
	private static GameTimer timer;
	private Timer actionTimer;
	boolean paused;

	public GameTimer(int time)
	{
		super();
		setPreferredSize(new Dimension(width, height));
		setBackground(Color.BLACK);
		init(time);
		timer = this;
	}

	private void init(int time)
	{
		paused = false;
		y = 0;
		this.time = time;
		rate = (height / time * FLOW); // how much to take off the rectangle in
										// order to get blank at the end
		actionTimer = new Timer((int) (FLOW * 1000), this);
		actionTimer.setInitialDelay(3 * 1000); // wait three seconds before
												// starting the timer, to allow
												// reading annoucements.
		start();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.fillRect(0, (int) y, width, height);
		g.setColor(Color.RED);
		g.drawString("" + getTimeRemaining(), width / 8, 15);
	}

	public static GameTimer getTimer()
	{
		return timer;
	}

	public void reset(int time)
	{
		pause();
		init(time);
	}

	public void start()
	{
		actionTimer.start();
	}

	public void pause()
	{
		actionTimer.stop();
	}

	public int getElapsedTime()
	{
		return (int) (y / height * time);
	}

	public int getTimeRemaining()
	{
		int remaining = time - (int) (y / height * time);
		// System.out.println("Time remaining is " + remaining);
		return remaining;
	}

	public int getHeight()
	{
		return height;
	}

	public int getWidth()
	{
		return width;
	}

	/**
	 * Logic behind drawing the timer. If the timer runs out, it ends the
	 * current player's turn
	 */
	public void actionPerformed(ActionEvent e)
	{
		if (y < height)
		{
			y += rate;
			repaint();
		}
		else
		{
			actionTimer.stop();
			Controller.getController().endTurn();
		}
	}

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		GameTimer timer = new GameTimer(10);
		frame.add(timer);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
