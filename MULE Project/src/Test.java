import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import control.GTools;

public class Test extends JFrame
{

	JPanel pane1, pane2, pane3;
	JLayeredPane layers;

	public Test()
	{
		setLayout(new BorderLayout());
		init();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private void init()
	{
		layers = new JLayeredPane();
		layers.setPreferredSize(new Dimension(800, 800));
		pane1 = new Pane1();
		pane2 = new Pane2();
		pane3 = new Pane3();

		layers.add(pane1, 1);
		layers.add(pane2, 2);
		layers.add(pane3, new Integer(-1));

		add(layers, BorderLayout.CENTER);
	}

	private abstract class Paner extends JPanel
	{
		protected int HEIGHT = 800, WIDTH = 800;

		public Paner()
		{
			setLayout(null);
			setPreferredSize(new Dimension(WIDTH, HEIGHT));
		}

		public int getWidth()
		{
			return WIDTH;
		}

		public int getHeight()
		{
			return HEIGHT;
		}
	}

	private class Pane1 extends Paner
	{
		public Pane1()
		{
			setOpaque(false);
			GTools.positionAndAdd(new JButton("HELLO"), .1, .5, this);
		}

	}

	private class Pane2 extends Paner
	{
		public Pane2()
		{
			setOpaque(false);
			GTools.positionAndAdd(new JLabel(
					"THIS IS WHAT YOU GET FOR BEING STUPID"), .2, .5, this);
		}
	}

	private class Pane3 extends Paner implements KeyListener, ActionListener
	{
		int x, y;

		public Pane3()
		{
			setBackground(Color.RED);
			addKeyListener(this);
			setFocusable(true);
			requestFocus();
			x = 250;
			y = 250;

			javax.swing.Timer timer = new javax.swing.Timer(100, this);
			timer.start();
		}

		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			System.out.println("MOVE");
			g.drawString("Hello", x, y);
		}

		@Override
		public void keyPressed(KeyEvent e)
		{
			System.out.println("KEY PRESSED");
			int src = e.getKeyCode();

			if (src == KeyEvent.VK_LEFT)
				x--;
			if (src == KeyEvent.VK_RIGHT)
				x++;
			if (src == KeyEvent.VK_UP)
				y--;
			if (src == KeyEvent.VK_DOWN)
				y++;

			repaint();

		}

		@Override
		public void keyReleased(KeyEvent e)
		{
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent e)
		{
			// TODO Auto-generated method stub

		}

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			x++;
			y++;
			this.repaint();
		}

	}

	public static void main(String[] args)
	{
		new Test();
	}
}
