package carsFX.control;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class AddCar implements Initializable {

    @FXML
    private JFXComboBox brandCombo;

    @FXML
    private JFXComboBox versionCombo;

    @FXML
    private JFXComboBox alimCombo;

    @FXML
    private JFXTextField startingFrom, modello;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}