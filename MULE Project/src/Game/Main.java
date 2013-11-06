package Game;
import java.awt.EventQueue;

import control.*;



/**
 * @author Naveen Chandran
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame();
					Iterator iterator = new Iterator(frame);
					Controller controller = new Controller();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
