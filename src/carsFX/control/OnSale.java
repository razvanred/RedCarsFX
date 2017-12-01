package carsFX.control;

import carsFX.model.Auto;
import carsFX.model.AutoUsata;
import carsFX.model.Motore;
import carsFX.model.Tipo;
import carsFX.model.enums.Alimentazione;
import carsFX.model.enums.Marca;
import carsFX.model.enums.Versione;
import com.jfoenix.controls.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import org.controlsfx.control.SegmentedButton;
import org.controlsfx.control.ToggleSwitch;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class OnSale implements Initializable {

    @FXML
    private TableView table;

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


        //addRange.getChildren().add(startingAt);

        ToggleGroup toggleGroup=new ToggleGroup();
        radioNew.setToggleGroup(toggleGroup);
        radioUsed.setToggleGroup(toggleGroup);

        radioNew.setSelected(true);

        filterBrand.getStyleClass().add(SegmentedButton.STYLE_CLASS_DARK);
        for (Marca m : Marca.values())
            filterBrand.getButtons().add(new ToggleButton(m.getNome()));

        filterBrand.getButtons().addListener(new ListChangeListener<ToggleButton>() {
            @Override
            public void onChanged(Change<? extends ToggleButton> c) {
                //c.get
            }
        });
        System.out.println(filterBrand.getToggleGroup().getSelectedToggle());

        TableColumn<RowAuto, Marca> marcaCol = new TableColumn<>("Marca");
        TableColumn<RowAuto, String> modelloCol = new TableColumn<>("Modello");
        TableColumn<RowAuto, String> versioneColumn = new TableColumn<>("Versione");
        TableColumn<RowAuto, String> pesoColumn = new TableColumn<>("Peso in t");
        TableColumn<RowAuto, Integer> kwColumn = new TableColumn<>("KW");
        TableColumn<RowAuto, Integer> cilindrataColumn = new TableColumn<>("Cilindrata");
        TableColumn<RowAuto, JFXCheckBox> neoColumn = new TableColumn<>("Neopatentati");
        TableColumn<RowAuto, Alimentazione> alimentazioneColumn = new TableColumn<>("Alimentazione");
        TableColumn<RowAuto, JFXButton> buttonSellColumn = new TableColumn<>();
        TableColumn<RowAuto, String> priceColumn = new TableColumn<>("A partire da");
        TableColumn<RowAuto, String> dateColumn=new TableColumn<>("Data");

        final ObservableList<RowAuto> cars = FXCollections.observableArrayList();
        cars.add(new RowAuto(new Auto(Marca.PEUGEOT, "206", new Motore(Alimentazione.BENZINA, 2000, 70), new Tipo(Versione.UTILITARIA, 1.565f), 13000)));
        cars.add(new RowAuto(new Auto(Marca.BMW, "Serie 5", new Motore(Alimentazione.DIESEL, 3000, 110), new Tipo(Versione.BERLINA, 2f), 1500)));

        marcaCol.setCellValueFactory(new PropertyValueFactory<>("marca"));
        modelloCol.setCellValueFactory(new PropertyValueFactory<>("modello"));
        versioneColumn.setCellValueFactory(new PropertyValueFactory<>("versione"));
        pesoColumn.setCellValueFactory(new PropertyValueFactory<>("peso"));
        kwColumn.setCellValueFactory(new PropertyValueFactory<>("kw"));
        cilindrataColumn.setCellValueFactory(new PropertyValueFactory<>("cilindrata"));
        neoColumn.setCellValueFactory(new PropertyValueFactory<>("neo"));
        alimentazioneColumn.setCellValueFactory(new PropertyValueFactory<>("alimentazione"));
        buttonSellColumn.setCellValueFactory(new PropertyValueFactory<>("sellButton"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("eurPrice"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        comboVersione.getItems().add("Tutti");
        comboAlimentazione.getItems().add("Tutti");

        for (Alimentazione a : Alimentazione.values())
            comboAlimentazione.getItems().add(a.name());

        for (Versione v : Versione.values())
            comboVersione.getItems().add(v.getDescrizione());

        comboVersione.getSelectionModel().selectFirst();
        comboAlimentazione.getSelectionModel().selectFirst();

        table.getColumns().addAll(marcaCol, modelloCol, versioneColumn, alimentazioneColumn, pesoColumn, kwColumn, cilindrataColumn,dateColumn, neoColumn, priceColumn, buttonSellColumn);
        table.setItems(cars);

    }

    public class RowAuto {

        private final Marca marca;
        private final SimpleStringProperty modello;
        private final SimpleStringProperty versione;
        private final SimpleStringProperty peso;
        private final SimpleIntegerProperty cilindrata;
        private final SimpleIntegerProperty kw;
        private final SimpleStringProperty eurPrice;
        private final JFXCheckBox neo;
        private final Alimentazione alimentazione;
        private final JFXButton sellButton;
        private final SimpleStringProperty date;
        //private final BooleanProperty active=new SimpleBooleanProperty(false);

        public RowAuto(Auto a) {
            marca = a.getMarca();

            modello = new SimpleStringProperty(a.getModello());
            versione = new SimpleStringProperty(a.getTipo().getVersione().getDescrizione());
            peso = new SimpleStringProperty(a.getTipo().getFormattedTonn());


            kw = new SimpleIntegerProperty(a.getMotore().getKw());
            cilindrata = new SimpleIntegerProperty(a.getMotore().getCilindrata());
            alimentazione = a.getMotore().getAlimentazione();

            neo = new JFXCheckBox();
            neo.setSelected(a.isNeo());
            neo.setDisable(true);

            sellButton = new JFXButton("VENDI");
            sellButton.setStyle("-fx-background-color: dodgerblue; -fx-text-fill: white");

            eurPrice = new SimpleStringProperty(a.getPrice() + " EUR");

            if(a instanceof AutoUsata)
                date=new SimpleStringProperty(((AutoUsata)a).getLocalDate().toString());
            else
                date=new SimpleStringProperty(" - ");
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

        public String getDate() {
            return date.get();
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

        public String getEurPrice() {
            return eurPrice.get();
        }

        public int getCilindrata() {
            return cilindrata.get();
        }

        public JFXCheckBox isNeo() {
            return neo;
        }

        public JFXButton getSellButton() {
            return sellButton;
        }

        public String getVersione() {
            return versione.get();
        }
    }

    public void comboAction(ActionEvent ae) {

    }

    public void addCar(){
        System.out.println(table.getSelectionModel().getSelectedItem());
    }

    public void removeCar() {
        Alert alert;
        RowAuto row = (RowAuto) table.getSelectionModel().getSelectedItem();

        if (row != null) {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Conferma");
            alert.setHeaderText("Sei sicuro di voler elinare l'auto selezionata?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                System.err.println("OK");
            }
        } else {
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attenzione");
            alert.setHeaderText("Devi prima selezionare un'auto");
            alert.showAndWait();
        }

    }
}
