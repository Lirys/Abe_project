import Managers.CutoffManager;
import Managers.EmployeeManager;
import Objects.Employee;
import Objects.Utils;

import java.util.*;

public class Main {
    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        CutoffManager cutOffManager;

        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do{
            int id = 0;
            String name = "";
            double rate_per_day = 0;
            Utils.displayMenu();
            try {
                System.out.print("What's on your mind? ");
                choice = scanner.nextInt();
            } catch ( Exception e ) {
                System.out.println("Error: " + e.getMessage());
            }
            if(choice > 0){
                switch (choice) {
                    case 1 -> {
                            System.out.println("----------------------------------");
                            System.out.print("Enter id: ");
                            id = scanner.nextInt();
                            System.out.print("Enter name: ");
                            name = scanner.next();
                            System.out.print("Enter Rate/Day: ");
                            rate_per_day = scanner.nextDouble();
                            employeeManager.createEmployee(new Employee(id, name, rate_per_day));
                            System.out.println("----------------------------------");
                            System.out.println("Successfully Added!");
                            System.out.println("Employee ID: " + id);
                            System.out.println("Employee Name: " + name);
                            System.out.println("Employee Rate/Day: " + rate_per_day);
                    }
                }
            }
        }while (choice > 0);
    }
}
