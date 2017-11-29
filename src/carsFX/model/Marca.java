package carsFX.model;

public enum Marca {

    VOLKSWAGEN("Volkswagen", "volkswagen.png"),
    CITROEN("Citroën", "citroen.png"),
    PEUGEOT("Peugeot", "peugeot.png"),
    DACIA("Dacia", "dacia.png"),
    RENAULT("Renault", "renault.png"),
    BMW("BMW", "bmw.png"),
    MERCEDES_BENZ("Mercedes-Benz", "mercedes-benz.png"),
    TESLA("Tesla", "tesla.png");

    private static final String PATH = "/logo/";
    private String nome, path;

    Marca(String nome, String path) {
        this.nome = nome;
        this.path = PATH + path;
    }

    public String getNome() {
        return nome;
    }

    public String getPath() {
        return path;
    }

}
