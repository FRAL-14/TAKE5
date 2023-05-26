package be.kdg.integration2.take5.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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

        // Load the image from file
        Image image = new Image(getClass().getResourceAsStream("/cards/main1.png"));

        // Create an ImageView and set the image to it
        ImageView imageView = new ImageView(image);

        // Set the size of the ImageView
        imageView.setFitHeight(400);
        imageView.setFitWidth(600);


        BorderPane.setMargin(imageView, new Insets(-130, -580, 0, -100));


        // Set the position of the ImageView in the layout
        setLeft(imageView);
        BorderPane.setAlignment(imageView, Pos.CENTER_LEFT);


        // Set the position of the ImageView in the layout
        setLeft(imageView);
        BorderPane.setAlignment(imageView, Pos.CENTER_LEFT);



        // Load the second image from file
        Image image2 = new Image(getClass().getResourceAsStream("/cards/main2.png"));

        // Create an ImageView and set the image to it
        ImageView imageView2 = new ImageView(image2);

        // Set the size of the second ImageView
        imageView2.setFitHeight(400);
        imageView2.setFitWidth(600);

        BorderPane.setMargin(imageView2, new Insets(-130, -100, 0, -580));

        // Set the position of the second ImageView in the layout
        setRight(imageView2);
        BorderPane.setAlignment(imageView2, Pos.CENTER_RIGHT);


        this.setStyle("-fx-background-color: linear-gradient(to bottom, #ffdcb6, #E06469);");
        play.setStyle("-fx-background-color: #E06469; -fx-background-radius: 15px;");
        help.setStyle("-fx-background-color: #fcc488; -fx-background-radius: 15px;");
        // add hover effect to play button
        play.setOnMouseEntered(e -> play.setStyle("-fx-background-color: #C95156;-fx-background-radius: 15px;-fx-cursor: hand;"));
        play.setOnMouseExited(e -> play.setStyle("-fx-background-color: #E06469;-fx-background-radius: 15px;"));

        // add hover effect to play button
        help.setOnMouseEntered(e -> help.setStyle("-fx-background-color: #e2a857;-fx-background-radius: 15px;-fx-cursor: hand;"));
        help.setOnMouseExited(e -> help.setStyle("-fx-background-color: #fcc488;-fx-background-radius: 15px;"));

        setTop(lb);
        BorderPane.setAlignment(lb, Pos.TOP_CENTER);
        BorderPane.setMargin(lb, new Insets(100, 250, 100, 250));
        lb.setFont(Font.font("Georgia", FontWeight.BOLD, 80));

        setCenter(play);
        BorderPane.setAlignment(play, Pos.CENTER);
        setMargin(play, new Insets(-100, 10, 10, 10));
        play.setFont(new Font(50));


        setBottom(help);
        BorderPane.setAlignment(help, Pos.BOTTOM_CENTER);
        help.setFont(new Font(20));
        setMargin(help, new Insets(10, 13, 100, 10));
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
