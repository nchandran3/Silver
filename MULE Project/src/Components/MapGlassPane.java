package Components;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Components.*;
import Player.*;
import Tile.*;
import ViewScreens.*;
import control.*;
import Game.*;

/**
 * Class for drawing the player sprite across the map. Will be overlaid and transparent over map.
 * @author Michael
 *
 */
public class MapGlassPane extends Screen implements KeyListener {
	private ImageIcon sprite;
	private Iterator iterator;
	private Player currPlayer;
	private int ind;
	private Point location;
	private int image_width, image_height;
	private Controller controller;
	
	public MapGlassPane(){
		
		init();		//initialize all variables
		
		/*
		 * set up Glass Pane
		 */
		this.setOpaque(false);
		this.setVisible(true);
		
		this.setFocusable(true);
		requestFocus();
		
		 
	}

	public void init()
	{
		controller = Controller.getController();
		iterator = Iterator.getIterator();
		
		currPlayer = controller.getCurrentPlayer();
		sprite = currPlayer.getImage();
		ind = controller.getCurrentPlayerIndex();
		location = new Point(getWidth()/2, getHeight()/2); //begin player in the center of the screen
		currPlayer.move(location);
		image_width = (int) (getWidth()*.05);
		image_height = (int) (getHeight()*.05);
	}
	
	
	/**
	 * Paints the player sprite on the map
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(sprite.getImage(), location.x - image_width/2, location.y - image_height/2,
				image_width, image_height, null); //center the image drawn
		
	}
	
	
	/**
	 * Listener method to determine what to do on a Key Press
	 */
	public void keyPressed(KeyEvent e) {
		
		doKeyAction(e);
		repaint();
		
	}

	
	public void doKeyAction(KeyEvent e)
	{
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_DOWN){
			location.y += 2;
		}
		else if(code == KeyEvent.VK_UP){
			location.y -= 2;
		}
		else if(code == KeyEvent.VK_LEFT){
			location.x += 2;
		}
		else if(code == KeyEvent.VK_RIGHT){
			location.x=- 2;
		}
		if (code == KeyEvent.VK_SPACE)
		{
			selection();
		}
		currPlayer.move(location);	//update player location
		
		repaint();
	}
	/**
	 * Lets the MapGlassPane know what tile the player selected.
	 */
	public void selection()
	{
		Tile result = controller.getTileFromCoord(location);
		result.setOwner(currPlayer);
		//if(ind != controller.getNumPlayers())
			//controller.setPlayerIndex(ind+1);
		//controller.buyLand(result);
		
			
	}
	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new JButton("hello"));
		MapGlassPane gp = new MapGlassPane();
		JPanel glass = (JPanel) frame.getGlassPane();
		glass.setVisible(true);
		glass.add(gp);
		gp.requestFocus();
		frame.pack();
		frame.setVisible(true);
	}

}
