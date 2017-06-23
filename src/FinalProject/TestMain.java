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

public class TestMain {
    public static void main(String[] args)
    {
        //Begin the test.
        Test firstExam = new Test();
        
        //Check the answers
        firstExam.checkAnswers();
        
        //Allow the user to revisit the questions they've seen.
        firstExam.revisitQuestions();
    }
}
