import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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


public class ColorChooseBox extends JPanel implements ActionListener {
	private static Color [] colors = new Color [] {Color.BLUE, Color.YELLOW, Color.RED, Color.MAGENTA, Color.GREEN, Color.CYAN};
	private static ArrayList <Color> colors_available = new ArrayList <Color>(Arrays.asList(colors));			//Each time a color is chosen, the color will be removed from the ArrayList
	private int width = 1200, height = 900/8;
	private HashMap<JButton, Color> map = new HashMap<>();
	private Color chosen;
	
	public ColorChooseBox()
	{
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		setPreferredSize(new Dimension(width, height));
		setBackground(Color.PINK);
		
		for(Color c : colors_available)
			drawColorBox(c, width);
	}
	
	public void drawColorBox(Color c, int width)
	{
		add(Box.createHorizontalGlue());
		JButton box = new JButton("                                                                  ");
		map.put(box, c);
		box.setBackground(c);
		box.setBorder(null);
		box.setForeground(c);
		box.setSize(new Dimension(width, height));
		box.addActionListener(this);
		add(box);
		add(Box.createHorizontalGlue());
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		JButton source = (JButton)e.getSource();
		colors_available.remove(map.get(source));
		System.out.println(colors_available.toString());
		JFrame frame = new JFrame();
		frame.add(new ColorChooseBox());
		frame.pack();
		frame.setVisible(true);
	}
	
	public Color getColorChosen()
	{
		return chosen;
	}
	public static void main (String [] args)
	{
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setBackground(Color.RED);
		frame.add(new ColorChooseBox());
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

