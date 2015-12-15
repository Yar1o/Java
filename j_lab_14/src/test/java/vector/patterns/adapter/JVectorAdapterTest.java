package vector.patterns.adapter;

import org.junit.Before;
import org.junit.Test;
import vector.exceptions.IncompatibleVectorSizesException;
import vector.impl.ArrayVector;

import static org.junit.Assert.assertEquals;

/**
 * Created by AdminY on 02.12.2015.
 */
public class JVectorAdapterTest {

    java.util.Vector utilVector;
    JVectorAdapter jAdapter;

    double v1 = 12.37;
    double v2 = 0.0;
    double v3 = -39.74;
    double v4 = 15.00;

    double[] mass1 = { v1, v2, v3};
    double[] mass2 = { v1, v2 };

    ArrayVector instance1 = new ArrayVector(mass1);
    ArrayVector instance2 = new ArrayVector(mass2);

    @Before
    public void setUp() {
        utilVector = new java.util.Vector();
        utilVector.add(v1);
        utilVector.add(v2);
        utilVector.add(v3);

        jAdapter = new JVectorAdapter(utilVector);
    }

    @Test
    public void testGetSize() throws Exception {
        int expected = 3;
        int actual = jAdapter.getSize();
        assertEquals(expected,actual);
    }

    @Test
    public void testGetElement() throws Exception {
        double expected = v1;
        double actual = jAdapter.getElement(0);
        assertEquals(expected,actual, 0.00);
    }

    @Test
    public void testSetElement() throws Exception {
        double expected = v2;
        jAdapter.setElement(0,v2);
        double actual = jAdapter.getElement(0);
        assertEquals(expected,actual, 0.00);
    }

    @Test
    public void testMult() throws Exception {
        double expected = v2;
        jAdapter.mult(v2);
        for (int i = 0; i < jAdapter.getSize(); i++){
            assertEquals(expected,jAdapter.getElement(0), 0.00);
        }
    }

    @Test
    public void testSumEqualLength() throws Exception {
        jAdapter.sum(instance1);
        for (int i = 0; i < jAdapter.getSize(); i++){
            assertEquals(instance1.getElement(i)+instance1.getElement(i), jAdapter.getElement(i), 0.00);
        }
    }

    @Test(expected = IncompatibleVectorSizesException.class)
    public void testSumNotEqualLength() throws Exception {
        jAdapter.sum(instance2);
        for (int i = 0; i < jAdapter.getSize(); i++){
            assertEquals(instance2.getElement(i)+instance2.getElement(i), jAdapter.getElement(i), 0.00);
        }
    }


    @Test
    public void testAddElement() throws Exception {
        jAdapter.addElement(v4);
        double[] testArray = {v1,v2,v3,v4};
        for (int i = 0; i < jAdapter.getSize(); i++){
            assertEquals(testArray[i], jAdapter.getElement(i), 0.00);
        }
    }

    @Test
    public void testInsertElement() throws Exception {
        jAdapter.insertElement(v4,1);
        double[] testArray = {v1,v4,v2,v3};
        for (int i = 0; i < jAdapter.getSize(); i++){
            System.out.println(testArray[i] + "  -equals-  " + jAdapter.getElement(i));
        }
        for (int i = 0; i < jAdapter.getSize(); i++){
            assertEquals(testArray[i], jAdapter.getElement(i), 0.00);
        }
    }

    @Test
    public void testDeleteElement() throws Exception {
        for (int i = 0; i < jAdapter.getSize(); i++){
            System.out.println(i + " before:  " + jAdapter.getElement(i));
        }
        jAdapter.deleteElement(0);
        double[] testArray = {v2,v3};
        for (int i = 0; i < jAdapter.getSize(); i++){
            System.out.println(i + " after:   " + testArray[i] + "  -equals-  " + jAdapter.getElement(i));
        }
        for (int i = 0; i < jAdapter.getSize(); i++){
            assertEquals(testArray[i], jAdapter.getElement(i), 0.00);
        }
    }

    @Test
    public void testFillFromVector() throws Exception {
        double[] mass3 = { v1,v2,v3};
        double[] testMass = { v1,v2,v3,v1,v2,v3};
        ArrayVector m3 = new ArrayVector(mass3);
        jAdapter.fillFromVector(m3);
        System.out.println("Length is: " + jAdapter.getSize());
        for (int i = 0; i < jAdapter.getSize(); i++){
            System.out.println(i +"--" + testMass[i] + "  -equals-  " + jAdapter.getElement(i));
        }
    }

    @Test
    public void testFillFromMass() throws Exception {
        double[] mass3 = { v1,v2,v3,v1,v2,v3 };
        jAdapter.fillFromMass(mass1);
        for (int i = 0; i < jAdapter.getSize(); i++){
            System.out.println(i +"--" + mass3[i] + "  -equals-  " + jAdapter.getElement(i));
        }
    }

    @Test
    public void testClone() throws Exception {
        System.out.println("clone");
        double[] original = {5.0, -2.9, 0.0, -50000, 9};
        java.util.Vector oArray = new java.util.Vector();
        for (int i = 0; i < original.length; i++) {
            oArray.add(original[i]);
        }
        JVectorAdapter instance = new JVectorAdapter(oArray);
        JVectorAdapter result = (JVectorAdapter) instance.clone();
        for (int i = 0; i < result.getSize(); i++) {
            System.out.println(i + ": " + instance.getElement(i)
                    + "  -equals-  "
                    + result.getElement(i));
        }
        //assertEquals(instance,result);
    }
}