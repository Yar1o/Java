package vector.container;

import vector.Vector;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by AdminY on 02.12.2015.
 */
public class VectorMap implements Map {

    protected Object keys[];
    protected Vector values[];
    protected int size;

    public VectorMap() {
        this.keys = new Object[10];
        this.values = new Vector[10];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        for (int i = 0; i < this.size(); i++) {
            if (key == null && keys[i] == null) {
                return true;
            }
            if (key != null && keys[i] == null) {
                return false;
            }
            if (key != null && keys[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        if (!(value instanceof Vector) && value != null) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (value == null && values[i] == null) {
                return true;
            }
            if (value != null && values[i] == null) {
                return false;
            }
            if (value != null && values[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        for (int i = 0; i < size; i++) {
            if (key != null && keys[i].equals(key)) {
                return values[i];
            } else if (key == null && keys[i] == null) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        if (!(value instanceof Vector) && value != null) {
            throw new IllegalArgumentException();
        }

        if (this.containsKey(key)) {
            int position = 0;
            for (int i = 0; i < size; i++) {
                if (key == null) {
                    if (values[i] == null) {
                        position = i;
                    }
                } else if (key.equals(keys[i])) {
                    position = i;
                }
            }
            // return old value for given key and rewrite it with new
            Vector oldValue = values[position];
            values[position] = (Vector) value;
            return oldValue;
        } else {
            // grow arrays
            if (size == keys.length) {
                Object auxKeys[] = new Object[keys.length + 10];
                Vector auxVal[] = new Vector[values.length + 10];
                // copying
                System.arraycopy(keys, 0, auxKeys, 0, size);
                System.arraycopy(values, 0, auxVal, 0, size);
                keys = auxKeys;
                values = auxVal;
            }

            values[size] = (Vector) value;
            keys[size] = key;
            size++;
        }
        return null;
    }

    @Override
    public Object remove(Object key) {
        if (this.containsKey(key)) {
            int position = 0;
            for (int i = 0; i < size; i++) {
                if (key == null) {
                    if (values[i] == null) {
                        position = i;
                    }
                } else if (key.equals(keys[i])) {
                    position = i;
                }
            }
            // return old value for given key and delete
            Vector oldValue = values[position];
            Object auxKeys[] = new Object[keys.length];
            Vector auxVal[] = new Vector[values.length];

            // copying
            System.arraycopy(keys, 0, auxKeys, 0, position);
            System.arraycopy(values, 0, auxVal, 0, position);
            System.arraycopy(keys, position + 1, auxKeys, position, size - position - 1);
            System.arraycopy(values, position + 1, auxVal, position, size - position - 1);

            keys = auxKeys;
            values = auxVal;
            size--;

            return oldValue;
        }
        return null;
    }

    @Override
    public void putAll(Map m) {
        Object[] mArr = m.keySet().toArray();
        for (int i = 0; i < mArr.length; i++) {
            put(mArr[i], get(mArr[i]));
        }
    }

    @Override
    public void clear() {
        this.keys = new Object[10];
        this.values = new Vector[10];
        this.size = 0;
    }

    @Override
    public Set keySet() {
        Set keySet = new HashSet();
        for (int i = 0; i < size; i++) {
            keySet.add(keys[i]);
        }
        return keySet;
    }

    @Override
    public Collection values() {
        Collection c = new VectorCollection();
        for (int i = 0; i < size; i++) {
            c.add(values[i]);
        }
        return c;
    }

    @Override
    public Set entrySet() {
        Set set = new HashSet();
        for (int i = 0; i < size(); i++) {
            Map.Entry entry = new EntrySet(keys[i], (Vector) get(keys[i]));
            set.add(entry);
        }
        return set;
    }

    class EntrySet implements Map.Entry {
        private Object key;
        private Vector value;

        EntrySet(Object key, Vector value) {
            this.key = key;
            this.value = (Vector) value;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public Object setValue(Object value) {
            Vector oldValue = this.value;
            this.value = (Vector) value;
            return oldValue;
        }
    }
}
