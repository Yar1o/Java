package vector;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import vector.patterns.adapter.JVectorAdapter;
import vector.patterns.adapter.ProtectedVector;
import vector.patterns.factory.FactoryOfArrayVector;
import vector.patterns.factory.FactoryOfLinkedVector;
import vector.patterns.factory.VectorFactory;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/**
 * @author netcracker
 */
public class Vectors{

    /**
     * Фабрика FactoryOfArrayVector
     */
    private static VectorFactory vectorFactory = new FactoryOfArrayVector();

    /**
     * @author netcracker
     */


    public static void sort(Vector inputVector) {
        double temp = 0.0;
        for (int i = 0; i < inputVector.getSize(); i++) {
            for (int j = 1; j <= inputVector.getSize(); i++) {
                if (inputVector.getElement(i) > inputVector.getElement(j)) {
                    temp = inputVector.getElement(i);
                    inputVector.setElement(i, inputVector.getElement(j));
                    inputVector.setElement(j, temp);
                }
            }
        }
    }

    /**
     * Метод записи вектора в байтовый поток
     */
    public static void outputVector(Vector v, OutputStream out) throws IOException {
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeInt(v.getSize());
        for (int i = 0; i < v.getSize(); i++) {
            dos.writeDouble(v.getElement(i));
        }
        dos.flush();
    }

    /**
     * Метод чтения вектора из байтового потока
     */
    public static Vector inputVector(InputStream in) throws IOException {
        DataInputStream dis = new DataInputStream(in);
        int size = dis.readInt();
        double[] bufr = new double[size];
        Vector vec = createInstance(size);
        //ArrayVector vec = new ArrayVector(size);
        for (int i = 0; i < size; i++) {
            bufr[i] = dis.readDouble();
        }
        vec.fillFromMass(bufr);
        return vec;
    }

    /**
     * Метод записи вектора в символьный поток
     */
    public static void writeVector(Vector v, Writer out) throws IOException {
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
     * - чтение вектора из символьного потока
     */
    public static Vector readVector(Reader in) throws IOException {
        StreamTokenizer st = new StreamTokenizer(in);
        st.nextToken();
        int size = (int) st.nval;
        //ArrayVector arr = new ArrayVector(size);
        Vector arr = createInstance(size); //new ArrayVector(size);
        for (int i = 0; i < size; i++) {
            st.nextToken();
            arr.setElement(i, st.nval);
        }
        return arr;
    }

    /**
     * - Преобразование util.Vector в Vector
     */
    public static Vector getAdaptedJVector(java.util.Vector jVector) {
        return new JVectorAdapter(jVector);
    }

    /**
     * - Преобразование Vector в вектор с защитой от записи.
     */
    public static Vector getProtectedVector(Vector inputVector) {
        return new ProtectedVector(inputVector);
    }

    /**
     * Реализация фабрики Vector
     */
    public static void setVectorFactory(VectorFactory vectorFactory) {
        Vectors.vectorFactory = vectorFactory;
    }

    /**
     * Фабричные методы Vector
     */
    public static Vector createInstance() {
        return vectorFactory.createVector();
    }

    public static Vector createInstance(int size) {
        return vectorFactory.createVector(size);
    }

    public static Vector createInstance(int size, Vector inputVector) {
        Vector newWector = createInstance(5);
        Class nclass = newWector.getClass();
        System.out.println(nclass.toString());

        Class c = inputVector.getClass();
        Class cParams[] = new Class[]{int.class};
        Constructor aConstructor;
        try {
            setVectorFactory(new FactoryOfLinkedVector());
            aConstructor = c.getConstructor(cParams);

            Vector temp = (Vector) aConstructor.newInstance(size);

            return temp;
        } catch (NoSuchMethodException e) {
            System.out.println("Конструктор не найден");
            return vectorFactory.createVector(size);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            setVectorFactory(new FactoryOfArrayVector());
        }


        //c.newInstance(size);

        //System.out.println("Конструктор найден");
        return null;
        //return (Vector)aConstructor.newInstance(size);
    }
}



















