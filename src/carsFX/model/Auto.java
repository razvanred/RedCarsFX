package carsFX.model;

import java.io.Serializable;

public class Auto implements Serializable {

    private final String modello;
    private final Marca marca;
    private final Motore motore;
    private final Tipo tipo;
    private final int price;

    public Auto(final Marca marca, final String modello, final Motore motore, final Tipo tipo,final int price) {
        this.modello = modello;
        this.motore = motore;
        this.tipo = tipo;
        this.marca = marca;
        this.price=price;
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

    public final boolean isNeo() {
        return motore.getKw() <= 70 && motore.getKw() / tipo.getTonn() <= 55;
    }

    public final int getPrice(){ return price; }
}
