package Game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.*;

import control.Controller;
import control.Iterator;
import control.Store;


/**
 * This class takes care of the saving and loading of game paraphernalia.  
 * @author Hamilton Greene
 *
 */
public class Cerealizer implements Serializable{

	private static final long serialVersionUID = 117;
	private static Logger aLogger = Logger.getLogger("BigBadMotherfucker");
	private static final String filename = "MuleLogData";
	private Controller controller;
	private static Iterator iterator;
	private static Store store;
	private static Cerealizer cereal;
	
	public void save(){
		ingest();
		 try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(this);
        } catch (FileNotFoundException e) {
            aLogger.log(Level.SEVERE, "Save file not found: " + filename, e);
        } catch (IOException e) {
            aLogger.log(Level.SEVERE, "General IO Error on saving: " + filename, e);
        }
	}
	
	/**
	 * This takes in all the information needed to save the game.
	 */
	public void ingest(){
		controller = Controller.getController();
		iterator = Iterator.getIterator();
		store = Store.getStore();
	}
	
	public void load(){
		cereal = null;
		try {
           
           ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
           cereal = (Cerealizer) in.readObject();
           
       } catch (FileNotFoundException e) {
           aLogger.log(Level.SEVERE, "Load file not found: " + filename, e);
       } catch (IOException e) {
           aLogger.log(Level.SEVERE, "General IO Error on loading: " + filename, e);
       } catch (ClassNotFoundException e) {
           aLogger.log(Level.SEVERE, "Company class not found on loading: " + filename, e);
       }
		vomit(cereal);
	}
	
	private void vomit(Cerealizer frostedFlakes){
		if(frostedFlakes!=null){
			controller = new Controller(controller);
			iterator = new Iterator(iterator);
			store = new Store(store);
		}
	}
}
