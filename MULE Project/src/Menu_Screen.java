import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;


public class Menu_Screen extends Screen {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Menu_Screen() {
		super(Color.BLUE);
		setPreferredSize(new Dimension(1700, 900));
		setLayout(null);
		
		JLabel title = new JLabel("D.R.A.G.O.N.");
		title.setFont(new Font("Stencil", Font.PLAIN, 90));
		title.setForeground(Color.YELLOW);
		title.setBounds(668, 11, 524, 145);
		add(title);
		
	}

	public static void main (String [] args)
	{
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.getContentPane().add(new Menu_Screen());
		frame.pack();
		frame.setVisible(true);
	}
}
