package control;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * 
 * @author Naveen Chandran
 * 
 */
public abstract class GTools
{

	/**
	 * Sets the bounds of the component by computing the percent of pixels horizontally and vertically. Centers the
	 * component on the given pixel
	 * 
	 * @param component
	 *            the JComponent to add to the panel
	 * @param percentX
	 *            the percent x of the panel to center the component
	 * @param percentY
	 *            the percent y of the panel to center the component
	 * @param container
	 *            the container to add the component to
	 */
	public static void positionAndAdd(JComponent component, double percentX,
			double percentY, JComponent container)
	{
		int c_width = component.getPreferredSize().width;
		int c_height = component.getPreferredSize().height;

		int width = container.getWidth();
		int height = container.getHeight();

		component.setBounds((int) (width * percentX - c_width / 2.0), // the centered x bound
				(int) (height * percentY - c_height / 2.0), // the centered y bound
				c_width, // the width
				c_height); // the height

		container.add(component);
	}

	/**
	 * Overload Sets the bounds of the component by computing the percent of pixels horizontally and vertically. Centers
	 * the component on the given pixel. Scales the component based on the given width and height ratios
	 * 
	 * @param component
	 *            the JComponent to add to the panel
	 * @param percentX
	 *            the percent x of the panel to center the component
	 * @param percentY
	 *            the percent y of the panel to center the component
	 * @param rwidth
	 *            the ratio to scale the width
	 * @param rheight
	 *            the ratio to scale the height
	 * @param container
	 *            the container to add the component to
	 */
	public static void positionAndAdd(JComponent component, double percentX,
			double percentY, double rwidth, double rheight, JComponent container)
	{
		double c_width = component.getPreferredSize().width * rwidth;
		double c_height = component.getPreferredSize().height * rheight;

		int width = container.getWidth();
		int height = container.getHeight();

		component.setBounds((int) (width * percentX - c_width / 2), // the centered x bound
				(int) (height * percentY - c_height / 2), // the centered y bound
				(int) (c_width), // the width scaled by a factor of rwidth
				(int) (c_height)); // the height scaled by a factor of rheight

		container.add(component);
	}

	/**
	 * Compresses an ImageIcon to the desired size
	 * 
	 * @param icon
	 *            the ImageIcon to compress
	 * @param width
	 *            the desired width
	 * @param height
	 *            the desired height
	 * @return compressed ImageIcon
	 */
	public static ImageIcon compress(ImageIcon icon, int width, int height)
	{
		Image icon2 = icon.getImage().getScaledInstance(width, height,
				Image.SCALE_FAST);
		return new ImageIcon(icon2);
	}

	/**
	 * Overload Creates a compressed ImageIcon from a file in the working directory
	 * 
	 * @param image
	 *            the image to compress
	 * @param width
	 * @param height
	 * @return
	 */
	public static ImageIcon compress(String image, int width, int height)
	{
		Image icon2 = new ImageIcon(image).getImage().getScaledInstance(width,
				height, Image.SCALE_FAST);
		return new ImageIcon(icon2);
	}

	/**
	 * Gets the Screen width of the user, excluding taskbars
	 * 
	 * @return screen width
	 */
	public static int getScreenWidth()
	{
		return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getMaximumWindowBounds().width;
	}

	/**
	 * Gets the Screen height of the user, excluding taskbars
	 * 
	 * @return screen height
	 */
	public static int getScreenHeight()
	{
		return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getMaximumWindowBounds().height;
	}
}
