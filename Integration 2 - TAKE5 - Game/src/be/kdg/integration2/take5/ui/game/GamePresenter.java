package be.kdg.integration2.take5.ui.game;

import be.kdg.integration2.take5.model.*;
import be.kdg.integration2.take5.ui.CardView;
import be.kdg.integration2.take5.ui.help.HelpPresenter;
import be.kdg.integration2.take5.ui.help.HelpView;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GamePresenter {

    private GameSession model;
    private GameView gameView;
    private HBox humanCards = new HBox();
    private HBox aiCards = new HBox();
    private GridPane boardCards = new GridPane();
    private Player player;
    //    private HBox board = new HBox();
    private int humanScore = 0;
    private int aiScore = 0;
    private boolean isSelected = false;

    public GamePresenter(GameSession model, GameView gameView) {
        this.model = model;
        this.gameView = gameView;
        addEventHandlers();
//        updateView();
        displayCards(humanCards, aiCards, boardCards);
        gameView.setHumanCards(humanCards);
        gameView.setAiCards(aiCards);
        gameView.setBoardCards(boardCards);
    }

    private void addEventHandlers() {
//        gameView.getMenu().setOnAction(event -> showHelp()); //shows next screen
//        model.makeBoard();
//        model.startGame();
//        gameView.getRestartGame().setOnAction(event -> restartGame());
        gameView.getHumanCards().setOnMouseClicked(event -> playOnBoard(player));
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


    public void displayCards(HBox humanCards, HBox aiCards, GridPane boardCards) {
        List<Card> deck = new ArrayList<>(Arrays.asList(Card.values()));
        Collections.shuffle(deck);

        for (int i = 0; i < 10; i++) {
            CardView cardView = new CardView(deck.remove(0));
            humanCards.getChildren().add(cardView);
        }

        for (int i = 0; i < 10; i++) {
            CardView cardView = new CardView(deck.remove(0));
            aiCards.getChildren().add(cardView);
        }

        for (int i = 0; i < 4; i++) {
            CardView cardView = new CardView(deck.remove(0));
            boardCards.add(cardView, 0, i);
        }

    }


    //    private void playOnBoard() {
//        VBox oldBoardCards = gameView.getBoardCards();
//        VBox newBoardCards = new VBox();
//        for (Node cardNode : gameView.getHumanCards().getChildren()) {
//            if (cardNode instanceof CardView) {
//                CardView cardView = (CardView) cardNode;
//                cardView.setOnMouseClicked(event -> {
//                    // Remove the card from the humanCards HBox
//                    gameView.getHumanCards().getChildren().remove(cardView);
//                    // Add the card to the boardCards VBox
//                    gameView.getBoardCards().getChildren().add(cardView);
//                    // Add the card to the newBoardCards VBox
//                    newBoardCards.getChildren().add(cardView);
//
//                });
//            }
//        }
//        // Add the newBoardCards VBox next to the oldBoardCards VBox
//        int oldIndex = gameView.getBoardCards().getChildren().indexOf(oldBoardCards);
//        gameView.getBoardCards().getChildren().add(oldIndex + 1, newBoardCards);
//    }

// TODO CORRECT!

    //    private void playOnBoard() {
//        VBox boardCards = new VBox();
//        boardCards.setSpacing(10);
//        boardCards.setAlignment(Pos.CENTER);
//
//        for (Node cardNode : gameView.getHumanCards().getChildren()) {
//            if (cardNode instanceof CardView) {
//                CardView cardView = (CardView) cardNode;
//                cardView.setOnMouseClicked(event -> {
//                    // Remove the card from the humanCards HBox
//                    gameView.getHumanCards().getChildren().remove(cardView);
//                    // Create a new VBox and add the card to it
//                    VBox newBoardCards = new VBox();
//                    newBoardCards.setSpacing(10);
//                    newBoardCards.setAlignment(Pos.CENTER);
//                    newBoardCards.getChildren().add(cardView);
//                    // Add the new VBox to the board
//                    gameView.getBoardCards().getChildren().add(newBoardCards);
//                });
//            }
//        }
//    }

    //TODO ALSO KINDA WORKRD
//    private VBox lastVBox;
//
//    private void playOnBoard() {
//        for (Node cardNode : gameView.getHumanCards().getChildren()) {
//            if (cardNode instanceof CardView) {
//                CardView cardView = (CardView) cardNode;
//                cardView.setOnMouseClicked(event -> {
//                    // Remove the card from the humanCards HBox
//                    gameView.getHumanCards().getChildren().remove(cardView);
//                    // Create a new VBox and add the card to it
//                    VBox boardCards = new VBox();
//                    boardCards.setSpacing(10);
//                    boardCards.setAlignment(Pos.CENTER);
//                    boardCards.getChildren().add(cardView);
//                    // Add the new VBox to the board
//                    if (lastVBox == null || lastVBox.getChildren().size() == 3) {
//                        gameView.getBoardCards().getChildren().add(boardCards);
//                        lastVBox = boardCards;
//                    } else {
//                        gameView.getBoardCards().getChildren().add(boardCards);
//                        HBox.setMargin(boardCards, new Insets(0, 0, 0, 20));
//                        lastVBox = boardCards;
//                    }
//                });
//            }
//        }
//    }
//private GridPane lastGridPane;
//
//    private void playOnBoard() {
//        for (Node cardNode : gameView.getHumanCards().getChildren()) {
//            if (cardNode instanceof CardView) {
//                CardView cardView = (CardView) cardNode;
//                cardView.setOnMouseClicked(event -> {
//                    // Remove the card from the humanCards HBox
//                    gameView.getHumanCards().getChildren().remove(cardView);
//
//                    // Create a new GridPane and add the card to it
//                    GridPane boardCards = new GridPane();
//                    boardCards.setHgap(10);
//                    boardCards.setAlignment(Pos.CENTER);
//                    boardCards.add(cardView, 0, 0);
//
//                    // Add the new GridPane to the board
//                    if (lastGridPane == null || lastGridPane.getChildren().size() == 4) {
//                        gameView.getBoardCards().getChildren().add(boardCards);
//                        lastGridPane = boardCards;
//                    } else {
//                        gameView.getBoardCards().getChildren().add(boardCards);
//                        GridPane.setMargin(boardCards, new Insets(0, 0, 0, 100));
//                        lastGridPane = boardCards;
//                    }
//                });
//            }
//        }
//    }
//
    private int getCardColumnIndex(CardView cardView) {
        int cardValue = cardView.getCard().getValue();
        int closestValue = Integer.MAX_VALUE;
        int closestIndex = -1;
        for (int i = 0; i < boardCards.getChildren().size(); i++) {
            Node node = boardCards.getChildren().get(i);
            if (node instanceof GridPane) {
                GridPane gridPane = (GridPane) node;
                int lastCardValue = ((CardView) gridPane.getChildren().get(gridPane.getChildren().size() - 1)).getCard().getValue();
                if (cardValue <= lastCardValue && lastCardValue - cardValue < closestValue) {
                    closestValue = lastCardValue - cardValue;
                    closestIndex = GridPane.getColumnIndex(gridPane);
                }
            }
        }
        return closestIndex;
    }

    //todo works but still have to apply the logic of card placement
    //player instanceOf Human / AI
    //read clickedCard
    //get card with closest card value (will create other method)
    private void playOnBoard(Player player) {
        HBox handCard = new HBox();
        if (player instanceof Human) {
            handCard = gameView.getHumanCards();
        } else if (player instanceof AI) {
            handCard = gameView.getAiCards();
        }
        //i think the board is added as a GridPane, but all 4 of the cards are put into one cell of the grid (what i assume, gottta fix)
        for (Node cardNode : gameView.getHumanCards().getChildren()) {
            if (cardNode instanceof CardView) {
                CardView cardView = (CardView) cardNode;
                Card card = cardView.getCard();
                cardView.setOnMouseClicked(event -> {
                    gameView.getHumanCards().getChildren().remove(cardView);
                    int clickedCardValue = card.getValue();
                    // Find the closest but bigger card among the 4 already on the board
                    int closestButSmallerCardValue = Integer.MAX_VALUE;
                    CardView closestButSmallerCard = null;
                    for (Node boardNode : gameView.getBoardCards().getChildren()) {
                        if (boardNode instanceof GridPane) {
                            GridPane column = (GridPane) boardNode;
                            for (Node cardNodeOnBoard : column.getChildren()) {
                                if (cardNodeOnBoard instanceof CardView) {
                                    CardView cardOnBoard = (CardView) cardNodeOnBoard;
                                    int cardOnBoardValue = cardOnBoard.getCard().getValue();
                                    if (cardOnBoardValue > clickedCardValue && cardOnBoardValue < closestButSmallerCardValue) {
                                        closestButSmallerCardValue = cardOnBoardValue;
                                        closestButSmallerCard = cardOnBoard;
                                    }
                                }
                            }
                        }
                    }

                    // if there's no closest but bigger card, add the clicked card to a new column on the board
                    if (closestButSmallerCard == null) {
                        GridPane newColumn = new GridPane();
                        newColumn.setAlignment(Pos.CENTER); // if i leave this out, nothing appears, even though the condition isnt met...
                        newColumn.setVgap(10);
                        newColumn.add(cardView, 0, 0);
                        gameView.getBoardCards().add(newColumn, gameView.getBoardCards().getChildren().size(), 0);
                    } else {
                        GridPane closestButSmallerCardColumn = (GridPane) closestButSmallerCard.getParent();
                        int closestButSmallerCardIndex = closestButSmallerCardColumn.getChildren().indexOf(closestButSmallerCard);
                        closestButSmallerCardColumn.add(cardView, 0, closestButSmallerCardIndex + 1);
                    }
                });
            }
        }
    }

    private Card getLastCard(VBox vBox) {
        ObservableList<Node> children = vBox.getChildren();
        if (children.isEmpty()) {
            return null;
        }
        Node lastNode = children.get(children.size() - 1);
        if (lastNode instanceof CardView) {
            CardView lastCardView = (CardView) lastNode;
            return lastCardView.getCard();
        }
        return null;
    }

    private void checkLists() {
        for (Node vBoxNode : gameView.getBoardCards().getChildren()) {
            if (vBoxNode instanceof VBox) {
                VBox vBox = (VBox) vBoxNode;
                ObservableList<Node> children = vBox.getChildren();
                if (children.size() == 6) {
                    List<CardView> cardViews = new ArrayList<>();
                    for (Node child : children) {
                        if (child instanceof CardView) {
                            cardViews.add((CardView) child);
                        }
                    }
                    Card[] cards = cardViews.stream().map(CardView::getCard).toArray(Card[]::new);
                    int pointValue = Card.getPointValue(cards[4]);
                    for (CardView cardView : cardViews) {
                        Card.getPointValue(cardView.getCard());
                    }
                    vBox.getChildren().removeAll(cardViews);
                }
            }
        }
    }


//    private void playOnBoard() {
//        for (Node cardNode : gameView.getHumanCards().getChildren()) {
//            if (cardNode instanceof CardView) {
//                CardView cardView = (CardView) cardNode;
//                Card card = cardView.getCard();
//                cardView.setOnMouseClicked(event -> {
//                    // Remove the card from the humanCards HBox
//                    gameView.getHumanCards().getChildren().remove(cardView);
//
//                    // Determine where to add the card on the board
//                    VBox board = gameView.getBoardCards();
//                    int numVBoxes = board.getChildren().size();
//                    int cardValue = card.getValue();
//                    int bestDiff = Integer.MAX_VALUE;
//                    int bestIndex = -1;
//                    for (int i = 0; i < numVBoxes; i++) {
//                        VBox vBox = (VBox) board.getChildren().get(i);
//                        Card lastCard = getLastCard(vBox);
//                        if (lastCard == null || cardValue < lastCard.getValue()) {
//                            int diff = lastCard == null ? Integer.MAX_VALUE : lastCard.getValue() - cardValue;
//                            if (diff < bestDiff) {
//                                bestDiff = diff;
//                                bestIndex = i;
//                            }
//                        }
//                    }
//
//                    // Add the card to the appropriate VBox on the board
//                    VBox newVBox = new VBox();
//                    newVBox.setAlignment(Pos.CENTER);
//                    newVBox.getChildren().add(cardView);
//                    if (bestIndex == -1) {
//                        // Create a new VBox to the right of the existing ones
//                        board.getChildren().add(newVBox);
//                    } else {
//                        // Add the card to the appropriate VBox
//                        VBox vBox = (VBox) board.getChildren().get(bestIndex);
//                        vBox.getChildren().add(cardView);
//                    }
//                });
//            }
//        }
//    }

//    private Card getLastCard(VBox vBox) {
//        ObservableList<Node> children = vBox.getChildren();
//        if (children.isEmpty()) {
//            return null;
//        }
//        Node lastNode = children.get(children.size() - 1);
//        if (lastNode instanceof CardView) {
//            CardView lastCardView = (CardView) lastNode;
//            return lastCardView.getCard();
//        }
//        return null;
//    }
//    public void initializeBoardView(BoardView boardView, Deck deck) {
//        initializeRow(deck);
//        for (int i = 0; i < rows.length; i++) {
//            for (int j = 0; j < rows[i].size(); j++) {
//                Card card = rows[i].get(j);
//                CardView cardView = new CardView(card);
//                int rowIndex = i;
//                int columnIndex = j;
//                cardView.setOnMouseClicked(event -> {
//                    playCard(card, player);
//                    boardView.addCardView(cardView, rowIndex, columnIndex);
//                });
//                boardView.addCardView(cardView, i, j);
//            }
//        }
//    }


    private void restartGame() {
        model.makeBoard();
        model.startGame();
//        updateView();
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


    //literally has no effect on the board rip
    public void updateView() {
// update score and send to UI
     /*   HBox board = new HBox();
        board.setSpacing(10);

        Card[] cards = model.makeBoard();
        for (Card card : cards) {
            Label cardLabel = new Label(card.toString());
            cardLabel.setStyle("-fx-background-color: white; -fx-border-color: black;");
            cardLabel.setPadding(new Insets(10));
            cardLabel.setFont(new Font(20));
            board.getChildren().add(cardLabel);
        }*/
    }
////
//    //help screen empty for now
//    private void showHelp() {
//        HelpView helpView = new HelpView();
//        HelpPresenter presenter = new HelpPresenter(model, helpView);
//        Stage helpStage = new Stage();
//        helpStage.initOwner(gameView.getScene().getWindow());
//        helpStage.initModality(Modality.APPLICATION_MODAL);
//        helpStage.setScene(new Scene(helpView));
//        helpStage.setX(gameView.getScene().getWindow().getX());
//        helpStage.setY(gameView.getScene().getWindow().getY());
//        helpStage.showAndWait();
//    }

    public void addWindowEventHandlers() {
        Window window = gameView.getScene().getWindow();

    }
}
