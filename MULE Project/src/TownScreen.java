import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import control.GTools;


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
	public void updatePos(){
		if()
	}
	public boolean checkCollision(int x, int y){
		if(y <= super.height/3){
			return false;
		}
		else{
			return false;
		}
	}
}
