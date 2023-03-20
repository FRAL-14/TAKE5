package be.kdg.integration2.take5.ui.game;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;

public class GameView extends BorderPane {
    // private Node attributes (controls)
//    private MenuBar mBar;
//    private MenuItem mItem;

    private ComboBox<String> menu;

    public GameView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        /*Menu mHelp = new Menu("Help");
        mItem = new MenuItem("Rules");
        mHelp.getItems().addAll(mItem);
        mBar=new MenuBar(mHelp);*/
        this.menu = new ComboBox<>();    // QUESTION: whats better to use? Menu class or ComboBox()
        ObservableList<String> values = FXCollections.observableArrayList("leaderboard", "rules");
        this.menu.setItems(values);
        this.menu.getSelectionModel().select(0);

    }

    private void layoutNodes() {
        setTop(menu);
// add/set … methods
// Insets, padding, alignment, …
    }
// package-private Getters
// for controls used by Presenter

    public ComboBox<String> getMenu() {
        return menu;
    }

    public void setMenu(ComboBox<String> menu) {
        this.menu = menu;
    }
}
