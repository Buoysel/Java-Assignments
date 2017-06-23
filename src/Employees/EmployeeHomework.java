//////////////////////////////////////////////////////////////////////
// Author: Allan Poindexter                                         //
//                                                                  //
// Date: 10/20/16                                                   //
// Program Description: The user can create four employees          //
//                                                                  //
// Input: Employee Type, Name, ID, and Date of hire                 //
// Processing: Employee Type determins the creation of the employee.//
// The rest of the input is set using class methods.                //
// Output: The user sees the the employees they created.            //
//////////////////////////////////////////////////////////////////////

package Employees;

import java.util.Scanner;

public class EmployeeHomework {
    static Scanner input = new Scanner(System.in); //New Scanner
    static Employee[] employees = new Employee[4]; //Array of Employees

    /** Main method */
    public static void main(String[] args){
        for (int i = 0; i < employees.length; i++){
            //Ask the user if they want to create an Employee or a Boss
            System.out.println("Do you want to create an Employee or a Boss?");
            System.out.print("Type 'E' for \"Employee\" or 'B' for \"Boss\": ");
            char employeeType = input.next().charAt(0); //Take user input
            employeeType = Character.toUpperCase(employeeType);    //Convert to uppercase if the user enters 'e' or 'b'

            System.out.println();
            input.nextLine();   //Clear the Scanner?

            //Switch (input)
            switch(employeeType){
                    case 'B': //This is a Boss;
                        employees[i] = new Boss();  //Create a new Boss
                        createEmployee(employeeType, i);
                        System.out.println();
                        break;

                    case 'E': //This is an Employee
                        employees[i] = new Employee();  //Create a new Employee
                        createEmployee(employeeType, i);
                        System.out.println();
                        break;

                    default: //Wrong input
                        System.out.println("Please enter either a 'B' or an 'E.'");
                        i--;
                        break;
            }

            if (i == 3) { //All the employees have been entered.
                System.out.println("Thank you for entering the employees.");
                showEmployees();
            }
        }
  }

    /** Method that actually assigns employee date. I didn't want to have
     the same lines of code twice... */
    private static void createEmployee(char c, int iterate){
        String type = "";
        if (c == 'B')
            type = "boss";
        else if (c == 'E')
            type = "employee";

        System.out.println("Enter the " + type + "'s name: ");
        employees[iterate].setName(input.nextLine());

        System.out.println("Enter the " + type + "'s Employee ID:");
        employees[iterate].setEmployeeNumber(input.nextLine());

        System.out.println("Enter the " + type + "'s Date of Hire:");
        employees[iterate].setHireDate(input.nextLine());

        if (iterate < 3) System.out.println("\nNext Employee...");
    }

    /** Show all employees */
    private static void showEmployees(){
        for (int i = 0; i <= 3; i++) {
            System.out.println("\nEmployee number " + (i + 1) + ":");
            System.out.println(employees[i].toString());
        }
    }

}
