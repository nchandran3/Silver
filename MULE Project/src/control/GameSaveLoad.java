package control;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import Player.Race;
import Tile.Tile;
import Tile.TileListener;
/**
 * This class allows for the game state to be saved which then can later be accessed by loading it. 
 * @author Andrew Ford
 *
 */
public class GameSaveLoad implements Serializable
{
	private static GameSaveLoad game;
	private Controller savedController;
	private Iterator savedIterator;
	private Tile[][] map;

	/**
	 * This version number helps make sure everything is sync'd if we start changing object content
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The logger for this class
	 */
	private static Logger myLogger = Logger.getLogger("MULEGame.Silver");

	public GameSaveLoad(Controller c, Iterator i)
	{
		savedController = c;
		savedIterator = i;
	}

	/**
	 * Save this object via serialization
	 * 
	 * @param filename
	 *            the name of the file to save to
	 */
	public void save(String filename)
	{
		try
		{
			/*
			 * Create the object output stream for serialization. We are wrapping a FileOutputStream since we want to
			 * save to disk. You can also save to socket streams or any other kind of stream.
			 */
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(filename));

			/*
			 * The only real call we need. The stream buffers the output and reuses data, so if you are serializing very
			 * frequently, then the object values might not actually change because the old serialized object is being
			 * reused.
			 * 
			 * To fix this you can try writeUnshared() or you can reset the stream. out.reset();
			 */
			out.writeObject(this);
		}
		catch (FileNotFoundException e)
		{
			myLogger.log(Level.SEVERE, "Save file not found: " + filename, e);
		}
		catch (IOException e)
		{
			myLogger.log(Level.SEVERE, "General IO Error on saving: "
					+ filename, e);
		}

	}

	/**
	 * This is an example of a factory method We call this static method to create an instance of Company from a
	 * serialized file.
	 * 
	 * @param filename
	 *            the name of the file to use
	 * @return an instance of Company initialized from a file.
	 */
	public static GameSaveLoad getFromFile(String filename)
	{
		GameSaveLoad c = null;
		try
		{
			/*
			 * Create the input stream. Since we want to read from the disk, we wrap a file stream.
			 */
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					filename));
			/*
			 * Now we can read the entire company in with only one call
			 */
			c = (GameSaveLoad) in.readObject();

		}
		catch (FileNotFoundException e)
		{
			myLogger.log(Level.SEVERE, "Load file not found: " + filename, e);
		}
		catch (IOException e)
		{
			myLogger.log(Level.SEVERE, "General IO Error on loading: "
					+ filename, e);
		}
		catch (ClassNotFoundException e)
		{
			myLogger.log(Level.SEVERE, "Company class not found on loading: "
					+ filename, e);
		}
		return c;
	}

	public Controller getController()
	{
		return savedController;
	}

	public Iterator getIterator()
	{
		return savedIterator;
	}

	public void reset()
	{
		// map = savedController.getTileMap();
		Tile.changeClickListener(new TileListener());

	}

	public static void main(String[] args)
	{
		// Controller cont = new Controller();
		// GameSaveLoad test = new GameSaveLoad(cont, new Iterator());
		// cont.setDifficulty(5);
		// test.save("test.dat");
		// test.getFromFile("test.dat");
		// Controller.setController(getFromFile("test.dat").getController());
		// Iterator.setIterator(getFromFile("test.dat").getIterator());
		// test.
		// System.out.println(test.test);
		// test.test++;
		// System.out.println(test.test);
		// test.save("test.dat");
		// System.out.println(test.test);
	}
}
