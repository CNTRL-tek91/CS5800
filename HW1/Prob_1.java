class Employee {
    //Class Attributes
    private String firstName, lastName, socialSecurityNumber;



    //Constructor
    public Employee (String firstName, String lastName, String socialSecurityNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }


    //Get Methods
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getSocialSecurityNumber(){
        return socialSecurityNumber;
    }


    //Set Methods
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }
}

class SalariedEmployee extends Employee {
    //Class Attributes
    private int weeklySalary;


    //Constructor
    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, int weeklySalary){
        super(firstName, lastName, socialSecurityNumber);
        this.weeklySalary = weeklySalary;
    }


    //Get Methods
    public int getWeeklySalary() {
        return weeklySalary;
    }


    //Set Methods
    public void setWeeklySalary(int weeklySalary) {
        this.weeklySalary = weeklySalary;
    }
}

class HourlyEmployee extends Employee{
    //Class Attributes
    private int wage;
    private int hoursWorked;


    //Constructor
    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, int wage, int hoursWorked)
    {
        super(firstName, lastName, socialSecurityNumber);
        this.wage = wage;
        this.hoursWorked = hoursWorked;
    }


    //Get Methods
    public int getWage() {
        return wage;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }


    //Set Methods
    public void setWage(int wage) {
        this.wage = wage;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}

class CommissionEmployee extends Employee{
    //Class Attributes
    private int commissionRate, grossSales;


    //Constructor
    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, int commissionRate, int grossSales)
    {
        super(firstName, lastName, socialSecurityNumber);
        this.commissionRate = commissionRate;
        this.grossSales = grossSales;
    }


    //Get Methods
    public int getCommissionRate() {
        return commissionRate;
    }

    public int getGrossSales() {
        return grossSales;
    }


    //Set Methods
    public void setCommissionRate(int commissionRate) {
        this.commissionRate = commissionRate;
    }

    public void setGrossSales(int grossSales) {
        this.grossSales = grossSales;
    }
}

class BaseEmployee extends Employee{
    //Class Attributes
    private int baseSalary;


    //Constructor
    public BaseEmployee(String firstName, String lastName, String socialSecurityNumber, int baseSalary)
    {
        super(firstName, lastName, socialSecurityNumber);
        this.baseSalary = baseSalary;
    }


    //Get Methods
    public int getBaseSalary() {
        return baseSalary;
    }


    //Set Methods
    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }
}

public class Prob_1 {
    public static void main(String[] args) {

        SalariedEmployee joeJones = new SalariedEmployee( "Joe", "Jones", "111-11-1111", 2_500);
        HourlyEmployee stephanieSmith = new HourlyEmployee("Stephanie", "Smith", "222-22-2222", 25, 32);
        HourlyEmployee maryQuinn = new HourlyEmployee("Mary", "Quinn", "333-33-3333", 19, 47);
        CommissionEmployee nicoleDior = new CommissionEmployee("Nicole", "Dior", "444-44-4444", 15, 50_000);
        SalariedEmployee renwaChanel = new SalariedEmployee( "Renwa", "Chanel", "555-55-5555", 1_700);
        BaseEmployee mikeDavenport = new BaseEmployee("Mike", "Davenport", "666-66-6666", 95_000);
        CommissionEmployee mahnazVaziri = new CommissionEmployee("Mahnaz", "Vaziri", "777-77-7777", 22, 40_000);

        displaySalariedEmployee(joeJones);
        System.out.println();
        displayHourlyEmployee(stephanieSmith);
        System.out.println();
        displayHourlyEmployee(maryQuinn);
        System.out.println();
        displayCommissionEmployee(nicoleDior);
        System.out.println();
        displaySalariedEmployee(renwaChanel);
        System.out.println();
        displayBaseEmployee(mikeDavenport);
        System.out.println();
        displayCommissionEmployee(mahnazVaziri);
        System.out.println();

    }

    public static void displaySalariedEmployee(Employee employee) {
        System.out.println("First Name: " + employee.getFirstName());
        System.out.println("Last Name: " + employee.getLastName());
        System.out.println("SSN: " + employee.getSocialSecurityNumber());
        System.out.println("Weekly Salary: $" + ((SalariedEmployee) employee).getWeeklySalary());
    }

    public static void displayHourlyEmployee(Employee employee) {
        System.out.println("First Name: " + employee.getFirstName());
        System.out.println("Last Name: " + employee.getLastName());
        System.out.println("SSN: " + employee.getSocialSecurityNumber());
        System.out.println("Wage: $" + ((HourlyEmployee) employee).getWage());
        System.out.println("Hours Worked: " + ((HourlyEmployee) employee).getHoursWorked());

    }

    public static void displayCommissionEmployee(Employee employee) {
        System.out.println("First Name: " + employee.getFirstName());
        System.out.println("Last Name: " + employee.getLastName());
        System.out.println("SSN: " + employee.getSocialSecurityNumber());
        System.out.println("Commission Rate: " + ((CommissionEmployee)employee). getCommissionRate() + "%");
        System.out.println("Gross Salary: $" + ((CommissionEmployee)employee). getGrossSales());


    }
    public static void displayBaseEmployee(Employee employee) {
        System.out.println("First Name: " + employee.getFirstName());
        System.out.println("Last Name: " + employee.getLastName());
        System.out.println("SSN: " + employee.getSocialSecurityNumber());
        System.out.println("Base Salary: $" + ((BaseEmployee) employee). getBaseSalary());


    }


}