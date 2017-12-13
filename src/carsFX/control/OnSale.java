package carsFX.control;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.ResourceBundle;

public class OnSale extends TableProperties {

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        super.initialize(location, resources);
    }


    public void sellCar(final ActionEvent ae) {
        final Alert alert;
        //Auto a=table.getSelectionModel().getSelectedItem();
    }

    @Override
    public final GestoreFile.List getList() {
        return GestoreFile.List.onSale;
    }
}
