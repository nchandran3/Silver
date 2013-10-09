import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

/**
 * @author Naveen Chandran
 * GUI for selecting player name, race, and color
 */
public class PlayerSelectScreen extends Screen {
	private JTextField txtEnterPlayerName;

	public PlayerSelectScreen()
	{
		super(Color.MAGENTA); //Creates screen with background color Blue
		setBackground(Color.PINK);
		setLayout(null);
		setPreferredSize(new Dimension(1700,900));
		
		JLabel title = new JLabel("Player Creation");
		title.setForeground(Color.BLACK);
		title.setFont(new Font("Vivaldi", Font.PLAIN, 90));
		title.setBounds(605, 11, title.getPreferredSize().width, title.getPreferredSize().height);
		add(title);
		
		txtEnterPlayerName = new JTextField();
		txtEnterPlayerName.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 20));
		txtEnterPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterPlayerName.setText("ENTER PLAYER NAME");
		txtEnterPlayerName.setForeground(Color.WHITE);
		txtEnterPlayerName.setBackground(Color.BLACK);
		txtEnterPlayerName.setBounds(625, 174, 449, 50);
		add(txtEnterPlayerName);
		txtEnterPlayerName.setColumns(10);
		
		RaceSelectPanel raceSelectPanel = new RaceSelectPanel();
		raceSelectPanel.setBounds(634, 276, 432, 320);
		add(raceSelectPanel);
		
		ColorChooseBox colorChooseBox = new ColorChooseBox();
		colorChooseBox.setBounds(250, 664, 1200, 173);
		add(colorChooseBox);
		
		JLabel lblChooseColor = new JLabel("Choose A Color: ");
		lblChooseColor.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblChooseColor.setBounds(701, 607, lblChooseColor.getPreferredSize().width, lblChooseColor.getPreferredSize().height);
		add(lblChooseColor);
		
		JButton done = new JButton("Done");
		done.setForeground(Color.WHITE);
		done.setBackground(Color.BLACK);
		done.setBounds(805, 866, 115, 34);
		add(done);
	}
}
