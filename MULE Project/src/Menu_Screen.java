import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

/**
 * This class creates the first screen that will be displayed when the player starts the game. In allows the 
 * player to choose a difficulty, map, and the number of players that are going to be playing.  
 * 
 * @author Naveen Chandran 
 *
 */
public class Menu_Screen extends Screen implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JComboBox <Integer> comboBox;
	private ButtonGroup difgroup;
	private JRadioButton plebian;
	private JRadioButton bourg;
	private JRadioButton royalty;
	Controller controller = new Controller();

	//hey ford
	/*
	 * Create the panel.
	 */
	public Menu_Screen() 
	{
		super(Color.BLUE);
		setLayout(null);



		/*Initialization components and methods below
		 * 
		 * ****************************************************************************************************************************
		 ******************************************************************************************************************************/


		/*
		 * Code for the title. Includes font, color, size, and position.
		 */

		JLabel title = new JLabel("D.R.A.G.O.N.");
		title.setFont(new Font("Stencil", Font.PLAIN, 90));
		title.setForeground(Color.YELLOW);
		title.setBounds(588, 11, title.getPreferredSize().width, title.getPreferredSize().height);
		add(title);

		

		/*
		 * Combo box to select the number of players. Includes selectable options, font, color, position, and default selection.
		 */

		comboBox = new JComboBox <Integer>();
		comboBox.setFont(new Font("Iskoola Pota", Font.BOLD, 16));
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(new Color(255, 51, 153));
		comboBox.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1, 2, 3, 4}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(1018, 270, 94, 28);
		add(comboBox);

		/*
		 * Label for the combo box.
		 */
		
		JLabel lblNumberOfNobles = new JLabel("Number of Nobles");
		lblNumberOfNobles.setForeground(new Color(255, 51, 204));
		lblNumberOfNobles.setFont(new Font("Vivaldi", Font.BOLD, 40));
		lblNumberOfNobles.setBackground(Color.BLUE);
		lblNumberOfNobles.setBounds(588, 257, lblNumberOfNobles.getPreferredSize().width, lblNumberOfNobles.getPreferredSize().height);
		add(lblNumberOfNobles);

		/*
		 * Difficulty Label
		 */
		
		JLabel difficultylbl = new JLabel("DIFFICULTY");
		difficultylbl.setForeground(Color.CYAN);
		difficultylbl.setFont(new Font("Onyx", Font.PLAIN, 88));
		difficultylbl.setBounds(724, 433, difficultylbl.getPreferredSize().width, difficultylbl.getPreferredSize().height);
		add(difficultylbl);
		
		/*
		 * Difficulty selector. Plebian is beginner, bourgeoisie is intermediate, and royalty is advanced. 
		 * No two check boxes can be selected at once due to the ButtonGroup functionality.
		 */

		plebian = new JRadioButton("Plebian");
		plebian.setOpaque(false);
		plebian.setForeground(Color.YELLOW);
		plebian.setFont(new Font("Vivaldi", Font.BOLD, 30));
		plebian.setBounds(320,586,plebian.getPreferredSize().width,plebian.getPreferredSize().height);
		
		bourg = new JRadioButton("Bourgeoisie");
		bourg.setOpaque(false);
		bourg.setForeground(Color.YELLOW);
		bourg.setFont(new Font("Vivaldi", Font.BOLD, 30));
		bourg.setBounds(761,586,bourg.getPreferredSize().width,bourg.getPreferredSize().height);
		
		royalty = new JRadioButton("Royalty");
		royalty.setOpaque(false);
		royalty.setForeground(Color.YELLOW);
		royalty.setFont(new Font("Vivaldi", Font.BOLD, 30));
		royalty.setBounds(1250,586,royalty.getPreferredSize().width,royalty.getPreferredSize().height);

		difgroup = new ButtonGroup();
		difgroup.add(plebian);
		difgroup.add(bourg);
		difgroup.add(royalty);

		add(plebian);
		add(bourg);
		add(royalty);

		
		/*
		 * Random map generation check box. If checked, map will be generated randomly. 
		 */
		
		JCheckBox map = new JCheckBox("Random Map");
		map.setFont(new Font("Vivaldi", Font.BOLD, 30));
		map.setForeground(Color.YELLOW);
		map.setOpaque(false);
		map.setToolTipText("Randomly generate the tiles of the map");
		map.setBounds(742, 722, map.getPreferredSize().width , map.getPreferredSize().height);
		add(map);
		
		
		/*
		 * Start button, which initiates the connection to the configuration manager 
		 * to set up the next screens and record input.
		 */

		JButton done = new JButton("START!");
		done.setBackground(Color.BLACK);
		done.setForeground(Color.YELLOW);
		done.setBounds(792, 855, 115, 34);
		done.addActionListener(this);
		add(done);
		
		
	}
	
	/**
	 * This is the action performed method which reads when the user presses the start button. It then reads all the 
	 * other information that was selected and then calls the controller class to start the game and progress to the 
	 * player select screen. 
	 * 
	 * @param ActionEvent e
	 */
	public void actionPerformed(ActionEvent e) {
		System.out.println("test");

		controller.getController();
		controller.setNumPlayers((int) comboBox.getSelectedItem());
		
		if(verifyDifficultySelected() != -1)
			System.out.println("test");
			Iterator it = new Iterator();
			it.getIterator().switchScreen("pSS");
		
	}

	public int verifyDifficultySelected()
	{
		System.out.println("tedededt");

		int difficulty = -1;
		
		if(plebian.isSelected()){
			difficulty =1;
			controller.setDifficulty(difficulty);
		}
		else if(bourg.isSelected())
		{
			difficulty =2;
			controller.setDifficulty(difficulty);
		}
		else if (royalty.isSelected())
		{
			difficulty =3;
			controller.setDifficulty(difficulty);
		}
		else
			JOptionPane.showMessageDialog(null,"You must pick a difficulty!");
		return difficulty;
	}
	public static void main (String [] args)
	{
		
		Controller controller = new Controller();
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.getContentPane().setLayout(new java.awt.CardLayout());
		Iterator iterator = new Iterator(frame);
		frame.getContentPane().add(new Menu_Screen());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(new Point(100,0));
		frame.pack();
		frame.setVisible(true);
	}
}
