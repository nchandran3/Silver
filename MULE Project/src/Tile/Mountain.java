package Tile;

public class Mountain extends Tile
{

	String directory;

	public Mountain()
	{
		foodProduced = 1;
		dragonFireProduced = 1;
		oreProduced = 2;
		this.directory = "./Images/mountain.png";
		setUp(directory);
	}
}
