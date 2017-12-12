package carsFX.model;

import carsFX.model.enums.Accessorio;
import carsFX.model.enums.Alimentazione;
import carsFX.model.enums.Marca;
import com.jfoenix.controls.JFXCheckBox;

import java.io.Serializable;

public class Auto implements Serializable {

    private final String modello;
    private final Marca marca;
    private final Motore motore;
    private final Tipo tipo;
    private final int price;
    private final Accessorio[] accessori;

    public Auto(final Marca marca, final String modello, final Motore motore, final Tipo tipo, final int price, final Accessorio[] accessori) {
        this.modello = modello;
        this.motore = motore;
        this.tipo = tipo;
        this.marca = marca;
        this.price=price;
        this.accessori = accessori;
    }

    public final Marca getMarca() {
        return marca;
    }

    public final Motore getMotore() {
        return motore;
    }

    public final String getModello() {
        return modello;
    }

    public final Tipo getTipo() {
        return tipo;
    }

    public final String getVersionestr() {
        return tipo.getVersione().getDescrizione();
    }

    public final boolean isNeo() {
        return motore.getKw() <= 70 && motore.getKw() / tipo.getTonn() <= 55;
    }

    public final int getPrice(){ return price; }

    public final String getPesostr() {
        return tipo.getFormattedTonn();
    }

    public String getDate() {
        return "-";
    }

    public final int getEurPrice() {
        int eurPrice = 0;

        for (Accessorio a : accessori)
            eurPrice += a.getPrice();

        return eurPrice + price;
    }

    public final JFXCheckBox getNeo() {
        final JFXCheckBox check = new JFXCheckBox();
        check.setSelected(isNeo());
        return check;
    }

    public final Alimentazione getAlimentazione() {
        return motore.getAlimentazione();
    }
}
