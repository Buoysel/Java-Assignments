//////////////////////////////////////////////////////////////////////
// Author: Allan Poindexter                                         //
//                                                                  //
// Date: 11/01/16                                                   //
// Program Description: Return the power of an entered number       //
//                                                                  //
// Input: Int for number and Int for power                          //
// Processing: Multiply number by itself depending on power.        //
// Output: Power is returned as an int.                             //
//////////////////////////////////////////////////////////////////////

import java.util.Scanner;   //Get the Scanner

public class Power {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); // Create the scanner

        //Get the numbers
        System.out.print("Enter a number and a power: ");
        int number = input.nextInt();
        int power = input.nextInt();

        try {
            //Return the power
            System.out.println(number + " raised to power " + power +
                    " is " + powerOf(number, power));
        }
        catch (ArithmeticException ex) {
            System.out.println("Power cannot be a negative number.");
        }
    }

    /** Take two Ints and return the power. */
    static int powerOf(int num, int pow){
        //Ensure that power is not negative.
        if (pow < 0)
            throw new ArithmeticException("Power can't be negative.");

        if (pow == 1)
            return num * pow;
        return num * powerOf(num, pow-1);
    }
}
