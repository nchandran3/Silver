package control;

import javax.swing.JComponent;
import javax.swing.JPanel;

public abstract class GTools {
	
/**
 * Sets the bounds of the component by computing the percent of pixels horizontally and vertically. Centers the component on the given pixel
 * @param component
 * @param x
 * @param y
 * @param container
 */
	public static void setBounds(JComponent component, double percentX, double percentY, JPanel container)
	{
		int c_width = component.getPreferredSize().width;
		int c_height = component.getPreferredSize().height;
		
		int width = container.getWidth();
		int height = container.getHeight();
				
		component.setBounds(
				(int)(width*percentX - c_width/2 ), //the centered x bound
				(int) (height*percentY - c_height/2), //the centered y bound
				c_width, //the width
				c_height); //the height
	}
}
