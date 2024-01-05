package Nov15Homework;

import java.io.File;
import java.util.Scanner;

// Create a Java program that takes at least two strings as arguments. The first argument is the absolute or relative path of a file. The rest of the arguments are words. For each word passed to the program, print out the number of times it appears in the file.
public class Question5FileReaderByArg {
    public static void main(String[] args) {
    String filePath = "";
    String test1 = "";
    File ReadFile = new File(filePath);
    String absolutePath = ReadFile.getAbsolutePath();
    Scanner scan = null;
        for(String arg : args){
           filePath = args[0].toString();
           test1 = args[1].toString();
           System.out.println(filePath);
           System.out.println(test1);
        }
    }
}
