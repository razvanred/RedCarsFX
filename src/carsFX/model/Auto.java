package carsFX.model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public class Auto extends RecursiveTreeObject<Auto> {

    private final String modello;
    private final Marca marca;
    private final Motore motore;
    private final Tipo tipo;

    public Auto(final Marca marca, final String modello, final Motore motore, final Tipo tipo) {
        this.modello = modello;
        this.motore = motore;
        this.tipo = tipo;
        this.marca = marca;
    }

    public Marca getMarca() {
        return marca;
    }

    public Motore getMotore() {
        return motore;
    }

    public String getModello() {
        return modello;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public boolean isNeo() {
        return motore.getKw() / tipo.getTonn() <= 55;
    }
}
