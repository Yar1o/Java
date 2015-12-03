package vector.container;

import org.junit.Test;
import vector.impl.ArrayVector;

import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by AdminY on 02.12.2015.
 */
public class VectorSetTest {
    double[] mass1 = { 1, 2, 3, 4, 5 };
    double[] mass2 = { 5, 4, 3, 2, 1 };
    double[] mass3 = { 2, 3, 4, 8, -0.4 };
    double[] mass4 = { 5, 6, 7, -500, 9 };
    double[] mass5 = { 666, 666, 666, 666, 666 };

    ArrayVector instance1 = new ArrayVector(5);
    ArrayVector instance2 = new ArrayVector(5);
    ArrayVector instance3 = new ArrayVector(5);
    ArrayVector instance4 = new ArrayVector(5);
    ArrayVector instance5 = new ArrayVector(5);



    @Test
    public void testAdd() {
        instance1.fillFromMass(mass1);
        instance2.fillFromMass(mass2);
        instance3.fillFromMass(mass3);
        instance4.fillFromMass(mass4);
        instance5.fillFromMass(mass5);

        Set testSet = new VectorSet();
        testSet.add(instance1);
        System.out.println(testSet.size());
        testSet.add(instance2);
        testSet.add(instance2);
        System.out.println(testSet.size());
        testSet.add(instance3);
        System.out.println(testSet.size());
        testSet.add(instance4);
        System.out.println(testSet.size());
        testSet.add(instance5);
        testSet.add(instance4);
        testSet.add(instance4);
        testSet.add(instance4);
        testSet.add(instance3);
        System.out.println(testSet.size());
        testSet.add(null);
        for (int i =0; i < testSet.size(); i++){
            System.out.println(testSet.toArray()[i]);
        }

        Set expectedSet = new VectorSet();
        expectedSet.add(instance1);
        expectedSet.add(instance2);
        expectedSet.add(instance3);
        expectedSet.add(instance4);
        expectedSet.add(instance5);
        expectedSet.add(null);

        Object[] arrayFromTestSet = testSet.toArray();
        Object[] arrayFromExpectedSet = expectedSet.toArray();

        assertEquals(testSet.size(), expectedSet.size());
        for (int i = 0; i < arrayFromTestSet.length; i++) {
            assertEquals(arrayFromExpectedSet[i], arrayFromTestSet[i]);
        }
    }
}