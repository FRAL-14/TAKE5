package be.kdg.integration2.take5.ui;

import be.kdg.integration2.take5.model.Card;
import be.kdg.integration2.take5.ui.game.GamePresenter;
import be.kdg.integration2.take5.ui.game.GameView;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CardView extends StackPane {
    private final Card card;
    private final ImageView imageView;

    public CardView(Card card) {
        this.card = card;
        this.imageView = new ImageView(new Image(getClass().getResourceAsStream("/cards/" + card.getValue() + ".png")));
        imageView.setFitWidth(160);
        imageView.setFitHeight(100);
        imageView.setPreserveRatio(true);
        getChildren().addAll(imageView);

        // Apply padding to the StackPane (top, right, bottom, left)
        setPadding(new Insets(0, 20, 40, 40));
    }

    public Card getCard() {
        return card;
    }
}
