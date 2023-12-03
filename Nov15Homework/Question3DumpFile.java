package Nov15Homework;
import java.io.*; 
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths; 

public class Question3DumpFile {
    // -------- QUESTION 3 -----------
// Given the absolute path or relative path of a file, print the contents of the file.
     static void dumpFileContents(String filePath) {
        File ReadFile = new File(filePath);
        String absolutePath = ReadFile.getAbsolutePath();
        Scanner scan = null;
        try {
        scan = new Scanner(ReadFile);
           while(scan.hasNextLine()){
               System.out.println(scan.nextLine());
           }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

     //   Scanner Reader = new Scanner(filePath);
      //  Scanner scanner = new Scanner(new File("TestTheFileAgain.txt"));

    }

     public static void main(String[] args) {
        dumpFileContents("../../../../Downloads/TestTheFileAgain.txt");
  }
}
