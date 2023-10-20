package Oct17Homework;
import java.util.*;
import java.lang.Math;
// ---------- QUESTION 2 -----------
/*** Make a class called GhettoChatBot.
There should be three constructors. 
   The first is the default constructor that takes no paramters. 
   The second takes in two lists of strings, where the first is a list of questions and the other is the list of corresponding answers.
   The third takes in two arrays of strings, where the first is an array of questions and the other is an array of the corresponding answers.
The following public methods should be implemented:
   void addQuestionAndAnswer(String question, String answer) -> Adds a new question that the GhettoChatBot can answer.
   String askQuestion(String question) -> If the GhettoChatBot can answer the question, it does. If not, it says "Sorry, I do not understand the question."
When you've implemented the method, make an interactive program out of GhettoChatBot. Be creative.
/*** */
public class Oct17HomeworkP2 {
    
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in); 
      List<String> mQuestions = new ArrayList<String>();
      List<String> mAnswers = new ArrayList<String>(0);
      GhettoChatBot ChatBot = new GhettoChatBot(mQuestions, mAnswers);
      ChatBot.addQuestionAndAnswer("How are you?", "I am very good");
      ChatBot.addQuestionAndAnswer("What is your name?", "My name is Razvan, the GhettoChatBoy");
      ChatBot.addQuestionAndAnswer("What is your favourite FRC Team?", "Its 5036 duh");
      System.out.println("Hey! My name is Razvan, the GhettoChatBoy, so... ask me a question");
      String Question = scanner.nextLine();
          System.out.println(ChatBot.askQuestion(Question)); 

    }
}
