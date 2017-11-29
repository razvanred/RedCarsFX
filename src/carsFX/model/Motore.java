package carsFX.model;

public class Motore {

    private int cilindrata;
    private int cv;
    private Alimentazione alimentazione;

    public Motore(Alimentazione alimentazione, int cilindrata, int cv) {
        this.alimentazione = alimentazione;
        this.cilindrata = cilindrata;
        this.cv = cv;
    }

    public int getCv() {
        return cv;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public Alimentazione getAlimentazione() {
        return alimentazione;
    }
}
