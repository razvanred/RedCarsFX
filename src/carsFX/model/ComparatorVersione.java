package carsFX.model;

import java.util.Comparator;

public class ComparatorVersione implements Comparator<Auto> {

    @Override
    public int compare(Auto o1, Auto o2) {
        return o1.getTipo().getVersione().compareTo(o2.getTipo().getVersione());
    }
}
