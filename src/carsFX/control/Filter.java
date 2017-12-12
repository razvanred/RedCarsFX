package carsFX.control;

import carsFX.model.enums.Alimentazione;
import carsFX.model.enums.Marca;
import carsFX.model.enums.Versione;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import org.controlsfx.control.SegmentedButton;
import org.controlsfx.control.ToggleSwitch;

import java.net.URL;
import java.util.ResourceBundle;

public class Filter implements Initializable {

    private TableProperties table;

    @FXML
    private ToggleSwitch neoToggle;

    @FXML
    private JFXComboBox<String> comboVersione;

    @FXML
    private JFXComboBox<String> comboAlimentazione;

    @FXML
    private JFXTextField startingAt;

    @FXML
    private SegmentedButton filterBrand;

    @FXML
    private JFXRadioButton radioNew, radioUsed;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        startingAt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    startingAt.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        ToggleGroup status = new ToggleGroup();
        radioNew.setToggleGroup(status);
        radioNew.setUserData(0);
        radioUsed.setToggleGroup(status);
        radioUsed.setUserData(1);

        radioNew.setSelected(true);

        ToggleGroup brandGroup = new ToggleGroup();

        filterBrand.getStyleClass().add(SegmentedButton.STYLE_CLASS_DARK);
        for (Marca m : Marca.values()) {
            ToggleButton button = new ToggleButton(m.getNome());
            filterBrand.getButtons().add(button);
            button.setUserData(m);
            button.setToggleGroup(brandGroup);

            button.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {
                        System.out.println(m.getNome());
                    }
                }
            });
        }

        status.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                System.out.println(newValue.getUserData());
            }
        });

        comboVersione.getItems().add("Tutti");
        comboAlimentazione.getItems().add("Tutti");

        for (Alimentazione a : Alimentazione.values())
            comboAlimentazione.getItems().add(a.name());

        for (Versione v : Versione.values())
            comboVersione.getItems().add(v.getDescrizione());

        comboVersione.getSelectionModel().selectFirst();
        comboAlimentazione.getSelectionModel().selectFirst();

    }

    public void comboAction(ActionEvent ae) {

    }

    public void attachTable(final TableProperties table) {
        this.table = table;
    }


}
