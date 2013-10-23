import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class for drawing the player sprite across the map. Will be overlaid and transparent over map.
 * @author Michael
 *
 */
public class MapGlassPane extends Screen implements KeyListener {
	private ImageIcon sprite;
	
	public MapGlassPane(){
		
		sprite = Iterator.getIterator().getCurrPlayer().g
		this.setOpaque(false);
		this.setVisible(true);
		
		this.setFocusable(true);
		requestFocus();
		
		 
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.red);
//		g2.fillRect(0, 0, 999999, 999999);
		g.setColor(Color.BLUE);
		g2.fill(rec);
		
	}
	public void keyPressed(KeyEvent e) {
//		System.out.println("down");
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_DOWN){
			rec.setLocation(rec.x, rec.y + 2);
			System.out.println("down");
			playerY =+ 2;

		}
		if(code == KeyEvent.VK_UP){
			rec.setLocation(rec.x, rec.y - 2);
//			playerY =- 2;

		}
		if(code == KeyEvent.VK_LEFT){
			rec.setLocation(rec.x - 2, rec.y);
//			playerX =+ 2;

		}
		if(code == KeyEvent.VK_RIGHT){
			rec.setLocation(rec.x + 2, rec.y);
//			playerX =- 2;

		}
		repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new JButton("hello"));
		MapGlassPane gp = new MapGlassPane();
		JPanel glass = (JPanel) frame.getGlassPane();
		glass.setVisible(true);
		glass.add(gp);
		gp.requestFocus();
		frame.pack();
		frame.setVisible(true);
	}

}
