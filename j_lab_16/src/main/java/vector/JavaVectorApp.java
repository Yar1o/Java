package vector;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import vector.impl.ArrayVector;
import vector.impl.ThreadRead;
import vector.impl.ThreadWrite;


/**
 * @author AdminY
 */
public class JavaVectorApp{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        ArrayVector vector1;

        vector1 = new ArrayVector(100);

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
