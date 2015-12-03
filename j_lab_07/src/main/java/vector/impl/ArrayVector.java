/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector.impl;

import vector.Vector;
import vector.exceptions.VectorIndexOutOfBoundsException;

import java.io.Serializable;

/**
 *
 * @author AdminY
 */
public class ArrayVector implements Vector, Cloneable, Serializable {
     
    protected double[] data;
     
    // конструкторы
    // конструктор по-умолчанию
    public ArrayVector (int length) {
        this.data = new double[length];
    }

    public ArrayVector() {this.data = null;}
    
    /*  заполнение вектора из указанного массива   */
    public ArrayVector(double[] inputVector) {
        this.data = new double[inputVector.length];
        System.arraycopy(inputVector, 0, this.data, 0, inputVector.length);
    }
        
    /*  методы  */
    /*  получение значения из вектора  */
    public double getElement(int index) {
        try {
            return(this.data[index]);
        }
        catch (ArrayIndexOutOfBoundsException e){  
            throw new vector.exceptions.VectorIndexOutOfBoundsException("Index Out");
        }
    }
    
    /*  изменение значения в векторе  */    
    public void setElement(int index, double inputValue) {
        try {
            this.data[index] = inputValue;
        }
        catch (ArrayIndexOutOfBoundsException e){  
            throw new vector.exceptions.VectorIndexOutOfBoundsException("Index Out");
        }
    }
    
    /*  получение размера вектора  */
    public int getSize() {
        return this.data.length;
    }
    
     /*  заполнение вектора из указанного массива   */
    public void fillFromMass(double[] mass) {
        if (this.getSize() != mass.length) {
            double[] newMass = new double[mass.length];
            System.arraycopy(mass, 0, newMass, 0, mass.length);
            this.data = newMass;
            } else {
            System.arraycopy(mass, 0, data, 0, data.length);
            }
    }
    
    /*  заполнение вектора из другого объекта этого класса  */
    public void fillFromVector(Vector inputVector){
	if (this.getSize() != inputVector.getSize()) {
            double[] newMass = new double[inputVector.getSize()];
            for (int i = 0; i < inputVector.getSize(); i++) {
		newMass[i] = inputVector.getElement(i);
            }
            this.data = newMass;
            } else {
                for (int i = 0; i < this.data.length; i++) {
                    this.data[i] = inputVector.getElement(i);
		}
            }
    }    

    /*  умножение вектора на значение  */
    public void multiply(double inputValue) {
        for (int i = 0; i < this.data.length; i++) {
            this.data[i] = this.data[i]*inputValue;
        }
    }
    
    /*  сложение векторов поэлементно */
    public void sum(Vector sVector) throws vector.exceptions.IncompatibleVectorSizesException {
        if (sVector.getSize() == this.getSize()) {
            for (int i = 0; i < this.data.length; i++){
                this.data[i] = this.data[i] + sVector.getElement(i);
            }
        } else throw new vector.exceptions.IncompatibleVectorSizesException();
    }   
     
    public void addElement (double inputValue){
        double[] NewMass = new double[this.data.length + 1];
        System.arraycopy(this.data, 0, NewMass, 0, this.data.length);
        NewMass[this.data.length] = inputValue;
        this.data = NewMass;
    }
    
    public void insertElement (double inputValue, int index){
        if (index < 0 || index > data.length) {
            throw new VectorIndexOutOfBoundsException("Bad Index Error");
        }
        double[] NewMass = new double[data.length + 1];
        if (index < data.length - 1) {
            System.arraycopy(data, 0, NewMass, 0, index);
            NewMass[index] = inputValue;
            System.arraycopy(data, index, NewMass, index + 1, data.length - index);
            data = NewMass;
        } else {
            this.addElement(inputValue);
        }
    }
    public void deleteElement (int index){
        if (index < 0 || index >= this.data.length) {
            throw new VectorIndexOutOfBoundsException("Bad Index Error");
        }
        double[] newMass = new double[this.data.length - 1];
        System.arraycopy(data, 0, newMass, 0, index);
        if (index < data.length - 1) {
            System.arraycopy(data, index + 1, newMass, index, newMass.length - index);
        }
        this.data = newMass;
    }
    
    public String toString () {
        StringBuilder s = new StringBuilder();
        for (double aData : this.data) {
            s.append(Double.toString(aData));
            s.append(" ");
        }
        return s.toString().trim();
    }
        
    public boolean equals (Object obj) {
        if (obj instanceof Vector ) {
            Vector tmp = (Vector) obj;
            if (tmp.getSize() == this.data.length) {
                for (int i = 0; i < this.data.length; i++){
                    if (tmp.getElement(i) != this.data[i]) {
                        return false;
                    }
                }
            return true;
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public Object clone () {            
        ArrayVector obj = null;
        try{
            obj = (ArrayVector) super.clone();
            obj.data = new double[this.getSize()];
            obj.fillFromVector(this);
        }
        catch (CloneNotSupportedException e){
            System.out.println("Cloning of this object is not supported");
        }
        return obj;
    }
}
