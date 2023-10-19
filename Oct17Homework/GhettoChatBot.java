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

    List<String> mQuestions = new ArrayList<String>();
    List<String> mAnswers = new ArrayList<String>();
    String[] mArrayQuestions;
    String[] mArrayAnswers;
    public GhettoChatBot(){

    }
    public GhettoChatBot(List<String> Questions, List<String> Answers){
        mQuestions = new ArrayList<String>(Questions);
        mAnswers = new ArrayList<String>(Answers);
    }
    public GhettoChatBot(String[] Questions, String[] Answers){
        mArrayQuestions = new String[Questions.length];
        mArrayAnswers = new String[Answers.length];
    }
    public void addQuestionAndAnswer(String Question, String Answer){
        mQuestions.add(Question);
        mAnswers.add(Answer);
        for(int i = 0; i < mArrayQuestions.length; i += 1){
            mArrayQuestions[i] = Question;
        }
        for(int i = 0; i < mArrayAnswers.length; i += 1){
            mArrayAnswers[i] = Answer;
        }
    }
    public String askQuestion(String Question){
        for(String i : mQuestions){
            if(i )
        }
    }
    }

