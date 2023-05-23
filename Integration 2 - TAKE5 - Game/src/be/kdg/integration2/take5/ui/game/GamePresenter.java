package be.kdg.integration2.take5.ui.game;

import be.kdg.integration2.take5.model.*;
import be.kdg.integration2.take5.ui.CardView;
import be.kdg.integration2.take5.ui.game_over.GameOverPresenter;
import be.kdg.integration2.take5.ui.game_over.GameOverView;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.util.*;
import java.util.concurrent.CompletableFuture;

public class GamePresenter {
    private GameSession model;
    private GameView gameView;
    private HBox humanCards = new HBox();
    private HBox aiCards = new HBox();
    private GridPane boardCards = new GridPane();
    private int humanScore = 0;
    private int aiScore = 0;
    private String humanScoreLbl;
    private String aiScoreLbl;
    private boolean isSelected = false;
    LinkedList<Card> stack1;
    LinkedList<Card> stack2;
    LinkedList<Card> stack3;
    LinkedList<Card> stack4;
    boolean cardPlayed = false;

    public GamePresenter(GameSession model, GameView gameView) {
        this.model = model;
        this.gameView = gameView;
        addEventHandlers();
        displayHands(humanCards, aiCards);
        displayBoard(boardCards);
        gameView.setHumanCards(humanCards);
        gameView.setAiCards(aiCards);
        gameView.setBoardCards(boardCards);
    }

    /**
     * method that takes different methods that are used for game flow and logic and puts corresponding methods together
     */
    private void addEventHandlers() {
        model.makeBoard();
//        model.startGame();
        getRows();
        gameView.getRestartGame().setOnAction(event -> restartGame());
        gameView.getQuitGame().setOnAction(event -> quitGame());
        gameView.setOnMouseClicked(event -> {
        playCard();
        if (cardPlayed) {
            playAiCard();
            cardPlayed = false;
        }
        if (model.getTurn() == 10){
            model.newRound(getBoardCards());
            newRound();
            updateView();
        }
        });
    }

    private void quitGame() {
        GameOverView gameOverView = new GameOverView();
        new GameOverPresenter(model, gameOverView);
        gameView.getScene().setRoot(gameOverView);
        gameOverView.getScene().getWindow();
    }

    /**
     * method that takes the card that is clicked on by the user and passes it to the gameSession
     * to be called in gamePresenter class
     */
    private void restartGame() {
        model.clear();
        clearHand();
        model.makeBoard();
        resetScores();
//        model.startGame();
        updateView();
    }

    private void newRound() {
        clearHand();
        updateView();
    }

    /**
     * updateView method to update the cards on the board after a card has been played
     */
    public void updateView() {
        getRows();
        boardCards.getChildren().clear();
        displayBoard(boardCards);
        gameView.setBoardCards(boardCards);
        displayHands(humanCards, aiCards);
        gameView.setHumanCards(humanCards);
        gameView.setAiCards(aiCards);
        updateScores();
        gameView.setScoreLabel(humanScoreLbl, aiScoreLbl);
    }
    /**
     * method that takes the 4 rows initially created in the board class and passes them to the gameSession
     * to be called in gamePresenter class
     */
    public void getRows() {
        stack1 = model.getRow(1);
        stack2 = model.getRow(2);
        stack3 = model.getRow(3);
        stack4 = model.getRow(4);
    }

    /**
     * displayHand is used to take the cards from the Human hand and the AI hand and displays them on the board
     *
     * @param humanCards
     * @param aiCards
     */
    public void displayHands(HBox humanCards, HBox aiCards) {
        LinkedList<Card> humanHand = model.getHand("human");
        LinkedList<Card> aiHand = model.getHand("ai");


        for (Card value : humanHand) {
            CardView cardView = new CardView(value);
            humanCards.getChildren().add(cardView);
        }

        for (Card card : aiHand) {
            CardView cardView = new CardView(card);
            aiCards.getChildren().add(cardView);
        }

    }

    /**
     * displayBoard is used to take the cards from the 4 rows and display them on the board
     *
     * @param boardCards
     */
    public void displayBoard(GridPane boardCards) {
        for (int i = 0; i < stack1.size(); i++) {
            CardView cardView = new CardView(stack1.get(i));
            boardCards.add(cardView, i, 0);
        }

        for (int i = 0; i < stack2.size(); i++) {
            CardView cardView = new CardView(stack2.get(i));
            boardCards.add(cardView, i, 1);
        }

        for (int i = 0; i < stack3.size(); i++) {
            CardView cardView = new CardView(stack3.get(i));
            boardCards.add(cardView, i, 2);
        }

        for (int i = 0; i < stack4.size(); i++) {
            CardView cardView = new CardView(stack4.get(i));
            boardCards.add(cardView, i, 3);
        }

    }

    /**
     * playCard method takes input from user on click to call playCard from gameSession with a card as parameter
     * card gets compared to the last card of each row on the board and gets placed behind the closest value that is lower
     * than that of the card itself
     */
    //ToDo: if card value is too low for all rows, user or AI has to choose a row and add bulls to his total
//    public void playCard() {
//        Card card = null;
//        for (Node cardNode : gameView.getHumanCards().getChildren()) {
//            if (cardNode instanceof CardView) {
//                CardView cardView = (CardView) cardNode;
//                card = cardView.getCard();
//                Card finalCard = card;
//                cardView.setOnMouseClicked(event -> {
//                    gameView.getHumanCards().getChildren().remove(cardView);
//                    int clickedCardValue = finalCard.getValue();
//                    boolean validPlay = model.playCard(finalCard);
//                });
//            }
//        }
//        updateView();
//        cardPlayed = true;
//    }

    public void playCard(){
        CompletableFuture<Card> cardSelectionFuture = new CompletableFuture<>();
        for (Node cardNode : gameView.getHumanCards().getChildren()) {
            cardNode.setOnMouseClicked(event -> {
                Node selectedCardView = (Node) event.getSource();
                CardView cardView = (CardView) selectedCardView;
                Card selectedCard = cardView.getCard();
                model.playCard(selectedCard);
                gameView.getHumanCards().getChildren().remove(selectedCardView);
                cardPlayed = true;
                cardSelectionFuture.complete(selectedCard);
                updateView();
            });
        }
    }

    public void playAiCard(){
        CardView cardView = new CardView(model.playAICard());
        gameView.getAiCards().getChildren().remove(cardView);
        updateView();
    }

    /**
     * Same method as playCard but for AI, instead of input from a user a card is randomly chosen from the hand of the AI
     * method works the same way as playCard
     */
//    public void playAiCard() {
//        Card aiCard = model.playAICard();
//        for (Node cardNode : gameView.getAiCards().getChildren()) {
//            if (cardNode instanceof CardView) {
//                CardView cardView = (CardView) cardNode;
//                aiCard = cardView.getCard();
//                Card finalCard = aiCard;
//                gameView.getAiCards().getChildren().remove(cardView);
////                int clickedCardValue = finalCard.getValue();
////                boolean validPlay = model.playCard(finalCard);
//            }
//        }
//        updateView();
//    }

    public void updateScores() {
        int humanScore = model.getBullTotal("human");
        int aiScore = model.getBullTotal("ai");
        humanScoreLbl = ("Score: " + humanScore);
        aiScoreLbl = ("Score: " + aiScore);
//        gameView.setScoreLabel(humanScoreLbl, aiScoreLbl);
//        gameView.displayScores(humanScore, aiScore);
//        gameView.updateScoreHuman(humanScore);
//        gameView.updateScoreAI(aiScore);
    }
    public int calculateHumanScore() {
        LinkedList<Card> humanCards = model.getHand("human");
        return model.calculateHumanScore(humanCards);
    }

    public int calculateAIScore() {
        LinkedList<Card> aiCards =  model.getHand("ai");
        return model.calculateAiScore(aiCards);
    }

    public LinkedList<Card> getBoardCards(){
        LinkedList<Card> cardList = new LinkedList<>();
        cardList.addAll(stack1);
        cardList.addAll(stack2);
        cardList.addAll(stack3);
        cardList.addAll(stack4);
        return cardList;
    }

    public void clearHand(){
        humanCards.getChildren().clear();
        aiCards.getChildren().clear();
    }

    public void resetScores(){
        humanScore = 0;
        aiScore = 0;
    }
}
