import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

/**
 * This listener is used when a player purchases a mule.  It essentially takes the place of
 * TileListener, thus changing which path of logic Tile chooses when clicked.
 * @author Hamilton Greene
 *
 */
public class MuleListener extends TileListener{
	private boolean buyLand;
	
	public MuleListener(){
		buyLand = false;
	}
	
	/**
	 * This should just change the background color of the tile your mouse is hovering over,
	 * so it's easier for the player to tell where it is.
	 */
	public void mouseOver(MouseEvent e){
		JButton source = (JButton) e.getSource();
		//source.setBorder(new LineBorder(Color.GRAY, 10));
		source.setBackground(Color.BLACK);
	}
	
}
