/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw20200224P1;

import java.util.*;

/**
 *
 * @author HP01
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList <Employee> employees = new ArrayList <Employee>();
        employees.add(new Employee("Say Rattana",2020,5000.00,"Camboia"));
        employees.add(new Employee("Pi Pang",2019,4000.00,"Vietnam"));
        employees.add(new Employee("Pi Phet",2018,3500.00,"Vietnam"));
        employees.add(new Employee("Mr hai",2017,3000.00,"camboia"));
        System.out.println("Name\t\tYearofJoin\t\tSalary\t\tAddress");
        System.out.println(employees.toString());
        
        
        
    }
    
}
