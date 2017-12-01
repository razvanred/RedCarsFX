package carsFX.model;

public class Gestione {

    private java.util.List<Auto> auto;

    public Gestione() {
        auto = new java.util.ArrayList<>();

    }

    public int getSize() {
        return auto.size();
    }

    public void add(Auto auto) {
        this.auto.add(auto);
    }

    public void remove(int index) {
        this.auto.remove(index);
    }

}
