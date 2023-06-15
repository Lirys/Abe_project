import java.util.*;
import java.io.*;

public class EmployeeCRUD {
        File employeeFile;
        public EmployeeCRUD() {
            employeeFile = new File("EmployeeFile.txt");
        }

        public List<EmployeeObject> getAllEmployee() {
            ArrayList<EmployeeObject> employee_list = new ArrayList<>();
            try {
                Scanner sc = new Scanner(new FileReader(employeeFile));

                while (sc.hasNextLine()) {
                    try {
                        EmployeeObject employee = new EmployeeObject();
                        employee.setEmployeeID(sc.nextInt());
                        employee.setEmployeeName(sc.next());
                        employee.setEmployeeID(sc.nextInt());
        
                        employee_list.add(employee);
                    } catch ( Exception e ) {
                        System.out.println("Something happened!");
                        System.out.println(e.getMessage());
                    }
                }
                sc.close();
            } catch ( FileNotFoundException e ) {
                e.printStackTrace();
            }
            return employee_list;
        }

        public void createEmployee ( EmployeeObject employee ) {
            boolean flag = true;
            List<EmployeeObject> employee_list = getAllEmployee();
            FileWriter fw;
            BufferedWriter bw;
            
            for ( EmployeeObject record : employee_list ) {
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
                    bw.write( String.valueOf(employee.getRatePerDay()));
                    bw.write("\n");
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

            public EmployeeObject retrieveEmployee( int id ){
      
                EmployeeObject record = new EmployeeObject();
                List<EmployeeObject> employee_list = getAllEmployee();
                for ( EmployeeObject employee : employee_list ){
                    if ( employee.getEmployeeID() == id ) {
                        record.setEmployeeID(employee.getEmployeeID());
                        record.setEmployeeName(employee.getEmployeeName());
        
                        return record;
                    }
                }
                return null;
            }
            public void updateEmployee( EmployeeObject record ) {
                List<EmployeeObject> employee_list = getAllEmployee();
                for ( EmployeeObject employee : employee_list ){

                    if ( employee.getEmployeeID() == record.getEmployeeID() ) {
                        employee_list.set(employee_list.indexOf(employee), record);

                        break;
                    }
                }
                String format = "";
                for ( EmployeeObject employee : employee_list ){
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
        




