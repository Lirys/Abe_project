package Managers;

import Exceptions.IDError;
import Objects.CutOffObject;

import java.util.*;
import java.io.*;

public class CutoffManager {
        File employeeFile;
        public CutoffManager() {
            employeeFile = new File("EmployeeFile.txt");
        }

        public List<CutOffObject> getAllEmployee() {
            ArrayList<CutOffObject> cutoff_list = new ArrayList<>();
            try {
                Scanner sc = new Scanner(new FileReader(employeeFile));

                while (sc.hasNextLine()) {
                    try {
                        CutOffObject employee = new CutOffObject();
                        employee.setEmployeeID(sc.nextInt());
                        employee.setCutoffID(sc.nextInt());
                        employee.setNo_of_days(sc.nextInt());
                        employee.setNo_of_holidays(sc.nextInt());
                        
                        cutoff_list.add(employee);
                    } catch ( Exception e ) {
                        continue;
                    }
                }
                sc.close();
            } catch ( FileNotFoundException e ) {
                e.printStackTrace();
            }
            return cutoff_list;
        }

        public void createEmployee ( CutOffObject employee ) {
            boolean flag = true;
            List<CutOffObject> cutoff_list = getAllEmployee();
            FileWriter fw;
            BufferedWriter bw;
            
            for ( CutOffObject record : cutoff_list ) {
                try { 
                if ( record.getEmployeeID() == employee.getEmployeeID() ){
                    throw new IDError();
                } 
            } catch ( IDError e ) {
                flag = false;
                e.getMessage();
            }       
        }
        if ( flag ) {
            try {
                fw = new FileWriter(employeeFile, true);
                bw = new BufferedWriter(fw);

                bw.write(employee.getEmployeeID()+"");
                bw.write(" ");
                bw.write(employee.getCutoffID()+"");
                bw.write("");
                bw.write(employee.getNo_of_days()+"");
                bw.write("");
                bw.write(employee.getNo_of_holidays()+"");
                bw.write("\n");
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
