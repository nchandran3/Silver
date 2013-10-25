import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import control.GTools;

/**
 * 
 * @author Andrew Ford
 *
 */
public class TownScreen extends Screen implements MouseListener{
//	int Xcord = 0;
//	int Ycord = 0;
	int step_size = 10;
	
	public TownScreen(){
		super();
		this.setBackground(new Color(255, 200, 0));
		//super(Color.YELLOW);
		setLayout(null);
	}
	/**
	 * Draws the town screen and all its components
	 * @param Graphics G
	 */
	public void paintComponent(Graphics g){ 
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//Image store = GTools.compress(new ImageIcon("./Images/store.png"), 80, 80).getImage();
		//super.paintComponent(g);
		g.setColor(Color.ORANGE);
		g2.fillRect(0, 0, 999999, 999999);
		
		g2.setFont(new Font("Stencil", Font.BOLD, 30));
		Image store = new ImageIcon("./Images/store.png").getImage();
		g2.drawImage(store , 0, 40, super.getWidth()/4, super.getHeight()/3, null);
		g2.setColor(Color.BLACK);
		g2.drawString("STORE", 10, 30);
		
		g2.setFont(new Font("Stencil", Font.BOLD, 30));
		Image pub = new ImageIcon("./Images/pub.png").getImage();
		g2.drawImage(pub, super.width/4, 40, super.width/4, super.height/3, null);
		g2.drawString("PUB", super.width/4, 30);
		
		g2.setFont(new Font("Stencil", Font.BOLD, 30));	
		Image officeImage = new ImageIcon("./Images/auction.png").getImage();
		g2.drawImage(officeImage, super.width/2, 40, super.width/4, super.height/3, null);
		g2.drawString("AUCTION HOUSE", super.width/2, 30);
		
		g2.setFont(new Font("Stencil", Font.BOLD, 30));	
		Image assay = new ImageIcon("./Images/assay.png").getImage();
		g2.drawImage(assay, super.width/4 * 3, 40, super.width/4, super.height/3, null);
		g2.drawString("ASSAY", super.width/4 *3, 30);
		
		JButton back = new JButton("Back");
		back.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{		
				Iterator iterator = Iterator.getIterator();
				iterator.switchScreen(Map.getMap());
			}
		});
		GTools.positionAndAdd(back, .5, .9, this);
	}
/*
  	public int getX(){
		
		return Xcord;
	}
	public int getY(){
		
		return Ycord;
	}
	public void setX(int x){
		Xcord = x;
	}
	public void setY(int y){
		Ycord = y;
	}
	public void updatePos(){
		
	}*/
/*	public int checkCollision(int x, int y){
		if(y <= super.height/3){
			if(x >= 0 && x < super.width/4){
				return 1;
			}
			else if(x >= super.width/4 && x < super.width/2){
				return 2;
			}
			else if(x >= super.width/2 && x < super.width/4 * 3){
				return 3;
			}
			else{
				return 4;
			}
		}
		else{
			return 0;
		}
	}
	public void chooseStore(int x, int y){
		Iterator iterator = Iterator.getIterator();
		if(checkCollision(x, y) == 1){
			iterator.switchScreen(pub);
		}
	}*/
	public static void main (String [] args)
	{
		Controller controller = new Controller();
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.getContentPane().setLayout(new java.awt.CardLayout());
		//Iterator iterator = new Iterator(frame);
		frame.getContentPane().add(new TownScreen());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(new Point(100,0));
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
