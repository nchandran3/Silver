import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JButton;


public class Menu_Screen extends Screen {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Menu_Screen() {
		super(Color.BLUE);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel title = new JLabel("M.U.L.E.");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.YELLOW);
		title.setFont(new Font("Stencil", Font.BOLD, 32));
		
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.gridheight = 2;
		gbc_title.gridwidth = 11;
		gbc_title.insets = new Insets(0, 0, 5, 10);
		gbc_title.gridx = 6;
		gbc_title.gridy = 4;
		add(title, gbc_title);
		
		JButton btnNewButton = new JButton("Done");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 10;
		gbc_btnNewButton.gridy = 12;
		add(btnNewButton, gbc_btnNewButton);

	}

	public static void main (String [] args)
	{
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.getContentPane().add(new Menu_Screen());
		frame.pack();
		frame.setVisible(true);
	}
}
