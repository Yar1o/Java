package client;

import vector.Vector;
import vector.Vectors;

import java.io.*;
import java.net.Socket;

/**
 * @author AdminY
 */
public class Client{
    private Socket clientSocket;

    public static void main(String[] args) {
        Client c = new Client();
        int socketNumber = 9890;
        File inputFile = new File("input.bin");
        File outputFile = new File("output.bin");
        try {
            inputFile.createNewFile();
            outputFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            c.startClient(inputFile, outputFile, socketNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void startClient(String input, String output) throws IOException {
        BufferedInputStream inputStream;
        BufferedOutputStream outputStream;
        FileReader fileReader;
        FileWriter fileWriter;
        Vector vector;

        clientSocket = new Socket("127.0.0.1", 9890);
        inputStream = new BufferedInputStream(clientSocket.getInputStream());
        outputStream = new BufferedOutputStream(clientSocket.getOutputStream());
        fileReader = new FileReader(input);
        fileWriter = new FileWriter(output);

        while (fileReader.ready()) {
            vector = Vectors.readVector(fileReader);
            Vectors.outputVector(vector, outputStream);
            vector = Vectors.readVector(fileReader);
            Vectors.outputVector(vector, outputStream);
            outputStream.flush();
            vector = Vectors.inputVector(inputStream);
            Vectors.writeVector(vector, fileWriter);
            outputStream.flush();
        }
        inputStream.close();
        outputStream.close();
        clientSocket.close();
    }


    public void startClient(File inputFile, File outputFile, int socketNumber)
            throws IOException {

        BufferedInputStream inputStream;
        BufferedOutputStream outputStream;
        Vector vector;

        clientSocket = new Socket("127.0.0.1", socketNumber); //9888
        inputStream = new BufferedInputStream(clientSocket.getInputStream());
        outputStream = new BufferedOutputStream(clientSocket.getOutputStream());

        FileReader fileReader = new FileReader(inputFile);
        FileWriter fileWriter = new FileWriter(outputFile);

        while (fileReader.ready()) {
            vector = Vectors.readVector(fileReader);
            Vectors.outputVector(vector, outputStream);
            vector = Vectors.readVector(fileReader);
            Vectors.outputVector(vector, outputStream);
            outputStream.flush();
            vector = Vectors.inputVector(inputStream);
            Vectors.writeVector(vector, fileWriter);
            outputStream.flush();
        }
        inputStream.close();
        outputStream.close();
        clientSocket.close();
    }
}
