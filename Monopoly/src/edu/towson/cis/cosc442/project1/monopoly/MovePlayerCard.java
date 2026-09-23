package edu.towson.cis.cosc442.project1.monopoly;


public class MovePlayerCard extends Card {
    
    private String destination;
    private int type;

    public MovePlayerCard(String destination, int cardType) {
        this.destination = destination;
        this.type = cardType;
    }

    public void applyAction() {
        Player currentPlayer = GameMaster.instance().getCurrentPlayer();
        Cell currentPosition = currentPlayer.getPosition();
        int newCell = GameMaster.instance().getGameBoard().queryCellIndex(destination);
        int currentCell = GameMaster.instance().getGameBoard().queryCellIndex(currentPosition.getName());
        int diceValue = newCell - currentCell; //Task 11 - redefined diceValue, removed the else if statement (CCM:3 -> CCM:2)
        if(currentCell > newCell) {
            diceValue += (GameMaster.instance().getGameBoard().getCellNumber());
        }
        System.out.println(diceValue);
        GameMaster.instance().movePlayer(currentPlayer, diceValue);
    }

    /** 
     * @return int
     */
    public int getCardType() {
        return type;
    }

    /** 
     * @return String
     */
    public String getLabel() {
        return "Go to " + destination;
    }

}
