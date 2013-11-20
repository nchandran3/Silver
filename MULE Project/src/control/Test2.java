package control;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;

import ViewScreens.Map;
import ViewScreens.Screen;
import Player.*;

public class Test2 extends Screen
{
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

		if (iterator.getRound() > 2)
		{
			pass = new JButton("Pass");
			add(pass, BorderLayout.SOUTH);
		}

	}

	public static void main(String[] args)
	{
		GameSaveLoad test = GameSaveLoad.getFromFile("test.dat");
		// System.out.println(test.test);
		// Controller.controller = test.getController();
		Controller.setController(test.getController());
		int tester = Controller.getController().getDifficulty();
		System.out.print(tester);
	}

}
