import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Race Selection Panel that is a part of the Player Select Screen
 * @author Naveen Chandran
 *
 */
public class RaceSelectPanel extends Screen {

	private static final long serialVersionUID = 1L;
	private Race selected;
	private JButton btnGreyjoy, btnTargaryen, btnBaratheon, btnStark, btnLannister;
	private ArrayList<Component> buttons = new ArrayList<>();
	private JLabel image;
	private HashMap <String, ImageIcon> map = new HashMap<>(); //allows calling images by their name
	/**
	 * This creates the panel where the races will be displayed on the create player class and
	 * reads what the user presses and sets that player's race to what they selected.
	 */
	public RaceSelectPanel() {
		super(Color.BLACK);
		setLayout(null);
		setPreferredSize(new Dimension(430,320));
		
		/*
		 * Button initialization
		 */
		btnGreyjoy = new JButton("Greyjoy");
		btnGreyjoy.setBounds(170, 32, 89, 23);
		add(btnGreyjoy);
		buttons.add(btnGreyjoy);
		
		btnTargaryen = new JButton("Targaryen");
		btnTargaryen.setBounds(331, 131, 89, 23);
		add(btnTargaryen);
		buttons.add(btnTargaryen);
		
		btnBaratheon = new JButton("Baratheon");
		btnBaratheon.setBounds(84, 261, 89, 23);
		add(btnBaratheon);
		buttons.add(btnBaratheon);
		
		btnStark = new JButton("Stark");
		btnStark.setBounds(257, 261, 89, 23);
		add(btnStark);
		
		btnLannister = new JButton("Lannister");
		btnLannister.setBounds(10, 131, 89, 23);
		add(btnLannister);
		
		try
		{
			ImageIcon icon = new ImageIcon(new URL("http://opinionessoftheworld.files.wordpress.com/2013/04/game-of-thrones-daenerys-dragon.jpg"));
			Image icon2 = icon.getImage().getScaledInstance(148, 148, Image.SCALE_FAST);
			icon = new ImageIcon(icon2);
			image = new JLabel(icon);
			image.setBounds(141, 79, 148, 148);
			add(image);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
	}
	
	public ImageIcon compress(ImageIcon icon)
	{
		Image icon2 = icon.getImage().getScaledInstance(148, 148, Image.SCALE_FAST);
		return new ImageIcon(icon2);
	}
	/**
	 * Listener for race buttons
	 * @author Naveen
	 *
	 */
	private class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton src = (JButton) e.getSource();
			setSelected(src); //sets the selected race			
		}
		
		public void setSelected(JButton src)
		{
			if(src == btnGreyjoy)
				selected = Race.GREYJOY;
			else if (src == btnTargaryen)
				selected = Race.TARGARYEN;
			else if (src == btnBaratheon)
				selected = Race.BARATHEON;
			else if (src == btnStark)
				selected = Race.STARK;
			else if (src == btnLannister)
				selected = Race.LANNISTER;
		}
		
	}
}
