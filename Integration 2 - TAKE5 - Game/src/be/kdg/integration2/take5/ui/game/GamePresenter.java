package be.kdg.integration2.take5.ui.game;

import be.kdg.integration2.take5.model.*;
import be.kdg.integration2.take5.ui.CardView;
import be.kdg.integration2.take5.ui.game_over.GameOverPresenter;
import be.kdg.integration2.take5.ui.game_over.GameOverView;
import be.kdg.integration2.take5.ui.help.HelpPresenter;
import be.kdg.integration2.take5.ui.help.HelpView;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class GamePresenter {
    private GameSession model;
    private GameView gameView;
    private HBox humanCards = new HBox();
    private HBox aiCards = new HBox();
    private GridPane boardCards = new GridPane();
    private int humanScore;
    private int aiScore;
    private Label humanScoreLbl;
    private Label aiScoreLbl;
    private boolean isSelected = false;
    LinkedList<Card> stack1;
    LinkedList<Card> stack2;
    LinkedList<Card> stack3;
    LinkedList<Card> stack4;
    boolean cardPlayed = false;

    public GamePresenter(GameSession model, GameView gameView) {
        this.model = model;
        humanScore = model.getBullTotal("human");
        aiScore = model.getBullTotal("ai");
        humanScoreLbl = new Label("Score: " + humanScore);
        aiScoreLbl = new Label("Score: " + aiScore);
        gameView.setScoreLabel(humanScoreLbl, aiScoreLbl);
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
        gameView.getHumanCards().setOnMouseClicked(event -> {
            playCard();
            if (cardPlayed) {
                playAiCard();
            }
            if (model.getTurn() == 10){
                model.newRound(getBoardCards());
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
        model.makeBoard();
//        model.startGame();
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
        gameView.setAiCards(aiCards);
//        gameView.setHumanCards(humanCards);
        gameView.setScoreLabel(humanScoreLbl, aiScoreLbl);
//        updateScores();
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
    public void playCard() {
        Card card = null;
        for (Node cardNode : gameView.getHumanCards().getChildren()) {
            if (cardNode instanceof CardView) {
                CardView cardView = (CardView) cardNode;
                card = cardView.getCard();
                Card finalCard = card;
                cardView.setOnMouseClicked(event -> {
                    gameView.getHumanCards().getChildren().remove(cardView);
                    int clickedCardValue = finalCard.getValue();
                    boolean validPlay = model.playCard(finalCard);
                });
            }
        }
        updateView();
        cardPlayed = true;
    }

//    public void playAiCard(){
//        CardView cardView = new CardView(model.playAICard());
//        gameView.getAiCards().getChildren().remove(cardView);
//        updateView();
//    }

    /**
     * Same method as playCard but for AI, instead of input from a user a card is randomly chosen from the hand of the AI
     * method works the same way as playCard
     */
    public void playAiCard() {
        Card aiCard = model.playAICard();
        for (Node cardNode : gameView.getAiCards().getChildren()) {
            if (cardNode instanceof CardView) {
                CardView cardView = (CardView) cardNode;
                aiCard = cardView.getCard();
                Card finalCard = aiCard;
                gameView.getAiCards().getChildren().remove(cardView);
//                int clickedCardValue = finalCard.getValue();
//                boolean validPlay = model.playCard(finalCard);
            }
        }
        updateView();
    }

//    public void updateScores() {
////        int humanScore = model.calculateHumanScore(model.getHand("human"));
////        int aiScore = model.calculateAiScore(model.getHand("ai"));
//        gameView.setScoreLabel(humanScoreLbl, aiScoreLbl);
//        gameView.displayScores(humanScore, aiScore);
//        gameView.updateScoreHuman(humanScore);
//        gameView.updateScoreAI(aiScore);
//    }
    public int calculateHumanScore() {
        LinkedList<Card> humanCards = model.getHand("human");
        return model.calculateHumanScore(humanCards);
    }

    public int calculateAIScore() {
        LinkedList<Card> aiCards =  model.getHand("ai");
        return model.calculateAiScore(aiCards);
    }

    public Label getHumanScore() {
        return humanScoreLbl;
    }

    public Label getAiScore() {
        return aiScoreLbl;
    }

    public LinkedList<Card> getBoardCards(){
        LinkedList<Card> cardList = new LinkedList<>();
        cardList.addAll(stack1);
        cardList.addAll(stack2);
        cardList.addAll(stack3);
        cardList.addAll(stack4);
        return cardList;
    }
}
