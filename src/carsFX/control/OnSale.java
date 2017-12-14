package carsFX.control;

import carsFX.model.Auto;
import carsFX.model.RowAuto;
import javafx.event.ActionEvent;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.util.ResourceBundle;

public class OnSale extends TableProperties {

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        super.initialize(location, resources);
    }


    public void sellCar(final ActionEvent ae) {

        final Auto row = ((RowAuto) table.getSelectionModel().getSelectedItem()).getA();


        try {
            GestoreFile.inserimento(row, GestoreFile.List.sold);
            GestoreFile.delete(row, getList());
            Notifications.create().title("Fatto").text("L'auto è stata venduta con successo").showInformation();
        } catch (Exception exc) {
            exc.printStackTrace();
            Notifications.create().title("Attenzione").text("Si è verificato un problema durante la vendita").showWarning();
        }
    }

    @Override
    public final GestoreFile.List getList() {
        return GestoreFile.List.onSale;
    }
}
