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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


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
		title.setBounds(588, 11, 524, 145);
		add(title);
		
		JButton done = new JButton("START!");
		done.setBackground(Color.BLACK);
		done.setBounds(792, 855, 115, 34);
		add(done);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Iskoola Pota", Font.BOLD, 16));
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(Color.MAGENTA);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(1018, 370, 94, 28);
		add(comboBox);
		
		JLabel lblNumberOfNobles = new JLabel("Number of Nobles");
		lblNumberOfNobles.setForeground(Color.MAGENTA);
		lblNumberOfNobles.setFont(new Font("Vivaldi", Font.BOLD, 35));
		lblNumberOfNobles.setBackground(Color.BLUE);
		lblNumberOfNobles.setBounds(588, 357, 278, 54);
		add(lblNumberOfNobles);
		
	}

	public static void main (String [] args)
	{
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.getContentPane().add(new Menu_Screen());
		frame.pack();
		frame.setVisible(true);
	}
}
