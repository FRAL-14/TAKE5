package be.kdg.integration2.take5.ui;

import be.kdg.integration2.take5.model.Card;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CardView extends StackPane {
    private final Card card;
    private final ImageView imageView;
    private boolean selected;

    public CardView(Card card) {
        this.card = card;
        this.imageView = new ImageView(new Image(getClass().getResourceAsStream("/cards/" + card.getValue() + ".png")));
        imageView.setFitWidth(100);
        imageView.setFitHeight(90);
        Rectangle border = new Rectangle(90, 125);
        border.setFill(Color.TRANSPARENT);
//        border.setStroke(selected ? Color.RED : Color.BLACK);

        getChildren().addAll(border, imageView);
    }

    public Card getCard() {
        return card;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        ((Rectangle) getChildren().get(0)).setStroke(selected ? Color.RED : Color.BLACK);
    }
}
