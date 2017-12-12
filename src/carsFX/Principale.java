package carsFX;

import carsFX.model.Auto;
import carsFX.model.enums.Filiale;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Principale extends Application {

    public final static String TITLE = " - RosuCars";
    public static Filiale choosen;
    public static final ArrayList<Auto> auto=new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/login.fxml"));
        primaryStage.setTitle("Accedi" + TITLE);
        primaryStage.setScene(new Scene(root, 290, 435));
        primaryStage.setResizable(false);
        primaryStage.show();


        //System.out.println(Accessorio.AUTORADIO.name());
        //Auto usata=new AutoUsata(Marca.PEUGEOT,"206", new Motore(Alimentazione.BENZINA,1500,40),new Tipo(Versione.UTILITARIA,3f), LocalDate.now());
        //Auto nuova=new Auto(Marca.PEUGEOT,"206", new Motore(Alimentazione.BENZINA,1500,40),new Tipo(Versione.UTILITARIA,3f));
        //System.out.println(nuova instanceof AutoUsata);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
