import java.awt.EventQueue;


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
					Iterator iterator = new Iterator(frame.getContentPane());
					Controller controller = new Controller();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
