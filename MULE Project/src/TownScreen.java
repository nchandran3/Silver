import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.geom.Line2D;


public class TownScreen extends Map {
	int Xcord = 640;
	int Ycord = 600;
	int step_size = 10;
	public TownScreen(){
		//super();
		//setBackground(Color.ORANGE);
		super(Color.YELLOW);		
		setPreferredSize(new Dimension(super.width,super.height));
		setLayout(null);
	}
	public void paintComponent(Graphics g){  
		Graphics2D g2 = (Graphics2D) g;
	/*	g2.drawImage(storeImage, 0, 0, super.width/4, super.height/3, null);
		g2.drawImage(assayImage, super.width/4, 0, super.width/4, super.height/3, null);
		g2.drawImage(officeImage, super.width/2, 0, super.width/4, super.height/3, null);
		g2.drawImage(pubImage, super.width/4 * 3, 0, super.width/4, super.height/3, null);*/
	}
/*
  	public int getX(){
		
		return Xcord;
	}
	public int getY(){
		
		return Ycord;
	}
	public void updatePos(){
		if()
	}
	public boolean checkCollision(int x, int y){
		if(y <= super.height/3){
			
		}
		else{
			return false;
		}
	}
	private
	*/
	public static void main(String[]args){
		Controller controller = new Controller();
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.getContentPane().setLayout(new java.awt.CardLayout());
		Iterator iterator = new Iterator(frame);
		frame.getContentPane().add(new TownScreen());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(new Point(100,0));
		frame.pack();
		frame.setVisible(true);
	}
}
