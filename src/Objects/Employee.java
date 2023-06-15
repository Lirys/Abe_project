package Objects;

public class Employee {

    private int employeeID;
    private String employeeName;
    private double rate_per_day;

    public Employee() {}

    public Employee(int employeeID, String employeeName, double rate_per_day){
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.rate_per_day = rate_per_day;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setRatePerDay(double rate_per_day) {
        this.rate_per_day = rate_per_day;
    }

    public double getRatePerDay() {
        return rate_per_day;
    }
}