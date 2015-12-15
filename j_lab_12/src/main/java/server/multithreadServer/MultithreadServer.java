package server.multithreadServer;

import vector.exceptions.IncompatibleVectorSizesException;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @author AdminY
 */

public class MultithreadServer{
    private ServerSocket serverSocket;
    private Socket clientSocket;

    public static void main(String[] args) {
        MultithreadServer s = new MultithreadServer();
        try {
            System.out.println("MultithreadServer is Ready to run.");
            s.startServer();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (IncompatibleVectorSizesException e) {
            System.err.println("Vector sizes are incompatible");
        }
    }

    public void startServer() throws IOException, IncompatibleVectorSizesException {
        BufferedInputStream inputStream;
        BufferedOutputStream outputStream;

        serverSocket = new ServerSocket(9890);
        clientSocket = serverSocket.accept();
        inputStream = new BufferedInputStream(clientSocket.getInputStream());
        outputStream = new BufferedOutputStream(clientSocket.getOutputStream());

        while (true) {
            try {
                ServerThread st = new ServerThread(inputStream, outputStream);
                st.run();
            } catch (Exception e) {
                break;
            } finally {
                clientSocket.close();
                serverSocket.close();
                outputStream.close();
                inputStream.close();
            }
        }
    }
}
