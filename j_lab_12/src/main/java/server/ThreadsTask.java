package server;

import vector.impl.ArrayVector;

/**
 * Created by AdminY on 08.12.2015.
 */
public class ThreadsTask{
    public static void main(String[] args) throws InterruptedException {
        ArrayVector vector1;
        vector1 = new ArrayVector(150);
        runThreads(vector1);
    }

    public static void runThreads(ArrayVector vector) throws InterruptedException {
        Runnable r1 = new ThreadWrite(vector);
        Thread t1 = new Thread(r1);
        t1.setPriority(Thread.MIN_PRIORITY);

        t1.start();

        Runnable r2 = new ThreadRead(vector);
        Thread t2 = new Thread(r2);
        t2.setPriority(Thread.MAX_PRIORITY);

        t2.start();
    }
}
