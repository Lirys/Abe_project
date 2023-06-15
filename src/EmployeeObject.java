public class EmployeeObject {

    private int employeeID;
    private String employeeName;
    private int rate_per_day;

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

    public void setRatePerDay(int rate_per_day) {
        this.rate_per_day = rate_per_day;
    }

    public int getRatePerDay() {
        return rate_per_day;
    }
}