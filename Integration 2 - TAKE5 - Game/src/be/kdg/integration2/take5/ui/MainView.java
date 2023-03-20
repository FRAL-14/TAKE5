package be.kdg.integration2.take5.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class MainView extends BorderPane{
    // private Node attributes (controls)
    private Button sButton;
    private Label sLabel;

    public MainView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        // create and configure controls
        sLabel = new Label("Take 5");
        sButton = new Button("Click to start...");
    }

    private void layoutNodes() {
        setCenter(sLabel);
        setBottom(sButton);
        BorderPane.setAlignment(sButton, Pos.CENTER);
        BorderPane.setAlignment(sLabel, Pos.CENTER);
        BorderPane.setMargin(sLabel, new Insets(150));
        sLabel.setFont(new Font(100));
        sButton.setFont(new Font(50));
        // add/set … methods
        // Insets, padding, alignment, …
    }
    // package-private Getters
    // for controls used by Presenter

    public Button getsButton() {
        return sButton;
    }

    public void setsButton(Button sButton) {
        this.sButton = sButton;
    }

    public Label getsLabel() {
        return sLabel;
    }

    public void setsLabel(Label sLabel) {
        this.sLabel = sLabel;
    }
}
