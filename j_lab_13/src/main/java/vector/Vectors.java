package vector;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import vector.patterns.FactoryOfArrayVector;
import vector.patterns.VectorFactory;
import vector.impl.ArrayVector;
import vector.impl.LinkedListVector;

import java.io.*;


/**
 *
 * @author netcracker
 */
public class Vectors {
    private static VectorFactory vectorFactory = new FactoryOfArrayVector();

    public static void setVectorFactory(VectorFactory vectorFactory){
        Vectors.vectorFactory = vectorFactory;
    }

    public static Vector createInstance(){
        return vectorFactory.createVector();
    }

    public static Vector createInstance(int size){
        return vectorFactory.createVector(size);
    }

    public static void sort(Vector inputVector){
        double temp = 0.0;
        for (int i = 0; i < inputVector.getSize(); i++){
            for (int j = 1; j <= inputVector.getSize(); i++){
                if (inputVector.getElement(i) > inputVector.getElement(j)){
                    temp = inputVector.getElement(i);
                    inputVector.setElement(i,inputVector.getElement(j));
                    inputVector.setElement(j,temp);
                }
            }
        }
    }
 
    /**
    *
    *   Метод записи вектора в байтовый поток
    */     
    public static void outputVector (Vector v, OutputStream out) throws IOException {
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeInt(v.getSize());
        for (int i = 0; i < v.getSize(); i++) {
            dos.writeDouble(v.getElement(i));
        }
        dos.flush();
    }

    /**
    *  Метод чтения вектора из байтового потока
    */
    public static Vector inputVector (InputStream in) throws IOException {
        DataInputStream dis = new DataInputStream (in);       
        int size = dis.readInt();     
        double [] bufr = new double [size];
        Vector vec = createInstance(size);
        //ArrayVector vec = new ArrayVector(size);
        for (int i = 0; i < size; i++) {            
            bufr [i] = dis.readDouble();
        }
        vec.fillFromMass(bufr);
        return vec;
    }
    
    /**
    *   Метод записи вектора в символьный поток
    */
    public static void writeVector (Vector v, Writer out) throws IOException {
        StringBuffer str = new StringBuffer();
        str.append(v.getSize());
        str.append(" ");
        str.append(v.toString());
        str.append(System.getProperty("line.separator"));
        BufferedWriter bw = new BufferedWriter(out);
        bw.write(str.toString());
        bw.flush();
    }
   
    /**
    *  - чтение вектора из символьного потока
    */
    public static Vector readVector (Reader in) throws IOException{
        StreamTokenizer st = new StreamTokenizer(in);
        st.nextToken();        
        int size = (int)st.nval;
        //ArrayVector arr = new ArrayVector(size);
        Vector arr = createInstance(size); //new ArrayVector(size);
        for (int i = 0; i < size; i++) {                   
            st.nextToken();
            arr.setElement(i,(double)st.nval); 
        }
        return arr;        
    }



    public static void main(String[] args) 
            throws vector.exceptions.IncompatibleVectorSizesException, IOException,ClassNotFoundException{

        double[] students = { 1.3, 2.8, 3.4, 4.1, 5.3, 6.6 };

        Vector vect = createInstance(students.length);
        //ArrayVector vect = new ArrayVector(students.length);
	    vect.fillFromMass(students);
		
	    DataOutputStream out1 = new DataOutputStream(new FileOutputStream("students.bin"));
        outputVector(vect, out1);
	    out1.close();

        PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter("out1.txt")));
        writeVector(vect, out2);
        out2.close();
		
        BufferedReader in1 = new BufferedReader(new FileReader("out1.txt"));
        System.out.println("Read from text file:            "+readVector(in1));
        in1.close();
        
        InputStream in2 = new FileInputStream("students.bin");
        System.out.println("Read from binary file:          "+inputVector(in2));
        in2.close();
                
        // ArrayVector serialization
        // Test serialization
        ObjectOutputStream out3 = new ObjectOutputStream(new FileOutputStream("out.bin"));
        out3.writeObject(vect);
        out3.close();
        System.out.println("Serialization of ArrayVector:   " + vect.toString());
        
        // Test deserialization
        ObjectInputStream in3 = new ObjectInputStream(new FileInputStream("out.bin"));
        vect = (ArrayVector) in3.readObject();
        in3.close();
        System.out.println("Deserialization of ArrayVector: " + vect.toString());
        
        // LinkedListVector serialization
        LinkedListVector lvect = new LinkedListVector();
	    lvect.fillFromMass(students);
        
        // Test serialization
        ObjectOutputStream out4 = new ObjectOutputStream(new FileOutputStream("out2.bin"));
        out4.writeObject(lvect);
        out4.close();
        System.out.println("Serialization of LinkedListVector:  " + lvect.toString());
        
        // Test deserialization
        ObjectInputStream in4 = new ObjectInputStream(new FileInputStream("out2.bin"));
        lvect = (LinkedListVector) in4.readObject();
        in4.close();
        System.out.println("Deserialization of LinkedListVector:" + lvect.toString());
    }
}
