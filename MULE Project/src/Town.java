/**
 * This class will need to be updated after the demo...
 * @author Hamilton Greene
 *
 */
public class Town extends Tile{
	
	public Town(){
		this.tileName="town";
	}
	
	@Override
	protected void buttonPressed(){
		TownScreen town = new TownScreen();
	}
}
