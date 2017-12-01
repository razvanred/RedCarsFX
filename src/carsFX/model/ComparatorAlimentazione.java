package carsFX.model;

import java.util.Comparator;

public class ComparatorAlimentazione implements Comparator<Auto> {

    @Override
    public int compare(Auto a1, Auto a2) {
        return a1.getMotore().getAlimentazione().compareTo(a2.getMotore().getAlimentazione());
    }

}
