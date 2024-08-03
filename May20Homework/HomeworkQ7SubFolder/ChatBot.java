package May20Homework.HomeworkQ7SubFolder;

import java.util.*;

public class ChatBot {
    private int numOfWords;
    public ChatBot(int numOfWords){
        this.numOfWords = numOfWords;
    }
    public static void talkBack(){
        Scanner userInput = new Scanner(System.in);
        String end = "end";
        String[] wordBank = {"the","of","and","a","to","in","is","you","that","it","he","was","for","on","are","as","with","his","they","I","at","be","this","have","from","or","one","had","by","word","but","not","what","all","were","we","when","your","can","said","there","use","an","each","which","she","do","how","their","if","will","up","other","about","out","many","then","them","these","so","some","her","would","make","like","him","into","time","has","look","two","more","write","go","see","number","no","way","could","people","my","than","first","water","been","call","who","oil","its","now","find","long","down","day","did","get","come","made","may","part"};
        List<String> Story = new ArrayList<>();
        int counter = 0;
        boolean flag = true;

    
        for(int i = 0; i < wordBank.length; i += 1){
            Random randomAns = new Random();
            int randomIVal = randomAns.nextInt(wordBank.length);
            String userWord = userInput.nextLine();
            Story.add(userWord);
            if(validateInput(userWord) && flag == true){
                System.out.println("The next word in the story is " + wordBank[randomIVal]);
                Story.add(wordBank[randomIVal]);
                if (userWord.equals(end)) {
                    System.out.println("Finished Story!");
                    System.out.println("Printed Story! " + Story);
                    i = wordBank.length;
                    flag = false;
                }
            } // else {r
            // //     userWord = userInput.nextLine();
            // // }
        }
    }

    public static boolean validateInput(String input){
        if(input != null){
            return true;
        } else {
            return false;
        }
    }
}
