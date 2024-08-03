package May20Homework;

import java.util.ArrayList;
import java.util.List;

public class HomeworkQ4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aadfdaa");
        list.add("aaadfdfdfdfdfa");
        list.add("adfdfdfdfaaa");
        list.add("adfdfaaa");

        printListNTimes(list, 2);
    }
// Guess what this function is supposed to do and then implement it.

    static void printListNTimes(List<String> list, int n) {
// Fill in the rest
    for(int j = 0; j < n; j += 1){
    for(int i = 0; i < list.size(); i += 1){
        System.out.println(list.get(i));
    }
    System.out.println("It has printed " + (j + 1) + " times");
    }
}

}
