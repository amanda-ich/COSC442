package edu.towson.cis.cosc442.project1.monopoly;

public abstract class Card {

    public static int TYPE_CHANCE = 1;
    public static int TYPE_CC = 2;

    /**
     * Returns the label or description text of this card.
     * @return the label text of the card
     */
    public abstract String getLabel();
    /**
     * Executes the action associated with this card when drawn.
     */
    public abstract void applyAction();
    /**
     * Retrieves the type identifier of this card, indicating its category.
     * @return the integer type identifier of the card
     */
    public abstract int getCardType();
}
