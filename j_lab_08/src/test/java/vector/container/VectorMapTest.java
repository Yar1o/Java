package vector.container;

import org.junit.Test;
import vector.impl.ArrayVector;

import java.util.Collection;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by AdminY on 02.12.2015.
 */
public class VectorMapTest {
    double[] mass1 = { 1, 2, 3, 4, 5 };
    double[] mass2 = { 5, 4, 3, 2, 1 };
    double[] mass3 = { 2, 3, 4, 8, -0.4 };

    ArrayVector instance1 = new ArrayVector(5);
    ArrayVector instance2 = new ArrayVector(5);
    ArrayVector instance3 = new ArrayVector(5);


    String key1 = "instance1";
    String key2 = "instance2";
    String key3 = "instance3";

    @Test
    public void testSize() {
        System.out.println("testSize");
        instance1.fillFromMass(mass1);
        Map map1 = new VectorMap();
        map1.put(key1, instance1);
        map1.put(key2, instance2);
        map1.put(key2, instance3);
        assertEquals(2, map1.size());
    }

    @Test
    public void testIsEmpty() {
        System.out.println("testIsEmpty");
        Map map1 = new VectorMap();
        assertTrue(map1.isEmpty());
    }

    @Test
    public void testContainsKey() {
        System.out.println("testContainsKey");
        instance1.fillFromMass(mass1);
        instance2.fillFromMass(mass2);
        Map map1 = new VectorMap();
        map1.put(key1, instance1);
        map1.put(key2, instance2);
        assertTrue(map1.containsKey(key1));
        assertTrue(map1.containsKey(key2));
        assertFalse(map1.containsKey(key3));
    }

    @Test
    public void testContainsValue() {
        System.out.println("testContainsValue");
        instance1.fillFromMass(mass1);
        instance2.fillFromMass(mass2);
        Map map1 = new VectorMap();
        map1.put(key1, instance1);
        map1.put(key2, instance2);
        assertTrue(map1.containsValue(instance1));
        assertTrue(map1.containsValue(instance2));
        assertFalse(map1.containsValue(instance3));
    }

    @Test
    public void testGet() {
        System.out.println("testGet");
        instance1.fillFromMass(mass1);
        instance2.fillFromMass(mass2);
        Map map1 = new VectorMap();
        map1.put(key1, instance1);
        map1.put(key2, instance2);
        assertEquals(instance1, map1.get(key1));
        assertEquals(instance2, map1.get(key2));
        assertNotEquals(instance1, map1.get(key2));
    }

    @Test
    public void testPut() {
        System.out.println("testPut");
        instance1.fillFromMass(mass1);
        instance2.fillFromMass(mass2);
        instance3.fillFromMass(mass3);
        Map map1 = new VectorMap();
        map1.put(key1, instance1);
        map1.put(key2, instance2);
        map1.put(key3, instance3);
        assertEquals(instance3, map1.put(key3, instance1));

    }

    @Test
    public void testRemove() {
        System.out.println("testRemove");
        instance1.fillFromMass(mass1);
        instance2.fillFromMass(mass2);
        instance3.fillFromMass(mass3);
        Map map1 = new VectorMap();
        map1.put(key1, instance1);
        map1.put(key2, instance2);
        map1.put(key3, instance3);

        assertEquals(instance3, map1.remove(key3));
        assertEquals(2, map1.size());
        assertFalse(map1.containsValue(instance3));

    }

    @Test
    public void testPutAll() {
        System.out.println("testPutAll");
        instance1.fillFromMass(mass1);
        instance2.fillFromMass(mass2);
        instance3.fillFromMass(mass3);
        Map map1 = new VectorMap();
        map1.put(key1, instance1);
        map1.put(key2, instance2);
        map1.put(key3, instance3);
        Map map2 = new VectorMap();
        map2.put(key1, instance1);
        map2.putAll(map1);
        assertTrue(map1.containsValue(instance3));
    }

    @Test
    public void testClear() {
        System.out.println("testClear");
        instance1.fillFromMass(mass1);
        Map map1 = new VectorMap();
        map1.put(key1, instance1);
        map1.clear();
        assertEquals(0, map1.size());
        assertFalse(map1.containsValue(instance1));
    }

    @Test
    public void testKeySet() {
        System.out.println("testKeySet");
        instance1.fillFromMass(mass1);
        instance2.fillFromMass(mass2);
        instance3.fillFromMass(mass3);
        Map map1 = new VectorMap();
        map1.put(key2, instance2);
        map1.put(key3, instance3);
    }


    @Test
    public void testValues() {
        System.out.println("testValues");
        instance1.fillFromMass(mass1);
        instance2.fillFromMass(mass2);
        instance3.fillFromMass(mass3);
        Map map1 = new VectorMap();
        map1.put(key1, instance1);
        map1.put(key2, instance2);
        map1.put(key3, instance3);
        Collection c = map1.values();
        assertTrue(c.contains(instance3));
        assertTrue(c.contains(instance3));
        assertTrue(c.contains(instance3));
    }
}

