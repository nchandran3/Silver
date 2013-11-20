package Tile;

public class River extends Tile
{

	String directory;

	public River()
	{
		foodProduced = 4;
		dragonFireProduced = 2;
		this.directory = "./Images/river.png";
		setUp(directory);
	}
}
