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

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.GridLayout;

/**
 * This class is responsible for creating the map and storing the tileMap, as a 2-D 
 * array, and the players of game, stored in the array players.
 * @author Michael Carlson
 *
 */
public class Map extends Screen {
	private Tile[][] tileMap;
	//private JButton[][] spotMap;
	private Player currentPlayer;
	private int playerX =0, playerY = 0;
	private int rows;
	private int columns;
	private static Map map;
	
	
	
	/**
	 * This is the constructor of the class which sets the number of tiles on the map and also 
	 * sets the players array equal to the parameters value. 
	 * 
	 * @param numTiles
	 * @param newPlayers
	 */
	public Map(){
		super();
		map = this;
	}
	public Map(Color c){
		super(c);
	}
	
/**
 * this takes in a 2d array of Tiles from Controller filled with tile pieces.
 * @param tileMap
 */
	public Map(Tile[][] tileMap){
		super();
		this.tileMap = tileMap;
		rows = tileMap.length;
		columns = tileMap[0].length;
		setLayout(new GridLayout(rows, columns));
		
		//adds the tiles to the Jpanel
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				add(tileMap[i][j]);
			}
			
		}
		
		//draws the players character on the screen.
		//player.drawPlayer();
		
		
	}
	
	public static Map getMap(){
		return map;
	}
	//kl
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//g.setColor(Color.BLACK);
		//g2.fillRect(0, 0, 999999, 999999);
		g.setColor(Color.BLUE);

//		g.fillRect(playerX, playerY, 20, 20);
		
	}
	
//	public void drawMap(Player player){
//		for(int i=0; i<rows; i++){
//			for(int j = 0; j<columns; j++){
//				tileMap[i][j] = (Tile) new JButton();
//			}
//			
//		}
//	}
	
	public Tile[][] getTileMap(){
		return tileMap;
	}

	
	@Override
/*	public void keyPressed(KeyEvent e) {
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
	
*/	
	public static void main(String[] args){
		Map testMap = new Map();
		GameFrame test = new GameFrame();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setVisible(true);
		test.add(testMap);
		test.pack();
	}
}
