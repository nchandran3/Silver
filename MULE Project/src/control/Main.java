package control;
import java.awt.EventQueue;

import javax.swing.JOptionPane;

import Game.GameFrame;
import ViewScreens.StartScreen;
import control.*;



/**
 * @author Naveen Chandran
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new StartScreen();
		while(StartScreen.chosen == 0) {System.out.print("");}

		if(StartScreen.chosen == 1)			//create a new game
		{
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
		
		else 
		{
			GameSaveLoad game = GameSaveLoad.getFromFile("save.dat");
			Controller.setController(game.getController());
			Iterator.setIterator(game.getIterator());
			Iterator iterator = Iterator.getIterator();
			iterator.switchScreen(iterator.getScreen());
			iterator.getFrame().setVisible(true);
			System.out.println(Controller.getController().getNumPlayers());
		}
	}

}
