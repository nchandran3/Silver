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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame();
					frame.pack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 450, 300);
		setTitle("D.R.A.G.O.N. The Game");
		contentPane = new JPanel();
		cl = new CardLayout();
		contentPane.setLayout(cl);
		setContentPane(contentPane);
		
		contentPane.add(new Menu_Screen());
		
	}

}
