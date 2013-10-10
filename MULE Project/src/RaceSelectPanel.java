import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JButton;

import java.net.MalformedURLException;
import java.net.URL;
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
	private JButton btnHuman, btnTargaryen, btnBaratheon, btnStark, btnLannister;
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
		JButton btnHuman = new JButton("Greyjoy");
		btnHuman.setBounds(170, 32, 89, 23);
		add(btnHuman);
		
		JButton btnTargaryen = new JButton("Targaryen");
		btnTargaryen.setBounds(331, 131, 89, 23);
		add(btnTargaryen);
		
		JButton btnBaratheon = new JButton("Baratheon");
		btnBaratheon.setBounds(84, 261, 89, 23);
		add(btnBaratheon);
		
		JButton btnStark = new JButton("Stark");
		btnStark.setBounds(257, 261, 89, 23);
		add(btnStark);
		
		JButton btnLannister = new JButton("Lannister");
		btnLannister.setBounds(10, 131, 89, 23);
		add(btnLannister);
		
		try
		{
			ImageIcon icon = new ImageIcon(new URL("http://opinionessoftheworld.files.wordpress.com/2013/04/game-of-thrones-daenerys-dragon.jpg"));
			Image icon2 = icon.getImage().getScaledInstance(148, 148, Image.SCALE_FAST);
			icon = new ImageIcon(icon2);
			JLabel label = new JLabel(icon);
			label.setBounds(141, 79, 148, 148);
			add(label);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
	}
	
}
