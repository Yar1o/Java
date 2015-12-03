package vector.patterns.adapter;


import vector.Vector;
import vector.exceptions.IncompatibleVectorSizesException;
import vector.exceptions.VectorIndexOutOfBoundsException;


/**
 * Created by AdminY on 02.12.2015.
 */

public class JVectorAdapter implements Vector{

    private java.util.Vector dataVector;

    public JVectorAdapter(java.util.Vector utilVector){
            dataVector = utilVector;
    }

    @Override
    public int getSize() {
        return dataVector.size();
    }

    @Override
    public double getElement(int index) {
        try {
            return (Double)dataVector.get(index);
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new VectorIndexOutOfBoundsException("Array index is out of array bounds");
        }
    }

    @Override
    public void setElement(int index, double inputValue) {
        try {
            dataVector.set(index,inputValue);
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new VectorIndexOutOfBoundsException("Array index is out of array bounds");
        }
    }

    @Override
    public void mult(double inputValue) {
        for (int i = 0; i < dataVector.size(); i++){
            dataVector.set(i, (Double)dataVector.get(i)*inputValue);
        }
    }

    @Override
    public void sum(Vector inputValue) throws IncompatibleVectorSizesException {
        if (dataVector.size() == inputValue.getSize()){
            for (int i = 0; i < dataVector.size(); i++){
                dataVector.set(i, (Double)dataVector.get(i) + inputValue.getElement(i));
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
            dataVector.add(index,element);
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new VectorIndexOutOfBoundsException("Array index is out of array bounds");
        }
    }

    @Override
    public void deleteElement(int index) {
        try {
            dataVector.remove(index);
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new VectorIndexOutOfBoundsException("Array index is out of array bounds");
        }
    }

    @Override
    public void fillFromMass(double[] inputVector) {
        for (int i = 0; i < inputVector.length; i++){
            dataVector.add(inputVector[i]);
        }
    }

    @Override
    public void fillFromVector(Vector inputVector) {
        for (int i = 0; i < inputVector.getSize(); i++){
            dataVector.add(inputVector.getElement(i));
        }
    }

    //////////////////// проблемы с клоном, не приводит к родительскому типу
    @Override
    public Object clone () {
        return dataVector.clone();
    }
}
