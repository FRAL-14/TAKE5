package be.kdg.integration2.take5.model;

public abstract class Player {

    public static int aiBullTotal = 0;
    public static int humanBullTotal = 0;

    public static int getAiBullTotal() {
        return aiBullTotal;
    }

    public static int getHumanBullTotal() {
        return humanBullTotal;
    }

    //public abstract Card playCard();
    public abstract void showHand(Deck deck);


//    public void addCard(Card card) {
//        MAX_HAND_SIZE.add(card);
//    }


}
