import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Creates the Color choose option that is displayed on the player select screen. Once a color is 
 * selected it is dicarded from the remaining colors that the next player can choose from.
 * 
 * @author Naveen Chandran
 *
 */
public class ColorChooseBox extends JPanel implements ActionListener {
	private static Color [] colors = new Color [] {Color.BLUE, Color.YELLOW, Color.RED, Color.MAGENTA, Color.GREEN, Color.CYAN};
	private static ArrayList <Color> colors_available = new ArrayList <Color>(Arrays.asList(colors));			//Each time a color is chosen, the color will be removed from the ArrayList
	private int width = 1200, height = 900/5;
	private HashMap<JButton, Color> map = new HashMap<>();
	private Color chosen;
	/**
	 * Constructor that initializes the layout and dimensions of the boxlayout where the colors will be displayed.
	 */
	public ColorChooseBox()
	{
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		setPreferredSize(new Dimension(width, height));
		setBackground(Color.PINK);

		for(Color c : colors_available)
			drawColorBox(c, width);
	
	}
	
	/**
	 * This draws the colorBox in the panel and adds the action listener that reads what the user inputs. 
	 * @param c
	 * @param width
	 */
	public void drawColorBox(Color c, int width)
	{
		add(Box.createHorizontalGlue());
		JButton box = new JButton("                                                       ");
		map.put(box, c);
		box.setBackground(c);
		box.setBorder(null);
		box.setForeground(c);
		box.setMinimumSize(new Dimension(width, height));
		box.addActionListener(this);
		add(box);
		add(Box.createHorizontalGlue());
	}
	
	
	/**
	 * Recognizes an action performed from the players and based on that action draws over the color 
	 * that was just chosen which in turn eliminates that option from the next player.
	 * 
	 * @param ActionEvent e
	 */
	public void actionPerformed(ActionEvent e)
	{
		JButton source = (JButton)e.getSource();
		chosen = (map.get(source));
		Graphics g= getGraphics();
		g.setColor(chosen);
		g.fillRect(getWidth()/2-25, 0, 50, 50);
	}
	/**
	 * simple getter which returns the color that the player chose
	 * @return Color
	 */
	public Color getColorChosen()
	{
		return chosen;
	}
	/**
	 * This removes the color that the player has recently chosen. 
	 */
	public void removeColorFromChoices()
	{
		colors_available.remove(chosen);
	}
	
	public static void main (String [] args)
	{
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setBackground(Color.RED);
		frame.getContentPane().add(new ColorChooseBox());
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

