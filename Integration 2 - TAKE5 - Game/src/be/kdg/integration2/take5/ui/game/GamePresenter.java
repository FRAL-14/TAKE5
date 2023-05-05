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

    private void addEventHandlers() {
//        gameView.getMenu().setOnAction(event -> showHelp()); //shows next screen
        model.makeBoard();
        model.startGame();
        getRows();
        gameView.getRestartGame().setOnAction(event -> restartGame());
        gameView.getHumanCards().setOnMouseClicked(event -> {
            playCard();

            playAiCard();
        });
    }

    public void updateView() {
        getRows();
        boardCards.getChildren().clear();
        displayBoard(boardCards);
        humanCards.getChildren().clear();
        displayHands(humanCards, aiCards);
        gameView.setBoardCards(boardCards);
    }

//    public static int calculateHumanScore() {
//        ObservableList<Card> humanHand = humanCards.getChildren();
//        return ScoreCalc.calculateScore(humanHand);
//    }
//
//    public static int calculateAiScore() {
//        ObservableList<Card> aiHand = aiCards.getChildren();
//        return ScoreCalc.calculateScore(aiHand);
//    }

    public void getRows() {
        stack1 = model.getRow(1);
        stack2 = model.getRow(2);
        stack3 = model.getRow(3);
        stack4 = model.getRow(4);
    }


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

    //todo works but still have to apply the logic of card placement
    //player instanceOf Human / AI
    //read clickedCard
    //get card with closest card value (will create other method)
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
//        if (validPlay) {
////            gameView.updateGameView(model.getGameState);
//        } else {
////            alert invalid play
//        }
        cardPlayed = true;
    }

    public void playAiCard() {
        System.out.println("ai playing");
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


    private void restartGame() {
        model.clear();
        model.makeBoard();
        model.startGame();
        updateView();   //works
    }
}
