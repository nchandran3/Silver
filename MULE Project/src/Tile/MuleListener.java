package Tile;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import Components.*;
import Player.*;
import Tile.*;
import ViewScreens.*;
import control.*;
import Game.*;

/**
 * This listener is used when a player purchases a mule. It essentially takes the place of TileListener, thus changing
 * which path of logic Tile chooses when clicked.
 * 
 * @author Hamilton Greene
 * 
 */
public class MuleListener extends TileListener
{

	/**
	 * This should just change the background color of the tile your mouse is hovering over, so it's easier for the
	 * player to tell where it is.
	 */
	public void mouseOver(MouseEvent e)
	{
		JButton source = (JButton) e.getSource();
		// source.setBorder(new LineBorder(Color.GRAY, 10));
		source.setBackground(Color.BLACK);
	}

	public void mouseClicked(MouseEvent e)
	{
		Tile source = (Tile) e.getSource();
		Player currPlayer = Controller.getController().getCurrentPlayer();

		// If player owns property and player has a mule
		if (currPlayer.equals(source.getOwner()) && currPlayer.getMule() > -1)
		{
			System.out.println("We can see the half-ass!");

			// This places whatever mule the player has onto the property
			source.changeMule(currPlayer.getMule());

			// This will draw the mule on the property
			source.repaint();
		}
		currPlayer.setMule(-1);
		Tile.changeClickListener(new TileListener());

		// This sets the cursor back to normal.
		Controller.getController().resetDefaultCursor();
	}

}
