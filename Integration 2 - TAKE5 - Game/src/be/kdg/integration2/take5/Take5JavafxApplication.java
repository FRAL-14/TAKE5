package be.kdg.integration2.take5;

import be.kdg.integration2.take5.model.GameSession;
import be.kdg.integration2.take5.ui.MainPresenter;
import be.kdg.integration2.take5.ui.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class Take5JavafxApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameSession model = new GameSession();
        MainView startView = new MainView();
        MainPresenter startPresenter = new MainPresenter(model, startView);
        Scene scene = new Scene(startView);
        scene.setFill(new RadialGradient
                (0, 0, 0, 0, 1,
                        true, CycleMethod.NO_CYCLE,
                        new Stop(0, Color.web("#EA899A")),
                        new Stop(1, Color.web("#bd223d"))));
        primaryStage.setTitle("Take 5");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
//      primaryStage.setScene(new Scene(new StartView()));    // QUESTION: if i use this, how can i set the color of the scene?
        startPresenter.addWindowEventHandlers();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
