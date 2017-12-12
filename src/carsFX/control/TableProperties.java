package carsFX.control;

import carsFX.model.Auto;
import carsFX.model.enums.Alimentazione;
import carsFX.model.enums.Marca;
import com.jfoenix.controls.JFXCheckBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class TableProperties implements Initializable {

    protected ObservableList<Auto> cars;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cars = FXCollections.observableArrayList();

        final TableColumn<Auto, Marca> marcaCol = new TableColumn<>("Marca");
        final TableColumn<Auto, String> modelloCol = new TableColumn<>("Modello");
        final TableColumn<Auto, String> versioneColumn = new TableColumn<>("Versione");
        final TableColumn<Auto, String> pesoColumn = new TableColumn<>("Peso in t");
        final TableColumn<Auto, Integer> kwColumn = new TableColumn<>("KW");
        final TableColumn<Auto, Integer> cilindrataColumn = new TableColumn<>("Cilindrata");
        final TableColumn<Auto, JFXCheckBox> neoColumn = new TableColumn<>("Neopatentati");
        final TableColumn<Auto, Alimentazione> alimentazioneColumn = new TableColumn<>("Alimentazione");
        final TableColumn<Auto, String> priceColumn = new TableColumn<>("Prezzo con accessori");
        final TableColumn<Auto, String> dateColumn=new TableColumn<>("Data");

        marcaCol.setCellValueFactory(new PropertyValueFactory<>("marcastr"));
        modelloCol.setCellValueFactory(new PropertyValueFactory<>("modello"));
        versioneColumn.setCellValueFactory(new PropertyValueFactory<>("versionestr"));
        pesoColumn.setCellValueFactory(new PropertyValueFactory<>("pesostr"));
        kwColumn.setCellValueFactory(new PropertyValueFactory<>("kw"));
        cilindrataColumn.setCellValueFactory(new PropertyValueFactory<>("cilindrata"));
        neoColumn.setCellValueFactory(new PropertyValueFactory<>("neo"));
        alimentazioneColumn.setCellValueFactory(new PropertyValueFactory<>("alimentazione"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("eurPrice"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        getTable().getColumns().addAll(marcaCol, modelloCol, versioneColumn, alimentazioneColumn, pesoColumn, kwColumn, cilindrataColumn, dateColumn, neoColumn, priceColumn);
        getTable().setItems(cars);

    }

    protected abstract TableView getTable();

}
