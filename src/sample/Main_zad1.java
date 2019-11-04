package sample;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Main_zad1 extends Application {
    final static int FROM = -60;
    final static int TO = 60;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
        root.getChildren().add(createChart());
    }

    protected ScatterChart<Number, Number> createChart() {
        final NumberAxis xAxis = new NumberAxis();
        xAxis.setSide(Side.BOTTOM);
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setSide(Side.LEFT);
        final ScatterChart<Number, Number> sc = new ScatterChart<>(xAxis, yAxis);
        // setup chart
        xAxis.setLabel("X Axis");
        yAxis.setLabel("Y Axis");
        // y = 0
        XYChart.Series<Number, Number> series = new XYChart.Series<>();

        series.setName("f(x) = 0");
        for (int i = FROM; i < TO; i++) {
            series.getData().add(new XYChart.Data<>(i, 0));
        }
        sc.getData().add(series);

        // y = -x^2
        series = new XYChart.Series<>();
        series.setName("f(x) = -x^2");
        for (int i = FROM; i < TO; i++) {
            series.getData().add(new XYChart.Data<>(i, -(i * i)));
        }
        sc.getData().add(series);

        // y = x^2 - x + 3
        series = new XYChart.Series<>();
        series.setName("f(x) = x^2 - x + 3");
        for (int i = FROM; i < TO; i++) {
            series.getData().add(new XYChart.Data<>(i, ((i * i) - i + 3)));
        }
        sc.getData().add(series);

        return sc;
    }
}
