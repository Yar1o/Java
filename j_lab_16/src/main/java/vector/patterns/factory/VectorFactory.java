package vector.patterns.factory;


/**
 * Created by AdminY on 02.12.2015.
 */

import vector.Vector;

public interface VectorFactory{
    Vector createVector();

    Vector createVector(int size);
}
