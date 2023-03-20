package be.kdg.integration2.take5.model;

public abstract class Player {

    public int aiBullTotal = 0;
    public int humanBullTotal = 0;

    //public abstract Card playCard();
    public abstract void showHand(Deck deck);

//TODO: askName() should only be in Human, since the AI wont enter its name!


}
