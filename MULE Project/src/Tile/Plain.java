package Tile;

public class Plain extends Tile{
	String directory;
	
	public Plain(){
		foodProduced = 2;
		dragonFireProduced = 3;
		oreProduced = 1;
		this.directory = "./Images/plain.png";
		setUp(directory);
	}
}
