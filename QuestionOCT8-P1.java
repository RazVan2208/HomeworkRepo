import java.util.*;
// --------- QUESTION 1 -------- //
// Create a function called printFromListEveryNSeconds that will print
// an element from an array list every n seconds until there are no 
// more strings to print.
// Example: Given the list {"I", "am", "not", "very", "smart"} and n = 3,
//  the function should print "I" after 3 seconds, "am" after 6 seconds,
//  "not" after 9 seconds, "very" after 12 seconds and finally "smart"
//  after 15 seconds.
class Main {
    static void printFromListEveryNSeconds(ArrayList<String> strList, int n){
        long startTime = System.currentTimeMillis();
        for(String i : strList){
            int convertedNTime = n * 1000;
            int b = -1;
            while(b < strList.size()){
                long currentTime = System.currentTimeMillis();
                long timePassed = currentTime - startTime;
                if(timePassed >= convertedNTime){
                    b += 1;
                    System.out.println(strList.get(b));
                    System.out.println("I waited " + timePassed + " ms!");
                }
            }
        }
    }
  public static void main(String[] args) {
    ArrayList<String> newList = new ArrayList<String>();
    newList.add("I waited 3 seconds!");
    newList.add("My name is");
    newList.add("Razvan");
    newList.add("Test");
    printFromListEveryNSeconds(newList, 3);
  }
}
