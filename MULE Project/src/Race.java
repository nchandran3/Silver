
public enum Race {
	
	/*
	 * The numbers in the constructors represent the start money of each Race
	 */
	TARGARYEN(600), //represents the Human class
	GREYJOY(1000),
	LANNISTER(1600), //represents the Flapper class
	BARATHEON(1000),
	STARK(1000);
	
	
	
	private int start_money;
	Race(int mon) {
		this.start_money = mon;
	}
	
	public int getStartMoney()
	{
		return start_money;
	}
	
}
