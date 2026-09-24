package edu.towson.cis.cosc442.project1.monopoly;

public class TradeDeal {
    private int amount;
    private int playerIndex;
    private String propertyName;

    /** 
     * @return int
     */
    public int getAmount() {
        return amount;
    }
    
    /** 
     * @return int
     */
    public int getPlayerIndex() {
        return playerIndex;
    }
    
    /** 
     * @return String
     */
    public String getPropertyName() {
        return propertyName;
    }
    
    /** 
     * @return String
     */
    // Task 12 - redefined makeMessage method
    public String makeMessage() {
        return GameMaster.instance().getCurrentPlayer() + 
        	" wishes to purchase " +
        	propertyName + " from " + 
        	GameMaster.instance().getPlayer(playerIndex) +
        	" for " + amount + ".  " + 
        	GameMaster.instance().getPlayer(playerIndex) +
        	", do you wish to trade your property?";
    }
    
    /** 
     * @param amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    /** 
     * @param propertyName
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
    
    /** 
     * @param playerIndex
     */
    public void setSellerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }
}
