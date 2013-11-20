package ViewScreens;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import Player.Player;
import control.Controller;

public class PlayerStatsPanel extends JPanel implements Serializable
{
	private ArrayList<PlayerStatsBox> boxes = new ArrayList<>();
	private ArrayList<Player> players = Player.getPlArray();

	private PlayerStatsPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

		for (Player p : players)
		{
			PlayerStatsBox box = new PlayerStatsBox(p);
			boxes.add(box);
			add(box);
		}
	}

	public void updateBox()
	{
		int index = Controller.getController().getCurrentPlayerIndex();
		boxes.get(index).updateComponents();
	}

	public static PlayerStatsPanel getPanel()
	{
		return PlayerStatsPanelHolder.HOLDER;
	}

	private static class PlayerStatsPanelHolder
	{
		private final static PlayerStatsPanel HOLDER = new PlayerStatsPanel();
	}

}
