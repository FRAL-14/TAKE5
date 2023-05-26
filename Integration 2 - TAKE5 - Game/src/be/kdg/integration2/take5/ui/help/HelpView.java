package be.kdg.integration2.take5.ui.help;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
/**
 * This class is responsible for displaying the helpView.
 */
public class HelpView extends BorderPane {
    private Button returnButton;
    private Label rules;
    private Label header;

    public HelpView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        returnButton = new Button("Return");
        header = new Label("Help & Rules");
        rules = new Label("In the game, players choose cards from their hand to add to a layout, with the lowest card going first." + "\n" +
                "Cards must be added in ascending order from left to right, and if a card can be played in multiple rows, " + "\n" +
                "it must be placed in the row with the closest end-card value. If a player reveals a card that cannot be played," + "\n" +
                "they must collect a row and start a new one. The game ends when a player reaches more than 66 points," + "\n" +
                "and the player with the lowest score wins.");
    }

    private void layoutNodes() {
        this.setStyle("-fx-background-color: #fcc488");
        setTop(header);
        header.setFont(new Font(80));
        setAlignment(header, Pos.TOP_CENTER);
        setMargin(header, new Insets(30));

        setCenter(rules);
        rules.setFont(new Font(20));
        setMargin(rules, new Insets(20, 35, 20, 35));
        setAlignment(rules, Pos.CENTER);

        setBottom(returnButton);
        returnButton.setFont(new Font(20));
        returnButton.setStyle("-fx-background-color: #fffced;-fx-background-radius: 15px;");
        setMargin(returnButton, new Insets(40));
        setAlignment(returnButton, Pos.BOTTOM_LEFT);
    }

    public Button getReturnButton() {
        return returnButton;
    }

    public void setReturnButton(Button returnButton) {
        this.returnButton = returnButton;
    }

    public Label getRules() {
        return rules;
    }

    public void setRules(Label rules) {
        this.rules = rules;
    }
}
