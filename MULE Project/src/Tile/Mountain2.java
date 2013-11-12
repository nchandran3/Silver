package Tile;

public class Mountain2 extends Tile{

String directory;
	
	public Mountain2(){
		foodProduced = 1;
		dragonFireProduced = 1;
		oreProduced = 3;
		this.directory = "./Images/mountain.png";
		setUp(directory);
	}
}
