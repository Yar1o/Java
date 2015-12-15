package server.multithreadServer;

import vector.Vector;
import vector.Vectors;
import vector.exceptions.IncompatibleVectorSizesException;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

/**
 * Created by AdminY on 08.12.2015.
 */
public class ServerThread implements Runnable{

    BufferedInputStream inputStream;
    BufferedOutputStream outputStream;

    public ServerThread(BufferedInputStream iStream, BufferedOutputStream oStream) {
        this.inputStream = iStream;
        this.outputStream = oStream;

    }

    @Override
    public void run() {
        Vector inputV1;
        Vector inputV2;
        try {
            inputV1 = Vectors.inputVector(inputStream);
            inputV2 = Vectors.inputVector(inputStream);
            inputStream.close();

            inputV1.sum(inputV2);

            Vectors.outputVector(inputV1, outputStream);

            outputStream.flush();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IncompatibleVectorSizesException e) {
            e.printStackTrace();
        }
    }
}
