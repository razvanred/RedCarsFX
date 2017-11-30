package carsFX.model;

public class Auto {

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
        return motore.getKw() <= 70 && motore.getKw() / tipo.getTonn() <= 55;
    }
}
