import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Create a Java program that takes at least two strings as arguments. The first argument is the absolute or relative path of a file. The rest of the arguments are words. For each word passed to the program, print out the number of times it appears in the file.
public class Question5FileReaderByArg {
    public static void main(String[] args) {
    String filePath = "";
    String keyWord = "";
    File ReadFile = new File(filePath);
    String absolutePath = ReadFile.getAbsolutePath();
    Scanner scan = null;
        for(String arg : args){
        //     try {
        // scan = new Scanner(ReadFile);
        //    while(scan.hasNextLine()){
        //        System.out.println(scan.nextLine());
        //    }
        // } catch (FileNotFoundException e){
        //     e.printStackTrace();
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
           filePath = args[0].toString();
           for(int i = 1; i < args.length; i += 1){
                keyWord = args[i];
                System.out.println(keyWord + " Value of i is " + i);
           }
        }
    }
}
