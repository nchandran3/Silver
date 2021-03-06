package Player;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Components.*;
import Player.*;
import Tile.*;
import ViewScreens.*;
import control.*;
import Game.*;

/**
 * This class is responsible for the player's basic information.
 * 
 * @author Hamilton Greene
 * 
 */

public class Player implements Serializable, Comparable<Player>
{
	private ImageIcon image;
	private int score;
	private final Race race;
	private String name;
	private Color color;
	private int dragonFire;
	private int gold;
	private int food;
	private int ore;
	private int muleType; // -1= No mule, 0 = food, 1 = dragonFire, 2 = ore
	private int tilesOwned;
	private ArrayList<Tile> properties;
	private Point location;
	private static ArrayList<Player> plArray = new ArrayList<Player>();
	private static ArrayList<ImageIcon> sprites;

	/**
	 * This is the constructor for the player class which initializes the player's data.
	 * 
	 * @param name
	 * @param color
	 * @param race
	 */
	public Player(String name, Color color, Race race)
	{
		properties = new ArrayList<Tile>();
		this.name = name;
		this.color = color;
		this.race = race;
		playerInit();
		location = new Point(0, 0);
		plArray.add(this);
	}

	/**
	 * Moves the player's location to the point given. Returns the point the player ends up at.
	 */
	public Point move(Point p)
	{
		location.move(p.x, p.y);
		return location;
	}

	/**
	 * Get the player's location.
	 */
	public Point getLocation()
	{
		return location;
	}

	public static ArrayList<Player> getPlArray()
	{
		return plArray;
	}

	public int calculateTime()
	{

		return 20 + food;
	}

	/**
	 * updates the player's resources amount based on transactions that happen in-game. Negative integers will deplete
	 * the player's resources.
	 * 
	 */
	public void addResources(int dragonFire, int gold, int food, int ore)
	{
		this.dragonFire += dragonFire;
		this.gold += gold;
		this.food += food;
		this.ore += ore;
		PlayerStatsPanel.getPanel().updateBox();
	}

	/**
	 * This method will set the player's attributes and starting resources based on map chosen, difficulty, and selected
	 * race.
	 */
	public void playerInit()
	{
		// This code is to be implemented if/when additional map types are introduced
		// map = Map.getMapType();
		// resources[x] moneyStart = 1000;
		// (where x is chosen slot for money)
		// if(map==North){
		// if(race == Lannister){
		// moneyStart = 600;
		// }else if(race == Stark){
		// moneyStart = 1600;
		// }
		// }else if(map==AcrossSea){
		// if(race == Baratheon){
		// moneyStart = 600;
		// ]else if(race == Targaryen){
		// moneyStart = 1600;
		// }else{
		// if(race==Targaryen){
		// moneyStart = 600;
		// }else if(race == Lannister){
		// moneyStart == 1600;
		// }
		// }

		if (Controller.getController().getDifficulty() == 1)
		{
			food = 8;
			dragonFire = 4;
		}
		else
		{
			food = 4;
			dragonFire = 2;
		}
		gold = race.getStartMoney();
		ore = 0;
		tilesOwned = 0;
		image = new ImageIcon("./Images/danny_sprite.png");
		muleType = -1;
		// tintImage(image); reimplement once image array is set up
	}

	/**
	 * Tints the sprite image to the player's designated color.
	 * 
	 * @param image
	 *            the sprite of the player
	 */
	public void tintImage(BufferedImage image)
	{
		for (int x = 0; x < image.getWidth(); x++)
		{
			for (int y = 0; y < image.getHeight(); y++)
			{
				image.setRGB(x, y, color.getRGB());
			}
		}
	}

	/**
	 * Getter for race
	 * 
	 * @return Race
	 */
	public Race getRace()
	{
		// TODO Auto-generated method stub
		return race;
	}

	/**
	 * Sets the player's gold to the provided quantity. Should be used primarily in the case that some outside force
	 * would cause the player's gold quantity to go sub zero to set the gold amount to 0.
	 * 
	 * @param goldQuantity
	 */
	public void setGold(int goldQuantity)
	{
		gold = goldQuantity;
	}

	public int getGold()
	{
		return gold;
	}

	public int getDragonFire()
	{
		return dragonFire;
	}

	public int getFood()
	{
		return food;
	}

	public int getOre()
	{
		return ore;
	}

	/**
	 * Calculates the player's current score. Score calculation = sum of resources * properties owned
	 * 
	 * @return
	 */
	public int getScore()
	{
		return (getFood() + getDragonFire() + getGold()) * getProperties();
	}

	public Color getColor()
	{
		return color;
	}

	/**
	 * Returns the player's image, set in playerInit().
	 * 
	 * @return
	 */
	public ImageIcon getImage()
	{
		return image;
	}

	/**
	 * Returns -1 if the player has no mule, 0, 1, or 2 for food, energy, and ore respectively
	 * 
	 * @return
	 */
	public int getMule()
	{
		return muleType;
	}

	/**
	 * Setting the muleType should follow these guidelines: -1 = no mule, 0 = food mule, 1 = dragonFire mule, 2 = ore
	 * mule
	 * 
	 * @param muleType
	 */
	public void setMule(int muleType)
	{
		this.muleType = muleType;
	}

	/**
	 * Player just gained a property.
	 */
	public void addProperty(Tile newProperty)
	{
		properties.add(newProperty);
		tilesOwned++;
	}

	/**
	 * Player just lost a property.
	 */
	public void removeProperty(Tile oldProperty)
	{
		properties.remove(oldProperty);
		tilesOwned--;
	}

	/**
	 * Returns the number of properties owned. Mainly used for player score valuation.
	 * 
	 * @return
	 */
	public int getProperties()
	{
		return tilesOwned;
	}

	public ArrayList<Tile> getPropertiesArray()
	{
		return properties;
	}

	@Override
	public String toString()
	{
		return name;
	}

	/**
	 * This method details how Players are supposed to be compared (by score). Compares in opposite order to accomodate
	 * for Collection.sorts required ascending order sort
	 * 
	 * @param o
	 * @return
	 */
	@Override
	public int compareTo(Player pCompare)
	{
		// TODO Auto-generated method stub
		int compareScore = pCompare.getScore();
		return compareScore - this.getScore();
	}

}
