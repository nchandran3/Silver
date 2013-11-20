package Tile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Components.*;
import Player.*;
import Tile.*;
import ViewScreens.*;
import control.*;
import Game.*;

/**
 * This class will need to be updated after the demo...
 * 
 * @author Hamilton Greene
 * 
 */
public class Town extends Tile
{

	String directory;
	private boolean town;

	public Town()
	{
		town = true;
		this.directory = "./Images/town.png";
		setUp(directory);
		addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				buttonPressed();
			}
		});
	}

	@Override
	protected void buttonPressed()
	{
		Iterator.getIterator().switchScreen(new TownScreen());
	}

	public void resetClickListener()
	{
		addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				buttonPressed();
			}
		});
	}
}
