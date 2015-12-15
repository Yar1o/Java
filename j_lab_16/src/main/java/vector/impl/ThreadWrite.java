package vector.impl;

import java.util.Random;

/**
 *
 * @author AdminY
 */
public class ThreadWrite implements Runnable {
    private ArrayVector vector;
    public ThreadWrite(ArrayVector vector) { this.vector = vector; }

    @Override()
    public void run(){
        Random rand;
        double rangeMin;
        double rangeMax;
        double newValue;

        rand = new Random();
        rangeMin = 0.1;
        rangeMax = 200.0;

        for (int i = 0; i < vector.getSize(); i++) {
            newValue = rangeMin + rangeMax * rand.nextDouble();
            vector.setElement(i, newValue);
            System.out.println("Write: " + newValue + " to position " + i);
        }
    }
}