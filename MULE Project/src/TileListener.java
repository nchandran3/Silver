import java.awt.Color;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class TileListener extends MouseAdapter{
	
	public TileListener(){
		
	}
	
	public void mouseOver(MouseEvent e){
		JButton source = (JButton) e.getSource();
		//source.setBorder(new LineBorder(Color.GRAY, 10));
		source.setBackground(Color.BLACK);
	}

}
