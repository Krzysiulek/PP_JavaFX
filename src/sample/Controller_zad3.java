/**
 * Sample Skeleton for 'zad3.fxml' Controller Class
 */

package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_zad3 {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="total_id"
    private TableColumn<Coffee, String> total_id; // Value injected by FXMLLoader

    @FXML // fx:id="price_id"
    private TableColumn<Coffee, String> price_id; // Value injected by FXMLLoader

    @FXML // fx:id="table_id"
    private TableView<Coffee> table_id; // Value injected by FXMLLoader

    @FXML // fx:id="name_id"
    private TableColumn<Coffee, String> name_id; // Value injected by FXMLLoader

    @FXML // fx:id="supplier_id"
    private TableColumn<Coffee, String> supplier_id; // Value injected by FXMLLoader

    @FXML // fx:id="sales_id"
    private TableColumn<Coffee, String> sales_id; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert total_id != null : "fx:id=\"total_id\" was not injected: check your FXML file 'zad3.fxml'.";
        assert price_id != null : "fx:id=\"price_id\" was not injected: check your FXML file 'zad3.fxml'.";
        assert table_id != null : "fx:id=\"table_id\" was not injected: check your FXML file 'zad3.fxml'.";
        assert name_id != null : "fx:id=\"name_id\" was not injected: check your FXML file 'zad3.fxml'.";
        assert supplier_id != null : "fx:id=\"supplier_id\" was not injected: check your FXML file 'zad3.fxml'.";
        assert sales_id != null : "fx:id=\"sales_id\" was not injected: check your FXML file 'zad3.fxml'.";

        table_id.getItems().addAll(new CoffeeDao().getAll());

        name_id.setCellValueFactory(new PropertyValueFactory<>("name"));
        supplier_id.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        price_id.setCellValueFactory(new PropertyValueFactory<>("price"));
        sales_id.setCellValueFactory(new PropertyValueFactory<>("sales"));
        total_id.setCellValueFactory(new PropertyValueFactory<>("total"));
    }
}
