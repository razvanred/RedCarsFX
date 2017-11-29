package carsFX.model;

public class Motore {

    private int cilindrata;
    private int kw;
    private Alimentazione alimentazione;

    public Motore(final Alimentazione alimentazione, final int cilindrata, final int kw) {
        this.alimentazione = alimentazione;
        this.cilindrata = cilindrata;
        this.kw = kw;
    }

    public int getKw() {
        return kw;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public Alimentazione getAlimentazione() {
        return alimentazione;
    }
}
