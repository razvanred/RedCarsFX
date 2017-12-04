package carsFX.model.enums;

public enum Versione {

    BREAK("Famigliare"),
    UTILITARIA("Utilitaria"),
    BERLINA("Berlina"),
    SUV("Crossover"),
    SUPERCAR("Supercar");

    private String descrizione;

    Versione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }

}
