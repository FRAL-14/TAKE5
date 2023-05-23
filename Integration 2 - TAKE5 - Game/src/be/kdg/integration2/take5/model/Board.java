package be.kdg.integration2.take5.model;

import java.util.*;

public class Board {
    public LinkedList<Card> row1 = new LinkedList<>();
    public LinkedList<Card> row2 = new LinkedList<>();
    public LinkedList<Card> row3 = new LinkedList<>();
    public LinkedList<Card> row4 = new LinkedList<>();
    LinkedList<Card> closestRow = new LinkedList<>();
    LinkedList<Card> playHand;
    Card[] firstFiveCards = new Card[5];
    Deck deck;

    public Board(Deck deck) {
        this.deck = deck;
    }


    public LinkedList<Card> getRow1() {
        return row1;
    }

    public LinkedList<Card> getRow2() {
        return row2;
    }

    public LinkedList<Card> getRow3() {
        return row3;
    }

    public LinkedList<Card> getRow4() {
        return row4;
    }

    public void setRow1(LinkedList<Card> row1) {
        this.row1 = row1;
    }

    public void setRow2(LinkedList<Card> row2) {
        this.row2 = row2;
    }

    public void setRow3(LinkedList<Card> row3) {
        this.row3 = row3;
    }

    public void setRow4(LinkedList<Card> row4) {
        this.row4 = row4;
    }

    public LinkedList<Card> getHumanHand() {
        return deck.humanHand;
    }

    public LinkedList<Card> getAIHand() {
        return deck.aiHand;
    }


    /**
     * method to take 4 cards from boardHand List and adds them to the first place in each row
     *
     * @param deck
     */
    public void initializeRow(Deck deck) {
        row1.add(0, deck.boardHand.get(0));
        row2.add(0, deck.boardHand.get(1));
        row3.add(0, deck.boardHand.get(2));
        row4.add(0, deck.boardHand.get(3));
    }


    /**
     * method to check if a row had 6 cards, if a row has 6 cards the player that placed the last card must collect
     * the 5 first cards and add the bulls to his total, the last card becomes the first one in the row
     *
     * @param player
     */
    public void checkLists(Player player) {
        boolean listFilled = false;
        LinkedList<Card> removeCards = new LinkedList<>();
        if (row1.size() == 6) {
            for (int i = 0; i < 6; i++) {
                removeCards.add(i, row1.get(i));
                listFilled = true;
            }
            for (int j = 0; j < 5; j++) {
                row1.remove(row1.getFirst());
            }
        } else if (row2.size() == 6) {
            for (int i = 0; i < 6; i++) {
                removeCards.add(i, row2.get(i));
                listFilled = true;
            }
            for (int j = 0; j < 5; j++) {
                row2.remove(row2.getFirst());
            }
        } else if (row3.size() == 6) {
            for (int i = 0; i < 6; i++) {
                removeCards.add(i, row3.get(i));
                listFilled = true;
            }
            for (int j = 0; j < 5; j++) {
                row3.remove(row3.getFirst());
            }
        } else if (row4.size() == 6) {
            for (int i = 0; i < 6; i++) {
                removeCards.add(i, row4.get(i));
                listFilled = true;
            }
            for (int j = 0; j < 5; j++) {
                row4.remove(row4.getFirst());
            }
        }
        if (listFilled) {
            int humanBullTotal = 0;
            int aiBullTotal = 0;
            if (player instanceof Human) {
                humanBullTotal = player.bullValues(removeCards);
                player.setHumanBullTotal(humanBullTotal);
            } else {
                aiBullTotal = player.bullValues(removeCards);
                player.setAiBullTotal(aiBullTotal);
            }

//            for (int i = 0; i < 5; i++) {
//                if (player instanceof Human){
//                    humanBullTotal += removeCards.get(i).getValue();
//                } else {
//                    aiBullTotal += removeCards.get(i).getValue();
//                }
//            }
//            player.setHumanBullTotal(humanBullTotal);
//            player.setAiBullTotal(aiBullTotal);

        }
    }


    /**
     * method used to calculate which row is the most suitable for the card being played,
     * method is called in the playCard method
     *
     * @param playedCard
     * @return
     */
    //TODO: not sure but maybe this can be written in Card instead of Board?
    public LinkedList<Card> findClosestNumber(int playedCard) {
        Scanner scan = new Scanner(System.in);
        int closestNumber = Integer.MAX_VALUE;
        int smallestDifference = Integer.MAX_VALUE;
        boolean isTooLow = true;

        if (row1.getLast().getValue() < playedCard) {
            int difference = playedCard - row1.getLast().getValue();
            if (difference < smallestDifference) {
                smallestDifference = difference;
                closestNumber = row1.getLast().getValue();
                closestRow = row1;
                isTooLow = false;
            }
        }

        if (row2.getLast().getValue() < playedCard) {
            int difference = playedCard - row2.getLast().getValue();
            if (difference < smallestDifference) {
                smallestDifference = difference;
                closestNumber = row2.getLast().getValue();
                closestRow = row2;
                isTooLow = false;
            }
        }

        if (row3.getLast().getValue() < playedCard) {
            int difference = playedCard - row3.getLast().getValue();
            if (difference < smallestDifference) {
                smallestDifference = difference;
                closestNumber = row3.getLast().getValue();
                closestRow = row3;
                isTooLow = false;
            }
        }

        if (row4.getLast().getValue() < playedCard) {
            int difference = playedCard - row4.getLast().getValue();
            if (difference < smallestDifference) {
                smallestDifference = difference;
                closestNumber = row4.getLast().getValue();
                closestRow = row4;
                isTooLow = false;
            }
        }

        if (isTooLow) {
            closestRow = null;
        }
        return closestRow;
    }


    /**
     * playCard method takes parameter card that is inputted in gamePresenter class and then uses the findClosestNumber
     * class to determine position, card is then placed in correct row
     *
     * @param card
     */
    //TODO: this should be written in the Player class, and then you can call it in the Board class (!!)
    public boolean playCard(Card card, Player player) {
//        if (card == null){
//            return false;
//        }
        boolean lower = checkIfLower(card);
        if (lower){
            removeRow(card, player);
            return true;
        }

        // Get the card number at the given index
        int playedCard = card.getValue();
//        LinkedList<Card> playHand = deck.humanHand;

        closestRow = findClosestNumber(playedCard);

//        if (closestRow == null){
//            return false;
//        } else {
            // Remove the card from the hand list
//        playHand.remove(card);
            if (player instanceof Human){
                deck.humanHand.remove(card);
            } else {
                deck.aiHand.remove(card);
            }

            if (closestRow == row1) {
                row1.addLast(card);
            } else if (closestRow == row2) {
                row2.addLast(card);
            } else if (closestRow == row3) {
                row3.addLast(card);
            } else if (closestRow == row4) {
                row4.addLast(card);
            }
            return true;
//        }
    }


    /**
     * method used to clear the board when the game is restarted, otherwise board would be initialised with previous
     * card still added to rows
     */
    public void clear() {
        row1.clear();
        row2.clear();
        row3.clear();
        row4.clear();
    }


//    public void chooseRow(int row, Player player, Card card){
//        boolean listFilled = false;
//        LinkedList<Card> removeCards = new LinkedList<>();
//        if (row == 1){
//            row1.add(card);
//            for (int i = 1; i < row1.size(); i++){
//                removeCards.add(row1.getFirst());
//                row1.remove(row1.getFirst());
//                listFilled = true;
//            }
//        }
//        if (row == 2){
//            row2.add(card);
//            for (int i = 1; i < row2.size(); i++){
//                removeCards.add(row2.getFirst());
//                row2.remove(row2.getFirst());
//                listFilled = true;
//            }
//        }
//        if (row == 3){
//            row3.add(card);
//            for (int i = 1; i < row3.size(); i++){
//                removeCards.add(row3.getFirst());
//                row3.remove(row3.getFirst());
//                listFilled = true;
//            }
//        }
//        if (row == 4){
//            row4.add(card);
//            for (int i = 1; i < row4.size(); i++){
//                removeCards.add(row4.getFirst());
//                row4.remove(row4.getFirst());
//                listFilled = true;
//            }
//        }
//
//        if (listFilled) {
//            int humanBullTotal = 0;
//            int aiBullTotal = 0;
//            if (player instanceof Human) {
//                humanBullTotal = player.bullValues(removeCards);
//                player.setHumanBullTotal(humanBullTotal);
//            } else {
//                aiBullTotal = player.bullValues(removeCards);
//                player.setAiBullTotal(aiBullTotal);
//            }
//        }
//    }

    public boolean checkIfLower(Card card){
        return row1.getLast().getValue() > card.getValue() && row2.getLast().getValue() > card.getValue() && row3.getLast().getValue() > card.getValue() && row4.getLast().getValue() > card.getValue();
    }

    public void removeRow(Card card, Player player){
        int row = findBiggest();
        LinkedList<Card> removeCard = new LinkedList<>();
        if (row == 1){
            row1.add(card);
            for (int i = 1; i < row1.size(); i++){
                removeCard.add(row1.getFirst());
                row1.remove(row1.getFirst());
            }
        }
        if (row == 2){
            row2.add(card);
            for (int i = 1; i < row2.size(); i++){
                removeCard.add(row2.getFirst());
                row2.remove(row2.getFirst());
            }
        }
        if (row == 3){
            row3.add(card);
            for (int i = 1; i < row3.size(); i++){
                removeCard.add(row3.getFirst());
                row3.remove(row3.getFirst());
            }
        }
        if (row == 4){
            row4.add(card);
            for (int i = 1; i < row4.size(); i++){
                removeCard.add(row4.getFirst());
                row4.remove(row4.getFirst());
            }
        }

        if (player instanceof Human){
            deck.humanHand.remove(card);
        } else {
            deck.aiHand.remove(card);
        }

        int humanBullTotal = 0;
        int aiBullTotal = 0;
        if (player instanceof Human) {
            humanBullTotal = player.bullValues(removeCard);
            player.setHumanBullTotal(humanBullTotal);
        } else {
            aiBullTotal = player.bullValues(removeCard);
            player.setAiBullTotal(aiBullTotal);
        }

    }

    public int findBiggest() {
        int max = row1.getLast().getValue();
        int row = 1;
        if (row2.getLast().getValue() > max) {
            max = row2.getLast().getValue();
            row = 2;
        }
        if (row3.getLast().getValue() > max) {
            max = row3.getLast().getValue();
            row = 3;
        }
        if (row4.getLast().getValue() > max) {
            max = row4.getLast().getValue();
            row = 4;
        }
        return row;
    }
}