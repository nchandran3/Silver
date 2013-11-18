package Components;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import Components.*;
import Player.*;
import Tile.*;
import ViewScreens.*;
import control.*;
import Game.*;

/**
 * Creates the Color choose option that is displayed on the player select screen. Once a color is 
 * selected it is dicarded from the remaining colors that the next player can choose from.
 * 
 * @author Naveen Chandran
 *
 */
public class ColorChooseBox extends Screen implements ActionListener {
	private static Color [] colors = new Color [] {Color.BLUE, Color.YELLOW, Color.RED, Color.MAGENTA, Color.GREEN, Color.CYAN};
	private static ArrayList <Color> colors_available = new ArrayList <Color>(Arrays.asList(colors));			//Each time a color is chosen, the color will be removed from the ArrayList
//	private int width = width, height = super.height/6;
	private int height2 = height/6;
	private HashMap<JButton, Color> map = new HashMap<>();
	private Color chosen;
	private JPanel panel;
	private JLabel label;
	/**
	 * Constructor that initializes the layout and dimensions of the boxlayout where the colors will be displayed.
	 */
	public ColorChooseBox()
	{
//		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(width, height2));
		setBackground(Color.PINK);
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Choose Color", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
		
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		for(Color c : colors_available)
			drawColorBox(c, width);
		
		add(panel,BorderLayout.SOUTH);
	}
	
	/**
	 * This draws the colorBox in the panel and adds the action listener that reads what the user inputs. 
	 * @param c
	 * @param width
	 */
	public void drawColorBox(Color c, int width)
	{
		panel.add(Box.createHorizontalGlue());
		JButton box = new JButton("                                                       ");
		map.put(box, c);
		box.setBackground(c);
		box.setBorder(null);
		box.setForeground(c);
		box.setMinimumSize(new Dimension(width/6, height));
		box.addActionListener(this);
		panel.add(box);
		panel.add(Box.createHorizontalGlue());
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
		g.fillRect(getWidth()/2-25, 20, 50, 50);
		System.out.println("Color chosen was "  + chosen);
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
	
	public int getHeight()
	{
		return height2;
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

