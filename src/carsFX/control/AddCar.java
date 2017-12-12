package carsFX.control;

import carsFX.model.enums.Accessorio;
import carsFX.model.enums.Alimentazione;
import carsFX.model.enums.Marca;
import carsFX.model.enums.Versione;
import com.jfoenix.controls.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.controlsfx.control.ToggleSwitch;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddCar implements Initializable {

    @FXML
    private JFXComboBox brandCombo;

    @FXML
    private VBox accContainer;

    @FXML
    private JFXComboBox versionCombo;

    @FXML
    private JFXComboBox alimCombo;

    @FXML
    private JFXTextField startingFrom, modello, cilindrata, kw;

    @FXML
    private JFXButton btnAdd, btnLoadPic;

    @FXML
    private ImageView imagination;

    private boolean needUp;
    private Image unknown;

    @FXML
    private Spinner<Integer> decPeso;

    @FXML
    private Spinner<Integer> intPeso;

    @FXML
    private JFXSpinner spinnerCilindrata;

    @FXML
    private ToggleSwitch usedSwitch;

    @FXML
    private JFXDatePicker datePicker;

    @FXML
    private Label finalPrice;

    private JFXCheckBox[] accessori;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        accessori=new JFXCheckBox[Accessorio.values().length];

        for(int i=0;i<accessori.length;i++) {
            final Accessorio accessorio=Accessorio.values()[i];
            final HBox hbox=new HBox();
            hbox.setSpacing(10);
            accessori[i] = new JFXCheckBox(accessorio.getDescrizione());
            accessori[i].setOnAction(event -> calcPrice());
            hbox.getChildren().add(accessori[i]);
            final Label label=new Label("EUR "+accessorio.getPrice());
            label.setStyle("-fx-font-weight: bold");
            hbox.getChildren().add(label);
            accContainer.getChildren().add(hbox);
        }


        datePicker.setValue(LocalDate.now());

        for (Alimentazione a : Alimentazione.values())
            alimCombo.getItems().add(a);

        for (Versione v : Versione.values())
            versionCombo.getItems().add(v.getDescrizione());

        for (Marca m : Marca.values())
            brandCombo.getItems().add(m.getNome());

        alimCombo.getSelectionModel().selectFirst();
        versionCombo.getSelectionModel().selectFirst();
        brandCombo.getSelectionModel().selectFirst();

       /* final ChangeListener<String> change = (observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                //todo
                //.setText(newValue.replaceAll("[^\\d]", ""));

            }
            enableAdd();
        };*/

        startingFrom.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*"))
                startingFrom.setText(newValue.replaceAll("[^\\d]", ""));
            calcPrice();
            enableAdd();
        });

        kw.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*"))
                kw.setText(newValue.replaceAll("[^\\d]", ""));
            enableAdd();
        });

        cilindrata.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*"))
                cilindrata.setText(newValue.replaceAll("[^\\d]", ""));
            enableAdd();
        });

        modello.textProperty().addListener((observable, oldValue, newValue) -> {
            enableAdd();
        });

        unknown = new Image(getClass().getResourceAsStream("/unknown.png"));

        imagination.setImage(unknown);
        imagination.setFitHeight(200);
        imagination.setSmooth(true);
        imagination.setCache(true);
        imagination.setPreserveRatio(true);

        final SpinnerValueFactory<Integer> factoryInt = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 4, 1);
        final SpinnerValueFactory<Integer> factoryDec = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0);

        intPeso.setValueFactory(factoryInt);
        decPeso.setValueFactory(factoryDec);

        needUp = true;
        datePicker.setVisible(false);
    }

    private void calcPrice(){

        int price=0;

        try{
            price+=Integer.parseInt(startingFrom.getText());
        }catch(NumberFormatException num){
            System.err.println("Empty field");
            //num.printStackTrace();
        }

        for(int i=0;i<accessori.length;i++)
            if(accessori[i].isSelected())
                price+= Accessorio.values()[i].getPrice();

        finalPrice.setText(""+price);
    }

    public void aggiungi(ActionEvent ae) {
        //TODO
    }

    public void annulla(ActionEvent ae) {
        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();
    }

    public void selectImage(ActionEvent ae) {
        if (needUp) {
            FileChooser fileChooser = new FileChooser();

            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

            File file = fileChooser.showOpenDialog(null);

            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);

                imagination.setImage(image);

                btnLoadPic.setStyle("-fx-background-color: red");
                btnLoadPic.setTextFill(Paint.valueOf("white"));
                btnLoadPic.setText("RIMUOVI FOTO");

                needUp = false;

            } catch (IOException ex) {
                System.err.println("Errore nella lettura");
            } catch (NullPointerException nuller) {
                System.err.println("Operazione annullata!");
            }
        } else {
            btnLoadPic.setStyle("-fx-background-color: dodgerblue");
            btnLoadPic.setTextFill(Paint.valueOf("white"));
            btnLoadPic.setText("CARICA FOTO");

            imagination.setImage(unknown);

            needUp = true;
        }
    }

    public void enableDate() {
        datePicker.setVisible(usedSwitch.isSelected());
    }

    private void enableAdd() {
        btnAdd.setDisable(startingFrom.getText().isEmpty() || modello.getText().trim().isEmpty() || kw.getText().isEmpty() || cilindrata.getText().isEmpty());
    }

}
