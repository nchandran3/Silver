
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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
public class Tile extends JPanel implements ActionListener{

	BufferedImage img;
	private Player owner;
	private boolean isOwned;
	private String tileName;
	private String directory;
	private int imgWidth;
	private int imgHeight;
	private JButton button;
	
	//Load the images inside the constructor, so we only have to load them once
	public Tile(){
		super();
		setPreferredSize(new Dimension(imgWidth,imgHeight));
		//WTF? setLayout(BorderLayout);
		setFocusable(true);
		requestFocus();
		//Change the tileName to match the name of the corresponding png file
		this.tileName = "danaerys";
		//Not really sure why this . is needed
		this.directory = "./Images/";
		this.imgHeight = 50;
		this.imgWidth = 50;
		isOwned = false;        //set all new tiles to have no owners
		setUp();
		button = new JButton((Icon)img);
		add(button, BorderLayout.CENTER);
		button.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    selectionButtonPressed();
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
	
	@Override
	public Dimension getPreferredSize() {
	    return new Dimension(imgWidth, imgHeight);
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
}
