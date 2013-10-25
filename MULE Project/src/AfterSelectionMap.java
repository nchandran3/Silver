import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import control.GTools;

/**
 * 
 */


/**
 * @author Andrew Ford
 *
 */
public class AfterSelectionMap extends Screen{
	public AfterSelectionMap(){
		super();
		Map map = Map.getMap();
		
		Tile[][] tileMap = map.getTileMap();
		for(int i = 0; i < tileMap.length; i++){
			for(int j = 0; j < tileMap[0].length;j++)
			if(!tileMap[i][j].equals(tileMap[2][4])){
				tileMap[i][j].setEnabled(false);
			}
		}
		add(map);
		JButton pub = new JButton("Pub");
		GTools.positionAndAdd(pub, .5, 1.01, this);
		pub.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{		
				Controller controller = Controller.getController();
				if(controller.incrementCurrentPlayer() == null){
					Iterator iterator = Iterator.getIterator();
					iterator.switchScreen(new LandSelection());
				}
			}
		});
		GTools.positionAndAdd(pub, .90, .90, this);
	}
	
	public static void main (String [] args)
	{
		Controller controller = new Controller();
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.getContentPane().setLayout(new java.awt.CardLayout());
		//Iterator iterator = new Iterator(frame);
		new Map();
		frame.getContentPane().add(new AfterSelectionMap());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(new Point(100,0));
		frame.pack();
		frame.setVisible(true);
	}
}
