package vector.patterns;

import vector.impl.LinkedListVector;

/**
 * Created by AdminY on 02.12.2015.
 */


public class FactoryOfLinkedVector implements VectorFactory{

    @Override
    public LinkedListVector createVector(){
        return new LinkedListVector();
    }

    @Override
    public LinkedListVector createVector(int index){

        LinkedListVector tempVector = new LinkedListVector();
        for (int i = 0; i< index; i++)
            tempVector.addElement(0);
        return tempVector;
    }


}
