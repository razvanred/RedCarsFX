package carsFX.control;

import carsFX.model.Filiale;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    @FXML
    private VBox filiali;

    @FXML
    private Label somethingWrong;

    @FXML
    private JFXPasswordField passwordField;

    private ToggleGroup toggleGroup;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        toggleGroup = new ToggleGroup();

        for (Filiale f : Filiale.values()) {
            JFXRadioButton radio = new JFXRadioButton(f.getNome());
            filiali.getChildren().add(radio);
            radio.setUserData(f.getPassword());
            radio.setToggleGroup(toggleGroup);
        }

        if (!toggleGroup.getToggles().isEmpty()) {
            toggleGroup.getToggles().get(0).setSelected(true);
            passwordField.textProperty().addListener((observable, oldValue, newValue) -> somethingWrong.setText(""));
        }
    }

    public void checkPasskey(ActionEvent ae) {

        if (toggleGroup.getSelectedToggle().getUserData().toString().compareTo(passwordField.getText()) == 0) {
            try {

                ((Stage)((Node)ae.getSource()).getScene().getWindow()).close();

                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("../view/main.fxml"));
                primaryStage.setScene(new Scene(root, 550, 450));
            } catch (IOException io) {
                io.printStackTrace();
            }
        } else
            somethingWrong.setText("Password errata");
    }

}
