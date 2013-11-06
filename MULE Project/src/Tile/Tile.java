package Tile;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import Components.*;
import Player.*;
import Tile.*;
import ViewScreens.*;
import control.*;
import Game.*;
/**
 * This class represents a Tile on the Map. It stores the tileType(int), owner(Player), and isOwned(boolean).
 * There are 6 different types of tiles that are given in the constructor. The owner is set with the TileSold
 * method once the player has chosen a new tile in the GUI of the game.
 * @author Michael Carlson
 *
 */
public abstract class Tile extends JButton{

	ImageIcon img;
	protected Player owner;
	protected boolean isOwned;
	protected boolean town;
	protected String tileName;
	protected String directory;
	protected int x;
	protected int y;
	protected JButton button;
	protected static TileListener tListener;
	protected int muleType; // -1 = non-existent, 0 = food, 1 = DragonFire, 2 = Ore
	
	/*
	 * Essentially creates a new JPanel and then fills it with a JButton that reacts to 
	 * mouse clicks.
	 */
	public Tile(){
		super();
		town = false;
		//setLayout(new BorderLayout());
		muleType = -1;
		setFocusable(true);
		requestFocus();
		//Change the tileName to match the name of the corresponding png file
		//this.tileName = "danaerys";
		//Not really sure why this . is needed
		this.directory = "./Images/";
		isOwned = false;        //set all new tiles to have no owners
		tListener = new TileListener();
		/*button = new JButton((Icon)img);
		button.setBackground(Color.BLACK);
		add(button);*/
		//This is some shitty code, but I can't really figure out how to get around it.
		//Theoretically calls buttonPressed() in the case that the covering JButton is pressed.
		/*addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    buttonPressed();
			  } 
			} );*/
		if(!isTown()){
			addMouseListener(tListener);
		}
		//button.addMouseListener(tListener);
	}
	
	public void changeClickListener(TileListener listens){
		Tile[][] tileMap = Controller.getController().getTileMap();
		for(Tile [] x : tileMap){
			for(Tile t : x){
				if(!t.isTown()){
					t.addClickListener(listens);
				}
			}
		}
	}
	
	/**
	 * This method will attempt to replace the current listener with the listener placed inside.
	 * @param listens
	 */
	public void addClickListener(TileListener listens){
		removeMouseListener(tListener);
		tListener=listens;
		addMouseListener(tListener);
	}
	
	public boolean isTown(){
		return town;
	}
	
	/**
	 * This attempts to retrieve the image file from the Images folder and save it to the tile's
	 * img variable.
	 */
	public void setUp(String directory){

	        img = new ImageIcon(directory);
	        setIcon(img);
	        setVisible(true);
	   
	}
	
	/**
	 * Not sure if this is needed.  Further testing required.  Should paint the actual tiles
	 * to the map.  Emphasis on should.
	 */
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(img.getImage(), 0, 0, null);
	}
	
	/**
	 * When the covering JButton is pressed, this method is called.  This method attempts to
	 * purchase the selected tile.
	 */
	protected void buttonPressed()
	{
		/*if(tListener.getBuyLand()){
			if(Controller.buyLand(this)) //returns true if the player has enough money to complete the land transaction
			{
				Controller controller = Controller.getController();
				controller.endTurn();			//the player has purchased or obtained a land
				/*if(controller.incrementCurrentPlayer() != null)
				{
					new Announcement("Current player is now " + controller.getCurrentPlayer());
				}
				else
				{
					Iterator iterator = Iterator.getIterator();
					iterator.incrementRound();
					new Announcement("Round has changed to " + iterator.getRound());
				}*/
			/*}
		
			else
			{
				new Announcement("Transaction failed: Insufficient money or Owned Property");
			}*/
		/*}else{
			Player currPlayer = Controller.getController().getCurrentPlayer();
			if(currPlayer.equals(owner)){
				changeMule(currPlayer.getMule());
			}
			currPlayer.setMule(-1);
			changeClickListener(new TileListener());
			
			
			//This should set the cursor back to normal.
			//Toolkit.getDefaultToolkit().
		}*/
	}
	
	/**
	 * changes the owner of the Tile to the parameter given.  Sets the border of the tile
	 * to the color of the player.  Repaints.
	 * @param player: new owner of the tile.
	 */
	public void tileSold(Player player){
		if(isOwned == true)
		{
			owner.removeProperty();
		}
		owner = player;
		player.addProperty();
		isOwned = true;
		setBorder(new LineBorder(player.getColor(),10));
	}
	
	public Player getOwner(){
		return owner;
	}
	
	public void setOwner(Player newOwner){
		owner = newOwner;
		button.setBorder(new LineBorder(newOwner.getColor(),2));
		repaint();
	}

	public boolean isOwned(){
		return isOwned;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y=y;
	}
	
	/**
	 * Return the type of mule present on the tile
	 * -1 = No mule, 0 = food, 1 = DragonFire, 2 = ore
	 * @return
	 */
	public int getMule(){
		return muleType;
	}
	
	/**
	 * Changes whatever is currently the muleType to whatever is used as a parameter.  Then
	 * updates the tile's appearance to reflect the current mule.
	 * @param newMule
	 */
	public void changeMule(int newMule){
		muleType = newMule;
	}

}