package Nov15Homework;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner; 
public class Question3DumpFile {
    // -------- QUESTION 3 -----------
// Given the absolute path or relative path of a file, print the contents of the file.
    static void dumpFileContents(String filePath){
        File ReadFile = new File(filePath);
        Scanner Reader = new Scanner(filePath);
        String absoluteFilePath = ReadFile.getAbsolutePath();
        System.out.println(absoluteFilePath);
        System.out.println(filePath);
        while (Reader.hasNextLine()) {
            String data = Reader.nextLine();
            System.out.println(data);
          }
        Reader.close();
    }

     public static void main(String[] args) {
        dumpFileContents("TextFileTest.txt");
  }
}
