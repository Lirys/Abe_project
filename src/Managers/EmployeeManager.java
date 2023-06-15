package Managers;

import Exceptions.IDError;
import Objects.Employee;

import java.util.*;
import java.io.*;


public class EmployeeManager {
        File employeeFile;
        public EmployeeManager() {
            employeeFile = new File("EmployeeFile.txt");
        }

        public List<Employee> getAllEmployee() {
            ArrayList<Employee> employee_list = new ArrayList<>();
            try {
                Scanner sc = new Scanner(new FileReader(employeeFile));
                while (sc.hasNext()) {
                    try {
                        Employee employee = new Employee();
                        employee.setEmployeeID(sc.nextInt());
                        employee.setEmployeeName(sc.next());
                        employee.setRatePerDay(sc.nextDouble());
                        employee_list.add(employee);
                    } catch ( Exception e ) {
                        System.out.println("Something happened!");
                        e.printStackTrace();
                    }
                }
                sc.close();
            } catch ( FileNotFoundException e ) {
                e.printStackTrace();
            }
            return employee_list;
        }

        public void createEmployee(Employee employee) {
            boolean flag = true;
            List<Employee> employee_list = getAllEmployee();
            FileWriter fw;
            BufferedWriter bw;
            
            for ( Employee record : employee_list ) {
                try { 
                    if ( record.getEmployeeID() == employee.getEmployeeID() ){
                        throw new IDError();
                    } 
                } catch ( IDError e ) {
                    flag = false;
                    System.out.println(e.getMessage());
                }       
            }
            if ( flag ) {
                try {
                    fw = new FileWriter(employeeFile, true);
                    bw = new BufferedWriter(fw);

                    bw.write(employee.getEmployeeID()+" ");
                    bw.write(" ");
                    bw.write(employee.getEmployeeName().toUpperCase());
                    bw.write(" ");
                    bw.write(employee.getRatePerDay() + "\n");
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public Employee retrieveEmployee(int id){
            Employee record = new Employee();
            for ( Employee employee : getAllEmployee() ){
                if ( employee.getEmployeeID() == id ) {
                    record.setEmployeeID(employee.getEmployeeID());
                    record.setEmployeeName(employee.getEmployeeName());
        
                    return record;
                }
            }
            return null;
        }
        public void updateEmployee( Employee record ) {
            List<Employee> employee_list = getAllEmployee();
            for ( Employee employee : employee_list ){
                if ( employee.getEmployeeID() == record.getEmployeeID() ) {
                    employee_list.set(employee_list.indexOf(employee), record);
                    break;
                }
            }
            String format = "";
            for ( Employee employee : employee_list ){
                format += employee.getEmployeeID() + " " + employee.getEmployeeName().toUpperCase() + "\n";
            }
            try {
                Formatter formatFile = new Formatter(employeeFile);
                formatFile.format("%S", format);
                formatFile.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
}
        




