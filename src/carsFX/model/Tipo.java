package carsFX.model;

import java.text.DecimalFormat;

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

    public String getFormattedTonn() {
        return new DecimalFormat("#.##").format(tonn);
    }

    public Versione getVersione() {
        return versione;
    }
}
