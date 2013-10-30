
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


public class TestTimer extends Screen implements ActionListener{
	private int time;
	double y;
	private double rate;
	private int height = super.height;
	private int width = super.width/64;
	private final double FLOW = .01;
	private Timer timer;
	boolean paused;
	
	public TestTimer(int time)
	{
		super();
		setPreferredSize(new Dimension(width,height));
		setBackground(Color.BLACK);
		
		paused = false;
		y=0;
		this.time = time;
		rate = (height/time*FLOW); //how much to take off the rectangle in order to get blank at the end
		timer = new Timer((int)(FLOW*1000), this);
		/*JButton button = new JButton ("Pause");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(!paused)
				{
					pause();
					System.out.println("The time remaining is " + getTimeRemaining());
					paused = true;
					
				}
				else
				{
					timer.start();
					paused = false;
				}
			}
		});
		GTools.positionAndAdd(button, .9, .2, this);*/
		start();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.fillRect(0, (int)y, width, height);
	}

	public void start()
	{
		timer.start();
	}
	public void pause()
	{
		timer.stop();
	}
	
	public int getElapsedTime()
	{
		return (int) (y/height * time);
	}
	public int getTimeRemaining()
	{
		return time - (int)(y/height * time);
	}
	
	/**
	 * Logic behind drawing the timer. If the timer runs out, it ends the current player's turn
	 */
	public void actionPerformed(ActionEvent e)
	{
		if(y< height)
		{
			y+= rate;
			repaint();
		}
		else
		{
			timer.stop();
			Controller.getController().endTurn();
			
		}
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		TestTimer timer = new TestTimer(100);
		frame.add(timer);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}

}
