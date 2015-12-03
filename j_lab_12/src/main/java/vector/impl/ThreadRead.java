package vector.impl;

/**
 *
 * @author AdminY
 */
public class ThreadRead extends Thread {
    private ArrayVector vector;
    public ThreadRead(ArrayVector vector) { this.vector = vector; }

    @Override()
    public void run(){
        double value;

        for (int i = 0; i < vector.getSize(); i++) {
            value = vector.getElement(i);
            System.out.println("Read: " + value + " from position " + i);
        }
    }
}
