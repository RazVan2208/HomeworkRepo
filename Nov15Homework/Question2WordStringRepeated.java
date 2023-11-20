package Nov15Homework;
import java.util.ArrayList;
// -------- QUESTION 2 -----------
// Given a string with words separated by whitespace and a list of words, return a list containing the number of times each corresponding word appears in the string. 
//  Again, if a word is a substring of another word in the full string, it doesn't count.
// Example: str="bob played connect-4 with his younger brother bobby and his other friend named bob", words={"bob", "played", "connect" -> Return {2, 1, 1}
// Example: str="This is another example. Do you understand this example or do you need another example?", words={"example", you} -> Return {3, 2}
public class Question2WordStringRepeated{
    static ArrayList<Integer> getWordCounts(String str, ArrayList<String> words){
        ArrayList<Integer> RepeatedWords = new ArrayList<Integer>();
        String strArray[] = null;
        strArray = str.split(" ");
         for(int n = 0; n < words.size(); n += 1){ 
          int counter = 0;
          RepeatedWords.add(0);
        for(int i = 0; i < strArray.length; i += 1){  
          if(strArray[i].equals(words.get(n))){
            counter += 1;
            RepeatedWords.set(n, counter);
          }   
          System.out.println("Detected " + strArray[i] + " " + counter); 
        }
      }
      System.out.println(RepeatedWords);
        return RepeatedWords;
    }
  public static void main(String[] args) {
    String str = "This is another example. Do you understand this example or do you need another example?";
    ArrayList<String> words = new ArrayList<String>();
    words.add("example");
    words.add("you");
    getWordCounts(str, words);
  }
}


