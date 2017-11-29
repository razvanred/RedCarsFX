package carsFX.model;

public class Modello {

    private String nome;
    private Motore[] motori;

    public Modello(String nome, Motore... motori) {
        this.nome = nome;
        this.motori = motori;
    }

    public String getNome() {
        return nome;
    }

}
