package carsFX.control;

import carsFX.model.enums.Alimentazione;
import carsFX.model.enums.Marca;
import carsFX.model.enums.Versione;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    private JFXTextField startingFrom, modello;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private ImageView imagination;

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

        imagination.setFitHeight(200);

        startingFrom.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                startingFrom.setText(newValue.replaceAll("[^\\d]", ""));
            }
            btnAdd.setDisable(modello.getText().trim().isEmpty() || newValue.isEmpty());
        });

        modello.textProperty().addListener((observable, oldValue, newValue) -> {
            btnAdd.setDisable(startingFrom.getText().isEmpty() || newValue.trim().isEmpty());
        });

    }

    public void aggiungi(ActionEvent ae) {
        //TODO
    }

    public void annulla(ActionEvent ae) {
        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();
    }

    public void selectImage(ActionEvent ae) {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        File file = fileChooser.showOpenDialog(null);

        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imagination.setImage(image);
        } catch (IOException ex) {
            System.err.println("Errore nella lettura");
        }
    }

}
