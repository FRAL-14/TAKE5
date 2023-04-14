//package be.kdg.integration2.take5.ui.db_stats;
//
//import be.kdg.integration2.take5.model.Move;
//import java.time.Duration;
//import java.util.List;
//
//public class DBPresenter {
//
//    private final DBView view;
//    private final DBManager manager;
//
//    public DBPresenter(DBView view, DBManager manager) {
//        this.view = view;
//        this.manager = manager;
//    }
//
//    public void start() {
//        view.show();
//
//        List<Move> moves = manager.getAllMoves();
//
//        view.updateMovesTable(moves);
//
//        double avgDuration = manager.getAverageMoveDuration();
//        view.updateAvgDurationLabel(Duration.ofMillis((long) (avgDuration * 1000)));
//
//        List<Move> outliers = manager.getDurationOutliers();
//        view.updateOutlierLabel(outliers);
//
//        view.updateDurationChart(moves);
//    }
//
//}
