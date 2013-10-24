/**
 * This class will need to be updated after the demo...
 * @author Hamilton Greene
 *
 */
public class Town extends Tile{
	
String directory;
	
	public Town(){
		
		this.directory = "./Images/town.png";
		setUp(directory);
	}
	
	@Override
	protected void buttonPressed(){
		TownScreen town = new TownScreen();
	}
}
