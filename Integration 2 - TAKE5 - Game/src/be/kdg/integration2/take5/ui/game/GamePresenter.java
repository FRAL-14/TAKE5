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

public class GamePresenter {
    private GameSession model;
    private GameView gameView;
    private HBox humanCards = new HBox();
    private HBox aiCards = new HBox();
    private GridPane boardCards = new GridPane();
    private int humanScore = 0;
    private int aiScore = 0;
    private boolean isSelected = false;
    LinkedList<Card> stack1;
    LinkedList<Card> stack2;
    LinkedList<Card> stack3;
    LinkedList<Card> stack4;
    boolean cardPlayed = false;
    PauseTransition delay = new PauseTransition(Duration.seconds(4));

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
        model.startGame();
        getRows();
        gameView.getRestartGame().setOnAction(event -> restartGame());
        gameView.getQuitGame().setOnAction(event -> quitGame());
        gameView.getHumanCards().setOnMouseClicked(event -> {
            playCard();
            if (cardPlayed) {
                playAiCard();
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
        model.startGame();
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
    }
//TODO scores still implemented
    //    public static int calculateHumanScore() {
//        ObservableList<Card> humanHand = humanCards.getChildren();
//        return ScoreCalc.calculateScore(humanHand);
//    }
//
//    public static int calculateAiScore() {
//        ObservableList<Card> aiHand = aiCards.getChildren();
//        return ScoreCalc.calculateScore(aiHand);
//    }

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
    }

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
                cardView.setOnMouseClicked(event -> {
                    gameView.getAiCards().getChildren().remove(cardView);
                    int clickedCardValue = finalCard.getValue();
                    boolean validPlay = model.playCard(finalCard);
                });
            }
        }
    }
}
