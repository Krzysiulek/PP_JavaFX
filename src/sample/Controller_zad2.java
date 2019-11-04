/**
 * Sample Skeleton for 'zad2.fxml' Controller Class
 */

package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class Controller_zad2 {
    final static int FROM = -60;
    final static int TO = 60;
    final NumberAxis xAxis = new NumberAxis();
    final NumberAxis yAxis = new NumberAxis();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="series_name_id"
    private TextField series_name_id; // Value injected by FXMLLoader

    @FXML // fx:id="clear_button_id"
    private Button clear_button_id; // Value injected by FXMLLoader

    @FXML // fx:id="generateChartButton"
    private Button generateChartButton; // Value injected by FXMLLoader

    @FXML // fx:id="chart_id"
    private LineChart<Number, Number> chart_id; // Value injected by FXMLLoader

    @FXML // fx:id="chart_type_id"
    private CheckBox chart_type_id; // Value injected by FXMLLoader

    @FXML // fx:id="a_id"
    private TextField a_id; // Value injected by FXMLLoader

    @FXML // fx:id="b_id"
    private TextField b_id; // Value injected by FXMLLoader

    @FXML // fx:id="c_id"
    private TextField c_id; // Value injected by FXMLLoader

    @FXML
    void chartTypeChange(ActionEvent event) {
        System.out.println("Changing chart type");
    }

    @FXML
    void generateChart(ActionEvent event) {
        System.out.println("Chart generating");
        generateChart(a_id.getCharacters(), b_id.getCharacters(), c_id.getCharacters());
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert generateChartButton != null : "fx:id=\"generateChartButton\" was not injected: check your FXML file 'zad2.fxml'.";
        assert chart_id != null : "fx:id=\"chart_id\" was not injected: check your FXML file 'zad2.fxml'.";
        assert chart_type_id != null : "fx:id=\"chart_type_id\" was not injected: check your FXML file 'zad2.fxml'.";
        assert a_id != null : "fx:id=\"a_id\" was not injected: check your FXML file 'zad2.fxml'.";
        assert b_id != null : "fx:id=\"b_id\" was not injected: check your FXML file 'zad2.fxml'.";
        assert c_id != null : "fx:id=\"c_id\" was not injected: check your FXML file 'zad2.fxml'.";
    }

    @FXML
    void clearCharts(ActionEvent event) {
        chart_id.getData().clear();
    }

    private void generateChart(CharSequence a, CharSequence b, CharSequence c) {
        double A = Double.valueOf(String.valueOf(a));
        double B = Double.valueOf(String.valueOf(b));
        double C = Double.valueOf(String.valueOf(c));

        System.out.println(A);
        System.out.println(B);
        System.out.println(C);

        XYChart.Series series = new XYChart.Series();
        series.setName(String.valueOf(series_name_id.getCharacters()));

        for (int x = FROM; x < TO; x++) {
            series.getData().add(new XYChart.Data<>(x, getY(x, A, B, C)));
        }

        chart_id.getData().add(series);
        this.initialize();
    }

    private double getY(double x, double a, double b, double c) {
        return a * Math.pow(x, 2) + b * x + c;
    }
}

