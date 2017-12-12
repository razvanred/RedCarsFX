package carsFX.control;

import carsFX.model.Auto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class OnSale extends TableProperties {

    @FXML
    private TableView table;

    @FXML
    private BorderPane parent;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

        /*TableColumn<RowAuto, Marca> marcaCol = new TableColumn<>("Marca");
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
        cars.add(new RowAuto(new AutoUsata(Marca.MERCEDES_BENZ, "Classe A", new Motore(Alimentazione.DIESEL, 2000, 90), new Tipo(Versione.SUPERCAR, 1.3f), 20000, LocalDate.now())));
    */
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/filter.fxml"));
        try {
            parent.setTop(loader.load());
        } catch (IOException io) {
            io.printStackTrace();
        }

        ((Filter) loader.getController()).attachTable(this);

        super.initialize(location, resources);
    }

    @Override
    protected TableView getTable() {
        return table;
    }

    /*public class RowAuto {

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
    }*/

    /*public void addCar(ActionEvent actionEvent){
        System.out.println(table.getSelectionModel().getSelectedItem());

        try {

            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/addcar.fxml")), 890, 580));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Aggiungi auto");
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.showAndWait();

        }catch(IOException io){
            System.err.println("Colpa dello sviluppatore");
        }
    }*/

    public void removeCar() {
        Alert alert;
        Auto row = (Auto) table.getSelectionModel().getSelectedItem();

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

    public void sellCar(final ActionEvent ae) {

    }
}
