package ViewScreens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import control.Controller;
import control.Iterator;
import Player.Player;
import Player.Race;

public class PlayerStatsBox extends JPanel implements ActionListener,
		Serializable
{
	private transient Toolkit toolkit = Toolkit.getDefaultToolkit();
	private int HEIGHT, WIDTH;
	private JLabel goldlbl, gold, orelbl, ore, dflbl, df, foodlbl, food,
			scorelbl, score;
	private Player pl;

	public PlayerStatsBox(Player pl)
	{
		super();
		this.pl = pl;

		determineSize();

		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(new GridLayout(0, 2));

		init(pl);
		addButtons();

	}

	public void init(Player pl)
	{
		goldlbl = new JLabel("GOLD:");
		gold = new JLabel("" + pl.getGold());

		orelbl = new JLabel("ORE:");
		ore = new JLabel("" + pl.getOre());

		dflbl = new JLabel("DRAGONFIRE:");
		df = new JLabel("" + pl.getDragonFire());

		foodlbl = new JLabel("FOOD:");
		food = new JLabel("" + pl.getFood());

		scorelbl = new JLabel("SCORE:");
		score = new JLabel("" + pl.getScore());

		setBackground(pl.getColor());
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		setBorder(BorderFactory.createTitledBorder(this.getBorder(),
				pl.toString(), TitledBorder.CENTER, TitledBorder.TOP));
	}

	public void determineSize()
	{
		HEIGHT = toolkit.getScreenSize().height / 12;
		WIDTH = toolkit.getScreenSize().width / 6;
	}

	public void addButtons()
	{
		add(goldlbl);
		add(gold);
		add(foodlbl);
		add(food);
		add(dflbl);
		add(df);
		add(orelbl);
		add(ore);
		add(scorelbl);
		add(score);
	}

	public void updateComponents()
	{
		gold.setText("" + pl.getGold());
		food.setText("" + pl.getFood());
		df.setText("" + pl.getDragonFire());
		ore.setText("" + pl.getOre());
		score.setText("" + pl.getScore());
	}

	public static void main(String[] args)
	{
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.getContentPane().setLayout(new java.awt.CardLayout());
		frame.getContentPane().add(
				new PlayerStatsBox(new Player("BOZO", Color.MAGENTA,
						Race.TARGARYEN)));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(new Point(100, 0));
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub

	}
}
