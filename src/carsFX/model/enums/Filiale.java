package carsFX.model.enums;

public enum Filiale{

    TREVISO("Treviso", "3viso"),
    ODERZO("Oderzo", "orz"),
    VITTORIO_VNT("Vittorio Veneto", "vittVeneto"),
    MOGLIANO_VNT("Mogliano Veneto", "moglVeneto");

    private final String nome, password;

    Filiale(final String nome, final String password) {
        this.nome = nome;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public String getPassword() {
        return password;
    }
}
