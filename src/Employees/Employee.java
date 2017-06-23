package Employees;

public class Employee {
    //Strings to hold name, number, and date
    private String name;
    private String employeeNumber;
    private String hireDate;

    /** Employee constructor with arguments */
    public Employee (String n, String num, String date){
        name = n;
        employeeNumber = num;
        hireDate = date;
    }
    /** Employee constructor without arguments */
    public Employee(){
        name = "Unidentified";
        employeeNumber = "00000000";
        hireDate = "00/00/00";
    }

    /** Get and Set Employee name */
    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }

    /** Get and Set Employee number */
    public String getEmployeeNumber(){
        return employeeNumber;
    }
    public void setEmployeeNumber(String e){
        employeeNumber = e;
    }

    /** Get and Set Hire date */
    public String getHireDate(){
        return hireDate;
    }
    public void setHireDate(String h){
        hireDate = h;
    }

    /** To String prints the employee's value */
    public String toString() {
      String information = "Name: " + getName() +
                           "\nID Number: " + getEmployeeNumber() +
                           "\nDate of Hire: " + getHireDate();

      return information;
    }
}
