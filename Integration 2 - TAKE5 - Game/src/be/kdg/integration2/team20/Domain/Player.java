package be.kdg.integration2.team20.Domain;

public abstract class Player {

    Card[] playHand;
    Card playedCard;
    private String name;


    public abstract Card playCard();
    public abstract void showHand(Deck deck);

    public Player(String name) {
        this.name = name;
    }
    public abstract String getType();

}
