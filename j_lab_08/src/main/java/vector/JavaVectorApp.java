package vector;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author User
 */
public class JavaVectorApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Lol Wut");
        int[] test = new int[] {1,2,3};

    }
}
        
   //     BufferedReader in = new BufferedReader(new FileReader("out.txt")); // InputStreamReader(System.in));
//	LinkedVector lv = new LinkedVector();
//	lv.fillFromMass(dogs);
		
		
		
//      // Serialization
//      ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream("out.bin"));
//	out1.writeObject(v);
//	out1.close();
		
//	// Deserialization array vector
//	ObjectInputStream in1 = new ObjectInputStream(new FileInputStream("out.bin"));
//	lv = (LinkedVector) in1.readObject();
//	in1.close();
//	System.out.println(lv.toString());
	// Deserialization array vector
//	ObjectInputStream in1 = new ObjectInputStream(new FileInputStream("out.bin"));
//	v = (ArrayVector) in1.readObject();
//	in1.close();
//
//	System.out.println(v.toString());    
        

        
        
        
        
        
        

        
        
        
        
        
        
        
        
        
        
    /*    
        LinkedVector llv = new LinkedVector();
        double [] arr = {5,6,7,8,9};
        llv.fillFromMass(arr);
        FileOutputStream str;
        try {
                str = new FileOutputStream("out.bin");
                vector.Vectors.outputVector(llv, str);
                llv.delElement(0);
                vector.Vectors.outputVector(llv, str);
            } 
        catch (FileNotFoundException ex) {
             System.err.println(ex);
        }
        catch (IOException ex) {
            System.err.println(ex);   
        } 
        
       FileWriter fw;
        try{      
            fw = new FileWriter("out.txt");
            vector.Vectors.writeVector(llv, fw);
            llv.delElement(1);
            vector.Vectors.writeVector(llv, fw);
        }
        catch (IOException e) {
            System.out.println(e);
        }
        
        LinkedVector list = new LinkedVector();
        LinkedVector list1 = new LinkedVector();
        FileInputStream inpstr;
        try{
           inpstr = new FileInputStream("out.bin");
           list.fillFromVector(vector.Vectors.inputVector(inpstr));
           list1.fillFromVector(vector.Vectors.inputVector(inpstr));
        }
        catch (IOException e) {
            System.out.println(e);
        }
        System.out.println(list.toString());
        System.out.println(list1.toString());
        
        FileReader fr;
        try {
            fr = new FileReader("out.txt");
            list.fillFromVector(vector.Vectors.readVector(fr));
            list1.fillFromVector(vector.Vectors.readVector(fr));
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
        System.out.println(list.toString());
        System.out.println(list1.toString());
        
        llv.addElement(100);
        ObjectOutputStream out;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream("out_ser.bin");
            out = new ObjectOutputStream(fos);
            out.writeObject(llv);
            out.close();
        }
        catch (IOException ex) {
            System.out.println("Error in seralization");
        }
        
        ObjectInputStream oin;
        FileInputStream fin;
        LinkedVector llv_ser = new LinkedVector();
        try {
            fin = new FileInputStream("out_ser.bin");
            oin = new ObjectInputStream(fin);
            llv_ser.fillFromVector((LinkedVector) oin.readObject());
            oin.close();
        } 
        catch (Exception e) {
            System.out.println("deserialization error");
        }
        System.out.println(llv_ser.toString());
    }
    
    */
