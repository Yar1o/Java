package vector.patterns;


/**
 * Created by AdminY on 02.12.2015.
 */

import vector.Vector;

public interface VectorFactory {
    Vector createVector();
    Vector createVector(int index);
}
