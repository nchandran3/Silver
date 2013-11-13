/**
 * 
 */
package ViewScreens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Asks the user whether they would like to start a new game or load an old one.
 * @author Naveen
 *
 */
public class StartScreen extends JFrame implements ActionListener {
	private JButton load, newgame;
	private JPanel buttonpanel, titlepanel;		//south panel
	private JLabel title;
	public static int chosen =0;  		//1 if new game, 2 if load game
	
	public StartScreen()
	{
		setTitle("D.R.A.G.O.N.");
		setLayout(new BorderLayout());
		
		init();
		
		add(titlepanel, BorderLayout.CENTER);
		add(buttonpanel, BorderLayout.SOUTH);
		
		pack();
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - getWidth()/2, Toolkit.getDefaultToolkit().getScreenSize().height/2 - getHeight()/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public void init()
	{
		//initialize components
		buttonpanel = new JPanel();
		buttonpanel.setPreferredSize(new Dimension(0, 50));
		buttonpanel.setLayout(new BoxLayout(buttonpanel, BoxLayout.X_AXIS));
		buttonpanel.setBackground(Color.CYAN);
		
		
		load = new JButton("Load Game");
		newgame = new JButton ("New Game");
		
		title = new JLabel("D.R.A.G.O.N");
		title.setForeground(Color.BLACK);
		title.setFont(new Font("Vivaldi", Font.PLAIN, 45));
		
		titlepanel = new JPanel();
		titlepanel.setBackground(Color.CYAN);
		titlepanel.add(title);
		
		
		//add listeners to buttons
		load.addActionListener(this);
		newgame.addActionListener(this);
		
		
		//add buttons to panel
		buttonpanel.add(newgame);
		for(int i = 0; i < 3; i++)
			buttonpanel.add(Box.createHorizontalGlue());
		buttonpanel.add(load);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton) e.getSource();
		if(src == load)
		{
			System.out.println("LOAD GAME");
			chosen = 2;
		}
		
		else if (src == newgame)
		{
			System.out.println("NEW GAME");
			chosen =1;
		}
		dispose();
	}
	
	
	public static void main(String[] args) {
		new StartScreen();

	}

}
