package Nov15Homework;
// -------- QUESTION 4 -----------
// Write a Java program that prints out the arguments passed to it.
// Example: Run "java myProgram firstArg secondArg" in the command line. This should print out "firstArg" and "secondArg".

import java.util.Scanner;

public class Question4ArgFile {
    static int AddSomething(int a, int b){
        return a + b;
    }
    public static void main(String[] args) {
        Scanner Adder = new Scanner(System.in);
        for(String arg : args){
            System.out.println(arg);
        }
    }
}
