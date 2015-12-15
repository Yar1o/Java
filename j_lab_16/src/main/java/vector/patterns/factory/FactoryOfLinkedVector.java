package vector.patterns.factory;

import vector.impl.LinkedListVector;

/**
 * Created by AdminY on 02.12.2015.
 */


public class FactoryOfLinkedVector implements VectorFactory{

    @Override
    public LinkedListVector createVector() {
        return new LinkedListVector();
    }

    @Override
    public LinkedListVector createVector(int size) {

        LinkedListVector tempVector = new LinkedListVector();
        for (int i = 0; i < size; i++)
            tempVector.addElement(0);
        return tempVector;
    }
}
