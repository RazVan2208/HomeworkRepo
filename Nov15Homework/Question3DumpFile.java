package Nov15Homework;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner; 
import java.io.FileReader;
import java.io.IOException; 
public class Question3DumpFile {
    // -------- QUESTION 3 -----------
// Given the absolute path or relative path of a file, print the contents of the file.
    static void dumpFileContents(String filePath){
        File ReadFile = new File(filePath);
        Scanner Reader = new Scanner(filePath);
        String absoluteFilePath = ReadFile.getAbsolutePath();
        System.out.println(absoluteFilePath);
        System.out.println(filePath);
        FileReader NewFileReader = new FileReader(ReadFile);
        System.out.println(string(NewFileReader.read(ReadFile));

    }

     public static void main(String[] args) {
        dumpFileContents("C:\\Users\\Razvan\\Downloads\\TextFileTest.txt");
  }
}
