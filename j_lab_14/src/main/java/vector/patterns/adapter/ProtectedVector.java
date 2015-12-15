package vector.patterns.adapter;

import vector.Vector;
import vector.exceptions.IncompatibleVectorSizesException;

/**
 * Created by AdminY on 07.12.2015.
 */
public class ProtectedVector implements Vector{

    private Vector innerVector;

    public ProtectedVector(Vector innerVector) {
        this.innerVector = innerVector;
    }

    @Override
    public double getElement(int index) {
        return innerVector.getElement(index);
    }

    @Override
    public void setElement(int index, double inputValue) {

    }

    @Override
    public int getSize() {
        return innerVector.getSize();
    }

    @Override
    public void fillFromMass(double[] inputVector) {

    }

    @Override
    public void fillFromVector(Vector inputVector) {

    }

    @Override
    public void mult(double inputValue) {

    }

    @Override
    public void sum(Vector summandVector) throws IncompatibleVectorSizesException {

    }

    @Override
    public void addElement(double element) {

    }

    @Override
    public void insertElement(double element, int index) {

    }

    @Override
    public void deleteElement(int index) {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Vector newVector = (Vector) innerVector.clone();
        ProtectedVector newProtectedVector = (ProtectedVector) ProtectedVector.super.clone();
        newProtectedVector.innerVector = newVector;
        return newProtectedVector;
    }
}
