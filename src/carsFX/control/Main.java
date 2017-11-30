package carsFX.control;

import carsFX.model.*;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Main implements Initializable {

    @FXML
    private TableView table;

    @FXML
    private JFXCheckBox neoCheck;

    @FXML
    private JFXComboBox<String> comboVersione;

    @FXML
    private JFXComboBox<String> comboAlimentazione;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //table.setEditable(false);

        TableColumn<RowAuto, Marca> marcaCol = new TableColumn<>("Marca");
        TableColumn<RowAuto, String> modelloCol = new TableColumn<>("Modello");
        TableColumn<RowAuto, String> versioneColumn = new TableColumn<>("Versione");
        TableColumn<RowAuto, String> pesoColumn = new TableColumn<>("Peso in t");
        TableColumn<RowAuto, Integer> kwColumn = new TableColumn<>("KW");
        TableColumn<RowAuto, Integer> cilindrataColumn = new TableColumn<>("Cilindrata");
        TableColumn<RowAuto, JFXCheckBox> neoColumn = new TableColumn<>("Neopatentati");
        TableColumn<RowAuto, Alimentazione> alimentazioneColumn = new TableColumn<>("Alimentazione");


        final ObservableList<RowAuto> cars = FXCollections.observableArrayList();
        cars.add(new RowAuto(new Auto(Marca.PEUGEOT, "206", new Motore(Alimentazione.BENZINA, 2000, 70), new Tipo(Versione.UTILITARIA, 1.565f))));
        cars.add(new RowAuto(new Auto(Marca.BMW, "Serie 5", new Motore(Alimentazione.DIESEL, 3000, 110), new Tipo(Versione.BERLINA, 2f))));

        marcaCol.setCellValueFactory(new PropertyValueFactory<>("marca"));
        modelloCol.setCellValueFactory(new PropertyValueFactory<>("modello"));
        versioneColumn.setCellValueFactory(new PropertyValueFactory<>("versione"));
        pesoColumn.setCellValueFactory(new PropertyValueFactory<>("peso"));
        //kwColumn.setCellValueFactory(new PropertyValueFactory<>("kil"));
        kwColumn.setCellValueFactory(new PropertyValueFactory<>("kw"));
        cilindrataColumn.setCellValueFactory(new PropertyValueFactory<>("cilindrata"));
        neoColumn.setCellValueFactory(new PropertyValueFactory<>("neo"));
        alimentazioneColumn.setCellValueFactory(new PropertyValueFactory<>("alimentazione"));

        comboVersione.getItems().add("Tutti");
        comboAlimentazione.getItems().add("Tutti");

        for (Alimentazione a : Alimentazione.values())
            comboAlimentazione.getItems().add(a.name());

        for (Versione v : Versione.values())
            comboVersione.getItems().add(v.getDescrizione());

        comboVersione.getSelectionModel().selectFirst();
        comboAlimentazione.getSelectionModel().selectFirst();

        //comboVersione.setValue(0);

        table.getColumns().addAll(marcaCol, modelloCol, versioneColumn, pesoColumn, kwColumn, cilindrataColumn, alimentazioneColumn, neoColumn);
        table.setItems(cars);

    }

    /*private <Marca> void addTooltipToColumnCells(TableColumn<RowAuto, Marca> column) {

        Callback<TableColumn<RowAuto, Marca>, TableCell<RowAuto, Marca>> existingCellFactory
                = column.getCellFactory();

        column.setCellFactory(c -> {
            TableCell<RowAuto, Marca> cell = existingCellFactory.call(c);

            Tooltip tooltip = new Tooltip();
            // can use arbitrary binding here to make text depend on cell
            // in any way you need:
            tooltip.textProperty().bind(cell.itemProperty().asString());

            cell.setTooltip(tooltip);
            return cell;
        });
    }*/

    public class RowAuto {

        private final Marca marca;
        private final SimpleStringProperty modello;
        private final SimpleStringProperty versione;
        private final SimpleStringProperty peso;
        private final SimpleIntegerProperty cilindrata;
        private final SimpleIntegerProperty kw;
        private final JFXCheckBox neo;
        private final Alimentazione alimentazione;

        //private final BooleanProperty active=new SimpleBooleanProperty(false);

        public RowAuto(Auto a) {
            marca = a.getMarca();

            //Tooltip.install(marca,new Tooltip(a.getMarca().getNome()));

            modello = new SimpleStringProperty(a.getModello());
            versione = new SimpleStringProperty(a.getTipo().getVersione().getDescrizione());
            peso = new SimpleStringProperty(a.getTipo().getFormattedTonn());

            //System.out.println(a.getMotore().getKw());
            kw = new SimpleIntegerProperty(a.getMotore().getKw());
            //kil = new SimpleStringProperty("" + a.getMotore().getKw());
            cilindrata = new SimpleIntegerProperty(a.getMotore().getCilindrata());
            alimentazione = a.getMotore().getAlimentazione();

            neo = new JFXCheckBox();
            neo.setSelected(a.isNeo());
            neo.setDisable(true);
        }


        public String getModello() {
            return modello.get();
        }

        public ImageView getMarca() {

            ImageView logo = marca.getLogo();
            logo.setFitWidth(35);
            logo.setSmooth(true);
            logo.setCache(true);
            logo.setPreserveRatio(true);

            return logo;
        }

        public int getKw() {
            return kw.get();
        }

        public Alimentazione getAlimentazione() {
            return alimentazione;
        }

        public String getPeso() {
            return peso.get();
        }

        public int getCilindrata() {
            return cilindrata.get();
        }

        public JFXCheckBox isNeo() {
            return neo;
        }

        public String getVersione() {
            return versione.get();
        }
    }

}
