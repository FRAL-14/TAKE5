package be.kdg.integration2.take5.ui.game;

import be.kdg.integration2.take5.model.Card;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.List;

public class GameView extends BorderPane {
    private MenuBar mBar;
    private MenuItem menuItem;
    private Menu menu;
    private Button restartGame;
    private Button quitGame;
    private VBox board = new VBox(10);

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
        setAlignment(restartGame, Pos.BASELINE_LEFT);
        setAlignment(quitGame, Pos.BASELINE_LEFT);

        setCenter(board);
        BorderPane.setAlignment(board, Pos.CENTER);
        BorderPane.setMargin(board, new Insets(30));
    }

    public VBox displayCards(Card[] cards) {
        VBox hand = new VBox(10);
        hand.setAlignment(Pos.CENTER);

        for (Card card : cards) {
            ImageView imageView = new ImageView(new Image(/*PATH.TO.FILE*/" "));
            hand.getChildren().add(imageView);
        }

        setCenter(hand); // Set the VBox as the center of the BorderPane
        return hand;
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
