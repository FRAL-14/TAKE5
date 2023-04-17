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

import java.util.List;

public class GameView extends BorderPane {
    private MenuBar mBar;
    private MenuItem menuItem;
    private Menu menu;
    private Button restartGame;
    private Button quitGame;
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
        menu = new Menu("Help");
        menuItem = new MenuItem("Rules");
        menu.getItems().addAll(menuItem);
        mBar = new MenuBar(menu);
        restartGame = new Button("Restart");
        quitGame = new Button("Quit");
//        scoreHuman = new Label("0");
//        scoreAI = new Label("0");
    }

    private void layoutNodes() {
        setTop(mBar);
        setAlignment(mBar, Pos.TOP_CENTER);
        setBottom(quitGame);
        setBottom(restartGame);
        setAlignment(restartGame, Pos.BASELINE_LEFT);
        setAlignment(quitGame, Pos.BASELINE_RIGHT);
        setTop(aiCards);
        setRight(scoreAILbl);
        setBottom(humanCards);
        setRight(scoreHumanLbl);
        setCenter(boardCards);
        setAlignment(boardCards, Pos.CENTER_LEFT);
        setAlignment(humanCards, Pos.BOTTOM_CENTER);
        setAlignment(aiCards, Pos.TOP_LEFT);
        boardCards.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, null, new BorderWidths(1)))); //border around gridpane

//        for (int i = 0; i < 6; i++) {
//            ColumnConstraints c = new ColumnConstraints(20);
//            c.setMaxWidth(2000 / 6f);
//            boardCards.getColumnConstraints().add(c); //put in for loop to go thru all 6 cols, and do the same for rows
//        }
//
//        for (int i = 0; i < 6; i++) {
//            RowConstraints r = new RowConstraints(120);
//            r.setMaxHeight(2000 / 6f);
//            boardCards.getRowConstraints().add(r);
//        }
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

    public MenuBar getmBar() {
        return mBar;
    }

    public void setmBar(MenuBar mBar) {
        this.mBar = mBar;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Button getRestartGame() {
        return restartGame;
    }

    public void setRestartGame(Button restartGame) {
        this.restartGame = restartGame;
    }

    public Button getQuitGame() {
        return quitGame;
    }

    public void setQuitGame(Button quitGame) {
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

}
