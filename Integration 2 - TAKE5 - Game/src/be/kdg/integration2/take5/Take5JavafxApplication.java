package be.kdg.integration2.take5;

import be.kdg.integration2.take5.model.GameSession;
import be.kdg.integration2.take5.ui.MainPresenter;
import be.kdg.integration2.take5.ui.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Take5JavafxApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }
//when running, uncomment classes in db_stats folder
    @Override
    public void start(Stage primaryStage) throws Exception {
        GameSession model = new GameSession();
        MainView startView = new MainView();
        MainPresenter startPresenter = new MainPresenter(model, startView);
        HBox root = new HBox();
        root.setSpacing(10);
        Scene scene = new Scene(startView);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Take 5");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(600);
        startPresenter.addWindowEventHandlers();
        primaryStage.show();
    }
}
