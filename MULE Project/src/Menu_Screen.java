import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Point;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class Menu_Screen extends Screen {

	private static final long serialVersionUID = 1L;

	/*
	 * Create the panel.
	 */
	public Menu_Screen() {
		super(Color.BLUE);
		setPreferredSize(new Dimension(1700, 900));
		setLayout(null);
		
		/*
		 * Code for the title. Includes font, color, size, and position.
		 */
		JLabel title = new JLabel("D.R.A.G.O.N.");
		title.setFont(new Font("Stencil", Font.PLAIN, 90));
		title.setForeground(Color.YELLOW);
		title.setBounds(588, 11, title.getPreferredSize().width, title.getPreferredSize().height);
		add(title);
		
		/*
		 * Start button, which initiates the connection to the configuration manager 
		 * to set up the next screens and record input.
		 */
		JButton done = new JButton("START!");
		done.setBackground(Color.BLACK);
		done.setForeground(Color.YELLOW);
		done.setBounds(792, 855, 115, 34);
		add(done);
		
		/*
		 * Combo box to select the number of players. Includes selectable options, font, color, position, and default selection.
		 */
		JComboBox <Integer> comboBox = new JComboBox <Integer>();
		comboBox.setFont(new Font("Iskoola Pota", Font.BOLD, 16));
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(new Color(255, 51, 153));
		comboBox.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1, 2, 3, 4}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(1018, 370, 94, 28);
		add(comboBox);
		
		/*
		 * Label for the combo box.
		 */
		JLabel lblNumberOfNobles = new JLabel("Number of Nobles");
		lblNumberOfNobles.setForeground(new Color(255, 51, 204));
		lblNumberOfNobles.setFont(new Font("Vivaldi", Font.BOLD, 40));
		lblNumberOfNobles.setBackground(Color.BLUE);
		lblNumberOfNobles.setBounds(588, 357, lblNumberOfNobles.getPreferredSize().width, lblNumberOfNobles.getPreferredSize().height);
		add(lblNumberOfNobles);
		
		/*
		 * Difficulty selector. Plebian is beginner, bourgeoisie is intermediate, and royalty is advanced. 
		 * No two combo boxes can be selected at once due to the ButtonGroup functionality.
		 */
		
		JRadioButton plebian = new JRadioButton("Plebian");
		plebian.setOpaque(false);
		plebian.setForeground(Color.YELLOW);
		plebian.setFont(new Font("Vivaldi", Font.BOLD, 30));
		plebian.setBounds(320,686,plebian.getPreferredSize().width,plebian.getPreferredSize().height);
		JRadioButton bourg = new JRadioButton("Bourgeoisie");
		bourg.setOpaque(false);
		bourg.setForeground(Color.YELLOW);
		bourg.setFont(new Font("Vivaldi", Font.BOLD, 30));
		bourg.setBounds(761,686,bourg.getPreferredSize().width,bourg.getPreferredSize().height);
		JRadioButton royalty = new JRadioButton("Royalty");
		royalty.setOpaque(false);
		royalty.setForeground(Color.YELLOW);
		royalty.setFont(new Font("Vivaldi", Font.BOLD, 30));
		royalty.setBounds(1250,686,royalty.getPreferredSize().width,royalty.getPreferredSize().height);
		
		ButtonGroup difgroup = new ButtonGroup();
		difgroup.add(plebian);
		difgroup.add(bourg);
		difgroup.add(royalty);
		
		add(plebian);
		add(bourg);
		add(royalty);
		
		/*
		 * Difficulty Label
		 */
		JLabel difficultylbl = new JLabel("DIFFICULTY");
		difficultylbl.setForeground(Color.CYAN);
		difficultylbl.setFont(new Font("Onyx", Font.PLAIN, 88));
		difficultylbl.setBounds(724, 533, difficultylbl.getPreferredSize().width, difficultylbl.getPreferredSize().height);
		add(difficultylbl);
	}

	public static void main (String [] args)
	{
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.getContentPane().add(new Menu_Screen());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(new Point(100,0));
		frame.pack();
		frame.setVisible(true);
	}
}
