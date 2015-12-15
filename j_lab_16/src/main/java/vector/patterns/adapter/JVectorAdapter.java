package vector.patterns.adapter;


import vector.Vector;
import vector.exceptions.IncompatibleVectorSizesException;
import vector.exceptions.VectorIndexOutOfBoundsException;


/**
 * Created by AdminY on 02.12.2015.
 */

public class JVectorAdapter implements Vector{

    private java.util.Vector dataVector;

    public JVectorAdapter(java.util.Vector utilVector) {
        this.dataVector = utilVector;
    }

    @Override
    public int getSize() {
        return dataVector.size();
    }

    @Override
    public double getElement(int index) {
        try {
            return (Double) dataVector.get(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new VectorIndexOutOfBoundsException("Array index is out of array bounds");
        }
    }

    @Override
    public void setElement(int index, double inputValue) {
        try {
            dataVector.set(index, inputValue);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new VectorIndexOutOfBoundsException("Array index is out of array bounds");
        }
    }

    @Override
    public void mult(double inputValue) {
        for (int i = 0; i < dataVector.size(); i++) {
            dataVector.set(i, (Double) dataVector.get(i) * inputValue);
        }
    }

    @Override
    public void sum(Vector inputValue) throws IncompatibleVectorSizesException {
        if (dataVector.size() == inputValue.getSize()) {
            for (int i = 0; i < dataVector.size(); i++) {
                dataVector.set(i, (Double) dataVector.get(i) + inputValue.getElement(i));
            }
        } else {
            throw new IncompatibleVectorSizesException("Vector Lenght are incompatible");
        }
    }

    @Override
    public void addElement(double element) {
        dataVector.add(element);
    }

    @Override
    public void insertElement(double element, int index) {
        try {
            dataVector.add(index, element);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new VectorIndexOutOfBoundsException("Array index is out of array bounds");
        }
    }

    @Override
    public void deleteElement(int index) {
        try {
            dataVector.remove(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new VectorIndexOutOfBoundsException("Array index is out of array bounds");
        }
    }

    @Override
    public void fillFromMass(double[] mass) {
        if (dataVector.size() != mass.length) {
            dataVector.clear();
            for (int i = 0; i < mass.length; i++) {
                dataVector.add(i, mass[i]);
            }
        }
        for (int i = 0; i < mass.length; i++) {
            dataVector.set(i, mass[i]);
        }
    }

    @Override
    public void fillFromVector(Vector inputVector) {
        if (dataVector.size() != inputVector.getSize()) {
            dataVector.clear();
            for (int i = 0; i < inputVector.getSize(); i++) {
                dataVector.add(i, inputVector.getElement(i));
            }
        }
        for (int i = 0; i < inputVector.getSize(); i++) {
            dataVector.set(i, inputVector.getElement(i));
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        java.util.Vector newVector = (java.util.Vector) dataVector.clone();
        JVectorAdapter newAdapter = (JVectorAdapter) JVectorAdapter.super.clone();
        newAdapter.dataVector = newVector;
        return newAdapter;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < dataVector.size(); i++) {
            s.append(Double.toString((Double) dataVector.get(i)));
            s.append(" ");
        }
        return s.toString().trim();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vector) {
            Vector tmp = (Vector) obj;
            if (dataVector.size() == tmp.getSize()) {
                for (int i = 0; i < dataVector.size(); i++) {
                    if (tmp.getElement(i) != dataVector.get(i)) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
