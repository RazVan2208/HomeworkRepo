package Nov15Homework;
import java.util.List;
import java.util.ArrayList;
// -------- QUESTION 2 -----------
// Given a string with words separated by whitespace and a list of words, return a list containing the number of times each corresponding word appears in the string. 
//  Again, if a word is a substring of another word in the full string, it doesn't count.
// Example: str="bob played connect-4 with his younger brother bobby and his other friend named bob", words={"bob", "played", "connect" -> Return {2, 1, 1}
// Example: str="This is another example. Do you understand this example or do you need another example?", words={"example", you} -> Return {3, 2}
public class Question2WordStringRepeated{
    static ArrayList<Integer> getWordCounts(String str, ArrayList<String> words){
        ArrayList<Integer> RepeatedWords = new ArrayList<Integer>();
        int counter = 0;
        ArrayList<String> strArray = new ArrayList<String>();
        strArray.add(str);
        for(int i = 0; i < strArray.size(); i += 1){
          System.out.println(strArray.get(i));
         // System.out.println(strArray[i]);
          if(strArray.equals("world")){
            System.out.println("e");
          }
     //   if(words.get(i).equals(str)){
            //int counterA = 0;
           // counterA += 1;
           // System.out.println("e");
      //      RepeatedWords.add(1);
     //   }
        }
        return RepeatedWords;
    }
  public static void main(String[] args) {
    String str = "Hello world, I am in a world, with a big world";
    ArrayList<String> words = new ArrayList<String>();
    words.add("world");
    getWordCounts(str, words);
  }
}


