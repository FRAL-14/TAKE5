package be.kdg.integration2.take5.ui;

import be.kdg.integration2.take5.model.Card;
import be.kdg.integration2.take5.ui.game.GamePresenter;
import be.kdg.integration2.take5.ui.game.GameView;
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
//      old design
//        imageView.setFitWidth(140);
//        imageView.setFitHeight(100);
        imageView.setFitHeight(120);
//        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);
        getChildren().addAll(imageView);
    }

    public Card getCard() {
        return card;
    }
}
