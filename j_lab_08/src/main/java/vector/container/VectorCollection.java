/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector.container;

import vector.Vector;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author AdminY
 */
public class VectorCollection implements Collection{
    protected Vector[] vInstance;

    public VectorCollection(Vector[] vInstance) {
        this.vInstance = vInstance.clone();
    }

    public VectorCollection() {
        this.vInstance = null;
    }

    protected int findVector(Object o){
        int index = -1;
        int size;
        try {
            size = vInstance.length;
        } catch (NullPointerException e) {
            size = 0;
        }

        if (o == null){
            for (int i = 0; i < size; i++){
                if (vInstance[i] == null) {
                    return i;
                }
            }
        } else if (o instanceof Vector) {
            for (int i = 0; i < size; i++){
                if (o.equals(vInstance[i])) {
                    return i;
                }
            }
        } else {
            throw new ClassCastException();
        }
        return index;
    }


    @Override
    public int size() {
        return vInstance.length;
    }

    @Override
    public boolean isEmpty() {
        return vInstance.length == 0;
    }

    @Override
    public Iterator<Vector> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        Vector[] newArray =  new Vector[vInstance.length];
        System.arraycopy(vInstance, 0, newArray, 0,  vInstance.length);
        return newArray;
    }

    @Override
    public Object[] toArray(Object[] o) {
        if (o.length >= size()) {
            System.arraycopy(vInstance, 0, o, 0, vInstance.length);
            int diff = o.length - size();
            for (int i = 0; i < diff; i++) {
                o[vInstance.length + i] = null;
            }
        } else {
            o = new Vector[vInstance.length];
            System.arraycopy(vInstance, 0, o, 0, vInstance.length);
        }
        return o;
    }

    @Override
    public boolean contains(Object o) {
        return this.findVector(o) != -1;
    }

    @Override
    public boolean containsAll(Collection c) {
        Vector[] newVectorArray = (Vector[]) c.toArray();
        for (int i = 0; i < newVectorArray.length; i++) {
            if (!this.contains(newVectorArray[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean add(Object o) {
        int size;
        try {
            size = vInstance.length+1;
        } catch (NullPointerException e) {
            this.clear();
            vInstance[0] = (Vector) o;
            return true;
        }

        Vector[] tmpArray = new Vector[size];
        System.arraycopy(vInstance, 0, tmpArray, 0, vInstance.length);
        if (o == null){
            tmpArray[size-1] = null;
        } else if (o instanceof Vector){
            tmpArray[size-1] = (Vector)o;
            vInstance = tmpArray.clone();
        } else {
            throw new ClassCastException();
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        Vector[] newVectorArray;
        if (c == null){
            newVectorArray = null;
        } else {
            newVectorArray = (Vector[])c.toArray();
        }
        for (int i = 0; i < newVectorArray.length; i++){
            if (!this.add(newVectorArray[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Vector[] tmpVector = new Vector[vInstance.length-1];
        int index = this.findVector(o);
        if (index != -1){
            System.arraycopy(vInstance,0,tmpVector,0,index);
            System.arraycopy(vInstance,index+1,tmpVector,index,vInstance.length-index-1);
            this.vInstance = tmpVector;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeAll(Collection c) {
        Vector[] newVectorArray = (Vector[]) c.toArray();
        boolean result = false;
            for (int i = 0; i < c.size(); i++) {
                if (this.remove(newVectorArray[i])) {
                    result = true;
                    i--;
                } else {
                    continue;
                }
            }
        return result;
    }

    @Override
    public boolean retainAll(Collection c) {
        Vector[] newVectorArray = (Vector[]) c.toArray();
        boolean result = false;
        for (int j = 0; j < vInstance.length; j++){
            for (int i = 0; i < newVectorArray.length; i++) {
                if (vInstance.equals(newVectorArray[i])) {
                    continue;
                } else {
                    this.remove(newVectorArray[i]);
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public void clear() {
        vInstance = new Vector[1];
    }
}



