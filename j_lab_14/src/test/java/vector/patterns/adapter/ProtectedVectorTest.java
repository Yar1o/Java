package vector.patterns.adapter;

import org.junit.Before;
import org.junit.Test;
import vector.impl.ArrayVector;

import static org.junit.Assert.assertEquals;

/**
 * Created by AdminY on 08.12.2015.
 */
public class ProtectedVectorTest{

    private ProtectedVector instance;
    private double[] startArray;

    @Before
    public void setUp() {
        startArray = new double[]{1, 2, 3, 4, 5};
        ArrayVector aVector = new ArrayVector(startArray);
        instance = new ProtectedVector(aVector);
    }

    @Test
    public void testGetElement() throws Exception {
        double actual = instance.getElement(1);
        double expected = startArray[1];
        assertEquals(expected, actual, 0.0);
        System.out.println("getElement passed");
    }

    @Test
    public void testSetElement() throws Exception {
        instance.setElement(1, 555);
        assertEquals(2, instance.getElement(1), 0.0);
        System.out.println("setElement passed");
    }

    @Test
    public void testGetSize() throws Exception {
        int actual = instance.getSize();
        int expected = startArray.length;
        assertEquals(expected, actual);
        System.out.println("getSize passed");
    }


    @Test
    public void testFillFromMass() throws Exception {
        double[] newArray = new double[]{6, 7, 8, 9, 10, 11, 12};
        instance.fillFromMass(newArray);
        for (int i = 0; i < instance.getSize(); i++) {
            assertEquals(startArray[i], instance.getElement(i), 0.0);
        }
        System.out.println("fillFromMass passed");
    }

    @Test
    public void testFillFromVector() throws Exception {
        double[] newArray = new double[]{6, 7, 8, 9, 10, 11, 12};
        ArrayVector newArVector = new ArrayVector(newArray);
        instance.fillFromVector(newArVector);
        for (int i = 0; i < instance.getSize(); i++) {
            assertEquals(startArray[i], instance.getElement(i), 0.0);
        }
        System.out.println("fillFromVector passed");
    }

    @Test
    public void testMult() throws Exception {
        double multiplicand = 666;
        instance.mult(multiplicand);
        for (int i = 0; i < instance.getSize(); i++) {
            assertEquals(startArray[i], instance.getElement(i), 0.0);
        }
        System.out.println("Mult passed");
    }

    @Test
    public void testSum() throws Exception {
        double[] newArray = new double[]{6, 7, 8, 9, 10, 11, 12};
        ArrayVector newArVector = new ArrayVector(newArray);
        instance.sum(newArVector);
        for (int i = 0; i < instance.getSize(); i++) {
            assertEquals(startArray[i], instance.getElement(i), 0.0);
        }
        System.out.println("Sum passed");
    }

    @Test
    public void testAddElement() throws Exception {
        double newElement = 666;
        instance.addElement(newElement);
        for (int i = 0; i < instance.getSize(); i++) {
            assertEquals(startArray[i], instance.getElement(i), 0.0);
        }
        System.out.println("Add passed");
    }

    @Test
    public void testInsertElement() throws Exception {
        double newElement = 666;
        instance.insertElement(newElement, 1);
        for (int i = 0; i < instance.getSize(); i++) {
            assertEquals(startArray[i], instance.getElement(i), 0.0);
        }
        System.out.println("insertElement passed");
    }

    @Test
    public void testDeleteElement() throws Exception {
        instance.deleteElement(1);
        for (int i = 0; i < instance.getSize(); i++) {
            assertEquals(startArray[i], instance.getElement(i), 0.0);
        }
        assertEquals(instance.getSize(), startArray.length);
        System.out.println("deleteElement passed");
    }

    @Test
    public void testClone() throws Exception {
        ProtectedVector actual = (ProtectedVector) instance.clone();
        System.out.println(actual.getSize() + " size is equals " + instance.getSize());
        for (int i = 0; i < instance.getSize(); i++) {
            System.out.println(i + ": " + instance.getElement(i)
                    + "  -equals-  "
                    + actual.getElement(i));
        }
        //assertEquals(instance, actual);
    }
}