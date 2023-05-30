package be.kdg.integration2.take5.model;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

public class GameSession {

    private Leaderboard leaderboard;
    int turn = 0;
    Deck mainDeck = new Deck();
    Player player;
    Board board = new Board(mainDeck);
    Human human = new Human("human");
    AI ai = new AI();





    /**
     * makeBoard method takes method from deck to make hands and method from board to assign cards to the rows
     */
    public void makeBoard() {
        mainDeck.startRound();
        board.initializeRow(mainDeck);
    }

    public void clear() {
        mainDeck.remakeCards();
        board.clear();
    }

    public Deck getDeck() {
        return mainDeck;
    }

//    public void startGame() {
//        leaderboard.addPlayer(human);
//        human.setId();
//        leaderboard.addPlayer(ai);
//        ai.setId();
//
//    }


    /**
     * calling newRound from deck, method is called in gamePresenter
     * @param cards list of active cards in the ongoing game
     */
    public void newRound(LinkedList<Card> cards){
        mainDeck.newRound(cards);
        turn = 0;
    }


    /**
     * method to return the number of turns to call method newRound
     * @return the turn at which the game currently is
     */
    public int getTurn(){
        return turn;
    }

    /**
     * method to call playCard from board inside javaFx classes
     *
     * @param card the card that has to be played
     * @return is true if the method worked
     */
    public boolean playCard(Card card) {
        boolean played = board.playCard(card, human);
        board.checkLists(human);
        turn++;
        return played;

    }

    /**
     * same as playCard but for AI
     *
     * @return the card that got played by the AI
     */
    public Card playAICard() {
        Card card = ai.chooseCard(mainDeck, board);
        board.playCard(card, ai);
        board.checkLists(ai);
        return card;
    }

    /**
     * method used to call rows and use them in javaFx classes
     *
     * @param row the number of the row that has to be retrieved
     * @return the row of cards
     */
    public LinkedList<Card> getRow(int row) {
        return switch (row) {
            case 1 -> board.getRow1();
            case 2 -> board.getRow2();
            case 3 -> board.getRow3();
            case 4 -> board.getRow4();
            default -> throw new IllegalArgumentException("Invalid stack number");
        };
    }

    /**
     * same as getRow but for humanHand and AIHand
     *
     * @param type is either human or AI to determine which hand has to be retrieved
     * @return a list of cards also called hand
     */
    public LinkedList<Card> getHand(String type) {
        return switch (type) {
            case "human" -> mainDeck.getHumanHand();
            case "ai" -> mainDeck.getAiHand();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }

    /**
     * method used to retrieve the bullTotal in gamePresenter
     * @param type is either human or AI to determine which bullTotal has to be retrieved
     * @return the bullTotal of the player
     */
    public int getBullTotal(String type) {
        return switch (type) {
            case "human" -> human.getHumanBullTotal();
            case "ai" -> ai.getAiBullTotal();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }

    public void resetBullTotal(){
        human.resetBullTotal();
    }


    /**
     * method that is called in gamePresenter and calls the method in board, to pass all parameters
     * @param row the number of the row that has to be removed
     * @param type is either human or AI to determine which player played the invalid card
     * @param card
     */
    public void chooseRow(int row, String type, Card card){
        if (type.equals("human")){
            board.chooseRow(row, human, card);
        } else {
            board.chooseRow(row, ai, card);
        }
    }

}