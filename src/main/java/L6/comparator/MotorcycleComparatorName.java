package L6.comparator;

import L6.model.Motorcycle;

import java.util.Comparator;



public class MotorcycleComparatorName implements Comparator<Motorcycle> {

    @Override
    public int compare(Motorcycle o1, Motorcycle o2) {
        return o1.getModel().compareTo(o2.getModel());
    }

}
