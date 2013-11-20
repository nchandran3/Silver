package Tile;

public class Mountain3 extends Tile
{

	String directory;

	public Mountain3()
	{
		foodProduced = 1;
		dragonFireProduced = 1;
		oreProduced = 4;
		this.directory = "./Images/mountain.png";
		setUp(directory);
	}
}
