package be.kdg.integration2.take5.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

/**
 * This class is responsible for displaying the starting screen.
 */
public class MainView extends BorderPane {
    private Button play;
    private Button help;
    private Label lb;

    public MainView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        lb = new Label("Take 5");
        play = new Button("Start!");
        help = new Button("Help & Rules");
    }

    private void layoutNodes() {
        this.setStyle("-fx-background-color: #fffced");
        play.setStyle("-fx-background-color: #C5E3F2; -fx-background-radius: 15px;");
        help.setStyle("-fx-background-color: #DDFFC1; -fx-background-radius: 15px;");

        setTop(lb);
        BorderPane.setAlignment(lb, Pos.TOP_CENTER);
        BorderPane.setMargin(lb, new Insets(40, 250, 100, 250));
        lb.setFont(new Font(80));

        setCenter(play);
        BorderPane.setAlignment(play, Pos.CENTER);
        setMargin(play, new Insets(10, 10, 50, 10));
        play.setFont(new Font(50));

        setBottom(help);
        BorderPane.setAlignment(help, Pos.BOTTOM_CENTER);
        help.setFont(new Font(20));
        setMargin(help, new Insets(10, 10, 50, 10));
    }

    public Button getPlay() {
        return play;
    }

    public void setPlay(Button play) {
        this.play = play;
    }

    public Label getLb() {
        return lb;
    }

    public void setLb(Label lb) {
        this.lb = lb;
    }

    public Button getHelp() {
        return help;
    }

    public void setHelp(Button help) {
        this.help = help;
    }
}
