package edu.towson.cis.cosc442.project1.monopoly;

public class MockGUI implements MonopolyGUI {
    private boolean btnDrawCardState, btnEndTurnState, btnGetOutOfJailState;
    private boolean[] btnTradeState = new boolean[2];

    /** 
     * @param playerIndex
     */
    public void enableEndTurnBtn(int playerIndex) {
    }

    /** 
     * @param playerIndex
     */
    public void enablePlayerTurn(int playerIndex) {
    }

    /** 
     * @param playerIndex
     */
    public void enablePurchaseBtn(int playerIndex) {
    }
	/** 
     * @return int[]
     */
    public int[] getDiceRoll() {
		int roll[] = new int[2];
		roll[0] = 2;
		roll[1] = 3;
		return roll;
	}

    /** 
     * @return boolean
     */
    public boolean isDrawCardButtonEnabled() {
        return btnDrawCardState;
    }

    /** 
     * @return boolean
     */
    public boolean isEndTurnButtonEnabled() {
        return btnEndTurnState;
    }
	
	/** 
     * @return boolean
     */
    public boolean isGetOutOfJailButtonEnabled() {
		return btnGetOutOfJailState;
	}

    /** 
     * @param i
     * @return boolean
     */
    public boolean isTradeButtonEnabled(int i) {
        return btnTradeState[i];
    }

    /** 
     * @param index
     * @param from
     * @param to
     */
    public void movePlayer(int index, int from, int to) {
    }

    /** 
     * @param deal
     * @return RespondDialog
     */
    public RespondDialog openRespondDialog(TradeDeal deal) {
        RespondDialog dialog = new MockRespondDialog(deal);
        return dialog;
    }

    /** 
     * @return TradeDialog
     */
    public TradeDialog openTradeDialog() {
        TradeDialog dialog = new MockTradeDialog();
        return dialog;
    }

    /** 
     * @param b
     */
    public void setBuyHouseEnabled(boolean b) {
    }

    /** 
     * @param b
     */
    public void setDrawCardEnabled(boolean b) {
        btnDrawCardState = b;
    }

    /** 
     * @param enabled
     */
    public void setEndTurnEnabled(boolean enabled) {
        btnEndTurnState = enabled;
    }

    /** 
     * @param b
     */
    public void setGetOutOfJailEnabled(boolean b) {
    	this.btnGetOutOfJailState = b;
    }

    /** 
     * @param enabled
     */
    public void setPurchasePropertyEnabled(boolean enabled) {
    }

    /** 
     * @param b
     */
    public void setRollDiceEnabled(boolean b) {
    }

    /** 
     * @param index
     * @param b
     */
    public void setTradeEnabled(int index, boolean b) {
        this.btnTradeState[index] = b;
    }

    /** 
     * @param currentPlayer
     */
    public void showBuyHouseDialog(Player currentPlayer) {
    }

    /** 
     * @param string
     */
    public void showMessage(String string) {
    }

	/** 
     * @return int
     */
    public int showUtilDiceRoll() {
//		int[] diceValues = GameMaster.instance().rollDice();
//		return diceValues[0] + diceValues[1];
		return 10;
	}

    public void startGame() {
    }

	public void update() {
	}
}
