package employees;

public class Boss extends Employee {
    //Boss Name is a string
    private String bossName;

    /** Constructor for boss with arguments */
    public Boss(String n, String num, String date){
        bossName = n;
        setEmployeeNumber(num);
        setHireDate(date);
    }

    /** Constructor for boss without arguments */
    public Boss(){
        bossName = "Unidentified";
        setEmployeeNumber("00000000");
        setHireDate("00/00/00");
    }

    //Overide the Employee get and Set names.
    @Override
    public String getName(){
        return bossName;
    }
    @Override
    public void setName(String n) {
        bossName = n;
    }

    //Override the Employee toString
    @Override
    public String toString(){
        String information = "Boss name: " + getName() +
                           "\nID Number: " + getEmployeeNumber() +
                           "\nDate of Hire: " + getHireDate();

        return information;
    }
}
