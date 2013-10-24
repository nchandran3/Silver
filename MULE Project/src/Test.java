import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Test extends Screen{

	Test2 test2;
	public Test()
	{
		setPreferredSize(new Dimension(1280,720));
		setLayout(new GridLayout(5,9));
		for(int i =0; i< 45; i++)
		{
			JButton button = new JButton(""+ i);
			int rand = (int) (Math.random()*10);
			if(rand < 1)
				button.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
			else if (rand <2)
				button.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 3));
			else if (rand <3)
				button.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 3));


			if(rand >7)
				button.setIcon(new ImageIcon("./Images/mountain.png"));
			else if (rand > 5)
				button.setIcon(new ImageIcon("./Images/river.png"));
			else if (i == 22)
				button.setIcon(new ImageIcon("./Images/town.png"));
			else
				button.setIcon(new ImageIcon("./Images/plain.png"));
			add(button);
		}
		
	}
	
	public JPanel getTest2()
	{
		return new Test2();
	}
	
	
	private class Test2 extends JPanel implements KeyListener
	{
		int x, y;
		private Test2()
		{
			setPreferredSize(new Dimension(720,720));
			setOpaque(false);
			 x = 0;
			 y = 0;
			 addKeyListener(this);
			 setFocusable(true);
			 requestFocus();
		}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillRect(x, y, 40, 40);
		}

		@Override
		public void keyPressed(KeyEvent e) {
//				System.out.println("down");
				int code = e.getKeyCode();
				if(code == KeyEvent.VK_DOWN){
					y+=5;
					System.out.println("down");
//					playerY =+ 2;
//					repaint();
					
				}
				if(code == KeyEvent.VK_UP){
					y-=5;
//					playerY =- 2;
//					repaint();
				}
				if(code == KeyEvent.VK_LEFT){
					x-=5;
//					playerX =+ 2;
//					repaint();
				}
				if(code == KeyEvent.VK_RIGHT){
					x+=5;
//					playerX =- 2;
//					repaint();
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
	}
	public static void main (String [] args)
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Test test = new Test();
		frame.add(test);
		frame.getRootPane().setGlassPane(test.getTest2());
		frame.getRootPane().getGlassPane().setVisible(true);
		//JPanel glass = (JPanel) frame.getGlassPane();
//		glass.getGraphics().fillRect(10, 10, 100, 100);
//		glass.setVisible(true);
		frame.pack();
		frame.setVisible(true);
	}
}
