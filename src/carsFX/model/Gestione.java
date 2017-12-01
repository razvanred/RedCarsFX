package carsFX.model;

import carsFX.model.enums.Alimentazione;
import carsFX.model.enums.Marca;
import carsFX.model.enums.Versione;

import java.util.ArrayList;

public class Gestione {

    private ArrayList<Auto> auto;

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

    public ArrayList<Auto> noFilter() {
        return auto;
    }

    public void filterMarca(Marca marca, ArrayList<Auto> temp) {

        for (int i = 0; i < temp.size(); i++)
            if (temp.get(i).getMarca() != marca)
                temp.remove(i);

    }

    public void filterVersione(Versione versione, ArrayList<Auto> temp) {

        for (int i = 0; i < temp.size(); i++)
            if (temp.get(i).getTipo().getVersione() == versione)
                temp.remove(i);

    }

    public void filterAlimentazione(Alimentazione alimentazione, ArrayList<Auto> temp) {

        for (int i = 0; i < temp.size(); i++)
            if (temp.get(i).getMotore().getAlimentazione() != alimentazione)
                temp.remove(i);

    }

    public void filterNeo(ArrayList<Auto> temp) {

        for (int i = 0; i < temp.size(); i++)
            if (!temp.get(i).isNeo())
                temp.remove(i);

    }

    public void filterPrice(int starting, ArrayList<Auto> temp) {

        for (int i = 0; i < temp.size(); i++)
            if (temp.get(i).getPrice() < starting)
                temp.remove(i);

    }

}
