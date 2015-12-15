package server;

import vector.Vector;

import java.util.Random;

/**
 * Created by AdminY on 08.12.2015.
 */
public class ThreadWrite implements Runnable{
    private Vector vector;

    public ThreadWrite(Vector vector) {
        this.vector = vector;
    }

    @Override()
    public void run() {
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
