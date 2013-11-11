import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;

import control.Controller;
import control.Iterator;
import control.LandOffice;
import ViewScreens.Map;
import ViewScreens.Screen;
import Player.*;


public class Test2 extends Screen{
	private Controller controller;
	private Iterator iterator;
	private JButton pass;
	public Test2()
	{
		super();
		controller = Controller.getController();
		iterator = Iterator.getIterator();
		setLayout(new BorderLayout());
		add(Map.getMap(), BorderLayout.CENTER);
		
		if(iterator.getRound() > 2)
		{
			pass = new JButton("Pass");
			add(pass, BorderLayout.SOUTH);
		}
		
	}
	public static void main(String[] args) {
		Controller controller = new Controller();
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.getContentPane().setLayout(new java.awt.CardLayout());
		Iterator iterator = new Iterator(frame);
		controller.createPlayer("HELLO", Color.BLACK, Race.BARATHEON);
		controller.createPlayer("2", Color.YELLOW, Race.BARATHEON);
		controller.createPlayer("3", Color.RED, Race.BARATHEON);
		new Map();
		new LandOffice();
		frame.getContentPane().add(new Test2());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(new Point(100,0));
		frame.pack();
		frame.setVisible(true);
	}

}
