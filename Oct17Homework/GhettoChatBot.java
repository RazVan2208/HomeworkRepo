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
public class GhettoChatBot {
// Declaring empty Arrays and Lists
    List<String> mQuestions = new ArrayList<String>();
    List<String> mAnswers = new ArrayList<String>();
    String[] mArrayQuestions = new String[0];
    String[] mArrayAnswers = new String[0];
    int mAmountOfTimesRun = 0;
// First constructor takes in no Parameters
    public GhettoChatBot(){

    }
// Second Constructor takes in two lists, which we add to the empty lists
    public GhettoChatBot(List<String> Questions, List<String> Answers,int AmountOfTimesRun){
        mQuestions = new ArrayList<String>(Questions);
        mAnswers = new ArrayList<String>(Answers);
        mAmountOfTimesRun = AmountOfTimesRun;
    }
// Third Constructor takes in two arrays
    public GhettoChatBot(String[] Questions, String[] Answers){
        mArrayQuestions = new String[Questions.length];
        mArrayAnswers = new String[Answers.length];
    }
// Asking a question and answer, which we add the values of those to the Lists and Arrays
    public void addQuestionAndAnswer(String Question, String Answer){
        mQuestions.add(Question);
        mAnswers.add(Answer);
        for(int i = 0; i < mArrayQuestions.length; i += 1){
            mArrayQuestions[i] = Question;
            mQuestions.add(mArrayAnswers[i]);
        }
        for(int i = 0; i < mArrayAnswers.length; i += 1){
            mArrayAnswers[i] = Answer;
            mAnswers.add(mArrayAnswers[i]);
        }
    }
// Give the user the ability to ask the question, if input equals the question, then give the answer, otherwise if false, give them a possible amount of questions. Working on fixing this
    public String askQuestion(String Question){
        String NoUnderstando = "I don't understand the question asked";
        
        String SpecialMessage = "Hey, I know you're probably bored of re-running me, so heres a list of possible questions." + mQuestions;
        for(int b = 0; b < mQuestions.size(); b += 1){
            if(mQuestions.get(b).equals(Question)){
                return mAnswers.get(b);
        }

    }
    System.out.println(mAmountOfTimesRun);
        if(mAmountOfTimesRun > 2){
            return SpecialMessage;
        }
        return NoUnderstando;
}
    }

