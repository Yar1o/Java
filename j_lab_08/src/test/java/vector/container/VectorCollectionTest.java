package vector.container;

import org.junit.Before;
import org.junit.Test;
import vector.Vector;
import vector.impl.ArrayVector;

import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by AdminY on 28.11.2015.
 */
public class VectorCollectionTest {
    ArrayVector testVector;
    ArrayVector testVector2;
    VectorCollection instance;
    Vector[] someVector1;


    //---------------------------------------SET
    VectorCollection setInstanceNull;
    VectorCollection setInstanceValue;
    //---------------------------------------SET
    VectorCollection instAddExp;//--------ADD
    VectorCollection instAddAllExp;//-----addAll
    VectorCollection instRemoveExp;//-----Remove
    ArrayVector searchVector;//-----IndexOf


    @Before
    public void setUp() throws Exception {
        Random rand = new Random();
        rand.nextDouble();

        double[] arr1 = new double[] {0  ,1 , 2 , 3 , 4 ,-5};
        double[] arr2 = new double[] {6  ,7 , 8 , 9 ,-0 , 1};
        double[] arr3 = new double[] {2  ,3 ,-4 , 5 , 6 , 7};
        double[] arr4 = new double[] {-10,10,10            };
        double[] arr5 = new double[] {6  ,6 ,-6            };

        ArrayVector ar1 = new ArrayVector(arr1);
        ArrayVector ar2 = new ArrayVector(arr2);
        ArrayVector ar3 = new ArrayVector(arr3);
        ArrayVector ar4 = new ArrayVector(arr4);
        ArrayVector ar5 = new ArrayVector(arr5);

        someVector1 = new Vector[]  {ar1, ar2,ar3,null,ar4};

        Vector[] someVector2 = new Vector[] {null,ar2,ar3,null,ar5};
        Vector[] someVector3 = new Vector[] {ar4, ar2,ar3,null,ar5};
        Vector[] someVector4 = new Vector[] {ar4, ar1,ar2,ar3 ,null,ar5};

        Vector[] someVector5 = new Vector[] {ar1, ar2,ar3,null,ar5, ar1, ar2,ar3,null,ar5};
        Vector[] someVector6 = new Vector[] {ar1, ar3,null,ar5};


        testVector = new ArrayVector(arr4);
        testVector2 = new ArrayVector(arr5);

        instance = new VectorCollection(someVector1);

        setInstanceNull = new VectorCollection(someVector2);
        setInstanceValue= new VectorCollection(someVector3);

        instAddExp= new VectorCollection(someVector4);

        instAddAllExp = new VectorCollection(someVector5);

        instRemoveExp = new VectorCollection(someVector6);

        searchVector = new ArrayVector(arr1);
    }

/*
    @Test
    public void testFindVector() throws Exception {
        int result = instance.findVector(testVector);
        int expValue = 4;
        assertEquals(expValue, result);
    } */

    @Test
    public void testSize() throws Exception {
        int result = instance.size();
        int expValue = 5;
        assertEquals(expValue, result);
    }

    @Test
    public void testIsEmptyFalse() throws Exception {
        boolean result = instance.isEmpty();
        boolean expValue = false;
        assertEquals(expValue, result);
    }

    @Test
    public void testToArray() throws Exception {
        Vector[] newArray = (Vector[]) instance.toArray();
        assertArrayEquals(instance.toArray(), newArray);
    }

    @Test
    public void testToArray1() throws Exception {
        Vector[] newArray = (Vector[]) instance.toArray(someVector1);
        assertArrayEquals(instance.toArray(), newArray);
    }

    @Test
    public void testContains() throws Exception {
        boolean result = instance.contains(testVector);
        boolean expValue = true;
        assertEquals(expValue, result);
    }

    @Test
    public void testContainsAll() throws Exception {
        boolean result = instance.containsAll(instance);
        boolean expValue = true;
        assertEquals(expValue, result);
    }

    @Test
    public void testAdd() throws Exception {
        boolean result = instance.add(testVector);
        boolean expValue = true;
        assertEquals(expValue, result);
    }

    @Test
    public void testAddAll() throws Exception {
        boolean result = instance.addAll(instance);
        boolean expValue = true;
        assertEquals(expValue, result);
    }

    @Test
    public void testRemove() throws Exception {
        boolean result = instance.remove(testVector);
        boolean expValue = true;
        assertEquals(expValue, result);
    }

    @Test
    public void testRemoveAll() throws Exception {
        boolean result = instance.removeAll(instance);
        boolean expValue = true;
        assertEquals(expValue, result);
    }

    @Test
    public void testRetainAll() throws Exception {
        boolean result = instance.retainAll(instance);
        boolean expValue = true;
        assertEquals(expValue, result);
    }

    @Test
    public void testClear() throws Exception {
        instance.clear();
        int expValue = instance.size();
        assertEquals(1, expValue);
    }
}