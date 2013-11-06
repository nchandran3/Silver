package ViewScreens;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;


/**
 * Displays announcements to the player
 * @author Naveen Chandran
 *
 */
public class Announcement extends JOptionPane{

	public Announcement(String msg)
	{
		JOptionPane.showMessageDialog(null, msg, "ANNOUNCEMENT!", JOptionPane.PLAIN_MESSAGE);
	}
}