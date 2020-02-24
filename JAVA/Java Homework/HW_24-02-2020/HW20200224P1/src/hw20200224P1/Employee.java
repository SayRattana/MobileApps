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
public class Employee {
    String name;
    int yearOfjoin;
    double salary;
    String address;
 
 ArrayList <Employee> employees = new ArrayList <Employee>();

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
 
//    public Employee() {
//    }

    public Employee(String name, int yearOfjoin, double salary, String address) {
        this.name = name;
        this.yearOfjoin = yearOfjoin;
        this.salary = salary;
        this.address = address;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfjoin() {
        return yearOfjoin;
    }

    public void setYearOfjoin(int yearOfjoin) {
        this.yearOfjoin = yearOfjoin;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return     name + 
                  "\t\t" +yearOfjoin +
                   "\t\t" +salary + 
                   "\t\t" +address+"\n" ;
    }
    
    
    
     
    }
    
    
    

