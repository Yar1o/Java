package vector.patterns;

import vector.Vector;
import vector.Vectors;

/**
 * Created by AdminY on 02.12.2015.
 */
public class TestFactory {
    private static final int size = 10;
    public static void main(String[] args) {
        Vectors.setVectorFactory(new FactoryOfLinkedVector());
        Vector vector = Vectors.createInstance(size);
        vector.setElement(0, 0);
        vector.setElement(1, 1);
        vector.setElement(2, 2);
        vector.setElement(3, 3);
        vector.setElement(4, 4);
        vector.setElement(5, 5);
        vector.setElement(6, 6);
        vector.setElement(7, 7);
        vector.setElement(8, 8);
        vector.setElement(9, 9);
        Vectors.setVectorFactory(new FactoryOfArrayVector());
        for(int i = 0; i < size; i++) System.out.println(vector.getElement(i));
        System.out.println();
        Vector vector1 = Vectors.createInstance(size);
        vector1.setElement(0, 9);
        vector1.setElement(1, 8);
        vector1.setElement(2, 7);
        vector1.setElement(3, 6);
        vector1.setElement(4, 5);
        vector1.setElement(5, 4);
        vector1.setElement(6, 3);
        vector1.setElement(7, 2);
        vector1.setElement(8, 1);
        vector1.setElement(9, 0);
        for(int i = 0; i < size; i++) System.out.println(vector1.getElement(i));
    }
}
