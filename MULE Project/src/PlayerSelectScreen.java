import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

/**
 * @author Naveen Chandran
 * GUI for selecting player name, race, and color
 */
public class PlayerSelectScreen extends Screen {
	private JTextField txtEnterPlayerName;
	private Color color;
	private Race race;
	private RaceSelectPanel raceSelectPanel;
	private ColorChooseBox colorChooseBox;
	private static int players_created =0;

	public PlayerSelectScreen()
	{
		super(Color.MAGENTA); //Creates screen with background color Blue
		setBackground(Color.PINK);
		setLayout(null);
		setPreferredSize(new Dimension(1700,900));
		
		JLabel title = new JLabel("Player Creation");
		title.setForeground(Color.BLACK);
		title.setFont(new Font("Vivaldi", Font.PLAIN, 90));
		title.setBounds(605, 11, title.getPreferredSize().width, title.getPreferredSize().height);
		add(title);
		
		txtEnterPlayerName = new JTextField();
		txtEnterPlayerName.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 20));
		txtEnterPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterPlayerName.setText("ENTER PLAYER NAME");
		txtEnterPlayerName.setForeground(Color.WHITE);
		txtEnterPlayerName.setBackground(Color.BLACK);
		txtEnterPlayerName.setBounds(625, 174, 449, 50);
		add(txtEnterPlayerName);
		txtEnterPlayerName.setColumns(10);
		
		RaceSelectPanel raceSelectPanel = new RaceSelectPanel();
		raceSelectPanel.setBounds(634, 276, 432, 320);
		add(raceSelectPanel);
		
		ColorChooseBox colorChooseBox = new ColorChooseBox();
		colorChooseBox.setBounds(250, 664, 1200, 173);
		add(colorChooseBox);
		
		JLabel lblChooseColor = new JLabel("Choose A Color: ");
		lblChooseColor.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblChooseColor.setBounds(701, 607, lblChooseColor.getPreferredSize().width, lblChooseColor.getPreferredSize().height);
		add(lblChooseColor);
		
		JButton done = new JButton("Done");
		done.setFont(new Font("Stencil", Font.PLAIN, 16));
		done.setForeground(Color.WHITE);
		done.setOpaque(true);
		done.setBackground(Color.BLACK);
		done.setBounds(805, 866, 115, 34);
		done.addActionListener(new DoneListener());
		add(done);
		
		players_created++;
	}
	
	
	/**
	 * Listener for the Done button. Determines if all options are selected, and if so, will create a new player and bring up 
	 * another PlayerSelectScreen if needed; otherwise, bring up the map. 
	 * @author Naveen
	 *
	 */
	private class DoneListener implements ActionListener
	{

		/*
		 * If user has selected all required fields, create a new player. Then check to see if there are 
		 * more players left to create. If not, change to the map screen. 
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if(raceSelectPanel.getSelectedRace() != null && colorChooseBox.getColorChosen() != null && txtEnterPlayerName.getText() != "")
			{
				Controller controller = Controller.getController();
				Iterator iterator = Iterator.getIterator();
				
				if(players_created < controller.getNumPlayers())
				{
					controller.createPlayer(txtEnterPlayerName.getText(), colorChooseBox.getColorChosen(), raceSelectPanel.getSelectedRace());
					colorChooseBox.removeColorFromChoices(); //remove the color chosen from the list of options
					iterator.switchScreen(new PlayerSelectScreen());
				}
				
				else
				{
					iterator.switchScreen(new Menu_Screen()); //change this to the Map Screen class
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(null,"You must fill out all options!");
			}
			
		}
		
	}
	
	public static void main(String [] args)
	{
		Controller controller = new Controller();
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.getContentPane().setLayout(new java.awt.CardLayout());
		Iterator iterator = new Iterator(frame);
		frame.getContentPane().add(new PlayerSelectScreen());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(new Point(100,0));
		frame.pack();
		frame.setVisible(true);
	}
}
