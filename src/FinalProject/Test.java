//////////////////////////////////////////////////////////////////////
// Author: Allan Poindexter                                         //
//                                                                  //
// Date: 11/25/16                                                   //
// Program Description: Present an exam to the user                 //
//                                                                  //
// Input: Text document with questions and answers                  //
//        User can input numbers, letters or 'submit' to nagivate   //
//        the test or change their answers                          //
// Processing: Calculate percentage based on correct answers        //
// Output: User's final score and answers.                          //
//////////////////////////////////////////////////////////////////////

package FinalProject;

import java.io.*;
import java.util.Scanner;

/** The test class is a new randomly generated exam. */
public class Test {
    private String[][] questions = new String[20][5];   //Hold the questions and their answers
    private Integer[] questionNumbers = new Integer[10];//The 10 randomly selected questions
    private boolean[] hasAnswered = new boolean[10];    //Has the user answered this?
    
    private String[] answers = new String[10];          //The user's input.
    
    UsefulFunctions functions = new UsefulFunctions();   //Enables me to use the converters.
    
    public Test(){
        boolean fileFound = true;
        try {
            readTestFile();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            fileFound = false;
        }
        
        if (fileFound){
            createTest();
            showTest();
        }
    }
    
    /** Get the questions and answers from TestBank.txt and put them in the quests.txt */
    private void readTestFile() throws FileNotFoundException {
        File test = new File("Final Project Files/TestBank.txt");
        Scanner reader = new Scanner(test);
        
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 5; j++){
                questions[i][j] = reader.nextLine();
            }
        }
    }
    
    /** Generate random numbers to decide which question will be used.  */
    private void createTest() {
        java.util.Random randomQuestion = new java.util.Random();
        //questionNumbers consists of the 10 questions that will be used
        for (int i = 1; i <= 10; i++) {
            int question = randomQuestion.nextInt(20);
            if (!functions.contains(questionNumbers, question)){
                questionNumbers[i-1] = question;
            } else
                i--;   
        }
        
        //Empty the answers array
        for (int i = 0; i < answers.length; i++){
            answers[i] = "";
        }
        
        //hasAnswered ensures that none of the questions have been answered yet.
        for (int i = 0; i < hasAnswered.length; i++){
            hasAnswered[i] = false;
        }
    }
    
    /** Present the questions */
    private void showTest() {
        Scanner input = new Scanner(System.in);
        
        String question = "";
        //Show 10 questions
        for (int i = 0; i < questionNumbers.length; i++){   
            displayQuestion(i);
            
            recieveAnswer(i);
            
            System.out.println(); System.out.println();
        }
    } 
    
    /** Show whether the user has answered all of the questions */
    public void checkAnswers(){
        int answerCount = 0;  //How many questions did theys skip?
        int[] unAnswered = new int[10]; //An array of WHICH question they skipped
        for (int i = 0; i < hasAnswered.length; i++){
            if (!hasAnswered[i]) {
                unAnswered[answerCount] = (i + 1);
                answerCount++;
            }
        }
        
        System.out.println("The test is over.");
        if (answerCount == 0)
            System.out.println("You've answered all the questions! Good job!");
        else { //Tell the users how many questions they skipped, and which question they've skipped.
            System.out.println("You've answered " + (10 - answerCount) + " out of 10 questions.");
            System.out.print("You skipped questions "); 
            for (int i = 0; i < answerCount; i++){
                System.out.print(unAnswered[i]);
                if (i == (answerCount - 1) )
                    System.out.print(".");
                else
                    System.out.print(", ");
            }
            System.out.println();
        }
        
        System.out.println();
    }
    
    public void revisitQuestions() {
        Scanner input = new Scanner(System.in);
        String userInput = "";
        String submit = "SUBMIT";
        
        do {
            System.out.println("To revist a question, please enter a question number (1-10).");
            System.out.print("Or to submit the test and see your grade, type \"submit\": ");
            userInput = input.next();
            userInput = userInput.toUpperCase();
            System.out.println();

            if (functions.tryParseInt(userInput) &&   //The user tried to enter a number.
                functions.isBetweenOneAndTen(Integer.parseInt(userInput))){

                //Display the question.
                displayQuestion(Integer.parseInt(userInput) - 1);
                recieveAnswer(Integer.parseInt(userInput) - 1);
            } else if (userInput.equals(submit))  //the user tried to submit the test.
                submitTest();
             else //Invalid input
                System.out.println("Input is invalid");
        } while (!userInput.equals(submit));
    }
    
    /** Use index to select a question. */
    private void displayQuestion(int index){
        //Pull the questions using the random questionNumbers as the index
        String question = "";
        question = questions[questionNumbers[index]][0];   
        System.out.println((index + 1) + ". " + question);

        //Display an A. B. and C. next to each answer
        for (int j = 1; j < 4; j++) {
            char[] letters = {'A', 'B', 'C'};
            String answer = "   " + letters[j-1] + ". " +
                   questions[questionNumbers[index]][j];
            System.out.println(answer);
        }
        System.out.println();
        //Show the user's previous answer if they've answered this question before.
        if (hasAnswered[index]) 
            System.out.println("Your previous answer was " + answers[index] + ".");       
    }
    
    private void recieveAnswer(int index){
        Scanner input = new Scanner(System.in);
        String userInput = "";          //The user's input
        boolean validAnswer = false;    //Is the input valid?
        
        String skip = "SKIP"; //Use ANOTHER variable to hold "SKIP," because apparantly
                                      //JAVA can't compare string literals to string variables...
        String submit = "SUBMIT";
        
        if (!hasAnswered[index] && 
                !(answers[index].equals(skip))){ //If the user has not already answered this question
            do {
                System.out.print("Type A, B, or C to answer, or type \"Skip\" to skip this question: ");
                userInput = input.next(); 
                userInput = userInput.toUpperCase();
                
                if (userInput.equals(skip)) {
                    validAnswer = true;
                    answers[index] = userInput;
                    hasAnswered[index] = false;
                } else if (functions.isBetweenAandC(userInput.charAt(0))){
                    validAnswer = true;
                    answers[index] = userInput;
                    hasAnswered[index] = true;
                } else
                    System.out.println("Invalid input received");
            } while (!validAnswer);
        } else if (hasAnswered[index] ||
                    answers[index].equals(skip)){
            boolean answerChanged = false;
            do {
                if (answerChanged){
                    System.out.println("ANSWER UPDATED.");
                    System.out.println();
                    answerChanged = false;
                }
                
                System.out.println("Type A, B, or C to change your answer,");
                System.out.println("OR type a number through 1 and 10 to revisit another question.");
                System.out.print("OR type \"Submit\" to end the test: ");
                userInput = input.next(); 
                userInput = userInput.toUpperCase();
                
                if (functions.isBetweenAandC(userInput.charAt(0))){
                    validAnswer = true;
                    answers[index] = userInput;
                    System.out.println("My answer: " + userInput);
                    System.out.println("So the new answer is " + answers[index]);
                    answerChanged = true;
                } else if (functions.tryParseInt(userInput) && 
                        functions.isBetweenOneAndTen(Integer.parseInt(userInput))){
                    validAnswer = true;
                    displayQuestion(Integer.parseInt(userInput) - 1);
                } else if (userInput.equals(submit)){
                    validAnswer = true;
                    submitTest();
                }else
                    System.out.println("Invalid input received");
                
                System.out.println();
            } while (!userInput.equals(submit) && !validAnswer);
        }
    }
    
    /** Grade the user on the exam */
    private void submitTest(){
        int correct = 0;
        double score = 0.0;
        
        for (int i = 0; i < questionNumbers.length; i++){
            if (answers[i].equals(questions[questionNumbers[i]][4]))
                correct++;
            System.out.println("The answer to question " + (i+1) + " is " + questions[questionNumbers[i]][4]);
            System.out.println("My answer was " + answers[i]);
        }
        
        System.out.println("You got " + correct + " out of 10 correct.");
        score = ((double)correct / 10) * 100;
        
        if (score >= 90)
            System.out.println ("Your score is " + score + "%. You got an A! Great job!");
        else if (score >= 80)
            System.out.println ("Your score is " + score + "%. You got a B! Not bad...");
        else if (score >= 70) 
            System.out.println ("Your score is " + score + "%. You got a C. You pass.");
        else if (score >= 60)
            System.out.println ("Your score is " + score + "%. You got a D. Try to study harder.");
        else 
            System.out.println ("Your score is " + score + "%. You got a F. Time to study more...");

    }
}