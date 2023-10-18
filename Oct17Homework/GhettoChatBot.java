package Oct17Homework;
import java.util.List;
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
public class GhettoChatBot {

    ArrayList<String> mQuestions = new ArrayList<String>();
    ArrayList<String> mAnswers = new ArrayList<String>();
    public GhettoChatBot(){

    }
    public GhettoChatBot(ArrayList<String> Questions, ArrayList<String> Answers){
        mQuestions = new ArrayList<String>(Questions);
        mAnswers = new ArrayList<String>(Answers);
    }
    
}
