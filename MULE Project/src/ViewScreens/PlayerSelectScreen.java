package ViewScreens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import control.GTools;
import Components.*;
import Player.*;
import Tile.*;
import ViewScreens.*;
import control.*;
import Game.*;

/**
 * @author Naveen Chandran GUI for selecting player name, race, and color
 */
public class PlayerSelectScreen extends Screen
{
	private JTextField txtEnterPlayerName;
	private String textPrompt;
	private RaceSelectPanel raceSelectPanel;
	private ColorChooseBox colorChooseBox;
	private static int players_created = 0;

	public PlayerSelectScreen()
	{
		super(Color.PINK); // Creates screen with background color Blue
		setLayout(null);
		players_created++;

		/*
		 * Title Field
		 */
		JLabel title = new JLabel("Player " + players_created + " Creation");
		title.setForeground(Color.BLACK);
		title.setFont(new Font("Vivaldi", Font.PLAIN, 70));
		GTools.positionAndAdd(title, .5, .1, this);

		/*
		 * Player name input
		 */
		txtEnterPlayerName = new JTextField();
		txtEnterPlayerName.setFont(new Font("Lucida Sans Typewriter",
				Font.ITALIC, 20));
		txtEnterPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		textPrompt = "Player " + players_created;
		txtEnterPlayerName.setText(textPrompt);
		txtEnterPlayerName.setColumns(10);
		txtEnterPlayerName.addMouseListener(new MouseAdapter() // clear prompt when user focuses on textbox, and change
																// text properties
				{
					public void mouseClicked(MouseEvent e)
					{
						if (txtEnterPlayerName.getText().equals(textPrompt))
						{
							txtEnterPlayerName.setText("");
							txtEnterPlayerName.setFont(new Font("Vivaldi",
									Font.BOLD, 20));
							txtEnterPlayerName.setForeground(Color.CYAN);
						}
					}
				});
		txtEnterPlayerName.setForeground(Color.WHITE);
		txtEnterPlayerName.setBackground(Color.BLACK);
		GTools.positionAndAdd(txtEnterPlayerName, .5, .2, 1.5, 1.5, this);

		JLabel namelbl = new JLabel("Name:");
		namelbl.setFont(new Font("Vivaldi", Font.PLAIN, 20));
		GTools.positionAndAdd(namelbl, .3, .2, this);

		/*
		 * RaceSelectPanel initialization
		 */
		raceSelectPanel = new RaceSelectPanel();
		GTools.positionAndAdd(raceSelectPanel, .5, .5, this);

		/*
		 * ColorChooseBox initialization
		 */
		colorChooseBox = new ColorChooseBox();
		GTools.positionAndAdd(colorChooseBox, .5, .85, this);

		/*
		 * Submit Button
		 */
		JButton done = new JButton("Done");
		done.setFont(new Font("Stencil", Font.PLAIN, 16));
		done.setForeground(Color.WHITE);
		done.setOpaque(true);
		done.setBackground(Color.BLACK);
		done.addActionListener(new DoneListener());
		done.setVisible(true);
		GTools.positionAndAdd(done, .5, .97, this);

	}

	/**
	 * Listener for the Done button. Determines if all options are selected, and if so, will create a new player and
	 * bring up another PlayerSelectScreen if needed; otherwise, bring up the map.
	 * 
	 * @author Naveen
	 * 
	 */
	private class DoneListener implements ActionListener
	{

		/*
		 * If user has selected all required fields, create a new player. Then check to see if there are more players
		 * left to create. If not, change to the map screen.
		 */
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (raceSelectPanel.getSelectedRace() != null
					&& colorChooseBox.getColorChosen() != null
					&& !txtEnterPlayerName.getText().equals("") )
			{
				Controller controller = Controller.getController();
				Iterator iterator = Iterator.getIterator();

				controller.createPlayer(txtEnterPlayerName.getText(),
						colorChooseBox.getColorChosen(),
						raceSelectPanel.getSelectedRace());
				colorChooseBox.removeColorFromChoices(); // remove the color chosen from the list of options

				if (players_created < controller.getNumPlayers()) // if it is the last player that needs to be created,
																	// switch to Map
				{
					iterator.switchScreen(new PlayerSelectScreen());
				}

				else
				{
					Controller.getController().startGame();
					// iterator.startGame();
					// iterator.switchScreen(new Map()); //change this to the Map Screen class
				}
			}

			else
			{
				JOptionPane.showMessageDialog(null,
						"You must fill out all options!");
			}

		}

	}

	public static void main(String[] args)
	{
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.getContentPane().setLayout(new java.awt.CardLayout());
		// Iterator iterator = new Iterator(frame);
		frame.getContentPane().add(new PlayerSelectScreen());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(new Point(100, 0));
		frame.pack();
		frame.setVisible(true);
	}
}
