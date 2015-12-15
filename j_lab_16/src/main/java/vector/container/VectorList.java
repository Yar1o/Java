/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector.container;

import vector.Vector;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;


/**
 * @author AdminY
 */
public class VectorList extends VectorCollection implements List{


    public VectorList(Vector[] vInstance) {
        super.vInstance = vInstance;
    }

    public VectorList() {
        super.vInstance = null;
    }

    @Override
    public Object get(int index) {
        if (!(index < 0 || index > size())) {
            return vInstance[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Object set(int index, Object element) {
        if (!(index < 0 || index >= size())) {
            this.vInstance[index] = (Vector) element;
            return vInstance[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, Object element) {
        if (!(index < 0 || index > size())) {
            if ((element instanceof Vector) || element == null) {
                Vector[] tmpVector = new Vector[vInstance.length + 1];
                System.arraycopy(vInstance, 0, tmpVector, 0, index);
                System.arraycopy(vInstance, index, tmpVector, index + 1, vInstance.length - index);
                tmpVector[index] = (Vector) element;
                vInstance = tmpVector;
            } else {
                throw new ClassCastException();
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean addAll(int index, Collection c) {
        if (!(index < 0 || index > size())) {
            Vector[] newVectorArray = (Vector[]) c.toArray();
            for (int i = 0; i < newVectorArray.length; i++) {
                this.add(index + i, newVectorArray[i]);
            }
            return true;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Object remove(int index) {
        if (!(index < 0 || index > size())) {
            Vector[] tmpVector = new Vector[vInstance.length - 1];
            System.arraycopy(vInstance, 0, tmpVector, 0, index);
            System.arraycopy(vInstance, index + 1, tmpVector, index, vInstance.length - index - 1);
            Vector vecValue = vInstance[index];
            vInstance = tmpVector;
            return vecValue;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int indexOf(Object o) {
        return super.findVector(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        if (o == null) {
            for (int i = 0; i < vInstance.length; i++) {
                if (vInstance[i] == null) {
                    return i;
                }
            }
        } else if (o instanceof Vector) {
            for (int i = 0; i < vInstance.length; i++) {
                if (o.equals(vInstance[i])) {
                    index = i;
                }
            }
        } else {
            throw new ClassCastException();
        }
        return index;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        if (!(fromIndex < 0 || toIndex > vInstance.length || fromIndex > toIndex)) {
            Vector[] tmpVector = new Vector[toIndex - fromIndex];
            System.arraycopy(vInstance, fromIndex, tmpVector, 0, tmpVector.length);
            VectorList newList = new VectorList(tmpVector);
            return newList;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}