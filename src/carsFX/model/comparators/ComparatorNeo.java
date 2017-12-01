package carsFX.model.comparators;

import carsFX.model.Auto;

import java.util.Comparator;

public class ComparatorNeo implements Comparator<Auto> {
    @Override
    public int compare(Auto o1, Auto o2) {

        if (o1.isNeo() && o2.isNeo())
            return 0;
        else if (!o1.isNeo() && o2.isNeo())
            return -1;
        else
            return 1;
    }
}
