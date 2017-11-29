package carsFX.model;

public enum Marca {

    VOLKSWAGEN("Volkswagen"),
    CITROEN("Citroën"),
    PEUGEOT("Peugeot"),
    DACIA("Dacia"),
    RENAULT("Renault"),
    BMW("BMW"),
    MERCEDES_BENZ("Mercedes-Benz"),
    TESLA("Tesla");

    private String nome;

    Marca(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
