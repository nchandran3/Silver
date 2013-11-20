package Game;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;
import control.GameSaveLoad;
import control.Iterator;

public class GameFrame extends JFrame
{

	/**
	 * Create the frame.
	 */
	private GameFrame()
	{
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new Listener());
		setBounds(100, 0, 450, 300);
		setTitle("D.R.A.G.O.N. The Game");
		setResizable(false);
	}

	private static class Holder
	{
		private static GameFrame INSTANCE = new GameFrame();
	}

	public static GameFrame getFrame()
	{
		return Holder.INSTANCE;
	}

	/*
	 * This listener class automatically saves upon exiting the frame.
	 */
	private class Listener extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			GameSaveLoad saver = new GameSaveLoad(Controller.getController(),
					Iterator.getIterator());
			saver.save("save.dat");
			System.exit(0);
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		new GameFrame();
	}
}
