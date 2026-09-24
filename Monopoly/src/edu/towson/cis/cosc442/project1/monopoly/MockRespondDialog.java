package edu.towson.cis.cosc442.project1.monopoly;

public class MockRespondDialog implements RespondDialog {
    public MockRespondDialog(TradeDeal deal) {
    }

    /** 
     * @return boolean
     */
    public boolean getResponse() {
        return true;
    }
}
