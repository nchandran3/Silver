import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.Image;

import javax.swing.ImageIcon;







import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import control.GTools;

import java.awt.GridLayout;

/**
 * This class is responsible for creating the map and storing the tileMap, as a 2-D 
 * array, and the players of game, stored in the array players.
 * @author Michael Carlson
 *
 */
public class Map extends Screen implements KeyListener{
	private static Tile[][] tileMap;
	private static Map map;
	private Player currentPlayer;
	private int playerX, playerY = 0;
	private Rectangle rec;
	private int rows;
	private int columns;
	private int tile_width, tile_height;
	private Controller controller;
	
	
	/**
	 * This is the constructor of the class which sets the number of tiles on the map and also 
	 * sets the players array equal to the parameters value. 
	 * 
	 * @param numTiles
	 * @param newPlayers
	 */
	public Map(){
		super();
		//BorderLayout bd = new BorderLayout();
		
		controller = Controller.getController();
		controller.createMap();
		this.tileMap = controller.getTileMap();
		
		this.rows = tileMap.length;
		this.columns = tileMap[0].length;
		
		setLayout(new GridLayout(rows, columns));
		
		for(int i = 0; i < rows; i++){			//add tiles to screen
			for(int j = 0; j < columns; j++){
				add(tileMap[i][j]);
			}
		}
		
		tile_width = tileMap[0][0].getWidth();	//for use with MapGlassPane and the controller method 
		tile_height = tileMap[0][0].getHeight();// to return the tile given a coordinate. 
		
		map = this;								//there is only one map!
	}
	public Map(Color c){
		super(c);
	}
	
	public static Map getMap(){
		return map;
	}
	
/**
 * this takes in a 2d array of Tiles from Controller filled with tile pieces.
 * @param tileMap
 * @throws IllegalAccessException 
 * @throws InstantiationException 
 */
	public Map(Tile[][] tileMap){
		this.tileMap = tileMap;
		rows = tileMap.length;
		columns = tileMap[0].length;
		setLayout(new GridLayout(rows, columns));
		
		//adds the tiles to the Jpanel
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				JButton button = new JButton("" + i);
				
				add(button);
			}
			
		}
	/*	JButton pass = new JButton("PASS");
		pass.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{		
				Iterator iterator = Iterator.getIterator();
				
				iterator.switchScreen(Map.getMap());
			}
		});
		GTools.positionAndAdd(pass, .5, .9, this);
		*/
	}
	

	
	public Tile[][] getTileMap(){
		return tileMap;
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_DOWN){
			playerY =+ 2;
			repaint();
		}
		if(code == KeyEvent.VK_UP){
			playerY =- 2;
			repaint();
		}
		if(code == KeyEvent.VK_DOWN){
			playerX =+ 2;
			repaint();
		}
		if(code == KeyEvent.VK_UP){
			playerX =- 2;
			repaint();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main (String [] args)
	{
		
		Controller controller = new Controller();
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.getContentPane().setLayout(new java.awt.CardLayout());
		//Iterator iterator = new Iterator(frame);
		frame.getContentPane().add(new Map());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(new Point(100,0));
		frame.pack();
		frame.setVisible(true);
	}
}
