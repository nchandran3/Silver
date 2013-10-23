
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This class represents a Tile on the Map. It stores the tileType(int), owner(Player), and isOwned(boolean).
 * There are 6 different types of tiles that are given in the constructor. The owner is set with the TileSold
 * method once the player has chosen a new tile in the GUI of the game.
 * @author Michael Carlson
 *
 */
public class Tile extends JPanel implements TileListener{

	BufferedImage img;
	private Player owner;
	private boolean isOwned;
	private String tileName;
	private String directory;
	private int x;
	private int y;
	private JButton button;
	
	//Load the images inside the constructor, so we only have to load them once
	public Tile(){
		super();
		setFocusable(true);
		requestFocus();
		//Change the tileName to match the name of the corresponding png file
		this.tileName = "danaerys";
		//Not really sure why this . is needed
		this.directory = "./Images/";
		isOwned = false;        //set all new tiles to have no owners
		setUp();
		button = new JButton((Icon)img);
		add(button, BorderLayout.CENTER);
		//This is some shitty code, but I can't really figure out how to get around it.
		button.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    buttonPressed();
			  } 
			} );
	}
	
	public void setUp(){
		try {
	        img = ImageIO.read(new File(directory + tileName + ".png"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(img, 0, 0, null);
	}
	
	public void buttonPressed(){
		if(Controller.buyLand(this)){
			System.out.println("You successfully purchased the property");
		}else System.out.println("Transaction failed");
	}
	
	/**
	 * changes the owner of the Tile to the parameter given.
	 * @param player: new owner of the tile.
	 */
	public void tileSold(Player player){
		owner = player;
		isOwned = true;
	}
	
	public Player getOwner(){
		return owner;
	}
	
	public void setOwner(Player newOwner){
		owner = newOwner;
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

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
