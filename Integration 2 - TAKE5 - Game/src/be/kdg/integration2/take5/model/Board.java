package be.kdg.integration2.take5.model;

import java.util.*;

public class Board {
    public LinkedList<Card> row1 = new LinkedList<>();
    public LinkedList<Card> row2 = new LinkedList<>();
    public LinkedList<Card> row3 = new LinkedList<>();
    public LinkedList<Card> row4 = new LinkedList<>();
    LinkedList<Card> closestRow = new LinkedList<>();
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


    /**
     * method to take 4 cards from boardHand List and adds them to the first place in each row
     *
     * @param deck the active object of deck during the game
     */
    public void initializeRow(Deck deck) {
        if (!row1.isEmpty()){
            row1.clear();
            row2.clear();
            row3.clear();
            row4.clear();
        }
        row1.add(0, deck.boardHand.get(0));
        row2.add(0, deck.boardHand.get(1));
        row3.add(0, deck.boardHand.get(2));
        row4.add(0, deck.boardHand.get(3));
    }


    /**
     * method to check if a row had 6 cards, if a row has 6 cards the player that placed the last card must collect
     * the 5 first cards and add the bulls to his total, the last card becomes the first one in the row
     *
     * @param player the player that just played a card and who will get bulls if method goes through
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
            int humanBullTotal;
            int aiBullTotal;
            if (player instanceof Human) {
                humanBullTotal = player.bullValues(removeCards);
                player.setHumanBullTotal(humanBullTotal);
            } else {
                aiBullTotal = player.bullValues(removeCards);
                player.setAiBullTotal(aiBullTotal);
            }
        }
    }


    /**
     * method used to calculate which row is the most suitable for the card being played,
     * method is called in the playCard method
     *
     * @param playedCard the card being played by the player
     * @return the row in which the card has to be added
     */
    //TODO: not sure but maybe this can be written in Card instead of Board?
    public LinkedList<Card> findClosestNumber(int playedCard) {
        int smallestDifference = Integer.MAX_VALUE;
        boolean isTooLow = true;

        if (row1.getLast().getValue() < playedCard) {
            int difference = playedCard - row1.getLast().getValue();
            if (difference < smallestDifference) {
                smallestDifference = difference;
                closestRow = row1;
                isTooLow = false;
            }
        }

        if (row2.getLast().getValue() < playedCard) {
            int difference = playedCard - row2.getLast().getValue();
            if (difference < smallestDifference) {
                smallestDifference = difference;
                closestRow = row2;
                isTooLow = false;
            }
        }

        if (row3.getLast().getValue() < playedCard) {
            int difference = playedCard - row3.getLast().getValue();
            if (difference < smallestDifference) {
                smallestDifference = difference;
                closestRow = row3;
                isTooLow = false;
            }
        }

        if (row4.getLast().getValue() < playedCard) {
            int difference = playedCard - row4.getLast().getValue();
            if (difference < smallestDifference) {
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
     * @param card the card being played by the player
     */
    //TODO: this should be written in the Player class, and then you can call it in the Board class (!!)
    public boolean playCard(Card card, Player player) {
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


    /**
     * this method would've allowed the user to choose a row out of the 4 rows to remove and take in case of when his card
     * would be too low for the cards on the board
     * @param row is the row the player chose to remove from the board
     * @param player if it is the AI or the human removing a row
     * @param card is the card being played by the user
     */
    public void chooseRow(int row, Player player, Card card){
        boolean listFilled = false;
        LinkedList<Card> removeCards = new LinkedList<>();
        if (row == 1){
            row1.add(card);
            for (int i = 1; i < row1.size(); i++){
                removeCards.add(row1.getFirst());
                row1.remove(row1.getFirst());
                listFilled = true;
            }
        }
        if (row == 2){
            row2.add(card);
            for (int i = 1; i < row2.size(); i++){
                removeCards.add(row2.getFirst());
                row2.remove(row2.getFirst());
                listFilled = true;
            }
        }
        if (row == 3){
            row3.add(card);
            for (int i = 1; i < row3.size(); i++){
                removeCards.add(row3.getFirst());
                row3.remove(row3.getFirst());
                listFilled = true;
            }
        }
        if (row == 4){
            row4.add(card);
            for (int i = 1; i < row4.size(); i++){
                removeCards.add(row4.getFirst());
                row4.remove(row4.getFirst());
                listFilled = true;
            }
        }

        if (listFilled) {
            int humanBullTotal;
            int aiBullTotal;
            if (player instanceof Human) {
                humanBullTotal = player.bullValues(removeCards);
                player.setHumanBullTotal(humanBullTotal);
            } else {
                aiBullTotal = player.bullValues(removeCards);
                player.setAiBullTotal(aiBullTotal);
            }
        }
    }


    /**
     * method to check if card is lower than all cards on board
     * @param card the card that is being compared to other cards on the board
     * @return if the card is lower than cards on board method returns true
     */
    public boolean checkIfLower(Card card){
        return row1.getLast().getValue() > card.getValue() && row2.getLast().getValue() > card.getValue() && row3.getLast().getValue() > card.getValue() && row4.getLast().getValue() > card.getValue();
    }


    /**
     * method to remove a row when a player plays an invalid card
     * @param card being played by the player
     * @param player either the AI or the human, this determines who played and who gets bulls
     */
    public void removeRow(Card card, Player player){
        int row = findBiggest();
        LinkedList<Card> removeCard = new LinkedList<>();
        if (row == 1){
            row1.add(card);
            for (int i = 0; i < row1.size(); i++){
                removeCard.add(row1.getFirst());
                row1.remove(row1.getFirst());
            }
        }
        if (row == 2){
            row2.add(card);
            for (int i = 0; i < row2.size(); i++){
                removeCard.add(row2.getFirst());
                row2.remove(row2.getFirst());
            }
        }
        if (row == 3){
            row3.add(card);
            for (int i = 0; i < row3.size(); i++){
                removeCard.add(row3.getFirst());
                row3.remove(row3.getFirst());
            }
        }
        if (row == 4){
            row4.add(card);
            for (int i = 0; i < row4.size(); i++){
                removeCard.add(row4.getFirst());
                row4.remove(row4.getFirst());
            }
        }

        if (player instanceof Human){
            deck.humanHand.remove(card);
        } else {
            deck.aiHand.remove(card);
        }

        int humanBullTotal;
        int aiBullTotal;
        if (player instanceof Human) {
            humanBullTotal = player.bullValues(removeCard);
            player.setHumanBullTotal(humanBullTotal);
        } else {
            aiBullTotal = player.bullValues(removeCard);
            player.setAiBullTotal(aiBullTotal);
        }
    }


    /**
     * method used to find the row with the biggest last card, used in removeRow
     * @return the integer is the row that has the biggest card out of all the rows on the board
     */
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
            row = 4;
        }
        return row;
    }
}