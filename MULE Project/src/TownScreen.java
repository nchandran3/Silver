import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import control.GTools;


public class TownScreen extends Map {
	int Xcord = 640;
	int Ycord = 600;
	int step_size = 10;
	public TownScreen(){
		//super();
		//setBackground(Color.ORANGE);
		super(Color.YELLOW);
		setLayout(null);
	}
	public void displayTownScreen(){
		GTools.compress(new ImageIcon("./Images/store.png")));
		ImageIcon icon = new ImageIcon();
		Image icon2 = icon.getImage().getScaledInstance(148, 148, Image.SCALE_FAST);
		icon = new ImageIcon(icon2);
		image = new JLabel(icon);
	}
	public void paintComponent(Graphics g){  
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(store , 0, 0, super.width/4, super.height/3, null);
		g2.drawImage(assayImage, super.width/4, 0, super.width/4, super.height/3, null);
		g2.drawImage(officeImage, super.width/2, 0, super.width/4, super.height/3, null);
		g2.drawImage(pubImage, super.width/4 * 3, 0, super.width/4, super.height/3, null);*/
	}

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
		
	}
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
}
