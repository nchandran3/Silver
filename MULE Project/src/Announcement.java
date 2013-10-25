import javax.swing.JOptionPane;


/**
 * Displays announcements to the player
 * @author Naveen Chandran
 *
 */
public class Announcement extends JOptionPane {

	public Announcement(String msg)
	{
		JOptionPane.showMessageDialog(null, msg, "ANNOUNCEMENT!", JOptionPane.PLAIN_MESSAGE);
	}
}