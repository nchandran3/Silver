package control;

import static org.junit.Assert.*;

import org.junit.Test;

public class BuyDragonFireTest {

	@Test
	public void testBuyDragonFire() {
		Store store = Store.getStore();
		store.setDragonFirePrice(20);
		store.setFoodPrice(10);
		store.setOrePrice(15);
	}

}
