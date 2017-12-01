package carsFX.model;

import carsFX.model.enums.Alimentazione;

public class Motore {

    private int cilindrata;
    private int kw;
    private Alimentazione alimentazione;

    public Motore(final Alimentazione alimentazione, final int cilindrata, final int kw) {
        this.alimentazione = alimentazione;
        this.cilindrata = cilindrata;
        this.kw = kw;
    }

    public final int getKw() {
        return kw;
    }

    public final int getCilindrata() {
        return cilindrata;
    }

    public final Alimentazione getAlimentazione() {
        return alimentazione;
    }
}
