package Nov15Homework;

public class Question1WordSplit {
    static int AmountOfWordsInStr(String line, String word){
        int counter = 0;
        String[] strArray = null;
        strArray = line.split(" ");
        for(int i = 0; i < strArray.length; i += 1){
          System.out.println(strArray[i]);
          if(strArray[i].equals(word)){
            counter += 1;
          }
        }
        return counter;
      }
      public static void main(String[] args) {
        String line = "The Brown Fox Jumped over the big blue fence in the big blue sky in the blue-ish day";
        String word = "blue";
        System.out.println(AmountOfWordsInStr(line, word));
      }
}
