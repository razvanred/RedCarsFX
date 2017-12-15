package carsFX.control;

import com.jfoenix.controls.JFXTabPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Main implements Initializable {

    @FXML
    private JFXTabPane tabPane;

    @FXML
    private Tab tabOnSale, tabSold;

    private TableProperties onSale, sold;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/carsFX/view/onsale.fxml"));
        try {
            tabOnSale.setContent(loader.load());
        } catch (IOException io) {
            io.printStackTrace();
        }

        onSale = loader.getController();
        loader = new FXMLLoader(getClass().getResource("/carsFX/view/sold.fxml"));

        try {
            tabSold.setContent(loader.load());
        } catch (IOException io) {
            io.printStackTrace();
        }
        sold = loader.getController();

        tabPane.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() == 0)
                    onSale.refreshData();
                else if (newValue.intValue() == 2)
                    sold.refreshData();
            }
        });

    }
}
