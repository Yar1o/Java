package server;

import vector.Vector;

/**
 * Created by AdminY on 08.12.2015.
 */
public class ThreadRead implements Runnable{
    Vector vector;

    public ThreadRead(Vector innerVector) {
        this.vector = innerVector;
    }

    @Override
    public void run() {
        double value;

        for (int i = 0; i < vector.getSize(); i++) {
            value = vector.getElement(i);
            System.out.println("Read: " + value + " from position " + i);
        }
    }
}
