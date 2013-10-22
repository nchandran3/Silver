import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * This class is meant to provide a definition for all viewable game screens. It contains the basic properties and methods
 * for all viewable 
 * @author Naveen Chandran
 *
 */
public class Screen extends JPanel{
	private static final long serialVersionUID = 1L;
	protected ImageIcon background;
	protected int width = 1280, height = 720;
	private Iterator iterator;
	private Controller controller;
	
	public Screen()
	{
		super();
		setPreferredSize(new Dimension(width,height));
		setFocusable(true);
		requestFocus();
		iterator = Iterator.getIterator();
		controller = Controller.getController();
	}
	
	public Screen (Color c)
	{
		this();
		setBackground(c);
	}
	
	public Screen(ImageIcon bg_img)
	{
		this();
		background = bg_img;
		drawBackground();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(background != null) 
			g.drawImage(background.getImage(),0,0,width,height, null);
	}
	
	public void drawBackground()
	{
		repaint();
	}
	
	public String toString()
	{
		return this.getName();
	}
}
