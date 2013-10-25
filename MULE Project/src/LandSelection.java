import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class LandSelection extends Screen {
	private JButton pass;
	private Iterator iterator;
	private Controller controller;
	public LandSelection() {
		super();
		
		controller = Controller.getController();
		iterator = Iterator.getIterator();
		setLayout(new BorderLayout());
		add(Map.getMap(), BorderLayout.CENTER);
		if(iterator.getRound() > 2) {
			pass = new JButton("Pass");
			pass.addMouseListener(new PassListener());
		}
	}
	
	
	private class PassListener extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{
			if(controller.incrementCurrentPlayer() == null)
				iterator.switchScreen(new Menu_Screen());
			new Announcement("Current player is " + controller.getCurrentPlayer());
		}
	}
	
	public static void main (String [] args)
	{
		Controller controller = new Controller();
		Map map = new Map();
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.getContentPane().setLayout(new java.awt.CardLayout());
		Iterator iterator = new Iterator(frame);
		frame.getContentPane().add(new LandSelection());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(new Point(100,0));
		frame.pack();
		frame.setVisible(true);
	}
}
