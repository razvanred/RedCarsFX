package carsFX.model;

public class Tipo {

    private Versione versione;
    private float tonn;

    public Tipo(Versione versione, float peso) {
        this.versione = versione;
        this.tonn = peso;
    }

    public float getTonn() {
        return tonn;
    }

    public Versione getVersione() {
        return versione;
    }
}
