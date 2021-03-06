package vector.patterns;

import vector.impl.ArrayVector;

/**
 * Created by AdminY on 02.12.2015.
 */


public class FactoryOfArrayVector implements VectorFactory {
    @Override
    public ArrayVector createVector() {
        return new ArrayVector(0);
    }

    @Override
    public ArrayVector createVector(int index) {
        return new ArrayVector(index);
    }
}
