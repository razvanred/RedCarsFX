package carsFX.model.comparators;

import carsFX.model.Auto;

import java.util.Comparator;

public class ComparatorMarca implements Comparator<Auto> {

    @Override
    public int compare(Auto a1, Auto a2) {
        return a1.getMarca().compareTo(a2.getMarca());
    }
}
