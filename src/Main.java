import java.util.*;

public class Main {
    private static Scanner sc;
    private static EmployeeCRUD employeeManager;
    private static CutOffCRUD cutOffManager;
    
    public static void main(String[] args) {
        while (true) {
            sc = new Scanner(System.in);
            int id = 0, choice = 0, rate_per_day = 0;
            // double rate_per_day = 0;
            employeeManager = new EmployeeCRUD();
            String name = "";

            displayMenu();
            try {
                System.out.print("What's on your mind? ");
                choice = Integer.parseInt(sc.next());
            } catch ( Exception e ) {
                System.out.println("Error: " + e.getMessage());
            }

            switch (choice){
                case 1:
                    try {
                        System.out.println("----------------------------------");
                        System.out.print("Enter id: ");
                        id = sc.nextInt();
                        System.out.print("Enter name: ");
                        name = sc.next();
                        System.out.print("Enter Rate/Day: ");
                        rate_per_day = sc.nextInt();
                        createEmployee(id, name, rate_per_day);
                        System.out.println("----------------------------------");
                        System.out.println("Successfully Added!");
                        System.out.println("Employee ID: " + id);
                        System.out.println("Employee Name: " + name);
                        System.out.println("Employee Rate/Day: " + rate_per_day);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
            }
        }
    }

    public static void displayMenu(){
        System.out.println("----------------------------------");
        System.out.println("{1} Add Employee");
        System.out.println("{2} Employee List");
        System.out.println("{3} Cut Off");
        System.out.println("{4} View Specific Employee");
        System.out.println("{5} Edit Employee");
        System.out.println("{6} Exit");
        System.out.println("----------------------------------");
    }

    public static void createEmployee(int id, String name, int rate_per_day) {
        EmployeeObject employee = new EmployeeObject();
        employee.setEmployeeID(id);
        employee.setEmployeeName(name);
        employee.setRatePerDay(rate_per_day);

        employeeManager.createEmployee(employee);
    }
}
