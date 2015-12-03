package vector;    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author netcracker
 */
public interface Vector {
    double getElement(int index);

    void setElement(int index, double inputValue);

    int getSize();

    void fillFromMass(double[] inputVector);

    void fillFromVector(Vector inputVector);

    void multiply(double inputValue);

    void sum(Vector sVector)
            throws vector.exceptions.IncompatibleVectorSizesException;

    void addElement(double element);

    void insertElement(double element, int index);

    void deleteElement(int index);

    String toString();

    boolean equals(Object obj);

    Object clone() throws CloneNotSupportedException;
}
