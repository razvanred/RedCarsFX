package carsFX.model;

public enum Versione {

    BREAK("Famigliare"),
    UTILITARIA("Utilitaria"),
    BERLINA("Berlina"),
    SUV("Crossover");

    private String descrizione;

    Versione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }

}
