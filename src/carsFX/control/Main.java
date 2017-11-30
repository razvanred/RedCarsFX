package carsFX.control;

import carsFX.model.*;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Main implements Initializable {

    @FXML
    private HBox imagesContainer;

    @FXML
    private TableView table;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Marca m : Marca.values()) {

            ImageView img = new ImageView(new Image(getClass().getResourceAsStream(m.getPath())));
            img.setFitWidth(50);

            img.setSmooth(true);
            img.setCache(true);
            img.setPreserveRatio(true);

            imagesContainer.getChildren().add(img);
        }

        //table.setEditable(false);

        TableColumn<RowAuto, ImageView> marcaCol = new TableColumn<>("Marca");
        TableColumn<RowAuto, String> modelloCol = new TableColumn<>("Modello");
        TableColumn<RowAuto, String> versioneColumn = new TableColumn<>("Versione");
        TableColumn<RowAuto, String> pesoColumn = new TableColumn<>("Peso in t");
        TableColumn<RowAuto, Integer> kwColumn = new TableColumn<>("KW");
        TableColumn<RowAuto, Integer> cilindrataColumn = new TableColumn<>("Cilindrata");
        TableColumn<RowAuto, Boolean> neoColumn = new TableColumn<>("Neopatentati");
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


        table.getColumns().addAll(marcaCol, modelloCol, versioneColumn, pesoColumn, kwColumn, cilindrataColumn, neoColumn, alimentazioneColumn);
        table.setItems(cars);

    }

    public class RowAuto {

        private final ImageView marca;
        private final SimpleStringProperty modello;
        private final SimpleStringProperty versione;
        private final SimpleStringProperty peso;
        private final SimpleIntegerProperty cilindrata;
        private final SimpleIntegerProperty kw;
        private final SimpleBooleanProperty neo;
        private final Alimentazione alimentazione;

        //private final BooleanProperty active=new SimpleBooleanProperty(false);

        public RowAuto(Auto a) {
            marca = new ImageView(new Image(a.getMarca().getPath()));

            marca.setFitWidth(35);
            marca.setSmooth(true);
            marca.setCache(true);
            marca.setPreserveRatio(true);

            modello = new SimpleStringProperty(a.getModello());
            versione = new SimpleStringProperty(a.getTipo().getVersione().getDescrizione());
            peso = new SimpleStringProperty(a.getTipo().getFormattedTonn());

            //System.out.println(a.getMotore().getKw());
            kw = new SimpleIntegerProperty(a.getMotore().getKw());
            //kil = new SimpleStringProperty("" + a.getMotore().getKw());
            cilindrata = new SimpleIntegerProperty(a.getMotore().getCilindrata());
            alimentazione = a.getMotore().getAlimentazione();

            neo = new SimpleBooleanProperty(a.isNeo());
        }


        public String getModello() {
            return modello.get();
        }

        public ImageView getMarca() {
            return marca;
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

        public Boolean isNeo() {
            return neo.get();
        }

        public String getVersione() {
            return versione.get();
        }
    }

}
