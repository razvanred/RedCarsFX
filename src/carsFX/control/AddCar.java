package carsFX.control;

import carsFX.model.enums.Alimentazione;
import carsFX.model.enums.Marca;
import carsFX.model.enums.Versione;
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

        for(Alimentazione a:Alimentazione.values())
            alimCombo.getItems().add(a);

        for(Versione v:Versione.values())
            versionCombo.getItems().add(v.getDescrizione());

        for(Marca m:Marca.values())
            brandCombo.getItems().add(m.getNome());



    }
}
