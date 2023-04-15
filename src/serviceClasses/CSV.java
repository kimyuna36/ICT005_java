package serviceClasses;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSV {
    public static String fileName = "results.csv";
    public static String header = "className, methodName, marks";
    
    public static void write(String className, String methodName, double marks) {
        File f = new File(fileName);
        if(!f.exists()) {  //Create file and add header if it doenst exist
            try {
                f.createNewFile();
                FileWriter myWriter = new FileWriter(fileName);
                myWriter.write(header + System.lineSeparator());
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        try {
            FileWriter myWriter = new FileWriter(fileName, true);
            myWriter.write(className + "," + methodName + "," + marks + System.lineSeparator());
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
