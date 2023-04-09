package be.kdg.integration2.take5.ui.game;

import be.kdg.integration2.take5.model.Card;
import be.kdg.integration2.take5.model.Deck;
import be.kdg.integration2.take5.model.GameSession;
import be.kdg.integration2.take5.ui.help.HelpPresenter;
import be.kdg.integration2.take5.ui.help.HelpView;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.List;

public class GamePresenter {
    private GameSession model;
    private GameView gameView;

    public GamePresenter(GameSession model, GameView gameView) {
        this.model = model;
        this.gameView = gameView;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        gameView.getMenu().setOnAction(event -> showHelp()); //shows next screen
        model.makeBoard();
        model.startGame();
    }


//    private void updateCards() {
//        // get the current list of cards from the model
//        List<Card> cards = List.of(model.getDeck());
//        VBox cardContainer = gameView.displayCards(cards);
//        // clear any previous cards from the VBox
//        cardContainer.getChildren().clear();
//
//        // create a new HBox to hold each row of cards
//        VBox cardRow = new VBox();
//        cardRow.setAlignment(Pos.CENTER);
//        cardRow.setSpacing(10);
//
//        // loop through the list of cards and create a new CardView for each one
//        for (Card card : cards) {
//            CardView cardView = new CardView(card);
//            cardView.setOnMouseClicked(event -> cardClicked(cardView)); // add click event handler
//            cardRow.getChildren().add(cardView);
//        }
//
//        // add the row of cards to the cardContainer VBox
//        cardContainer.getChildren().add(cardRow);
//    }


    public void updateView() {
// update score and send to UI
        VBox board = new VBox();
        board.setSpacing(10);

        Card[] cards = model.makeBoard();
        for (Card card : cards) {
            Label cardLabel = new Label(card.toString());
            cardLabel.setStyle("-fx-background-color: white; -fx-border-color: black;");
            cardLabel.setPadding(new Insets(10));
            cardLabel.setFont(new Font(20));
            board.getChildren().add(cardLabel);
        }
    }

    //help screen empty for now
    private void showHelp() {
        HelpView helpView = new HelpView();
        HelpPresenter presenter = new HelpPresenter(model, helpView);
        Stage helpStage = new Stage();
        helpStage.initOwner(gameView.getScene().getWindow());
        helpStage.initModality(Modality.APPLICATION_MODAL);
        helpStage.setScene(new Scene(helpView));
        helpStage.setX(gameView.getScene().getWindow().getX());
        helpStage.setY(gameView.getScene().getWindow().getY());
        helpStage.showAndWait();
    }

    public void addWindowEventHandlers() {
        Window window = gameView.getScene().getWindow();

    }
}
