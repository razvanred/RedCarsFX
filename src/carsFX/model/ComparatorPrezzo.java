package carsFX.model;

import java.util.Comparator;

public class ComparatorPrezzo implements Comparator<Auto> {

    @Override
    public int compare(Auto a1, Auto a2) {
        if (a1.getPrice() == a2.getPrice())
            return 0;
        else if (a1.getPrice() < a2.getPrice())
            return -1;
        else
            return 1;
    }

}
