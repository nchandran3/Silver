import java.awt.Point;

/**
 * Theoretically supposed to interface for Player
 * @author Hamilton Greene
 *
 */
public interface Person {

		public Point move(Point p);
		public Point getLocation();
		
		public Race getRace();


}
