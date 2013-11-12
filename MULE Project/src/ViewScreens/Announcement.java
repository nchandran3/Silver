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
	private static Announcement announcement;
	
	public Announcement(String msg)
	{
		if(announcement != null && announcement != this)
			announcement.dispose();
		announcement = this;
		init(msg);
		timer.start();
	}
	
	private void init(String msg)
	{
		
		//Message construction
		msg_background = new ImageIcon("./Images/mountain.png");
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
		setBackground(Color.WHITE);
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - 150, Toolkit.getDefaultToolkit().getScreenSize().height/2 - 150);
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
		new Announcement("Player 1 is a complete nimrod and probably wants to do something with his life other than cry about it");
	}
}