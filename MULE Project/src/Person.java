import java.awt.Point;


public interface Person {

		public Point move(Point p);
		public Point getLocation();
		
		public int[] addResources(int[] transaction);
		
		public Race getRace();


}
