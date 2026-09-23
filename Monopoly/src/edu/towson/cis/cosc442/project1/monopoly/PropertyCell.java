package edu.towson.cis.cosc442.project1.monopoly;

public class PropertyCell extends Cell {
	private String colorGroup;
	private int housePrice;
	private int numHouses;
	private int rent;
	private int sellPrice;

	/** 
	 * @return String
	 */
	public String getColorGroup() {
		return colorGroup;
	}

	/** 
	 * @return int
	 */
	public int getHousePrice() {
		return housePrice;
	}

	/** 
	 * @return int
	 */
	public int getNumHouses() {
		return numHouses;
	}
    
    /** 
	 * @return int
	 */
	public int getPrice() {
		return sellPrice;
	}

	/** 
	 * @return int
	 */
	public int getRent() {
		int rentToCharge = rent;
		String [] monopolies = theOwner.getMonopolies();
		rentToCharge = calculateMonopoliesRent(rentToCharge, monopolies);
		if(numHouses > 0) {
			rentToCharge = rent * (numHouses + 1);
		}
		return rentToCharge;
	}

	/** 
	 * @param rentToCharge
	 * @param monopolies
	 * @return int
	 */
	private int calculateMonopoliesRent(int rentToCharge, String[] monopolies) {
		for(int i = 0; i < monopolies.length; i++) {
			if(monopolies[i].equals(colorGroup)) {
				rentToCharge = rent * 2;
			}
		}
		return rentToCharge;
	}

	public void playAction() {
		Player currentPlayer = null;
		if(!isAvailable()) {
			currentPlayer = GameMaster.instance().getCurrentPlayer();
			if(theOwner != currentPlayer) {
				currentPlayer.payRentTo(theOwner, getRent());
			}
		}
	}

	/** 
	 * @param colorGroup
	 */
	public void setColorGroup(String colorGroup) {
		this.colorGroup = colorGroup;
	}

	/** 
	 * @param housePrice
	 */
	public void setHousePrice(int housePrice) {
		this.housePrice = housePrice;
	}

	/** 
	 * @param numHouses
	 */
	public void setNumHouses(int numHouses) {
		this.numHouses = numHouses;
	}

	/** 
	 * @param sellPrice
	 */
	public void setPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	/** 
	 * @param rent
	 */
	public void setRent(int rent) {
		this.rent = rent;
	}
}
