import java.awt.Color;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * The main purpose of this class is to change the border of the tile when the mouse is hovered
 * over it.
 * @author Hamilton Greene
 *
 */
public class TileListener extends MouseAdapter{
	
	public TileListener(){
		
	}
	
	public void mouseOver(MouseEvent e){
		JButton source = (JButton) e.getSource();
		//source.setBorder(new LineBorder(Color.GRAY, 10));
		source.setBackground(Color.BLACK);
	}

}
