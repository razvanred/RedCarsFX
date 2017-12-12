package carsFX.control;

import carsFX.model.Auto;
import carsFX.model.enums.Alimentazione;
import carsFX.model.enums.Marca;
import com.jfoenix.controls.JFXCheckBox;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;

public class TableProperties implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        final TableColumn<Auto, Marca> marcaCol = new TableColumn<>("Marca");
        final TableColumn<Auto, String> modelloCol = new TableColumn<>("Modello");
        final TableColumn<Auto, String> versioneColumn = new TableColumn<>("Versione");
        final TableColumn<Auto, String> pesoColumn = new TableColumn<>("Peso in t");
        final TableColumn<Auto, Integer> kwColumn = new TableColumn<>("KW");
        final TableColumn<Auto, Integer> cilindrataColumn = new TableColumn<>("Cilindrata");
        final TableColumn<Auto, JFXCheckBox> neoColumn = new TableColumn<>("Neopatentati");
        final TableColumn<Auto, Alimentazione> alimentazioneColumn = new TableColumn<>("Alimentazione");
        final TableColumn<Auto, String> priceColumn = new TableColumn<>("A partire da");
        final TableColumn<Auto, String> dateColumn=new TableColumn<>("Data");

    }

}
