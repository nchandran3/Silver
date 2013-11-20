package ViewScreens;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import Game.GameFrame;


/**
 * Displays announcements to the player
 * @author Naveen Chandran
 *
 */
public class Announcement extends JFrame implements ActionListener{

	private final int TIMEOUT = 2;		//how long the message should display in seconds
	private Timer timer;
	private JLabel message;
	private ImageIcon msg_background;
	private JPanel background;
	private int startx, starty;
	//private StatusScreen ss;
	public Announcement(String msg)
	{
		//ss.setUpAnnouncement(msg);
		init(msg);
		timer.start();
	}
	
	private void init(String msg)
	{
		
		//Message construction
		message = new JLabel("<html>" + msg + "</html>");
		message.setForeground(Color.BLACK);
		message.setHorizontalAlignment(JLabel.CENTER);
		message.setFont(new Font("Vivaldi", Font.PLAIN, 20));
		message.setPreferredSize(new Dimension(300, 300));
		
		//Timer construction
		timer = new Timer(TIMEOUT*1000, this);
		
		//Background JPanel construction
		background = new JPanel();
		background.setPreferredSize(new Dimension(300, 300));
		background.setLayout(new BorderLayout());
		background.setBackground(new Color(0, 255, 0, 0));
		background.add(message, BorderLayout.CENTER);
		
		//Frame construction
		
		setUndecorated(true);
		setBackground(Color.LIGHT_GRAY);
		GameFrame frm = GameFrame.getFrame();
		startx = frm.getLocation().x + frm.getWidth()/2 - 150;
		starty = frm.getLocation().y + frm.getHeight()/2 - 150;
		setLocation(startx, starty);
		add(background);
		
		
		pack();
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		dispose();
	}
	
	public static void main(String [] args)
	{
		new Announcement("Player 1 probably wants to do something with his life other than cry about it");
	}
}