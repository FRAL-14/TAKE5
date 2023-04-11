package be.kdg.integration2.take5.ui.game;

import be.kdg.integration2.take5.model.Card;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.List;

public class GameView extends BorderPane {
    private MenuBar mBar;
    private MenuItem menuItem;
    private Menu menu;
    private Button restartGame;
    private Button quitGame;
    //    private HBox board = new HBox(10);
    private Pane boardPane;
    private HBox humanCards = new HBox(10);
    private HBox aiCards = new HBox(10);
    private VBox boardCards = new VBox(4);

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
    }

    private void layoutNodes() {
        setTop(mBar);
        setAlignment(mBar, Pos.TOP_CENTER);
        setBottom(quitGame);
        setBottom(restartGame);
        setAlignment(restartGame, Pos.BASELINE_LEFT);
        setAlignment(quitGame, Pos.BASELINE_RIGHT);

//        setCenter(board);
        setTop(aiCards);
        setBottom(humanCards);
        setLeft(boardCards);
//        aiCards.setPadding(new Insets(5, 0, 5, 0));
//        humanCards.setPadding(new Insets(5, 0, 5, 0));
//        boardCards.setPadding(new Insets(5, 0, 5, 0));
        humanCards.setSpacing(0);
        aiCards.setSpacing(0);
        boardCards.setSpacing(0);
        setAlignment(boardCards, Pos.TOP_LEFT);
//        setMargin(boardCards, new Insets(5,5,5,5));
        setAlignment(humanCards, Pos.BOTTOM_CENTER);
//        setMargin(humanCards, new Insets(5,5,5,5));
        setAlignment(aiCards, Pos.TOP_LEFT);
//        setMargin(aiCards, new Insets(5,5,5,5));

        //        BorderPane.setAlignment(board, Pos.CENTER);
//        BorderPane.setMargin(board, new Insets(30));
    }

//    public HBox displayCards(Card[] cards) {
//        System.out.println("displaying cards");
//        HBox hand = new HBox(10);
//        hand.setAlignment(Pos.CENTER);
//
//        for (Card card : cards) {
//            ImageView imageView = new ImageView(new Image("/cards/" + card.getValue() + ".png "));
//            hand.getChildren().add(imageView);
//        }
//
//        setCenter(hand); // Set the VBox as the center of the BorderPane
//        return hand;
//    }

    public Pane getBoardPane() {
        return boardPane;
    }

    //returns void
//    public void displayCards(List<Card> cards) {
//        VBox cardBox = new VBox(10); // Create a VBox to hold the card images
//        cardBox.setAlignment(Pos.CENTER);
//
//        for (Card card : cards) {
//            ImageView imageView = new ImageView(new Image(card.getImagePath())); // Create an ImageView for each card
//            cardBox.getChildren().add(imageView); // Add the ImageView to the VBox
//        }
//
//        setCenter(cardBox);
//    }

    private int cardSize = 200; // Set the size to 200 pixels

    public void setHumanCards(HBox humanCards) {
        this.humanCards.getChildren().clear();
        this.humanCards.setPrefWidth(10);
        this.humanCards.getChildren().addAll(humanCards.getChildren());
    }

//first approach TODO check with javafx if this works if the one above doesnt work
//    public void setAiCards(HBox cards) {
//        System.out.println("setting ai cards");
//        aiCards.getChildren().clear(); // clear previous cards from the view
//
//        // create and add card views for each card in the list
//        for (Card card : (List<Card>)cards) {
//            CardView cardView = new CardView(card);
//            aiCards.getChildren().add(cardView);
//        }
//    }

    public void setAiCards(HBox aiCards) {
        this.aiCards.getChildren().clear();
//        this.aiCards.setPrefSize(10 * 20 + 9 * (10 - 1), 20);
        this.aiCards.setPrefSize(250, 150);
        this.aiCards.getChildren().addAll(aiCards.getChildren());
    }

    public void setBoardCards(VBox boardCards) {
        this.boardCards.getChildren().clear();
//        this.boardCards.setPrefSize(4 * 20 + 3 * 10, 20);
        this.aiCards.setPrefSize(250, 150);

        this.boardCards.getChildren().addAll(boardCards.getChildren());
    }

//    public void setBoardCards(List<Card> cards) {
//        System.out.println("setting board cards");
//        boardCards.getChildren().clear(); // clear previous cards from the view
//
//        // create and add card views for each card in the list
//        for (Card card : cards) {
//            CardView cardView = new CardView(card);
//            boardCards.getChildren().add(cardView);
//        }
//    }


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
}
