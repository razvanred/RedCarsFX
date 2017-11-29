package carsFX.control;

import carsFX.model.*;
import com.jfoenix.controls.JFXTreeTableColumn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Main implements Initializable {

    @FXML
    private HBox imagesContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*for(Marca m:Marca.values()){

            System.out.println(m.getPath());

            ImageView img=new ImageView(new Image(getClass().getResourceAsStream(m.getPath())));
            img.setFitWidth(50);

            img.setSmooth(true);
            img.setCache(true);
            img.setPreserveRatio(true);

            imagesContainer.getChildren().add(img);
        }*/

        JFXTreeTableColumn<Auto, String> deptName = new JFXTreeTableColumn<>("Department");

        ObservableList<Auto> auto = FXCollections.observableArrayList();
        auto.add(new Auto(Marca.DACIA, "Duster", new Motore(Alimentazione.DIESEL, 1500, 70), new Tipo(Versione.SUV, 1f)));
        auto.add(new Auto(Marca.PEUGEOT, "206", new Motore(Alimentazione.DIESEL, 1400, 50), new Tipo(Versione.UTILITARIA, 0.9f)));
        auto.add(new Auto(Marca.BMW, "Serie 5", new Motore(Alimentazione.BENZINA, 3000, 140), new Tipo(Versione.BERLINA, 1.5f)));

    }

}
