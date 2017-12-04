package carsFX.control;

import carsFX.Principale;
import carsFX.model.enums.Filiale;
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
            radio.setUserData(f.name());
            radio.setToggleGroup(toggleGroup);
        }

        if (!toggleGroup.getToggles().isEmpty()) {
            toggleGroup.getToggles().get(0).setSelected(true);
            passwordField.textProperty().addListener((observable, oldValue, newValue) -> somethingWrong.setText(""));
        }
    }

    public void checkPasskey(ActionEvent ae) {

        Filiale f = Filiale.valueOf(toggleGroup.getSelectedToggle().getUserData().toString());

        if (passwordField.getText().isEmpty())
            somethingWrong.setText("Campo obbligatorio");
        else if (f.getPassword().compareTo(passwordField.getText()) == 0) {
            try {
                ((Stage) ((Node) (ae.getSource())).getScene().getWindow()).close();

                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("../view/main.fxml"));

                Scene scene = new Scene(root, 990, 680);

                primaryStage.setScene(scene);
                primaryStage.setTitle(f.getNome() + Principale.TITLE);
                primaryStage.show();

                Principale.choosen = f;

            } catch (IOException io) {
                io.printStackTrace();
            }
        } else
            somethingWrong.setText("Password errata");
    }

}
