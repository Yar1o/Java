package vector.container;

import vector.Vector;
import vector.impl.ArrayVector;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by AdminY on 25.11.2015.
 */
public class VectorListTest {
    ArrayVector testVector;
    VectorList instance;
    //---------------------------------------SET
    VectorList setInstanceNull;
    VectorList setInstanceValue;
    //---------------------------------------SET
    VectorList instAddExp;//--------ADD
    VectorList instAddAllExp;//-----addAll
    VectorList instRemoveExp;//-----Remove
    ArrayVector searchVector;//-----IndexOf

    @org.junit.Before
    public void SetUp(){
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

        Vector[] someVector1 = new Vector[] {ar1, ar2,ar3,null,ar5};
        Vector[] someVector2 = new Vector[] {null,ar2,ar3,null,ar5};
        Vector[] someVector3 = new Vector[] {ar4, ar2,ar3,null,ar5};
        Vector[] someVector4 = new Vector[] {ar4, ar1,ar2,ar3 ,null,ar5};

        Vector[] someVector5 = new Vector[] {ar1, ar2,ar3,null,ar5, ar1, ar2,ar3,null,ar5};
        Vector[] someVector6 = new Vector[] {ar1, ar3,null,ar5};

        testVector = new ArrayVector(arr4);
        instance = new VectorList(someVector1);

        setInstanceNull = new VectorList(someVector2);
        setInstanceValue= new VectorList(someVector3);

        instAddExp= new VectorList(someVector4);

        instAddAllExp = new VectorList(someVector5);

        instRemoveExp = new VectorList(someVector6);

        searchVector = new ArrayVector(arr1);
    }

    @org.junit.Test
    public void testSize() throws Exception {
        int expValue = 5;
        int result = instance.size();
        assertEquals(expValue, result);
    }

    @org.junit.Test
    public void testGet() throws Exception {
        Vector result = (Vector)instance.get(3);
        assertEquals(null, result);
    }


    @org.junit.Test(expected = Exception.class)
    public void testGet_exception_1() throws Exception {
        Vector result = (Vector)instance.get(10);
    }

    @org.junit.Test(expected = Exception.class)
    public void testGet_exception_2() throws Exception {
        Vector result = (Vector)instance.get(-1);
    }

    @org.junit.Test
    public void testSetNull() throws Exception {
        instance.set(0,null);
        assertArrayEquals(instance.toArray(), setInstanceNull.toArray());
    }

    @org.junit.Test
    public void testSetValue() throws Exception {
        instance.set(0,testVector);
        assertArrayEquals(instance.toArray(), setInstanceValue.toArray());
    }

    @org.junit.Test
    public void testAdd() throws Exception {
        instance.add(0,testVector);
        assertArrayEquals(instance.toArray(),instAddExp.toArray());
    }

    @org.junit.Test
    public void testAddAll() throws Exception {
        instance.addAll(0,instance);
        assertArrayEquals(instance.toArray(), instAddAllExp.toArray());
    }

    @org.junit.Test
    public void testRemove() throws Exception {
        instance.remove(1);
        assertArrayEquals(instance.toArray(), instRemoveExp.toArray());
    }

    @org.junit.Test
    public void testIndexOf() throws Exception {
        int expValue = 0;
        int result = instance.indexOf(searchVector);
        assertEquals(expValue, result);
    }

    @org.junit.Test
    public void testLastIndexOf() throws Exception {
        int expValue = 5;
        int result = instAddAllExp.lastIndexOf(searchVector);
        assertEquals(expValue, result);
    }

    @org.junit.Test
    public void testSubList() throws Exception {
        List result = instAddAllExp.subList(5,10);
        assertArrayEquals(instance.toArray(), result.toArray());
    }
}