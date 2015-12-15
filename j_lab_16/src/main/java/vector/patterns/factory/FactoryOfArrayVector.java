package vector.patterns.factory;

import vector.impl.ArrayVector;

/**
 * Created by AdminY on 02.12.2015.
 */


public class FactoryOfArrayVector implements VectorFactory{
    @Override
    public ArrayVector createVector() {
        return new ArrayVector(0);
    }

    @Override
    public ArrayVector createVector(int size) {
        return new ArrayVector(size);
    }
}
