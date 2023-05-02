package be.kdg.integration2.take5.ui.game;

import be.kdg.integration2.take5.model.Card;
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


    public GameView() {
        initialiseNodes();
        layoutNodes();
    }

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

        scoreHumanLbl = new Label("Score: 0");
        scoreAILbl = new Label("Score: 0");

    }

    private void layoutNodes() {
        this.setStyle("-fx-background-color: #fffced;");

        //top part of BorderPane
        HBox top = new HBox(50, aiCards);
        setTop(top);
        setAlignment(top, Pos.TOP_CENTER);
        setMargin(top, new Insets(10, 0, 0, 150));

        //bottom part of BorderPane
        HBox bottom = new HBox(60, humanCards);
        setBottom(bottom);
        setAlignment(bottom, Pos.BOTTOM_CENTER);
        setMargin(bottom, new Insets(10, 0, 0, 150));

        //left part of BorderPane
        HBox left = new HBox(20, helpMBar, gameMBar);
        setLeft(left);
        setAlignment(left, Pos.TOP_LEFT);
        setMargin(left, new Insets(-110, 150, 0, 10));

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
//    public void displayScores() {
//        int humanScore = GamePresenter.calculateHumanScore();
//        int aiScore = GamePresenter.calculateAiScore();
//
//        scoreHumanLbl.setText("Human score: " + humanScore);
//        scoreAILbl.setText("AI score: " + aiScore);
//    }


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

    public void updateScoreHuman(int score) {
        this.scoreHumanLbl.setText(String.valueOf(score));
    }

    public void updateScoreAI(int score) {
        this.scoreAILbl.setText(String.valueOf(score));
    }
//setter and getter

    public MenuBar getHelpMBar() {
        return helpMBar;
    }

    public void setHelpMBar(MenuBar helpMBar) {
        this.helpMBar = helpMBar;
    }

    public MenuItem getHelpMenuItem() {
        return helpMenuItem;
    }

    public void setHelpMenuItem(MenuItem helpMenuItem) {
        this.helpMenuItem = helpMenuItem;
    }

    public Menu getHelpMenu() {
        return helpMenu;
    }

    public void setHelpMenu(Menu helpMenu) {
        this.helpMenu = helpMenu;
    }

    public Menu getGameMenu() {
        return gameMenu;
    }

    public void setGameMenu(Menu gameMenu) {
        this.gameMenu = gameMenu;
    }

    public MenuBar getGameMBar() {
        return gameMBar;
    }

    public void setGameMBar(MenuBar gameMBar) {
        this.gameMBar = gameMBar;
    }

    public MenuItem getRestartGame() {
        return restartGame;
    }

    public void setRestartGame(MenuItem restartGame) {
        this.restartGame = restartGame;
    }

    public MenuItem getQuitGame() {
        return quitGame;
    }

    public void setQuitGame(MenuItem quitGame) {
        this.quitGame = quitGame;
    }

    public HBox getHumanCards() {
        return humanCards;
    }

    public HBox getAiCards() {
        return aiCards;
    }

    public GridPane getBoardCards() {
        return boardCards;
    }

    public Label getScoreHumanLbl() {
        return scoreHumanLbl;
    }

    public void setScoreHumanLbl(Label scoreHumanLbl) {
        this.scoreHumanLbl = scoreHumanLbl;
    }

    public Label getScoreAILbl() {
        return scoreAILbl;
    }

    public void setScoreAILbl(Label scoreAILbl) {
        this.scoreAILbl = scoreAILbl;
    }
}
