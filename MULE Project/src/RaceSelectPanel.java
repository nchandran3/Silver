import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BoxLayout;

import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Race Selection Panel that is a part of the Player Select Screen
 * @author Naveen Chandran
 *
 */
public class RaceSelectPanel extends Screen {

	private static final long serialVersionUID = 1L;

	public RaceSelectPanel() {
		super(Color.BLACK);
		setLayout(null);
		
		JButton btnHuman = new JButton("Greyjoy");
		btnHuman.setBounds(180, 32, 89, 23);
		add(btnHuman);
		
		JButton btnNewButton = new JButton("Targaryen");
		btnNewButton.setBounds(318, 131, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Baratheon");
		btnNewButton_1.setBounds(89, 244, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Stark");
		btnNewButton_2.setBounds(278, 244, 89, 23);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Lannister");
		btnNewButton_3.setBounds(41, 131, 89, 23);
		add(btnNewButton_3);
		
		try
		{
			ImageIcon icon = new ImageIcon(new URL("http://opinionessoftheworld.files.wordpress.com/2013/04/game-of-thrones-daenerys-dragon.jpg"));
			Image icon2 = icon.getImage().getScaledInstance(148, 148, Image.SCALE_FAST);
			icon = new ImageIcon(icon2);
			JLabel label = new JLabel(icon);
			label.setBounds(151, 79, 148, 148);
			add(label);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		
	}
	
}
