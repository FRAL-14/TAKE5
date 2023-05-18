package be.kdg.integration2.take5.ui.game;

import be.kdg.integration2.take5.model.Card;
import be.kdg.integration2.take5.model.Player;
import javafx.animation.ParallelTransition;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.util.List;

/**
 * This class is responsible for the view of the game screen.
 * It contains the layout of the game and the event handlers.
 */
public class GameView extends BorderPane {
    private MenuBar helpMBar;
    private MenuItem helpMenuItem;
    private Menu helpMenu;
    private Menu gameMenu;
    private MenuBar gameMBar;
    private MenuItem restartGame;
    private MenuItem quitGame;
    //    private HBox board = new HBox(10);
    private HBox humanCards = new HBox();
    private HBox aiCards = new HBox();
    private GridPane boardCards = new GridPane();
    private Label scoreHumanLbl;
    private Label scoreAILbl;
    private int humanScore;
    private int aiScore;

    public GameView() {
        initialiseNodes();
        layoutNodes();
    }

    /**
     * This method is responsible for displaying the cards of the human player and the AI.
     * It also adds the event handlers to the cards.
     */
    private void initialiseNodes() {
        helpMenu = new Menu("Help");
        helpMenuItem = new MenuItem("Rules");
        helpMenu.getItems().addAll(helpMenuItem);
        gameMenu = new Menu("Game");
        restartGame = new MenuItem("Restart");
        quitGame = new MenuItem("Quit");

        gameMenu.getItems().addAll(restartGame, quitGame);
        helpMBar = new MenuBar(helpMenu);
        gameMBar = new MenuBar(gameMenu);

        displayScores(humanScore, aiScore);
    }

    private void layoutNodes() {
        this.setStyle("-fx-background-color: linear-gradient(to bottom, #ffdcb6, #E06469);");

        //top part of BorderPane
        setTop(aiCards);
        setAlignment(aiCards, Pos.TOP_CENTER);
        setMargin(aiCards, new Insets(40, 0, 0, 10));

        //bottom part of BorderPane
        setBottom(humanCards);
        setAlignment(humanCards, Pos.BOTTOM_CENTER);
        setMargin(humanCards, new Insets(0, 0, 100, 10));

        //left part of BorderPane
        HBox left = new HBox(20, helpMBar, gameMBar);
        setLeft(left);
        setAlignment(left, Pos.TOP_LEFT);
        setMargin(left, new Insets(-150, 75, 0, 10));

        //right part of BorderPane
        VBox right = new VBox(500, scoreAILbl, scoreHumanLbl);
        setRight(right);
        setAlignment(right, Pos.TOP_RIGHT);
        setMargin(right, new Insets(20, 50, 10, 10));

        //center part of BorderPane
        setCenter(boardCards);
        setAlignment(boardCards, Pos.CENTER_LEFT);
        setMargin(boardCards, new Insets(0, 0, 0, 0));

        //fontsizes
        scoreAILbl.setFont(new Font(25));
        scoreHumanLbl.setFont(new Font(25));
    }
    public void setScoreLabel(Label scoreHumanLbl, Label scoreAILbl) {
        this.scoreHumanLbl = scoreHumanLbl;
        this.scoreAILbl = scoreAILbl;
    }
    public void displayScores(int humanScore,int aiScore) {
//        scoreHumanLbl = new Label("Score: " + Player.getHumanBullTotal());
//        scoreAILbl = new Label("Score: " + Player.getAiBullTotal());
        scoreHumanLbl = new Label("Score: " + humanScore);
        scoreAILbl = new Label("Score: " + aiScore);
    }


    public void setHumanCards(HBox humanCards) {
        this.humanCards.getChildren().clear();
        this.humanCards.getChildren().addAll(humanCards.getChildren());
    }

    public void setAiCards(HBox aiCards) {
        this.aiCards.getChildren().clear();
        this.aiCards.getChildren().addAll(aiCards.getChildren());
    }

    public void setBoardCards(GridPane boardCards) {
        this.boardCards.getChildren().clear();
        this.boardCards.getChildren().addAll(boardCards.getChildren());
    }

    //TODO displaying scores has yet to be implemented
    public void updateScoreHuman(int score) {
        this.scoreHumanLbl.setText(String.valueOf(Player.getHumanBullTotal()));
    }
    public void updateScoreAI(int score) {
        this.scoreAILbl.setText(String.valueOf(Player.getAiBullTotal()));
    }

    //setter and getter
    public HBox getHumanCards() {
        return humanCards;
    }

    public HBox getAiCards() {
        return aiCards;
    }

    public MenuItem getRestartGame() {
        return restartGame;
    }

    public MenuItem getQuitGame() {
        return quitGame;
    }
}
