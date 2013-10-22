package control;

import javax.swing.JComponent;
import javax.swing.JPanel;

public abstract class GTools {
	
	/**
	 * Returns the left coordinate to center a component at a fraction of the panel.
	 * @param panel The panel to add the component to
	 * @param ratio	The percent width on the screen where it should be centered
	 * @param component The component being added
	 * @return
	 */
	public static double setXBound(JPanel panel, double ratio, JComponent component)
	{
		int width = panel.getWidth();
		int c_width = component.getPreferredSize().width;
		
		return width*ratio - c_width/2;
	}
	
	public static double setYBound(JPanel panel, double ratio, JComponent component)
	{
		int height = panel.getHeight();
		int c_height = component.getPreferredSize().height;
		
		return height*ratio - c_height/2;
	}
}
