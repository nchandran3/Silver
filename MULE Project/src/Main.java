
/**
 * @author Naveen Chandran
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GameFrame frame = new GameFrame();
		Iterator iterator = new Iterator(frame);
		Controller controller = new Controller();
		frame.main(args);
	}

}
