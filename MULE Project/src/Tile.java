import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
	protected String tileName;
	protected String directory;
	protected int x;
	protected int y;
	protected JButton button;
	protected TileListener tListener;
	
	/*
	 * Essentially creates a new JPanel and then fills it with a JButton that reacts to 
	 * mouse clicks.
	 */
	public Tile(){
		super();
		//setLayout(new BorderLayout());
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
		addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    buttonPressed();
			  } 
			} );
		addMouseListener(tListener);
		//button.addMouseListener(tListener);
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
		}
		
		else
		{
			new Announcement("Transaction failed: Insufficient money or Owned Property");
		}
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

}
