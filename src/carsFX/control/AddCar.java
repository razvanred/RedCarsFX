package carsFX.control;

import carsFX.model.enums.Alimentazione;
import carsFX.model.enums.Marca;
import carsFX.model.enums.Versione;
import com.jfoenix.controls.*;
import javafx.beans.value.ChangeListener;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.controlsfx.control.ToggleSwitch;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (Alimentazione a : Alimentazione.values())
            alimCombo.getItems().add(a);

        for (Versione v : Versione.values())
            versionCombo.getItems().add(v.getDescrizione());

        for (Marca m : Marca.values())
            brandCombo.getItems().add(m.getNome());

        alimCombo.getSelectionModel().selectFirst();
        versionCombo.getSelectionModel().selectFirst();
        brandCombo.getSelectionModel().selectFirst();

        ChangeListener<String> change = (observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                //todo
                //.setText(newValue.replaceAll("[^\\d]", ""));
            }
            enableAdd();
        };

        startingFrom.textProperty().addListener(change);

        kw.textProperty().addListener(change);

        cilindrata.textProperty().addListener(change);

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

    }

    private void enableAdd() {
        btnAdd.setDisable(startingFrom.getText().isEmpty() || modello.getText().trim().isEmpty() || kw.getText().isEmpty() || cilindrata.getText().isEmpty());
    }

}
