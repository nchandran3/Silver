package Tile;

import java.awt.Color;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.LineBorder;
import Components.*;
import Player.*;
import Tile.*;
import ViewScreens.*;
import control.*;
import Game.*;

/**
 * The main purpose of this class is to change the border of the tile when the mouse is hovered over it.
 * 
 * @author Hamilton Greene
 * 
 */
public class TileListener extends MouseAdapter
{
	private boolean buyLand;

	public TileListener()
	{
		buyLand = true;
	}

	public void mouseOver(MouseEvent e)
	{
		JButton source = (JButton) e.getSource();
		// source.setBorder(new LineBorder(Color.GRAY, 10));
		source.setBackground(Color.BLACK);
	}
	/**
	 * Keeps track of which tile was pressed.
	 * 
	 * @param Mouse event
	 */
	public void mouseClicked(MouseEvent e)
	{
		Tile source = (Tile) e.getSource();
		if (source.isEnabled() && !source.isTown())
		{
			if (Controller.getController().buyLand(source)) // returns true if the player has enough money to complete
															// the land transaction
			{
				Controller controller = Controller.getController();
				controller.endTurn();
			}

			else
			{
				new Announcement(
						"Transaction failed: Insufficient money or Owned Property");
			}
		}
	}

	/**
	 * Returns whether or not this listener is intended to buy land or not.
	 * 
	 * @return
	 */
	public boolean getBuyLand()
	{
		return buyLand;
	}

}
