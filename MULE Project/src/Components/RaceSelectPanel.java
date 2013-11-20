package Components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import control.GTools;
import Components.*;
import Player.*;
import Tile.*;
import ViewScreens.*;
import control.*;
import Game.*;

/**
 * Race Selection Panel that is a part of the Player Select Screen
 * 
 * @author Naveen Chandran
 * 
 */
public class RaceSelectPanel extends Screen
{

	private static final long serialVersionUID = 1L;
	private Race selected;
	private JButton btnGreyjoy, btnTargaryen, btnBaratheon, btnStark,
			btnLannister;
	private ArrayList<JButton> buttons = new ArrayList<>();
	private JLabel image;
	private HashMap<String, ImageIcon> map = new HashMap<>(); // allows calling images by their name
	private ButtonListener listener = new ButtonListener();
	private int width = super.width / 2, height = super.height / 2;

	/**
	 * This creates the panel where the races will be displayed on the create player class and reads what the user
	 * presses and sets that player's race to what they selected.
	 */
	public RaceSelectPanel()
	{
		super(Color.PINK);
		setLayout(null);
		setPreferredSize(new Dimension(width, height));
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		setBorder(BorderFactory.createTitledBorder(getBorder(),
				"Select a Race:", TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION));

		/*
		 * Button initialization
		 */
		btnGreyjoy = new JButton("Greyjoy");
		GTools.positionAndAdd(btnGreyjoy, .5, 1.0 / 8, this);
		buttons.add(btnGreyjoy);

		btnTargaryen = new JButton("Targaryen");
		GTools.positionAndAdd(btnTargaryen, 1.0 / 6, 3.0 / 8, this);
		buttons.add(btnTargaryen);

		btnBaratheon = new JButton("Baratheon");
		GTools.positionAndAdd(btnBaratheon, 5.0 / 6, 3.0 / 8, this);
		buttons.add(btnBaratheon);

		btnStark = new JButton("Stark");
		GTools.positionAndAdd(btnStark, 2.0 / 6, 7.0 / 8, this);
		buttons.add(btnStark);

		btnLannister = new JButton("Lannister");
		GTools.positionAndAdd(btnLannister, 4.0 / 6, 7.0 / 8, this);
		buttons.add(btnLannister);

		try
		{
			ImageIcon icon = new ImageIcon(
					new URL(
							"http://opinionessoftheworld.files.wordpress.com/2013/04/game-of-thrones-daenerys-dragon.jpg"));
			Image icon2 = icon.getImage().getScaledInstance(148, 148,
					Image.SCALE_FAST);
			icon = new ImageIcon(icon2);
			image = new JLabel(icon);
			GTools.positionAndAdd(image, .5, .5, this);
			;
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}

		/*
		 * Add action listener to all buttons
		 */

		for (JButton b : buttons)
		{
			b.addActionListener(listener);
		}
	}

	/**
	 * Compresses the ImageIcon to the preferred size.
	 * 
	 * @param icon
	 *            the icon to compress
	 * @return the compressed icon
	 */
	public ImageIcon compress(ImageIcon icon)
	{
		Image icon2 = icon.getImage().getScaledInstance(148, 148,
				Image.SCALE_FAST);
		return new ImageIcon(icon2);
	}

	public Race getSelectedRace()
	{
		return selected;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	/**
	 * Listener for race buttons
	 * 
	 * @author Naveen
	 * 
	 */
	private class ButtonListener implements ActionListener, Serializable
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton src = (JButton) e.getSource();
			setSelected(src); // sets the selected race
			changePicture(src); // changes the central image to the selected race
		}

		public void setSelected(JButton src)
		{
			if (src == btnGreyjoy)
				selected = Race.GREYJOY;
			else if (src == btnTargaryen)
				selected = Race.TARGARYEN;
			else if (src == btnBaratheon)
				selected = Race.BARATHEON;
			else if (src == btnStark)
				selected = Race.STARK;
			else if (src == btnLannister)
				selected = Race.LANNISTER;

			System.out.println("Seleted race was " + selected);
		}

		public void changePicture(JButton src)
		{
			if (src == btnGreyjoy)
				image.setIcon(compress(new ImageIcon("./Images/greyjoy.png")));
			else if (src == btnTargaryen)
				image.setIcon(compress(new ImageIcon("./Images/targaryen.png")));
			else if (src == btnBaratheon)
				image.setIcon(compress(new ImageIcon("./Images/baratheon.png")));
			else if (src == btnStark)
				image.setIcon(compress(new ImageIcon("./Images/stark.png")));
			else if (src == btnLannister)
				image.setIcon(compress(new ImageIcon("./Images/lannister.png")));
		}

	}

	public static void main(String[] args)
	{
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.getContentPane().setLayout(new java.awt.CardLayout());
		// Iterator iterator = new Iterator(frame);
		frame.getContentPane().add(new RaceSelectPanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(new Point(100, 0));
		frame.pack();
		frame.setVisible(true);
	}
}
