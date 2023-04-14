package be.kdg.integration2.take5.ui.help;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class HelpView extends BorderPane {
    private Button returnButton;
    private Label txt;

    public HelpView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        returnButton = new Button("Return");
        txt = new Label("The goal of the game is to get rid of all your cards.");
    }

    private void layoutNodes() {
        setBottom(returnButton);
        setAlignment(returnButton, Pos.BOTTOM_LEFT);
        setAlignment(txt, Pos.CENTER);
    }
//getters and setters

    public Button getReturnButton() {
        return returnButton;
    }

    public void setReturnButton(Button returnButton) {
        this.returnButton = returnButton;
    }

    public Label getTxt() {
        return txt;
    }

    public void setTxt(Label txt) {
        this.txt = txt;
    }
}
