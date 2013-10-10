import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class GameFrame extends JFrame {

	private JPanel contentPane;
	private CardLayout cl;

	/**
	 * Launch the application.
	 */
	public static void main(String [] args)
	{
		new GameFrame();
	}

	/**
	 * Create the frame.
	 */
	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 450, 300);
		setTitle("D.R.A.G.O.N. The Game");
		cl = new CardLayout();
		getContentPane().setLayout(cl);
		
		System.out.println("Layout: " + getContentPane().getLayout());
		add(new Menu_Screen());
		pack();
		setVisible(true);
	}

}
