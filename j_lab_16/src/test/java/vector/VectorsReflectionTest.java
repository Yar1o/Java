package vector;

import org.junit.Test;
import vector.impl.ArrayVector;
import vector.impl.LinkedListVector;

import static org.junit.Assert.assertEquals;
import static vector.Vectors.createInstance;

/**
 * Created by AdminY on 15.12.2015.
 */
public class VectorsReflectionTest{

    @Test
    public void testCreateArrayVector() throws Exception {

        double[] mass = new double[]{12, 14, 15, 18};
        ArrayVector testVector = new ArrayVector();
        testVector.fillFromMass(mass);

        Vector result = createInstance(5, testVector);

        Class expected = ArrayVector.class;
        Class actual = result.getClass();

        assertEquals(expected, actual);
    }

    @Test
    public void testCreateLinkedVector() throws Exception {

        double[] mass = new double[]{12, 14, 15, 18};
        LinkedListVector testVector = new LinkedListVector();
        testVector.fillFromMass(mass);

        Vector result = createInstance(5, testVector);

        Class expected = LinkedListVector.class;
        Class actual = result.getClass();

        assertEquals(expected, actual);
    }
}