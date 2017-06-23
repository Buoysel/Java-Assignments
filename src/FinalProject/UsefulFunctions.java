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

import java.util.Arrays;

/** This class contains functions I found online that helped me with 
conversions and array searching. */
public class UsefulFunctions {
    
    public UsefulFunctions() {
    }
    
    /** Check through questionNumbers and return true or false if the number
     has already been used. 
     * Credit:
     http://javadevnotes.com/check-if-java-array-contains-a-certain-value
     */
    public boolean contains(Integer[] array, Integer num){
        return Arrays.stream(array).anyMatch(num::equals);
    }
    
    /** Determine if value is an integer.
     * Credit:
     http://stackoverflow.com/questions/8391979/does-java-have-a-int-tryparse-that-doesnt-throw-an-exception-for-bad-data
     */
    public boolean tryParseInt(String value){
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /** If the user entered a value between 1 and 10 
     *Credit:
     http://stackoverflow.com/questions/10873590/in-java-using-switch-statement-with-a-range-of-value-in-each-case
     */
    public boolean isBetweenOneAndTen(int x){
        return 1 <= x && x <= 10;
    }
    
    /** If the user entered a value between A and C */
    public boolean isBetweenAandC(char c){
        return 'A' <= c && c <= 'C';
    }
}
