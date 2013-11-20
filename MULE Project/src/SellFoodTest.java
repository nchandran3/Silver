import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import Player.Player;
import Player.Race;
import control.Store;


public class SellFoodTest {
	Store ts;
	Player tp;
	
	public void setup() {
		System.out.println("Setting up the store and player...");
		ts = Store.getStore();
		tp = new Player("Test", Color.black, Race.STARK);
	}

}
