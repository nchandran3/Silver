package control;
import java.awt.EventQueue;
import java.awt.Frame;

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
						GameFrame.getFrame();
						Iterator.getIterator();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		else 
		{
			GameSaveLoad game = GameSaveLoad.getFromFile("save.dat");
			Controller.setController(game.getController());		//reset the controller
			Iterator.setIterator(game.getIterator());			//reset the iterator
			Iterator iterator = Iterator.getIterator();
			iterator.switchScreen(iterator.getScreen());		//makes the next screen to show up the last screen
			iterator.getFrame().setVisible(true);				
			game.reset();										//resets the listeners
			System.out.println(Controller.getController().getNumPlayers()); //shows the number of players
			
		}
	}

}
