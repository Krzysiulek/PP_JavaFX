/**
 * Sample Skeleton for 'zad2.fxml' Controller Class
 */

package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_zad2 {
    final String QUADRATIC = "Quadratic Function";
    final String LOG = "Logarithmic Function";
    final String POWER = "Power Function";

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="series_name_id"
    private TextField series_name_id; // Value injected by FXMLLoader

    @FXML // fx:id="generateChartButton"
    private Button generateChartButton; // Value injected by FXMLLoader

    @FXML // fx:id="clear_button_id"
    private Button clear_button_id; // Value injected by FXMLLoader

    @FXML // fx:id="from_id"
    private TextField from_id; // Value injected by FXMLLoader

    @FXML // fx:id="chart_id"
    private LineChart<?, ?> chart_id; // Value injected by FXMLLoader

    @FXML // fx:id="a_id"
    private TextField a_id; // Value injected by FXMLLoader

    @FXML // fx:id="b_id"
    private TextField b_id; // Value injected by FXMLLoader

    @FXML // fx:id="c_id"
    private TextField c_id; // Value injected by FXMLLoader

    @FXML // fx:id="to_id"
    private TextField to_id; // Value injected by FXMLLoader

    @FXML // fx:id="choice_id"
    private ChoiceBox<String> choice_id; // Value injected by FXMLLoader

    @FXML
    void generateChart(ActionEvent event) {
        generateChart(a_id.getCharacters(), b_id.getCharacters(), c_id.getCharacters());
    }

    @FXML
    void clearCharts(ActionEvent event) {
        chart_id.getData().clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert series_name_id != null : "fx:id=\"series_name_id\" was not injected: check your FXML file 'zad2.fxml'.";
        assert generateChartButton != null : "fx:id=\"generateChartButton\" was not injected: check your FXML file 'zad2.fxml'.";
        assert clear_button_id != null : "fx:id=\"clear_button_id\" was not injected: check your FXML file 'zad2.fxml'.";
        assert from_id != null : "fx:id=\"from_id\" was not injected: check your FXML file 'zad2.fxml'.";
        assert chart_id != null : "fx:id=\"chart_id\" was not injected: check your FXML file 'zad2.fxml'.";
        assert a_id != null : "fx:id=\"a_id\" was not injected: check your FXML file 'zad2.fxml'.";
        assert b_id != null : "fx:id=\"b_id\" was not injected: check your FXML file 'zad2.fxml'.";
        assert c_id != null : "fx:id=\"c_id\" was not injected: check your FXML file 'zad2.fxml'.";
        assert to_id != null : "fx:id=\"to_id\" was not injected: check your FXML file 'zad2.fxml'.";
        assert choice_id != null : "fx:id=\"choice_id\" was not injected: check your FXML file 'zad2.fxml'.";

        choice_id.setItems(FXCollections.observableArrayList(QUADRATIC, LOG, POWER));
        choice_id.setValue(QUADRATIC);
    }

    private void generateChart(CharSequence a, CharSequence b, CharSequence c) {
        double A = Double.valueOf(String.valueOf(a));
        double B = Double.valueOf(String.valueOf(b));
        double C = Double.valueOf(String.valueOf(c));
        double FROM = Double.valueOf(String.valueOf(from_id.getCharacters()));
        double TO = Double.valueOf(String.valueOf(to_id.getCharacters()));
        double ADD_VALUE = (TO - FROM) / 40;

        System.out.println(A);
        System.out.println(B);
        System.out.println(C);

        XYChart.Series series = new XYChart.Series();
        series.setName(String.valueOf(series_name_id.getCharacters()));

        final String choice = choice_id.getValue();
        System.out.println(choice_id.getValue());
        for (double x = FROM; x < TO; x += ADD_VALUE) {
            if (choice.equals(LOG)) {
                series.getData().add(new XYChart.Data<>(x, getYLog(x, A, B)));
            }
            else if (choice.equals(POWER)) {
                series.getData().add(new XYChart.Data<>(x, getYPower(x, A, B)));
            }
            else {
                series.getData().add(new XYChart.Data<>(x, getYQuadratic(x, A, B, C)));
            }
        }

        chart_id.getData().add(series);
        this.initialize();
    }

    private double getYQuadratic(double x, double a, double b, double c) {
        return a * Math.pow(x, 2) + b * x + c;
    }

    private double getYLog(double x, double a, double b) {
        return (Math.log(x) / Math.log(a)) + b;
    }

    private double getYPower(double x, double n, double b) {
        return Math.pow(x, n) + b;
    }
}

