package be.kdg.integration2.take5.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class MainView extends BorderPane {
    private Button play;
    private Button stats;
    private Button help;
    private Label lb;

    public MainView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        lb = new Label("Take 5");
        play = new Button("Start!");
        stats = new Button("Statistics");
        help = new Button("Help & Rules");
    }

    private void layoutNodes() {
        setTop(lb);
        setCenter(play);
        setLeft(stats);
        setRight(help);
        BorderPane.setAlignment(play, Pos.CENTER);
        BorderPane.setAlignment(lb, Pos.TOP_CENTER);
        BorderPane.setAlignment(stats, Pos.BASELINE_LEFT); // can be changed later
        BorderPane.setAlignment(help, Pos.BASELINE_RIGHT);
        BorderPane.setMargin(lb, new Insets(30));
        lb.setFont(new Font(80));
        play.setFont(new Font(40));
        stats.setFont(new Font(20));
        help.setFont(new Font(20));
        setMargin(stats, new Insets(20, 0, 0, 40));
        setMargin(help, new Insets(20, 40, 0, 0));
    }
    // getters and setters

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

    public Button getStats() {
        return stats;
    }

    public void setStats(Button stats) {
        this.stats = stats;
    }

    public Button getHelp() {
        return help;
    }

    public void setHelp(Button help) {
        this.help = help;
    }
}
